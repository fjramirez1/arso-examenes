package documentos.adaptador;

import org.springframework.stereotype.Component;

import documentos.modelo.Documento;
import documentos.puerto.ClienteDocumentos;
import documentos.puerto.DocumentosRetrofit;
import documentos.rest.dto.NuevoDocumentoDTO;
import retrofit2.Response;

@Component
public class ClienteDocumentosRetrofit implements ClienteDocumentos {

	private final DocumentosRetrofit api;

	public ClienteDocumentosRetrofit(DocumentosRetrofit api) {
		this.api = api;
	}

	@Override
	public String createDocumento(NuevoDocumentoDTO nuevoDocumentoDTO) throws Exception {
		Response<String> response = api.createDocumento(nuevoDocumentoDTO).execute();

		if (!response.isSuccessful() || response.body() == null) {
			throw new Exception("No se pudo crear el documento. Código: " + response.code());
		}

		return response.body().replace("\"", "");
	}

	@Override
	public Documento getDocumentoById(String id) throws Exception {
		String idLimpio = id.replace("\"", "");

		Response<Documento> response = api.getDocumentoById(idLimpio).execute();

		if (!response.isSuccessful() || response.body() == null) {
			throw new Exception("Documento no encontrado: " + idLimpio + " (Error: " + response.code() + ")");
		}

		return response.body();
	}

	@Override
	public void deleteDocumento(String id) throws Exception {
		String idLimpio = id.replace("\"", "");

		Response<Void> response = api.deleteDocumento(idLimpio).execute();

		if (!response.isSuccessful()) {
			throw new Exception("No se pudo eliminar el documento: " + idLimpio);
		}
	}
}