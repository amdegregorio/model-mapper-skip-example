/**
 * 
 */
package com.amydegregorio.modelmapperskipexample.config;

import java.util.Optional;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Configuration for JPA Auditing.
 * <br>
 * Since this simple demo app is not secured, this class hard codes a value in current auditor.
 * 
 * @author AMD
 */
@EnableJpaAuditing
@Configuration
public class AuditingConfig {
   @Bean
   public AuditorAware<String> createAuditorProvider() {
       return new SecurityAuditor();
   }

   @Bean
   public AuditingEntityListener createAuditingListener() {
       return new AuditingEntityListener();
   }

   public static class SecurityAuditor implements AuditorAware<String> {
       @Override
       public Optional<String> getCurrentAuditor() {
          //Hard-coding here because demo app is not secured.
          String username = "demo_user";
          return Optional.of(username);
       }
   }
}
