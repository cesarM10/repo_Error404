package ar.edu.unju.fi.tp4.service;

import java.util.List;

import ar.edu.unju.fi.tp4.model.Cliente;

public interface IClienteService {
	public void generarTablaCliente();
	
	public void agregarCliente(Cliente cliente);
	
	public List<Cliente> obtenerClientes();

}
