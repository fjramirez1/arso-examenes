package documentos.puerto;

import documentos.modelo.Documento;
import documentos.rest.dto.NuevoDocumentoDTO;
import retrofit2.http.Query;

public interface ClienteDocumentos {

	String createDocumento(NuevoDocumentoDTO nuevoDocumentoDTO) throws Exception;

	Documento getDocumentoById(@Query("id") String id) throws Exception;

	void deleteDocumento(@Query("id") String id) throws Exception;
}