
package documentos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import documentos.modelo.Documento;
import documentos.repositorio.RepositorioDocumentos;

@Service
@Transactional
public class ServicioDocumentos implements IServicioDocumentos {

	private RepositorioDocumentos repositorio;

	@Autowired
	public ServicioDocumentos(RepositorioDocumentos repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public String altaDocumento(String propietario, String colaboradores, String contenido) {
		Documento documento = new Documento(propietario, colaboradores, contenido);
		documento = repositorio.save(documento);
		return documento.getId();
	}

	@Override
	public Documento recuperarDocumento(String id) {
		return repositorio.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No existe documento con id: " + id));
	}

	@Override
	public void eliminarDocumento(String id) {
		repositorio.deleteById(id);
	}

	@Override
	public void añadirColaborador(String id, String colaborador) {
		Documento documento = recuperarDocumento(id);
		String colaboradores = documento.getColaboradores();

		if (colaboradores == null || colaboradores.trim().isEmpty()) {
			documento.setColaboradores(colaborador);

		} else {
			documento.setColaboradores(colaboradores + "," + colaborador);
		}

		repositorio.save(documento);
	}

	@Override
	public void eliminarColaborador(String colaborador) {
		List<Documento> documentos = repositorio.findAll();
		for (Documento documento : documentos) {
			String colaboradores = documento.getColaboradores();
			if (colaboradores == null || colaboradores.trim().isEmpty()) {
				continue;
			}
			StringBuilder nuevosColaboradores = new StringBuilder();
			for (String c : colaboradores.split(",")) {
				if (!colaborador.equals(c.trim())) {
					if (nuevosColaboradores.length() > 0) {
						nuevosColaboradores.append(",");
					}
					nuevosColaboradores.append(c.trim());
				}
			}
			documento.setColaboradores(nuevosColaboradores.toString());
			repositorio.save(documento);
		}
	}

	@Override
	public List<Documento> recuperarDocumentosPropietario(String propietario) {
		return repositorio.findByPropietario(propietario);
	}

}
