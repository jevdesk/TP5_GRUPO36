package ar.edu.unju.fi.pvisual.aplication.service;

import ar.edu.unju.fi.pvisual.aplication.model.Beca;
import ar.edu.unju.fi.pvisual.aplication.util.ListaBecas;

public interface IBecaService {
	
	public Beca getBeca();
	
	public boolean guardarBeca(Beca beca);
	
	public void modificarBeca(Beca beca);
	
	public void eliminarBeca(int codigo);
	
	public ListaBecas getListaBecas();
	
	public Beca buscarBeca(int codigo);

}
