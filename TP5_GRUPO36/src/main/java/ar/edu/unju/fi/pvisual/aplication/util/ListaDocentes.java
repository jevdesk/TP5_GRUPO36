package ar.edu.unju.fi.pvisual.aplication.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.pvisual.aplication.model.Docente;

public class ListaDocentes {
	
	private ArrayList<Docente> listaDocentes;
	
	public ListaDocentes() {
		listaDocentes = new ArrayList<>();
		Docente docente1 = new Docente(1598,"Ariel","Vega","s@gmail.com",999999999);
		Docente docente2 = new Docente(1010,"Gustavo","Sosa","s@gmail.com",154123123);
		Docente docente3 = new Docente(2020,"Carolina","Apaza","s@gmail.com",154123123);
		Docente docente4 = new Docente(1403,"Juan C","Rodriguez","s@gmail.com",154123123);
		listaDocentes.add(docente1);
		listaDocentes.add(docente2);
		listaDocentes.add(docente3);
		listaDocentes.add(docente4);
	}

	public ArrayList<Docente> getListaDocentes() {
		return listaDocentes;
	}

	public void setListaDocentes(ArrayList<Docente> listaDocentes) {
		this.listaDocentes = listaDocentes;
	}
	
	public Docente buscarDocente(int legajo) {
		Optional<Docente> docente = getListaDocentes().stream().filter(d -> d.getLegajo() == legajo).findFirst();
		return docente.get();
	}


}
