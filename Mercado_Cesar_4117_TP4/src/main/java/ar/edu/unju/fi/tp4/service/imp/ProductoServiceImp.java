package ar.edu.unju.fi.tp4.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;
import ar.edu.unju.fi.tp4.util.TablaProducto;

@Service("productoUtilService")
public class ProductoServiceImp implements IProductoService{

	private static final Log LOGGER = LogFactory.getLog(ProductoServiceImp.class);
	
	private List<Producto> productoList;
	
	@Override
	public void generarTablaProducto() {
		productoList = TablaProducto.listaProductos;
		productoList.add(new Producto(1,"Procesador Core i9",298999.99,"INTEL",100));
		productoList.add(new Producto(2,"Procesador Ryzen 5000",299999.99,"AMD",100));
		productoList.add(new Producto(3,"Juego PC F1 2021",1899.99,"CodeMasters",100));
		LOGGER.info("METHOD: generarTablaProducto - crea productos por defecto");

	}
	
	@Override
	public void agregarProducto(Producto producto) {
		// agrego un producto a la lista de productos
		productoList.add(producto);
		LOGGER.info("METHOD: agregarProducto - se agrego un objeto Producto a la lista -> "+ productoList.get(productoList.size()-1));

	}

	@Override
	public Producto ultimoProducto() {
		// muestra el ultimo producto agregado a la lista
		 LOGGER.info("METHOD: ultimoProducto - se muestra el ultimo objeto Producto a la lista -> "+ productoList.get(productoList.size()-1));
		 return productoList.get(productoList.size()-1);
	}

	@Override
	public List<Producto> obtenerProductos() {
		LOGGER.info("METHOD: obtenerProductos - se recupero la lista de Objeto Producto");
		return productoList;
	}

	
}
