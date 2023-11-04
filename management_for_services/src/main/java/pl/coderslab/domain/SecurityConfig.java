package pl.coderslab.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**", "/user/delete/{id}", "/rest/delete/{id}", "equip/delete/{id}", "/repair/delete/{id}", "/rest/edit/{id}", "/rest/create").hasRole("ADMIN")
                .antMatchers("/user/**", "/rest/**", "/repair/**", "/equip/**", "/problem/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/dashboard").authenticated()
                .and().formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/user/dashboard")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .permitAll()
                .and().exceptionHandling().accessDeniedPage("/403");
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
