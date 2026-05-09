package documentos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import documentos.puerto.DocumentosRetrofit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {

	@Value("${microservicio.documentos-spring.url}")
	private String urlDocumentos;

	@Bean
	public DocumentosRetrofit retrofitDocumentoApi() {
		return new Retrofit.Builder().baseUrl(urlDocumentos).addConverterFactory(GsonConverterFactory.create()).build()
				.create(DocumentosRetrofit.class);
	}
}
