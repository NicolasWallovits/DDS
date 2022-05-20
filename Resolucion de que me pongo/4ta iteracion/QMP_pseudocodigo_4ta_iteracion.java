class Atuendo
	public Atuendo (Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado, Prenda accesorio) {
		
		this.prendaSuperior = prendaSuperior;
		this.prendaInferior = prendaInferior;
		this.prendaCalzado = prendaCalzado;
		this.accesorio = accesorio;
		
		this.tempMaxima = la temp menor entre las prendas que conforman el atuendo
		this.tempMinima = la temp mayor entre las prendas que conforman el atuendo
		
	}
	
	public bool aptaTemperatura (grados) {
		
		return (tempMinima < grados < tempMaxima);
		
	}

	
class Guardarropas
	public Guardarropas () {
		
		this.atuendos = new ArrayList;
		
	}
	
	public void agregarAtuendo (atuendo) {
		
		this.atuendos.add (atuendo);
		
	}
	
	public List<Atuendo> atuendosPosibles (grados) {
		
		return atuendos.filter.aptaTemperatura(grados);		
		
	}
	

class QueMePongoBot
	public QueMePongoBot (Guardarropas guardarropas, ServicioClima servicio) {
		
		this.guardarropas = guardarropas;
		this.servicio = servicio;
		tomarMedicion();
		
	}
	
	public List<Atuendo> sugerir () {
		
		if ((LocalDateTime.now() - ultimaMedicion) > 1 hora)
			tomarMedicion; // esto es para evitar llamar constantemente a un servicio que tiene un costo asociado
		
		return this.guardarropas.atuendosPosibles (this.temperatura);
		
	}
	
	private void tomarMedicion () {
		
		this.temperatura = this.servicio.medirTemperatura ();
		this.ultimaMedicion = LocalDateTime.now();
		
	}