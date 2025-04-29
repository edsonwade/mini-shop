/**
 * Author: vanilson muhongo
 * Date:25/04/2025
 * Time:13:04
 * Version:1
 */

package code.with.vanilson.minishop.user.domain;

import code.with.vanilson.minishop.user.domain.enums.ERole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "roles")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;
    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Role role)) {return false;}

        return Objects.equals(id, role.id) && name == role.name && Objects.equals(users, role.users);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(users);
        return result;
    }
}