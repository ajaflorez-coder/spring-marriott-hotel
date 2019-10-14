package pe.edu.upn.marriott.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.marriott.models.entity.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, String> {

}
