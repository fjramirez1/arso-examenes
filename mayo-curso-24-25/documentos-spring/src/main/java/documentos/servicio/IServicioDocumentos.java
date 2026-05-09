package documentos.servicio;

import java.util.List;

import documentos.modelo.Documento;

public interface IServicioDocumentos {

	String altaDocumento(String propietario, String colaboradores, String contenido);

	Documento recuperarDocumento(String id);

	void eliminarDocumento(String id);

	void añadirColaborador(String id, String colaborador);

	void eliminarColaborador(String colaborador);

	List<Documento> recuperarDocumentosPropietario(String propietario);
}
