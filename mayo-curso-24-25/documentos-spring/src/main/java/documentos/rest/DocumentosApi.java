package documentos.rest;

import javax.validation.Valid;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import documentos.modelo.Documento;
import documentos.rest.dto.NuevoDocumentoDTO;

public interface DocumentosApi {

	@PostMapping
	ResponseEntity<String> createDocumento(@Valid @RequestBody NuevoDocumentoDTO nuevoDocumentoDTO) throws Exception;

	@DeleteMapping("/{id}")
	ResponseEntity<Void> deleteDocumento(@PathVariable String id) throws Exception;

	@GetMapping("/{id}")
	EntityModel<Documento> getDocumentoById(@PathVariable String id) throws Exception;

	@PatchMapping("/{id}/colaboradores/{colaborador}")
	ResponseEntity<Void> addColaborador(@PathVariable String id, @PathVariable String colaborador) throws Exception;
}
