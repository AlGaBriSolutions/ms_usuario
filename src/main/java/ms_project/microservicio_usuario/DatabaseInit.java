package ms_project.microservicio_usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import jakarta.transaction.Transactional;
import ms_project.microservicio_usuario.entities.Usuario;
import ms_project.microservicio_usuario.repositories.RepositoryUsuario;

@Controller
@Transactional
@Profile("default")
public class DatabaseInit implements ApplicationRunner{
    @Autowired
    RepositoryUsuario repositorio;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // Listas de posibles valores para generar fotos de perfil de usuarios
        String[] fotosUrl = {
            "https://randomuser.me/api/portraits/men/1.jpg",
            "https://randomuser.me/api/portraits/women/1.jpg",
            "https://randomuser.me/api/portraits/men/2.jpg",
            "https://randomuser.me/api/portraits/women/2.jpg",
            "https://randomuser.me/api/portraits/men/3.jpg",
            "https://randomuser.me/api/portraits/women/3.jpg",
            "https://randomuser.me/api/portraits/men/4.jpg",
            "https://randomuser.me/api/portraits/women/4.jpg",
            "https://randomuser.me/api/portraits/men/5.jpg",
            "https://randomuser.me/api/portraits/women/5.jpg",
            "https://randomuser.me/api/portraits/men/6.jpg",
            "https://randomuser.me/api/portraits/women/6.jpg",
            "https://randomuser.me/api/portraits/men/7.jpg",
            "https://randomuser.me/api/portraits/women/7.jpg",
            "https://randomuser.me/api/portraits/men/8.jpg",
            "https://randomuser.me/api/portraits/women/8.jpg",
            "https://randomuser.me/api/portraits/men/9.jpg",
            "https://randomuser.me/api/portraits/women/9.jpg",
            "https://randomuser.me/api/portraits/men/10.jpg",
            "https://randomuser.me/api/portraits/women/10.jpg",
            "https://randomuser.me/api/portraits/women/11.jpg"
        };

         // Listas de posibles valores para generar usuarios diversos
        String[] nombres = {
            "Ana Ramírez", "Carlos Mendoza", "María Fernández", "Juan Herrera", "Laura Torres", 
            "Pedro Guzmán", "Sofía Velasco", "Miguel Ochoa", "Isabel Quintana", "Roberto Soto", 
            "Elena Martínez", "Diego Vargas", "Carmen Rivas", "Luis Morales", "Patricia Castillo",
            "Gabriel Ortiz", "Valentina Ruiz", "Andrés Delgado", "Lucía Jiménez", "Fernando Cruz"
        };
        
        String[] descripcionesProveedor = {
            "Guía certificado en senderismo ecológico con 10 años de experiencia en la Sierra local",
            "Experta en avistamiento de aves, ofrece tours sostenibles en humedales protegidos",
            "Operador de eco-lodge solar, especializado en retiros de bienestar en la naturaleza",
            "Instructor de fotografía de naturaleza, organiza safaris fotográficos de bajo impacto",
            "Especialista en turismo rural comunitario, conecta viajeros con comunidades indígenas",
            "Biólogo marino, lidera snorkel y buceo responsable en arrecifes de coral",
            "Chef de cocina orgánica, ofrece experiencias gastronómicas con ingredientes locales",
            "Experto en camping ecológico, enseña técnicas de 'No Dejar Rastro'",
            "Agricultor orgánico, organiza tours educativos en su granja sostenible",
            "Guía de kayak, realiza expediciones de limpieza de ríos mientras explora",
            "Apicultor, ofrece experiencias educativas sobre la importancia de las abejas",
            "Botánico, especializado en tours de plantas medicinales en la selva",
            "Artesana local, enseña técnicas tradicionales usando materiales naturales",
            "Guardaparques, lidera caminatas educativas sobre conservación",
            "Especialista en observación de estrellas, realiza tours nocturnos de astronomía"
        };

        String[] descripcionesCliente = {
            "Viajero consciente buscando experiencias auténticas y sostenibles en la naturaleza",
            "Fotógrafa aficionada interesada en capturar la belleza natural sin perturbar ecosistemas",
            "Ejecutivo estresado buscando retiros ecológicos para reconectar con la naturaleza",
            "Familia activa que busca vacaciones educativas sobre medio ambiente para sus hijos",
            "Jubilada aventurera interesada en turismo de bajo impacto y apoyo a comunidades locales"
        };

        // Crear 15 proveedores
        for (int i = 0; i < 15; i++) {
            Usuario proveedor = new Usuario();
            proveedor.setNombre(nombres[i]);
            proveedor.setUsername(nombres[i].toLowerCase() + "_ecoprov");
            proveedor.setContrasena("password");
            proveedor.setEdad(28 + i); // Edades entre 28 y 42
            proveedor.setDescripcion(descripcionesProveedor[i]);
            proveedor.setTipo(0); // 0 para proveedor
            proveedor.setEliminado(false);
            proveedor.setFoto(fotosUrl[i]);
            
            repositorio.save(proveedor);
        }

        // Crear 5 clientes
        for (int i = 15; i < 20; i++) {
            Usuario cliente = new Usuario();
            cliente.setNombre(nombres[i]);
            cliente.setUsername(nombres[i].toLowerCase() + "_ecoturista");
            cliente.setContrasena("password");
            cliente.setEdad(25 + (i - 15) * 7); // Edades variadas: 25, 32, 39, 46, 53
            cliente.setDescripcion(descripcionesCliente[i - 15]);
            cliente.setTipo(1); // 1 para cliente
            cliente.setEliminado(false);
            cliente.setFoto(fotosUrl[i]);
            
            repositorio.save(cliente);
        }

    }
}