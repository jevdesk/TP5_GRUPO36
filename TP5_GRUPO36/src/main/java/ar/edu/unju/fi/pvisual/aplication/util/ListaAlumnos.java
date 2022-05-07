package ar.edu.unju.fi.pvisual.aplication.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.pvisual.aplication.model.Alumno;

public class ListaAlumnos {
	
	private List<Alumno> listaAlumnos;

	public ListaAlumnos() {
		listaAlumnos = new ArrayList<>();
		Alumno alumno1 = new Alumno(30303090,"Ariel","Mamaní","arielguti111@gmail.com",4496476);
		Alumno alumno2 = new Alumno(33333333,"José","Acosta","arielguti111@gmail.com",4496476);
		Alumno alumno3 = new Alumno(33333333,"Jonathan","Vera","arielguti111@gmail.com",4496476);
		Alumno alumno4 = new Alumno(33333333,"Alejandro","Gallardo","arielguti111@gmail.com",4496476);
		listaAlumnos.add(alumno1);
		listaAlumnos.add(alumno2);
		listaAlumnos.add(alumno3);
		listaAlumnos.add(alumno4);
	}
	
	public List<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(List<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	
}
