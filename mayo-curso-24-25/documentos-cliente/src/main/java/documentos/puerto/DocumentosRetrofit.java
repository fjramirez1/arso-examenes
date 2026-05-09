package documentos.puerto;

import documentos.modelo.Documento;
import documentos.rest.dto.NuevoDocumentoDTO;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DocumentosRetrofit {

	@POST("documentos-spring")
	Call<String> createDocumento(@Body NuevoDocumentoDTO nuevoDocumentoDTO);

	@GET("documentos-spring/{id}")
	Call<Documento> getDocumentoById(@Path("id") String id);

	@DELETE("documentos-spring/{id}")
	Call<Void> deleteDocumento(@Path("id") String id);
}