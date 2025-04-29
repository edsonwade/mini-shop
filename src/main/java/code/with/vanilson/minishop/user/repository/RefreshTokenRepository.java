/**
 * Author: vanilson muhongo
 * Date:25/04/2025
 * Time:13:50
 * Version:1
 */

package code.with.vanilson.minishop.user.repository;

import code.with.vanilson.minishop.user.domain.RefreshToken;
import code.with.vanilson.minishop.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    int deleteByUser(User user);
}
