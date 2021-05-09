package ar.edu.unju.fi.tp4.service;
import java.util.List;

import ar.edu.unju.fi.tp4.model.Compra;
public interface ICompraService {
public void generarTablaCompra();
	
	public void agregarCompra(Compra compra);
	
	public List<Compra> obtenerCompras();

}
