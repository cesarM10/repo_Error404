package ar.edu.unju.fi.tp4.service.imp;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.ICompraService;
import ar.edu.unju.fi.tp4.util.TablaCompra;

@Service("compraUtilService")
public class CompraServiceImp implements ICompraService{
	private static final Log LOGGER = LogFactory.getLog(CompraServiceImp.class);
	private List<Compra> compraList;
	
	@Override
	public void generarTablaCompra() {
		compraList = TablaCompra.listaCompras;
		compraList.add(new Compra(1, new Producto(1,"Procesador Core i9",298999.99,"INTEL",100),1));
		LOGGER.info("METHOD: generarTablaCompra - creo primera compra por defecto" + compraList.get(compraList.size()-1));

	}

	@Override
	public void agregarCompra(Compra compra) {
		compraList.add(compra);
		LOGGER.info("METHOD: agregarCompra - se agrego un objeto Compra a la lista ->" + compraList.get(compraList.size()-1));

	}

	@Override
	public List<Compra> obtenerCompras() {
		LOGGER.info("METHOD: obtenerCompras - se recupero la lista de Objeto Compra");

		return compraList;
	}

}
