package documentos.puerto;

import java.io.IOException;

import documentos.evento.Evento;

public interface PublicadorEventos {

	void publicarEvento(Evento evento) throws IOException;
}
