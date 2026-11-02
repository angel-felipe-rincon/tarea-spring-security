package co.edu.usco.springBoot_jpa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import co.edu.usco.springBoot_jpa.model.Role;
import co.edu.usco.springBoot_jpa.model.Usuario;
import co.edu.usco.springBoot_jpa.repository.RoleRepository;
import co.edu.usco.springBoot_jpa.repository.UsuarioRepository;

@Component
public class DatosIniciales implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) {
		
		if (usuarioRepository.count() > 0) {
			return;
		}

		roleRepository.save(new Role("ESTUDIANTE"));
		roleRepository.save(new Role("GRADUADO"));
		roleRepository.save(new Role("DOCENTE"));
		roleRepository.save(new Role("ADMIN"));

		crearUsuario("admin", "admin123", "ADMIN");
		crearUsuario("docente1", "docente123", "DOCENTE");
		crearUsuario("maria", "maria123", "ESTUDIANTE");
		crearUsuario("juan", "juan123", "ESTUDIANTE", "GRADUADO");
		crearUsuario("ana", "ana123", "GRADUADO", "DOCENTE");
	}

	private void crearUsuario(String username, String clave, String... nombresRoles) {
		Usuario u = new Usuario();
		u.setUsername(username);
		u.setPassword(passwordEncoder.encode(clave));
		u.setEnabled(true);
		for (String nombre : nombresRoles) {
			u.getRoles().add(roleRepository.findByNombre(nombre));
		}
		usuarioRepository.save(u);
	}
}