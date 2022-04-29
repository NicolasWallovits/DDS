
// PseudoCodigo QMP

class Prenda
	public Prenda (TipoDePrenda tipo, Material material, Color colorPrimario, Color colorSecundario) {
		
		// valido tipo, material, y colorPrimario. ninguno de ellos puede ser nulo
		// colorSecundario en cambio sí puede ser nulo
		
		this.tipo = tipo;
		this.material = material;
		this.colorPrimario = colorPrimario;
		this.colorSecundario = colorSecundario;
		
	}
	
	metodo categoria () {
		
		return (this.tipo.categoria ());
		
	}
	
	
class TipoDePrenda
	public TipoDePrenda (Categoria categoria) {
		
		// valido categoria, que no pueda ingresar un null
		this.categoria = categoria;
		
	}
	
	metodo categoria () {
		
		return (this.categoria);
		
	}
	
class Color
	public Color (int rojo, int verde, int azul) {
		
		// podria validar también máximos y mínimos de color
		// (por ejemplo de 0 a 256), no nulos, no negativos, etc.
		this.rojo = rojo;
		this.verde = verde;
		this.azul = azul;
		
	}
