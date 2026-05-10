package control.evento;

import java.util.Date;

import control.modelo.TipoAcceso;

public class EventoAccesoCreado extends Evento {

	public static final String TIPO = "acceso-creado";

	private TipoAcceso tipoAcceso;
	private String email;
	private int idMonitor;
	private Date fechaHora;

	public EventoAccesoCreado(TipoAcceso tipoAcceso, String email, int idMonitor, Date fechaHora) {
		super(email, TIPO);
		this.tipoAcceso = tipoAcceso;
		this.email = email;
		this.idMonitor = idMonitor;
		this.fechaHora = fechaHora;
	}

	public TipoAcceso getTipoAcceso() {
		return tipoAcceso;
	}

	public void setTipoAcceso(TipoAcceso tipoAcceso) {
		this.tipoAcceso = tipoAcceso;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIdMonitor() {
		return idMonitor;
	}

	public void setIdMonitor(int idMonitor) {
		this.idMonitor = idMonitor;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
}