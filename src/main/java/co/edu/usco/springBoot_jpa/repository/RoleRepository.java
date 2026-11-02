package co.edu.usco.springBoot_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usco.springBoot_jpa.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByNombre(String nombre);
}