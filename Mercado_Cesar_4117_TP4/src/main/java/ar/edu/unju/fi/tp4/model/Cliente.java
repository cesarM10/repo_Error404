package ar.edu.unju.fi.tp4.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Component("clienteObj")
public class Cliente {
	private String tipoDocumento;
	private int nroDocumento;
	private String nombreApellido;
	private String email;
	private String password;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private int codigoAreaTelefono;
	private int nroTelefono;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Cliente(String tipoDocumento, int nroDocumento, String nombreApellido, String email, String password,
			LocalDate fechaNacimiento, int codigoAreaTelefono, int nroTelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}



	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public int getNroDocumento() {
		return nroDocumento;
	}

	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	public int getNroTelefono() {
		return nroTelefono;
	}

	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}

	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}


	public int getEdad() {
		int edad = 0;
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento, hoy);
		edad = periodo.getYears();
		return edad;
	}
		
	public String calculoTiempoUltimaCompra() {
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechaUltimaCompra, hoy);
		String tiempoUltimaCompra = "Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
		
		return tiempoUltimaCompra; 
	}
	
	public long calculoTiempoDesdeNacimiento(){
		Calendar hoy = Calendar.getInstance();
		Calendar fechaNac = Calendar.getInstance();
		fechaNac.set(this.fechaNacimiento.getYear(),this.fechaNacimiento.getMonthValue()-1,this.fechaNacimiento.getDayOfMonth());
		
		long milisec = hoy.getTimeInMillis() - fechaNac.getTimeInMillis();
		long dias = milisec / 1000 / 60 / 60 / 24;
		
		return dias;
	}	
	
	public String calculoTiempoHastaCumple() {
		String texto = "";
		LocalDate hoy = LocalDate.now();
		int varanio=hoy.getYear();;
		if(hoy.getMonthValue() >= this.fechaNacimiento.getMonthValue()) {
			if(hoy.getMonthValue() == this.fechaNacimiento.getMonthValue() && hoy.getDayOfMonth() < this.fechaNacimiento.getDayOfMonth() ) {
				varanio = hoy.getYear()+1;
			}
			
			if(hoy.getMonthValue() > this.fechaNacimiento.getMonthValue()) {
				varanio = hoy.getYear()+1;
			}
			
		}else {
			varanio =hoy.getYear();
		}
		LocalDate fechaProxCumple = LocalDate.of(varanio, this.fechaNacimiento.getMonthValue(), this.fechaNacimiento.getDayOfMonth());
		
		Period periodo = Period.between(hoy,  fechaProxCumple);
		texto = "Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
				
		return texto;
	}
	
	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", nombreApellido="
				+ nombreApellido + ", email=" + email + ", password=" + password + ", fechaNacimiento="
				+ fechaNacimiento + ", codigoAreaTelefono=" + codigoAreaTelefono + ", nroTelefono="
				+ nroTelefono + ", fechaUltimaCompra=" + fechaUltimaCompra + "]";
	}

	
}
