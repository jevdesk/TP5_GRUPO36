package ar.edu.unju.fi.pvisual.aplication.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Component
public class Docente {
	
	@NotNull
	@Min(value = 1000,message = "El número de Legajo debe ser mayor a 1000")
	private int legajo;
	
	@Size(min=2, max=60, message="El(Los) Nombre(s) debe(n) tener entre 2 a 60 caracteres")
	@NotEmpty(message="Debe ingresar por lo menos un Nombre")
	private String nombre;
	
	@Size(min=2, max=60, message="El(Los) Apellido(s) debe(n) tener entre 3 a 60 caracteres")
	@NotEmpty(message="Debe ingresar por lo menos un apellido")
	private String apellido;
	
	@NotEmpty(message="El correo electrónico es requerido")
	@Email(message = "Correo no válido", regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")
	private String email;
	
	@NotNull(message="Debe ingresar un nro de teléfono")
	private long telefono;
	
	
	public Docente() {
		
	}
	
	/**
	 * Constructor con todos los atributos del objeto Docente
	 * @param legajo Nro. de Legajo del docente
	 * @param nombre Nombre(s) del docente
	 * @param apellido Apellido(s) del docente
	 * @param email Correo electrónico del docente
	 * @param telefono Nro de telf fijo o de celular del docente
	 */
	public Docente(int legajo, String nombre, String apellido, String email, long telefono) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public int getLegajo() {
		return legajo;
	}
	
	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public long getTelefono() {
		return telefono;
	}
	
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
}
