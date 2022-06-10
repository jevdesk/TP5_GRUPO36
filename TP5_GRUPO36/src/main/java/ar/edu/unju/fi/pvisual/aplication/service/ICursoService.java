package ar.edu.unju.fi.pvisual.aplication.service;

import ar.edu.unju.fi.pvisual.aplication.model.Curso;
import ar.edu.unju.fi.pvisual.aplication.util.ListaCursos;

public interface ICursoService {
	
	public Curso getCurso();
	
	public boolean guardarCurso(Curso curso);
	
	public void modificarCurso(Curso curso);
	
	public void eliminarCurso(int codigo);
	
	public ListaCursos listaCursos();
	
	public Curso buscarCurso(int codigo);
	
	
}
