package co.edu.usco.springBoot_jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import jakarta.servlet.DispatcherType;

@Configuration
public class SecurityConfig {


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()
				.requestMatchers("/login", "/403", "/error").permitAll()
				.requestMatchers("/", "/productos")
					.hasAnyAuthority("ESTUDIANTE", "GRADUADO", "DOCENTE", "ADMIN")
				.requestMatchers("/productos/nuevo", "/productos/guardar")
					.hasAnyAuthority("ADMIN", "GRADUADO")
				.requestMatchers("/productos/editar/**", "/productos/actualizar/**")
					.hasAnyAuthority("ADMIN", "DOCENTE")
				.requestMatchers("/productos/eliminar/**")
					.hasAuthority("ADMIN")
				.anyRequest().authenticated())
			.formLogin(form -> form
				.loginPage("/login")
				.defaultSuccessUrl("/", true)
				.permitAll())
			.logout(logout -> logout
				.logoutSuccessUrl("/login?logout")
				.permitAll())
			.exceptionHandling(ex -> ex.accessDeniedPage("/403"));

		return http.build();
	}
}