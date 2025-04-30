package code.with.vanilson.minishop.customer;

import code.with.vanilson.minishop.customer.address.Address;
import code.with.vanilson.minishop.user.domain.Auditable;
import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * Customer
 *
 * @author vamuhong
 * @version 1.0
 * @since 2025-04-30
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "customers",
        indexes = {
                @Index(name = "idx_customer_email", columnList = "customer_email"),
                @Index(name = "idx_customer_name", columnList = "customer_name"),
                @Index(name = "idx_customer_phone", columnList = "customer_phone")
        }
)
@Getter
@Setter
@JsonbPropertyOrder(
        value = {
                "customerId",
                "customerName",
                "customerEmail",
                "customerPhone",
                "customerAddress"
        }
)
/**
 * Represents a customer entity in the system.
 * This class extends Auditable to track creation and modification timestamps.
 * It includes personal information and address details of customers.
 */
public class Customer extends Auditable {
    /**
     * Unique identifier for the customer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Long customerId;
    /**
     * Full name of the customer.
     * Maximum length is 100 characters.
     */
    @Column(name = "customer_name", nullable = false, length = 100)
    private String customerName;
    /**
     * Customer's email address.
     * Must be unique in the system.
     * Maximum length is 50 characters.
     */
    @Column(name = "customer_email", nullable = false, unique = true, length = 50)
    private String customerEmail;

    /**
     * Customer's contact phone number.
     * Maximum length is 20 characters.
     */
    @Column(name = "customer_phone", nullable = false, length = 20)
    private String customerPhone;
    /**
     * Customer's physical address details.
     * Embedded as a complex type.
     */
    @Embedded
    private Address customerAddress;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Customer customer)) {return false;}

        return Objects.equals(customerId, customer.customerId) &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(customerEmail, customer.customerEmail) &&
                Objects.equals(customerPhone, customer.customerPhone) &&
                Objects.equals(customerAddress, customer.customerAddress);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(customerId);
        result = 31 * result + Objects.hashCode(customerName);
        result = 31 * result + Objects.hashCode(customerEmail);
        result = 31 * result + Objects.hashCode(customerPhone);
        result = 31 * result + Objects.hashCode(customerAddress);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerAddress=" + customerAddress +
                '}';
    }
}