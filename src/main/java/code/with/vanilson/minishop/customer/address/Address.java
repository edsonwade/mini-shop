/**
 * Address
 *
 * @author vamuhong
 * @version 1.0
 * @since 2025-04-30
 */

package code.with.vanilson.minishop.customer.address;

import jakarta.json.bind.annotation.JsonbPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * Represents a physical address that can be embedded in other entities.
 * Used for storing location information for customers and shipping.
 */
@SuppressWarnings("JpaDataSourceORMInspection")
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonbPropertyOrder(
        value = {
                "streetNumber",
                "street",
                "apartmentNumber",
                "floorNumber",
                "zipCode",
                "city",
                "state",
                "country"
        }
)
public class Address {
    /**
     * The name of the street or road
     * Example: "Main Street", "Broadway Avenue"
     */
    @Column(name = "street", nullable = false, length = 50)
    private String street;
    /**
     * The building or house number on the street
     * Example: "123", "45A"
     */
    @Column(name = "street_number", nullable = false, length = 10)
    private String streetNumber;
    /**
     * The name of the city or town
     * Example: "New York", "San Francisco"
     */
    @Column(name = "city", nullable = false, length = 50)
    private String city;

    /**
     * The name of the country
     * Example: "United States", "Canada"
     */
    @Column(name = "country", nullable = false, length = 50)
    private String country;
    /**
     * The state, province, or region
     * Example: "California", "New York"
     */
    @Column(name = "state", nullable = false, length = 15)
    private String state;
    /**
     * The postal or ZIP code
     * Example: "10001", "94105"
     */
    @Column(name = "zip_code", nullable = false, length = 10)
    private String zipCode;
    /**
     * The apartment, suite, or unit number (optional)
     * Example: "Apt 4B", "Suite 202"
     */
    @Column(name = "apartment_number", length = 10)
    private String apartmentNumber;
    /**
     * The floor number in the building (optional)
     * Example: "3", "15"
     */
    @Column(name = "floor_number", length = 10)
    private String floorNumber;

    @Override
    public final boolean equals(Object o) {
        return o instanceof Address address && compareFields(address);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(street);
        result = 31 * result + Objects.hashCode(streetNumber);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + Objects.hashCode(country);
        result = 31 * result + Objects.hashCode(state);
        result = 31 * result + Objects.hashCode(zipCode);
        result = 31 * result + Objects.hashCode(apartmentNumber);
        result = 31 * result + Objects.hashCode(floorNumber);
        return result;
    }

    private boolean compareFields(Address address) {
        return Objects.equals(street, address.street)
                && Objects.equals(streetNumber, address.streetNumber)
                && Objects.equals(city, address.city)
                && Objects.equals(country, address.country)
                && Objects.equals(state, address.state)
                && Objects.equals(zipCode, address.zipCode)
                && Objects.equals(apartmentNumber, address.apartmentNumber)
                && Objects.equals(floorNumber, address.floorNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", floorNumber='" + floorNumber + '\'' +
                '}';
    }
}