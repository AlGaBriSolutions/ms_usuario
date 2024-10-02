package ms_project.microservicio_usuario.entities;

import java.sql.Blob;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USUARIOS")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private String usuario;
    private String contrasena;
    private Blob foto;
    private Integer edad;
    private String descripcion;
    private ArrayList<Integer> items;
    private Integer tipo;
    private Boolean Eliminado;
}
