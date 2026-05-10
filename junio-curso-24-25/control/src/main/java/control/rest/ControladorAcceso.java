package control.rest;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import control.modelo.Acceso;
import control.rest.dto.AccesoInputDTO;
import control.servicio.FactoriaServicios;
import control.servicio.IServicioControl;

@Path("acceso")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ControladorAcceso {

	private final IServicioControl servicio = FactoriaServicios.getServicio(IServicioControl.class);

	@Context
	private UriInfo uriInfo;

	@Context
	private HttpServletRequest servletRequest;

	// curl -i -X POST -H "Content-Type: application/json" -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwicm9sZXMiOiJVU1VBUklPIiwiZXhwIjoxNzc4NDE1NjMwfQ.WJGELy9TW682LPrk9dUMj2Ui-5NU55kaqKoZarRkRNc" -d "{\"tipoAcceso\":\"ENTRADA\",\"email\":\"javi@@example.com\",\"idMonitor\":1,\"fechaHora\":\"2025-06-10T10:00:00.000+0000\"}" http://localhost:8080/api/acceso/
	
	@POST
	@PermitAll
	@RolesAllowed("USUARIO")
	public Response createAcceso(AccesoInputDTO dto) throws Exception {
		Acceso acceso = new Acceso(dto);
		if (!servicio.estaRegistrado(acceso.getEmail())) {
			throw new IllegalArgumentException("No está registrado el usuario con email: " + acceso.getEmail());
		}
		servicio.altaAcceso(acceso);
		return Response.accepted().build();
	}
}