package documentos.rest.dto;

import javax.validation.constraints.NotNull;

public class NuevoDocumentoDTO {
	
	@NotNull
	private String propietario;
	private String colaboradores;
	@NotNull
	private String contenido;

    public NuevoDocumentoDTO() { // POJO
    
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

}

