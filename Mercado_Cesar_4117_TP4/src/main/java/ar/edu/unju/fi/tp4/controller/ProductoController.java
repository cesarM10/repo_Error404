package ar.edu.unju.fi.tp4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tp4.model.Producto;
import ar.edu.unju.fi.tp4.service.IProductoService;

@Controller
public class ProductoController {
	@Autowired
	@Qualifier("productoUtilService")
	private IProductoService productoService;
	
	@Autowired
	@Qualifier("productoObj")
	private Producto producto;
	
	@GetMapping("/producto/nuevo")
	public String getNuevoProductoPage(Model model) {
		model.addAttribute(producto);
		return "nuevoproducto";
	}
	
	@PostMapping("/producto/guardar")
	public ModelAndView agregarProductoPage(@ModelAttribute("producto")Producto producto) {
		ModelAndView model = new ModelAndView("productos");
		if (productoService.obtenerProductos() == null) {
			productoService.generarTablaProducto();
		}
		productoService.agregarProducto(producto);
		
		model.addObject("producto", productoService.obtenerProductos());
		return model;
	}
	
	@GetMapping("/producto/ultimo")
	public ModelAndView ultimoProductoPage() {
		ModelAndView modelView = new ModelAndView("ultimoproducto");
		if(productoService.obtenerProductos() == null) {
			productoService.generarTablaProducto();
		}
		modelView.addObject("producto", productoService.ultimoProducto());
		
		return modelView;
	}
	
	@GetMapping("/producto/listado")
	public ModelAndView getProductosPage(){
		ModelAndView model = new ModelAndView("productos");
		if(productoService.obtenerProductos() == null) {
			productoService.generarTablaProducto();
		}
		
		model.addObject("producto", productoService.obtenerProductos());
		return model;
	}
	
}
