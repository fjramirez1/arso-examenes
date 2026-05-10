package control.rest.dto;

import java.util.Date;

import control.modelo.TipoAcceso;

public class AccesoInputDTO {
	private TipoAcceso tipoAcceso;
	private String email;
	private int idMonitor;
	private Date fechaHora;

	public AccesoInputDTO() {
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
