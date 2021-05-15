package ar.edu.unju.fi.tp4.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.service.imp.CompraServiceImp;
import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.ICompraService;
import ar.edu.unju.fi.tp4.service.IProductoService;


@Controller
public class CompraController {
	private static final Log LOGGER = LogFactory.getLog(CompraServiceImp.class);
	
	@Autowired
	@Qualifier("productoUtilService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("productoObj")
	private Producto producto;
	
	
	@Autowired
	@Qualifier("compraUtilService")
	private ICompraService compraService;
	
	@Autowired
	@Qualifier("compraObj")
	private Compra compra;
		
	@GetMapping("/compra/nuevo")
	public String getNuevaCompraPage(Model model) {
		model.addAttribute("compra", compra); 
		if (productoService.obtenerProductos() == null) {
			productoService.generarTablaProducto();
		}
		
		model.addAttribute("productos", productoService.obtenerProductos());
		return "formulario-compra";
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView agregarCompraPage(@ModelAttribute("compra")Compra compra) {
		LOGGER.info("Metodo: guardar --");
		ModelAndView model = new ModelAndView("lista-compras");
		
		if (productoService.obtenerProductos() == null) {
			productoService.generarTablaProducto();
		}
		
		
		Producto producto = productoService.getProductoPorCodigo(compra.getProducto().getCodigo(), compra.getCantidad());
		compra.setProducto(producto);
		
		if (compraService.obtenerCompras() == null) {
			compraService.generarTablaCompra();
		}
		compraService.agregarCompra(compra);
		
		model.addObject("compras", compraService.obtenerCompras());
		LOGGER.info(compraService.obtenerCompras());
		return model;
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView getCompraPage() {
		ModelAndView model = new ModelAndView("lista-compras");
		if (compraService.obtenerCompras() == null) {
			compraService.generarTablaCompra();
		}
		
		model.addObject("compras",compraService.obtenerCompras());
		LOGGER.info(compraService.obtenerCompras());
		return model;
	}
}