package ar.edu.unju.fi.pvisual.aplication.model;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


public class Beca {
	
	@NotNull
	@Min(value = 1111,message = "El código de la beca debe ser mayor a 1111")
	private int codigo;
	
	private Curso curso;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Seleccione o teclee Fecha de Inicio")
	@FutureOrPresent(message = "Ingrese fecha actual o futura")
	private LocalDate fechaInicio;
	
	@NotNull(message = "Seleccione o teclee Fecha de Cierre")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future(message = "La fecha debe ser posterior")
	private LocalDate fechaCierre;
	
	private String estado;
	
	
	/**
	 * Constructor por defecto de Beca que inicializa al atributo Curso
	 */
	public Beca() {
		//curso = new Curso();
	}
	
	/**
	 * Constructor con todos los atributos del objeto Beca
	 * @param codigo Nro. de Cód de la Beca
	 * @param curso Nombre del curso para la beca
	 * @param fechaInicio Fecha de inicio de la beca
	 * @param fechaCierre Fecha de cierre de la beca
	 * @param estado estado de la beca
	 */
	public Beca(int codigo, Curso curso, LocalDate fechaInicio, LocalDate fechaCierre, String estado) {
		super();
		this.codigo = codigo;
		this.curso = curso;
		this.fechaInicio = fechaInicio;
		this.fechaCierre = fechaCierre;
		this.estado = estado;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public LocalDate getFechaCierre() {
		return fechaCierre;
	}
	
	public void setFechaCierre(LocalDate fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
