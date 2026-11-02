package co.edu.usco.springBoot_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.usco.springBoot_jpa.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
