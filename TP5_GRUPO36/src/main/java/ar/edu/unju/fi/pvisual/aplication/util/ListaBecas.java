package ar.edu.unju.fi.pvisual.aplication.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.pvisual.aplication.model.Beca;
import ar.edu.unju.fi.pvisual.aplication.model.Curso;
import ar.edu.unju.fi.pvisual.aplication.model.Docente;

public class ListaBecas {
	
	private List<Beca> listaBecas;
	private ListaCursos listaCursos = new ListaCursos();
	
	/**
	 * Constructor por defecto que carga el atributo ListaBeca
	 */
	public ListaBecas() {
		//listaBecas = new ArrayList<Beca>();
		cargarListaBecas();
	}

	/**
	 * Procedimiento que permite cargar el atributo tipo lista listaBecas
	 */
	public void cargarListaBecas() {
		listaBecas = new ArrayList<>();
		Beca beca1 = new Beca(1,listaCursos.getCursos().get(0),LocalDate.of(2020,04,20),LocalDate.of(2021, 04, 20),"Activo");
		Beca beca2 = new Beca(2,listaCursos.getCursos().get(1),LocalDate.of(2020,04,20),LocalDate.of(2021, 04, 20),"Pendiente");
		listaBecas.add(beca1);
		listaBecas.add(beca2);
    }
	
	
	public List<Beca> getListaBecas() {
		return listaBecas;
	}

	public void setListaBecas(List<Beca> listaBecas) {
		this.listaBecas = listaBecas;
	}
	
}
