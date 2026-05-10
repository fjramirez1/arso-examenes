package control.servicio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import control.evento.EventoAccesoCreado;
import control.modelo.Acceso;
import control.puerto.PublicadorEventos;

public class ServicioControl implements IServicioControl {
	private final PublicadorEventos publicadorEventos = FactoriaServicios.getServicio(PublicadorEventos.class);

	private List<String> usuariosRegistrados;

	public ServicioControl() {
		usuariosRegistrados = new ArrayList<>();
		usuariosRegistrados.add("javi@example.com");
		usuariosRegistrados.add("maria@example.com");
		usuariosRegistrados.add("pedro@example.com");
	}

	@Override
	public boolean estaRegistrado(String email) {
		return usuariosRegistrados.contains(email);
	}

	@Override
	public void altaAcceso(Acceso acceso) throws IOException {
		EventoAccesoCreado evento = new EventoAccesoCreado(acceso.getTipoAcceso(), acceso.getEmail(),
				acceso.getIdMonitor(), acceso.getFechaHora());
		publicadorEventos.publicarEvento(evento);
	}
}
