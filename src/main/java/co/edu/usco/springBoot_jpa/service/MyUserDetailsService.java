package co.edu.usco.springBoot_jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import co.edu.usco.springBoot_jpa.model.Role;
import co.edu.usco.springBoot_jpa.model.Usuario;
import co.edu.usco.springBoot_jpa.repository.UsuarioRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("No existe el usuario: " + username);
		}

		String[] roles = usuario.getRoles().stream()
				.map(Role::getNombre)
				.toArray(String[]::new);

		return User.withUsername(usuario.getUsername())
				.password(usuario.getPassword())
				.disabled(!usuario.isEnabled())
				.authorities(roles)
				.build();
	}
}