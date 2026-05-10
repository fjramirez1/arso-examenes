package control.puerto;

import java.io.IOException;

import control.evento.Evento;

public interface PublicadorEventos {
	void publicarEvento(Evento evento) throws IOException;
}