package ar.edu.unju.fi.pvisual.aplication.model;

import java.time.LocalDate;


public class Curso {
	
	private int codigo;
	private String titulo;
	private String categoria;
	private LocalDate fechaInicio;
	private LocalDate fechaFinal;
	private int cantidadHoras;
	private String modalidad;
	private Docente docente;
	
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
