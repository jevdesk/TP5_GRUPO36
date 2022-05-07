package ar.edu.unju.fi.pvisual.aplication.model;


public class Docente {
	
	private int legajo;
	private String nombre;
	private String apellido;
	private String email;
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
