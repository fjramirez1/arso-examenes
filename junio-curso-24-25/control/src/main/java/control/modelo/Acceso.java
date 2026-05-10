package control.modelo;

import java.util.Date;

import control.rest.dto.AccesoInputDTO;

public class Acceso {
	private TipoAcceso tipoAcceso;
	private String email;
	private int idMonitor;
	private Date fechaHora;

	public Acceso() {
	}

	public Acceso(TipoAcceso tipoAcceso, String email, int idMonitor, Date fechaHora) {
		this.tipoAcceso = tipoAcceso;
		this.email = email;
		this.idMonitor = idMonitor;
		this.fechaHora = fechaHora;
	}

	public Acceso(AccesoInputDTO accesoInputDTO) {
		this.tipoAcceso = accesoInputDTO.getTipoAcceso();
		this.email = accesoInputDTO.getEmail();
		this.idMonitor = accesoInputDTO.getIdMonitor();
		this.fechaHora = accesoInputDTO.getFechaHora();
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

	@Override
	public String toString() {
		return "Acceso [tipoAcceso=" + tipoAcceso + ", email=" + email + ", idMonitor=" + idMonitor + ", fechaHora="
				+ fechaHora + "]";
	}
}
