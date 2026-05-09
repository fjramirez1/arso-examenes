package documentos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import documentos.adaptador.ClienteDocumentosRetrofit;
import documentos.evento.EventoUsuarioEliminado;
import documentos.modelo.Documento;
import documentos.puerto.PublicadorEventos;
import documentos.rest.dto.NuevoDocumentoDTO;

@SpringBootApplication
public class DocumentosSpringApplication {

	public static void main(String[] args) throws Exception{

		ConfigurableApplicationContext contexto = SpringApplication.run(DocumentosSpringApplication.class, args);
		System.out.println("\nEjercicio 2");
		ClienteDocumentosRetrofit clienteDocumentosRetrofit = contexto.getBean(ClienteDocumentosRetrofit.class);
		NuevoDocumentoDTO nuevoDocumentoDTO = new NuevoDocumentoDTO();
		nuevoDocumentoDTO.setPropietario("Javi");
		nuevoDocumentoDTO.setColaboradores("Antonio, Paco, Manuel");
		nuevoDocumentoDTO.setContenido("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
		String id = clienteDocumentosRetrofit.createDocumento(nuevoDocumentoDTO);
		System.out.println("Documento creado correctamente");
		Documento documento = clienteDocumentosRetrofit.getDocumentoById(id);
		System.out.println("Documento recuperado correctamente");
		System.out.println("Id: " + documento.getId());
		System.out.println("Propietario: " + documento.getPropietario());
		System.out.println("Colaboradores: " + documento.getColaboradores());
		System.out.println("Contenido: " + documento.getContenido());
		clienteDocumentosRetrofit.deleteDocumento(id);
		System.out.println("Documento eliminado correctamente");

		System.out.println("\nEjercicio 3");
		nuevoDocumentoDTO = new NuevoDocumentoDTO();
		String usuario = "Pedro";
		nuevoDocumentoDTO.setPropietario(usuario);
		nuevoDocumentoDTO.setColaboradores("Antonio, Paco, Manuel");
		nuevoDocumentoDTO.setContenido("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
		id = clienteDocumentosRetrofit.createDocumento(nuevoDocumentoDTO);
		PublicadorEventos publicadorEventos = contexto.getBean(PublicadorEventos.class);
		publicadorEventos.publicarEvento(new EventoUsuarioEliminado(usuario));
		System.out.println("EventoUsuarioEliminado publicado correctamente");
		System.out.println("Esperando a que el microservicio procese el evento...");
		Thread.sleep(2000);
		try {
			documento = clienteDocumentosRetrofit.getDocumentoById(id);
		} catch (Exception e) {
			System.out.println("Documento eliminado correctamente al recribir EventoUsuarioEliminado");
		}
	}

}
