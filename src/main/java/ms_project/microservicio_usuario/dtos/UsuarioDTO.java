package ms_project.microservicio_usuario.dtos;

import java.sql.Blob;
import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private long id;
    private String nombre;
    private Blob foto;
    private Integer edad;
    private String descripcion;
    private ArrayList<Integer> items;
    private Integer tipo;
}
