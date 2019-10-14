package pe.edu.upn.marriott.models.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upn.marriott.models.entity.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

}
