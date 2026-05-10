package documentos.puerto;

import documentos.modelo.Documento;
import documentos.rest.dto.NuevoDocumentoDTO;

public interface ClienteDocumentos {

	String createDocumento(NuevoDocumentoDTO nuevoDocumentoDTO) throws Exception;

	Documento getDocumentoById(String id) throws Exception;

	void deleteDocumento(String id) throws Exception;
}