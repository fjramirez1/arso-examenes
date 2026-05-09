package documentos.rest;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import documentos.modelo.Documento;
import documentos.rest.dto.NuevoDocumentoDTO;
import documentos.servicio.IServicioDocumentos;

@RestController
@RequestMapping("/documentos-spring")
public class DocumentosController implements DocumentosApi {

	private IServicioDocumentos servicio;

	@Autowired
	public DocumentosController(IServicioDocumentos servicio) {
		this.servicio = servicio;
	}

	@Override
	public ResponseEntity<String> createDocumento(@Valid NuevoDocumentoDTO nuevoDocumentoDTO) throws Exception {
		String id = servicio.altaDocumento(nuevoDocumentoDTO.getPropietario(), nuevoDocumentoDTO.getColaboradores(),
				nuevoDocumentoDTO.getContenido());

		URI nuevaURL = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		return ResponseEntity.created(nuevaURL).body("\"" + id + "\"");
	}

	@Override
	public ResponseEntity<Void> deleteDocumento(String id) throws Exception {
		servicio.eliminarDocumento(id);
		return ResponseEntity.noContent().build();
	}

	@Override
	public EntityModel<Documento> getDocumentoById(String id) throws Exception {
		Documento documento = servicio.recuperarDocumento(id);
		EntityModel<Documento> model = EntityModel.of(documento);
		model.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(DocumentosController.class).getDocumentoById(id))
				.withSelfRel());
		return model;
	}

	@Override
	public ResponseEntity<Void> addColaborador(String id, String colaborador) throws Exception {
		servicio.añadirColaborador(id, colaborador);
		return ResponseEntity.noContent().build();
	}
}