class UniformeInstitucional
	public UniformeInstitucional (Uniforme uniforme, Instituto instituto) {
		
		if (uniforme != NULL && instituto != NULL) {
			
			this.uniforme = uniforme;
			this.instituto = instituto;
			
		}
		
	}

class Uniforme
	public Uniforme (Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado) {
		
		if (prendaSuperior.categoria () == Categoria.PARTE_SUPERIOR && prendaInferior.categoria () == Categoria.PARTE_INFERIOR && prendaCalzado.categoria () == Categoria.CALZADO) {
			
			this.prendaSuperior = prendaSuperior;
			this.prendaInferior = prendaInferior;
			this.prendaCalzado = prendaCalzado;
			
		}
		
	}

class Borrador
	// para los atributos de tipo, material y colorPrimario valido que si el usuario ya tenía uno elegido (not NULL), no pueda pasar a simplemente deselegirlo, sino que de última elija otro
	public setTipo (TipoDePrenda tipoNuevo) {
		
		if (tipoNuevo != NULL)
			this.tipo = tipoNuevo;
	
	}
	
	public setMaterial (Material materialNuevo) {
		
		if (materialNuevo != NULL)
			this.material = material;
		
	}
	
	public setColorPrimario (Color colorNuevo) {
		
		if (colorNuevo != NULL)
			this.colorPrimario = colorNuevo;
		
	}
	
	// particularmente para colorSecundario y trama, el usuario podría pasar a no elegir ninguno después de ya haber preseleccionado algún valor. Porque la prenda acepta que sean NULLs
	public setColorSecundario (Color colorNuevo) {
		
		this.colorSecundario = colorNuevo;
		
	}
	
	public setTrama (Trama tramaNueva) {
		
		this.trama = tramaNueva;
		
	}
	
	public Prenda crearPrenda () {
		
		// sólo chequeo que no sean NULLs tipo, material y colorPrimario. el resto no habría problemas
		if (this.tipo != NULL && this.material != NULL && this.colorPrimario != NULL)
			new Prenda (this.tipo, this.material, this.colorPrimario, this.colorSecundario, this.trama);
		
	}

class Prenda
	public Prenda (TipoDePrenda tipo, Material material, Color colorPrimario, Color colorSecundario, Trama trama) {
		
		// valido tipo, material, y colorPrimario. ninguno de ellos puede ser nulo
		// colorSecundario en cambio sí puede ser nulo
		// EDIT: para esta segunda iteración no valido estas cosas. Porque esas validaciones se hacen de última en el borrador
		
		this.tipo = tipo;
		this.material = material;
		this.colorPrimario = colorPrimario;
		this.colorSecundario = colorSecundario;
		
		if (trama == NULL)
			this.trama = Trama.LISA;
		else
			this.trama = trama;
		
	}
	
	metodo categoria () {
		
		return (this.tipo.categoria ());
		
	}
	
	
class TipoDePrenda
	public TipoDePrenda (Categoria categoria) {
		
		// valido categoria, que no pueda ingresar un null
		// EDIT: acá en realidad no tengo que validar nada. Porque algo discutimos con Roli en clase y tiene razón, y es que el usuario va a interactuar con una UI. O sea no va a tener posibilidad de ingresar un valor no especificado en por ejemplo un dropdown
		this.categoria = categoria;
		
	}
	
	metodo categoria () {
		
		return (this.categoria);
		
	}
	
class Color
	public Color (int rojo, int verde, int azul) {
		
		// podria validar también máximos y mínimos de color
		// (por ejemplo de 0 a 256), no nulos, no negativos, etc.
		// EDIT: acá en realidad tampoco tengo que validar nada. El usuario probablemente vea una paleta de colores, de donde selecciona uno, y de fondo se hace el calculo de estos valores
		this.rojo = rojo;
		this.verde = verde;
		this.azul = azul;
		
	}
