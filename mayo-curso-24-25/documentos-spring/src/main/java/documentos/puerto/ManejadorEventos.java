package documentos.puerto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import documentos.modelo.Documento;
import documentos.repositorio.RepositorioDocumentos;

@Component
public class ManejadorEventos {

	@Autowired
	private RepositorioDocumentos repositorioDocumentos;

	public void usuarioEliminado(String propietario) {
		List<Documento> documentos = repositorioDocumentos.findByPropietario(propietario);
		documentos.stream().forEach(d -> repositorioDocumentos.delete(d));
	}

}
