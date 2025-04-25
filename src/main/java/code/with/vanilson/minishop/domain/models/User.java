/**
 * Author: vanilson muhongo
 * Date:25/04/2025
 * Time:13:04
 * Version:1
 */

package code.with.vanilson.minishop.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
@SuppressWarnings("unused")
@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 50)
    private String username;
    @Column(nullable = false)
    private String password;
    private boolean enabled = true;
    private boolean accountNonLocked = true;
    private boolean accountNonExpired = true;
    private boolean credentialsNonExpired = true;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }
        this.username = username;
    }


    public void addRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        this.roles.add(role);
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof User user)) {
            return false;
        }

        return enabled == user.enabled && accountNonLocked == user.accountNonLocked &&
                accountNonExpired == user.accountNonExpired && credentialsNonExpired == user.credentialsNonExpired &&
                Objects.equals(id, user.id) && Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(username);
        result = 31 * result + Objects.hashCode(password);
        result = 31 * result + Boolean.hashCode(enabled);
        result = 31 * result + Boolean.hashCode(accountNonLocked);
        result = 31 * result + Boolean.hashCode(accountNonExpired);
        result = 31 * result + Boolean.hashCode(credentialsNonExpired);
        result = 31 * result + Objects.hashCode(roles);
        return result;
    }
}
