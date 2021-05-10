package ar.edu.unju.fi.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Compra;
import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.ICompraService;
import ar.edu.unju.fi.tp4.service.IProductoService;


@Controller
public class CompraController {
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
	public ModelAndView getNuevaCompraPage() {
		ModelAndView model = new ModelAndView("formulario-compra"); 
		if (productoService.obtenerProductos() == null) {
			productoService.generarTablaProducto();
		}
		model.addObject("productos", productoService.obtenerProductos());
		
		return model;
	}
	
	@PostMapping("/compra/guardar")
	public ModelAndView agregarCompraPage(@RequestParam(name = "id")int id, @RequestParam(name = "codigo")int codigo, @RequestParam(name = "cantidad")int cantidad) {
		ModelAndView model = new ModelAndView("lista-compras");
		Compra compra = new Compra(id, new Producto(),cantidad);
				
		if (productoService.obtenerProductos() == null) {
			productoService.generarTablaProducto();
		}
		
		for (Producto p : productoService.obtenerProductos()) {
			if (p.getCodigo() == codigo) {
				compra.setProducto(p);
				p.setStock(p.getStock()-cantidad);
			}
		}
		
		if (compraService.obtenerCompras() == null) {
			compraService.generarTablaCompra();
		}
		
		compraService.agregarCompra(compra);
		
		model.addObject("compras", compraService.obtenerCompras());
		
		return model;
	}
	
	@GetMapping("/compra/listado")
	public ModelAndView getCompraPage() {
		ModelAndView model = new ModelAndView("lista-compras");
		if (compraService.obtenerCompras() == null) {
			compraService.generarTablaCompra();
		}
		
		model.addObject("compras",compraService.obtenerCompras());
		
		return model;
	}
}