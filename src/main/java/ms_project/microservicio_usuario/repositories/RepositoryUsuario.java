package ms_project.microservicio_usuario.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ms_project.microservicio_usuario.entities.Usuario;

@Repository
public interface RepositoryUsuario extends CrudRepository<Usuario, Long>{

}
