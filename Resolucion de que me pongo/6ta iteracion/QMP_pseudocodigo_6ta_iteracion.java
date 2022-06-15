class Empleado {
	
	private RepositorioUsuario repoUsuarios;
	private AlertasActuales alertasActuales;
	
	public void dispararSugerencias() {
		repoUsuarios.getUsuarios.forEeach(usuario => usuario.getSugerenciaDiaria());
	}
	
	public void refrescarAlertas() {
		alertasActuales.refrescarAlertas()
	}
	
}

class Usuario {
	
	private List<Atuendo> sugerencias;
	private AsesorImagen asesor;
	private AlertasActuales alertasActuales;
	private List<AccionConfigurable> acciones;
	private String correoElectronico;
	
	public void getSugerenciaDiaria() {
		
		sugerencias = asesor.sugerir();
		
	}
	
	public void realizarAccionesSobreAlertas() {
		
		accionesConfigurables.forEach(accion -> accion.nuevasAlertasMeteorologicas(this, alertasActuales));
		
	}
	
	public void agregarAccion(AccionConfigurable a) {
		
		if (!acciones.contains(a))
			acciones.add(a);
		
	}
	public void removerAccion(AccionConfigurable a) {
		
		if (acciones.contains(a))
			acciones.remove(a);
		
	}
	
}

class AlertasActuales { // como SINGLETON
	
	ServicioMeteorologico servicio;
	List<Alerta> alertas
	
	public void refrescarAlertas() {
		
		this.alertas = servicio.getAlertas();
		
	}
	
}

public interface Correo {
	
	public enviarCorreo(Usuario user, String cuerpo);
	
}

interface Notificador {
	
	public notificar(String mensaje);
	
}

public interface AccionConfigurable {
	
	public void nuevasAlertasMeteorologicas(Usuario usuario, AlertasActuales alertasActuales);
	
}

public class NotificarAlertas implements AccionConfigurable {
	
	public void nuevasAlertasMeteorologicas(Usuario usuario, AlertasActuales alertasActuales) {
		
		if (alertasActuales.contains(Alerta.TORMENTA)) {
			new Notificador().notificar("Sali con paraguas!");
		}
		else if (alertasActuales.contains(Alerta.GRANIZO)) { 
			new Notificador().notificar("No salgas en auto!");	
		}
		
	}
	
}

public class MandarMail implements AccionConfigurable { 

	@Override
	public void nuevasAlertasMeteorologicas(Usuario usuario) {
		enviarCorreo(usuario.getCorreoElectronico, "Hay nuevas alertas...");
	}
	
}

public class RecalcularSugerencias implements AccionConfigurable {
	
	@Override
	public void nuevasAlertasMeteorologicas(Usuario usuario) {
		usuario.getSugerenciaDiaria();
	}
	
}