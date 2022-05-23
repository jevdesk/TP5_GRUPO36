package ar.edu.unju.fi.pvisual.aplication.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;




public class Curso {
	
	/*
	 * @NotEmpty(message = "el campo no puede estar vacio") private int codigo;
	 * 
	 * @Size(min=3,max=30, message = "el campo debe terner entre 3 y 30 letras" )
	 * 
	 * @NotEmpty(message = "el campo no puede estar vacio") private String titulo;
	 * 
	 * @Size(min=3,max=30, message = "el campo debe terner entre 3 y 30 letras" )
	 * 
	 * @NotEmpty(message = "el campo no puede estar vacio") private String
	 * categoria;
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate fechaInicio;
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") private LocalDate fechaFinal;
	 * 
	 * @Min(value = 1) @Max(value = 100) private int cantidadHoras;
	 * 
	 * @Size(min=3,max=30, message = "el campo debe terner entre 3 y 30 letras" )
	 * 
	 * @NotEmpty(message = "el campo no puede estar vacio") private String
	 * modalidad;
	 * 
	 * @NotNull(message="Debe seleccionar un docente") private Docente docente;
	 * 
	 */
	
	@Min(value=1, message="El valor mínimo es 1") @Max(value=9999,message="El valor máximo permitido es 9999")
	private int codigo;
	@NotEmpty(message="El título no puede ser vacío")
	private String titulo;
	@NotNull @FutureOrPresent(message="La fecha debe ser hoy o posterior")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaInicio;
	@NotNull @Future(message="La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaFinal;
	@Min(value=1,message="Cantidad de horas debe ser mayor a 1")
	private int cantidadHoras;
	@NotEmpty(message="Modalidad no puede ser vacío")
	private String modalidad;
	@NotNull(message="Debe seleccionar un docente")
	private Docente docente;
	@NotEmpty(message="Categoría no puede ser vacío")
	private String categoria;
	
	public Curso() {
		
	}
	
	/**
	 * Constructor con todos los parámetros
	 * @param codigo Cod de curso
	 * @param titulo Nombre del curso
	 * @param categoria Tipo de curso
	 * @param fechaInicio Fecha de inicio del curso
	 * @param fechaFinal Fecha de finalización del curso
	 * @param cantidadHoras cantidad total de hs del curso
	 * @param modalidad Presencial o Virtual
	 * @param docente objeto Docente a cargo del curso
	 */
	public Curso(int codigo, String titulo, String categoria, LocalDate fechaInicio, LocalDate fechaFinal,
			int cantidadHoras, String modalidad, Docente docente) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.categoria = categoria;
		this.fechaInicio = fechaInicio;
		this.fechaFinal = fechaFinal;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.docente = docente;
	}
	

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public LocalDate getFechaFinal() {
		return fechaFinal;
	}
	
	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	public int getCantidadHoras() {
		return cantidadHoras;
	}
	
	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}
	
	public String getModalidad() {
		return modalidad;
	}
	
	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}
	
	public Docente getDocente() {
		return docente;
	}
	
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
	
}
