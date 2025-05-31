/**
 * Author: vanilson muhongo
 * Date:25/04/2025
 * Time:13:55
 * Version:1
 * <p>
 * AuditingConfig.java
 * This class configures auditing for the application.
 * It provides an AuditorAware bean that retrieves the current user's username
 * for auditing purposes.
 * It also customizes the Jackson ObjectMapper to use a specific date format
 * and timezone.
 * </p>
 */

package code.with.vanilson.minishop.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
import java.util.TimeZone;

@Configuration
@EnableJpaAuditing
public class AuditingConfig {
    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication())
                .map(Authentication::getName)
                .or(() -> Optional.of("system"));
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer() {
        return builder -> {
            builder.simpleDateFormat("yyyy-MM-dd HH:mm:ss");
            builder.timeZone(TimeZone.getTimeZone("UTC"));
        };
    }
}
