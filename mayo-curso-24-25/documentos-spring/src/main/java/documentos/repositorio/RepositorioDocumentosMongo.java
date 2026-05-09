package documentos.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import documentos.modelo.Documento;

@Repository
public interface RepositorioDocumentosMongo extends RepositorioDocumentos, MongoRepository<Documento, String> {

}