package documentos.modelo;

import org.springframework.data.annotation.Id;

public class Documento {

	@Id
	private String id;
	private String propietario;
	private String colaboradores;
	private String contenido;

	public Documento() { // POJO

	}

	public Documento(String propietario, String colaboradores, String contenido) {

		this.propietario = propietario;
		this.colaboradores = colaboradores;
		this.contenido = contenido;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public String getColaboradores() {
		return colaboradores;
	}

	public void setColaboradores(String colaboradores) {
		this.colaboradores = colaboradores;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	@Override
	public String toString() {
		return "Documento [id=" + id + ", propietario=" + propietario + ", colaboradores=" + colaboradores
				+ ", contenido=" + contenido + "]";
	}

}
