package documentos.repositorio;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import documentos.modelo.Documento;

@NoRepositoryBean
public interface RepositorioDocumentos extends PagingAndSortingRepository<Documento, String> {

	List<Documento> findByPropietario(String propietario);

}
