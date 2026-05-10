package control.auth;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/auth")
public class ControladorAuth {

	private static final String PASSWORD = "arso-2025";

	// curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "idMonitor=1&password=arso-2025" http://localhost:8080/api/auth/login

	// eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwicm9sZXMiOiJVU1VBUklPIiwiZXhwIjoxNzc4NDE3MzQ0fQ.78qac7DNL_E8l7Cx61K56L0OIABKZ14IuUGlPeFIdwo

	@POST
	@Path("/login")
	public Response login(@FormParam("idMonitor") String idMonitor, @FormParam("password") String password) {

		Map<String, Object> claims = verificarCredenciales(idMonitor, password);
		if (claims != null) {
			String token = JwtUtils.generateToken(claims);
			return Response.ok(token).build();
		} else {
			return Response.status(Response.Status.UNAUTHORIZED).entity("Credenciales inválidas").build();
		}

	}

	private Map<String, Object> verificarCredenciales(String idMonitor, String password) {
		if (!PASSWORD.equals(password))
			return null;

		HashMap<String, Object> claims = new HashMap<>();
		claims.put("sub", idMonitor);
		claims.put("roles", "USUARIO");

		return claims;
	}
}
