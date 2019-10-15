package pe.edu.upn.marriott.services;
import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
	List<T> findAll() throws Exception;
	Optional<T> findById( ID id ) throws Exception;
	T save( T entity ) throws Exception;
	T update( T entity ) throws Exception;	
	void deleteById( ID id ) throws Exception;
	void deleteAll() throws Exception;
}
