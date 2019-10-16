package pe.edu.upn.marriott.models.repository;

import org.springframework.stereotype.Repository;

import pe.edu.upn.marriott.models.entity.Alquiler;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {

}
