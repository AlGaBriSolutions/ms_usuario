package ms_project.microservicio_usuario.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms_project.microservicio_usuario.dtos.UsuarioDTO;
import ms_project.microservicio_usuario.entities.Usuario;
import ms_project.microservicio_usuario.repositories.RepositoryUsuario;

@Service
public class UsuarioServicio {
    RepositoryUsuario repositorio_usuario;
    ModelMapper modelMapper;

    @Autowired
    UsuarioServicio(RepositoryUsuario repositoryUsuario, ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.repositorio_usuario = repositoryUsuario;
    }

    public UsuarioDTO getUsuario(Long id){
        Optional<Usuario>usuarioOpt = repositorio_usuario.findById(id);
        UsuarioDTO usuarioDTO = null;
        if(usuarioOpt.isPresent()){
            Usuario usuario = usuarioOpt.get();
            usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        }
        return usuarioDTO;
    }

    public UsuarioDTO save(Usuario usuario){
        Usuario Usuario = usuario;
        Usuario = repositorio_usuario.save(Usuario);
        UsuarioDTO usuarioDTO = modelMapper.map(Usuario, UsuarioDTO.class);
        return usuarioDTO;
    }

    public void delete(Long id){
        Optional<Usuario> usuarioOpt = repositorio_usuario.findById(id);
        usuarioOpt.ifPresent(usuario -> {
            usuario.setEliminado(true);
            repositorio_usuario.save(usuario);
        });
    }

    public UsuarioDTO update(Usuario usuarioo){
        Optional<Usuario> usuarioOptional = repositorio_usuario.findById(usuarioo.getId());
    
        if (usuarioOptional.isPresent()) {
            Usuario usuarioDB = usuarioOptional.get();
        
            if (usuarioo.getNombre() != null) {
                usuarioDB.setNombre(usuarioo.getNombre());
            }
            if (usuarioo.getFoto() != null) {
                usuarioDB.setFoto(usuarioo.getFoto());
            }
            if (usuarioo.getEdad() != null) {
                usuarioDB.setEdad(usuarioo.getEdad());
            }
            if (usuarioo.getDescripcion() != null) {
                usuarioDB.setDescripcion(usuarioo.getDescripcion());
            }
            if (usuarioo.getUsername() != null) {
                usuarioDB.setUsername(usuarioo.getUsername());
            }
            if (usuarioo.getContrasena() != null) {
                usuarioDB.setContrasena(usuarioo.getContrasena());
            }
            Usuario usuarioActualizado = repositorio_usuario.save(usuarioDB);
            UsuarioDTO usuarioDTO = modelMapper.map(usuarioActualizado, UsuarioDTO.class);
            return usuarioDTO;
        } else {
            return null;
        }
    }

}
