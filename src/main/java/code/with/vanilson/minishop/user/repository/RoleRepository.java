/**
 * RoleRepository.java
 * <p>
 * This interface extends JpaRepository to provide CRUD operations for the Role entity.
 * It includes methods to find a role by role name and check if a role name already exists.
 * </p>
 *
 * @author Vanilson
 * @version 1.0
 * @Time 13:47
 * @Version: 1
 * @Date:25/04/2025
 */

package code.with.vanilson.minishop.user.repository;

import code.with.vanilson.minishop.user.domain.Role;
import code.with.vanilson.minishop.user.domain.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@SuppressWarnings("unused")
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);

    boolean existsByName(ERole name);
}
