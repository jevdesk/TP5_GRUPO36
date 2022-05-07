package ar.edu.unju.fi.pvisual.aplication.util;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.pvisual.aplication.model.Curso;
import ar.edu.unju.fi.pvisual.aplication.model.Docente;

public class ListaCursos {
	
	private List<Curso> cursos;
	
	Docente docente1 = new Docente(1598,"Ariel","Vega","s@gmail.com",154123123);
	Docente docente2 = new Docente(1010,"Gustavo","Sosa","s@gmail.com",154123123);
	Docente docente3 = new Docente(2020,"Carolina","Apaza","s@gmail.com",154123123);
	Docente docente4 = new Docente(1403,"Juan C","Rodriguez","s@gmail.com",154123123);
		
	/**
	 * Constructor por defecto que inicializa el atributo cursos en arraylist
	 * crea objetos tipo Curso y añade estos objetos al atributo tipo lista de cursos
	 */
	public ListaCursos() {
		cursos = new ArrayList<>();
		Curso curso1 = new Curso(1,"Idiomas","RRPP",LocalDate.of(2020,04,20),LocalDate.of(2021, 04, 20),60,"Virtual",docente3);
		Curso curso2 = new Curso(2,"Diseño","Informátio",LocalDate.of(2020,04,20),LocalDate.of(2021, 04, 20),60,"Virtual",docente4);
		Curso curso3 = new Curso(3,"Desarrollo","Informático",LocalDate.of(2020,04,20),LocalDate.of(2021, 04, 20),60,"Virtual",docente1);
		Curso curso4 = new Curso(4,"Marketing","Comercial",LocalDate.of(2020,04,20),LocalDate.of(2021, 04, 20),60,"Presencial",docente1);
		Curso curso5 = new Curso(5,"Conferencias","RRPP",LocalDate.of(2020,04,20),LocalDate.of(2021, 04, 20),60,"Presencial",docente2);
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);
		cursos.add(curso4);
		cursos.add(curso5);
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
}
