package ms_project.microservicio_usuario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import ms_project.microservicio_usuario.dtos.UsuarioDTO;
import ms_project.microservicio_usuario.entities.Usuario;
import ms_project.microservicio_usuario.services.UsuarioServicio;

@RestController
@RequestMapping("/Usuario")
public class UsuarioControlador {
    UsuarioServicio usuarioServicio;

    @Autowired
    UsuarioControlador(UsuarioServicio usuarioServicio){
        this.usuarioServicio = usuarioServicio;
    }

    @CrossOrigin(origins = "*")
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO get(@PathVariable Long id){
        return usuarioServicio.getUsuario(id);
    }
    
    @CrossOrigin(origins = "*")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO save(@RequestBody Usuario usuario){
        return usuarioServicio.save(usuario);
    }
    @CrossOrigin(origins = "*")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public UsuarioDTO update(@RequestBody Usuario usuario){
        return usuarioServicio.update(usuario);
    }
    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Long id){
        usuarioServicio.delete(id);
    }
}
