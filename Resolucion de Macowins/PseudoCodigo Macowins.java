
// PseudoCodigo Macowins

class Prenda
	metodo precio ()
		retornar estado.precioFinal (precioBase)
		
class Nueva
	metodo precioFinal (precioBase)
		retornar (precioBase)
		
class Promocion
	metodo precioFinal (precioBase)
		retornar (precioBase - valorDescuento)
		
class Liquidacion
	metodo precioFinal (precioBase)
		retornar (precioBase / 2)
		
class Item
	metodo importe ()
		retornar (prenda.precio * cantidad)
		
class Venta
	metodo importe ()
		if (pagaConTarjeta)
			retornar (items.sum(item.importe ()) * 1.01 + cantidadCuotas * coeficienteTarjeta)
		else
			retornar (items.sum(item.importe ()))
		
class Negocio
	metodo gananciasDeDia (dia)
		retornar ventas
			.filter (venta.esDeFecha (dia))
			.sum (venta.importe ())
