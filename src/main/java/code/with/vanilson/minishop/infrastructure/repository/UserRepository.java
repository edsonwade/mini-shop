/**
 * UserRepository.java
 * <p>
 * This interface extends JpaRepository to provide CRUD operations for the User entity.
 * It includes methods to find a user by username and check if a username already exists.
 * </p>
 *
 * @author Vanilson
 * @version 1.0
 * @Time 13:47
 * @Version: 1
 * @Date:25/04/2025me:13:45
 * @Version:1
 */
package code.with.vanilson.minishop.infrastructure.repository;

import code.with.vanilson.minishop.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
@SuppressWarnings("unused")

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);
}
