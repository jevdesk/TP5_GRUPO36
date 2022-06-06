package ar.edu.unju.fi.pvisual.aplication.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.pvisual.aplication.model.Beca;

/**
 * Clase que permite crear una lista de objetos Becas
 * y también tiene un atributo que inicializa una lista de cursos
 * @author arielguti - G36
 */
@Service
public class ListaBecas {
	
	private List<Beca> listaBecas;
	
	/**
	 * Atributo que permite acceder a la lista de Cursos
	 */
	//private ListaCursos listaCursos = new ListaCursos();
	
	/**
	 * Constructor por defecto que carga el atributo ListaBeca
	 */
	public ListaBecas() {
		//listaBecas = new ArrayList<Beca>();
		cargarListaBecas();
	}


	//Procedimiento que permite cargar el atributo tipo lista listaBecas
	public void cargarListaBecas() {
		listaBecas = new ArrayList<>();
		ListaCursos listaCursos = new ListaCursos();
		Beca beca1 = new Beca(1,listaCursos.getCursos().get(0),LocalDate.of(2020,04,20),LocalDate.of(2021, 04, 20),"Activo");
		listaBecas.add(beca1);
    }
	
	/**
	 * Getter que permite obtener lista de objetos becas
	 * @return ArrayList de objetos Beca
	 */
	public List<Beca> getListaBecas() {
		return listaBecas;
	}

	public void setListaBecas(List<Beca> listaBecas) {
		this.listaBecas = listaBecas;
	}
	
}
