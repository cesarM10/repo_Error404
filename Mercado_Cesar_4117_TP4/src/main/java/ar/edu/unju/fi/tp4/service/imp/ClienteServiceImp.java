package ar.edu.unju.fi.tp4.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tp4.model.Cliente;
import ar.edu.unju.fi.tp4.service.IClienteService;
import ar.edu.unju.fi.tp4.util.TablaCliente;

@Service("clienteUtilService")
public class ClienteServiceImp implements IClienteService {
	
	private static final Log LOGGER = LogFactory.getLog(ClienteServiceImp.class);
	private List<Cliente> clienteList;
	
	@Override
	public void generarTablaCliente() {
		clienteList = TablaCliente.listaClientes;
		clienteList.add(new Cliente("DNI",1234,"Cesar Mercado","cesarm10@gmail.com","01234",LocalDate.of(1992, 04, 10),3886,617729,LocalDate.of(2021, 03, 17)));
		clienteList.add(new Cliente("Pasaporte",5678,"David Mercado","example@gmail.com","98765",LocalDate.of(1993, 07, 8),3886,849151,LocalDate.of(2021, 04, 10)));
		LOGGER.info("METHOD: generarTablaCliente - creo primer cliente por defecto" + clienteList.get(clienteList.size()-1));

	}

	@Override
	public void agregarCliente(Cliente cliente) {
		// agrego un cliente a la lista de clientes
		
		clienteList.add(cliente);
		LOGGER.info("METHOD: agregarCliente - se agrego un objeto Cliente a la lista ->" + clienteList.get(clienteList.size()-1));

	}

	@Override
	public List<Cliente> obtenerClientes() {
		LOGGER.info("METHOD: obtenerClientes - se recupero la lista de Objeto Cliente");
		
		return clienteList;
	}

}
