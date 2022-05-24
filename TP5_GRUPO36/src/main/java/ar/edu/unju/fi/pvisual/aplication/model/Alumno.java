package ar.edu.unju.fi.pvisual.aplication.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class Alumno {
	
	@Min(value=10000000, message="Debe tener 8 dígitos") 
	@Max(value=99999999,message="Debe tener 8 dígitos")
	private int dni;
	@NotEmpty(message="El título no puede ser vacío")
	@Size(min=1,max=68,message="El tamaño del nombre no es valido")
	@Pattern(
			regexp ="^([a-zA-Z\\w]+(\\s[a-zA-Z\\w]+)*)$", 
			message ="No se admiten espacios como único, primer, o último caracter"
			)
	private String nombre;
	@NotEmpty(message="El nombre es requerido")
	@Size(min=1,max=24,message="El tamaño del apellido no es valido")
	@Pattern(
			regexp ="^([a-zA-Z\\w]+(\\s[a-zA-Z\\w]+)*)$", 
			message ="No se admiten espacios como único, primer, o último caracter"
			)
	private String apellido;
	@NotEmpty(message="El correo es requerido")
	@Email(message = "Correo es no valido", regexp = "^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")
	private String email;
	@NotEmpty(message="El correo es requerido")
	@Pattern(
			regexp ="^((\\d{2,4}|[(]\\d{2,4}[)])(\\s(15))?\\s?\\d{6,8}|(\\d{2,4}|[(]\\d{2,4}[)])(15)?\\d{6,8})$", 
			message ="Debe tener código de área de 2 a 4 dígitos entre parentesis o sin ellos, separado del resto con un espacio, usar u omitir el 15, separado o junto al resto de 6 a 8 dígitos. Ejemplo: (999) 15 8887777, (999) 158887777 (999)158887777, 999 15 8887777, 999 158887777, 9998887777"
			)
	private String telefono;
	
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
	public Alumno(int dni, String nombre, String apellido, String email, String telefono) {
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
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
