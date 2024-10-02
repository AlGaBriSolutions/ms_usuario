package ms_project.microservicio_usuario;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import ms_project.microservicio_usuario.controllers.UsuarioControlador;
import ms_project.microservicio_usuario.dtos.UsuarioDTO;
import ms_project.microservicio_usuario.entities.Usuario;
import ms_project.microservicio_usuario.services.UsuarioServicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MicroservicioUsuarioApplicationTests {

	@Mock
	private UsuarioServicio usuarioServicioMock;
	@InjectMocks
	private UsuarioControlador usuarioControlador;

	@Test
	void contextLoads() {
	}
	@Test
	public void testGetUsuarioById() {
		Long id = 1L;
		UsuarioDTO expectedUsuarioDTO = new UsuarioDTO();
		
		when(usuarioServicioMock.getUsuario(id)).thenReturn(expectedUsuarioDTO);
		
		UsuarioDTO actualUsuarioDTO = usuarioControlador.get(id);
		
		verify(usuarioServicioMock).getUsuario(id);
		assertEquals(expectedUsuarioDTO, actualUsuarioDTO);
	}

	@Test
	public void testSaveUsuario() {
		Usuario usuario = new Usuario();
		UsuarioDTO expectedUsuarioDTO = new UsuarioDTO();
		
		when(usuarioServicioMock.save(usuario)).thenReturn(expectedUsuarioDTO);
		
		UsuarioDTO actualUsuarioDTO = usuarioControlador.save(usuario);
		
		verify(usuarioServicioMock).save(usuario);
		assertEquals(expectedUsuarioDTO, actualUsuarioDTO);
	}
	
	@Test
	public void testUpdateUsuario() {
		Usuario usuario = new Usuario();
		UsuarioDTO expectedUsuarioDTO = new UsuarioDTO();
		
		when(usuarioServicioMock.update(usuario)).thenReturn(expectedUsuarioDTO);
		
		UsuarioDTO actualUsuarioDTO = usuarioControlador.update(usuario);
		
		verify(usuarioServicioMock).update(usuario);
		assertEquals(expectedUsuarioDTO, actualUsuarioDTO);
	}

	@Test
	public void testDeleteUsuarioById() {
		Long id = 1L;
		
		usuarioControlador.delete(id);
		
		verify(usuarioServicioMock).delete(id);
	}
}
