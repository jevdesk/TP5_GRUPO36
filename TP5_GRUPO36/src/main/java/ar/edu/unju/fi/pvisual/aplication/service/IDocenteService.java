package ar.edu.unju.fi.pvisual.aplication.service;

import ar.edu.unju.fi.pvisual.aplication.model.Docente;
import ar.edu.unju.fi.pvisual.aplication.util.ListaDocentes;

public interface IDocenteService {
	
	public Docente getDocente();
	
	public boolean guardarDocente(Docente docente);
	
	public void modificarDocente(Docente docente);

	public void eliminarDocente(int legajo);

	public ListaDocentes getListaDocentes();

	public Docente buscarDocente(int legajo);

}
