package ar.edu.unju.fi.tp4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	@GetMapping("/home")
	public String getPageHome() {
		return "home";
	}
	
	@GetMapping("/prueba")
	public String getPageCompra() {
		return "compra";
	}
	
	@GetMapping("/pruebaa")
	public String getPageCompraa() {
		return "listacompra";
	}
	
}
