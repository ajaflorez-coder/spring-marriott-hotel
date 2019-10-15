package pe.edu.upn.marriott.services;


import java.util.Optional;

import pe.edu.upn.marriott.models.entity.Vendedor;


public interface VendedorService extends CrudService<Vendedor, String> {

	Optional<Vendedor> findById(int id);



}
  