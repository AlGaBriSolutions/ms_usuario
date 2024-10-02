package ms_project.microservicio_usuario.entities;

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
    private String username;
    private String contrasena;
    private String foto;
    private Integer edad;
    private String descripcion;
    //0: Proveedor
    //1: Cliente
    private Integer tipo;
    private Boolean eliminado;

    public Usuario(String nombre, String username, String contrasena, String foto, Integer edad, String descripcion, Integer tipo, Boolean eliminado) {
        this.nombre = nombre;
        this.username = username;
        this.contrasena = contrasena;
        this.foto = foto;
        this.edad = edad;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.eliminado = eliminado;
    }

    
}
