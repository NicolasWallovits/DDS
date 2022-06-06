class Atuendo
	...
	
	public bool contienePrenda (Prenda prenda) {
		return (this.prendaSuperior == prenda || this.prendaInferior == prenda || this.prendaCalzado == prenda || this.accesorio == prenda);
	}

	
	
	
class Guardarropas
	...
	
	public void quitarAtuendo (Atuendo atuendo) {
		atuendos.remove(atuendo);
	}
	
	public void quitarPrenda (Prenda prenda) {
		atuendos.removeIf(contienePrenda(prenda));
		prendas.remove(prenda);
	}
	
	public void agregarPrenda (Prenda prenda) {
		prendas.add(prenda);
	}
	
	public void aPropuestaRealizada (Propuesta propuesta) {
		propuestasPendientes.remove(propuesta);
		propuestasFinalizadas.add(propuesta);
	}
	
	public void aPropuestaPendiente (Propuesta propuesta) {
		propuestasFinalizadas.remove(propuesta);
		propuestasPendientes.add(propuesta);
	}
	
	
abstract class PropuestaGuardarropas
	private Guardarropas guardarropas;
	private Prenda prenda;
	private EstadoPropuesta estado;
	
	public PropuestaGuardarropas(Guardarropas guardarropas, Prenda prenda) {
		this.guardarropas = guardarropas;
		this.prenda = prenda;
		this.estado = EstadoPropuesta.PENDIENTE;
	}
	
	public void aceptar();
	public void deshacer();
	
	public void rechazar() {
		this.estado = EstadoPropuesta.RECHAZADA;
		guardarropas.aPropuestaRealizada(this);
	}
	
	
	
	
class PropuestaQuitar extends PropuestaGuardarropas

	public PropuestaQuitar(Guardarropas guardarropas, Prenda prenda) {
		super(guardarropas, prenda);
	}

	public void aceptar() {
		guardarropas.quitarPrenda(this.prenda);
		this.estado = EstadoPropuesta.ACEPTADA;
		guardarropas.aPropuestaRealizada(this);
	}
		
	public void deshacer() {
		if (this.estado == EstadoPropuesta.ACEPTADA)
			guardarropas.agregarPrenda(this.prenda);
		
		this.estado = EstadoPropuesta.PENDIENTE;
		guardarropas.aPropuestaPendiente(this);
	}
	
	
class PropuestaAgregar extends PropuestaGuardarropas

	public PropuestaAgregar(Guardarropas guardarropas, Prenda prenda) {
		super(guardarropas, prenda);
	}
	
	public void aceptar() {
		guardarropas.agregarPrenda(this.prenda);
		this.estado = EstadoPropuesta.ACEPTADA;
		guardarropas.aPropuestaRealizada;
	}
	
	public void deshacer() {
		if (this.estado == EstadoPropuesta.ACEPTADA)
			guardarropas.quitarPrenda(this.prenda);
		
		this.estado = EstadoPropuesta.PENDIENTE;
		guardarropas.aPropuestaPendiente(this);
	}
