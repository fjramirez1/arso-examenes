package documentos.evento;

public class EventoUsuarioEliminado extends Evento {

	public static final String TIPO = "usuario-eliminado";

	private final String usuario;

	public EventoUsuarioEliminado(String usuario) {

		super(usuario, TIPO);
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

}