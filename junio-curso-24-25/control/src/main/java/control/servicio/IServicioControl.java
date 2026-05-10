package control.servicio;

import java.io.IOException;

import control.modelo.Acceso;

public interface IServicioControl {

	boolean estaRegistrado(String email);

	void altaAcceso(Acceso acceso) throws IOException;
}
