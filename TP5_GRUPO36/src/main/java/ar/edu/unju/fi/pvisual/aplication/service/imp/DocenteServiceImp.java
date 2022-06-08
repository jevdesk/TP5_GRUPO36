package ar.edu.unju.fi.pvisual.aplication.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.pvisual.aplication.model.Docente;
import ar.edu.unju.fi.pvisual.aplication.service.IDocenteService;
import ar.edu.unju.fi.pvisual.aplication.util.ListaDocentes;

@Service
public class DocenteServiceImp implements IDocenteService {

	@Autowired
	private ListaDocentes docentes;
	
	@Override
	public Docente getDocente() {
		return new Docente();
	}

	@Override
	public boolean guardarDocente(Docente docente) {		
		return docentes.getListaDocentes().add(docente);
	}

	@Override
	public void modificarDocente(Docente docente) {
		for(Docente docenteUbicado: docentes.getListaDocentes()) {
			if(docenteUbicado.getLegajo() == docente.getLegajo()) {
				docenteUbicado.setLegajo(docente.getLegajo());
				docenteUbicado.setApellido(docente.getApellido());
				docenteUbicado.setNombre(docente.getNombre());
				docenteUbicado.setEmail(docente.getEmail());
				docenteUbicado.setTelefono(docente.getTelefono());
			}
		}
		
	}

	@Override
	public void eliminarDocente(int legajo) {
		for(Docente docente: this.docentes.getListaDocentes()) {
			if(docente.getLegajo() == legajo) {
				this.docentes.getListaDocentes().remove(docente);
			}
		}		
	}

	@Override
	public ListaDocentes getListaDocentes() {
		return this.docentes;
	}

	@Override
	public Docente buscarDocente(int legajo) {
		Optional<Docente> docente = this.docentes.getListaDocentes().stream().filter(doc -> doc.getLegajo() == legajo).findFirst();
		return docente.get();
	}

}
