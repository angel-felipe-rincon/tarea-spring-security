package co.edu.usco.springBoot_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usco.springBoot_jpa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByUsername(String username);
}