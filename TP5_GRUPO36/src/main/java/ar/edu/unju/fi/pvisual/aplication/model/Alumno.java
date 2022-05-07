package ar.edu.unju.fi.pvisual.aplication.model;


public class Alumno {
	
	private int dni;
	private String nombre;
	private String apellido;
	private String email;
	private long telefono;
	
	public Alumno() {
		
	}
	
	/**
	 * Constructor con todos los atributos del objeto Alumno
	 * @param dni Nro de DNI del alumno
	 * @param nombre Nombres del alumno
	 * @param apellido Apellidos del alumno
	 * @param email Correo electrónico del alumno
	 * @param telefono Telefono fijo o celular del alumno
	 */
	public Alumno(int dni, String nombre, String apellido, String email, long telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
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
