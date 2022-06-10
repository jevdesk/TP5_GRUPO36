package ar.edu.unju.fi.pvisual.aplication.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.pvisual.aplication.model.Curso;
import ar.edu.unju.fi.pvisual.aplication.model.Docente;
import ar.edu.unju.fi.pvisual.aplication.service.ICursoService;
import ar.edu.unju.fi.pvisual.aplication.util.ListaCursos;
import ar.edu.unju.fi.pvisual.aplication.util.ListaDocentes;

@Service("cursoServiceList")
public class CursoServiceImp implements ICursoService {
	
	@Autowired 
	private ListaCursos cursos;
	
	@Autowired
	private ListaDocentes listaDocente;
	
	@Override
	public Curso getCurso() {
		return new Curso();
	}

	@Override
	public boolean guardarCurso(Curso curso) {
		
		return cursos.getCursos().add(curso);
	}

	@Override
	public void modificarCurso(Curso curso) {
		for(Curso c: cursos.getCursos()) {
			if(c.getCodigo()==curso.getCodigo()) {
				c.setCantidadHoras(curso.getCantidadHoras());
				c.setCategoria(curso.getCategoria());
				c.setFechaFinal(curso.getFechaFinal());
				c.setFechaInicio(curso.getFechaInicio());
				c.setModalidad(curso.getModalidad());
				c.setTitulo(curso.getTitulo());
				
				Optional<Docente> docente = listaDocente.getListaDocentes().stream().filter(d -> d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
				c.setDocente(docente.get());
			}
		}
		
	}

	@Override
	public void eliminarCurso(int codigo) {
		for(Curso c: cursos.getCursos()) {
			if(c.getCodigo()==codigo) {
				cursos.getCursos().remove(c);
				break;
			}
		}
		
	}

	@Override
	public ListaCursos listaCursos() {
		
		return cursos;
		
	}

	@Override
	public Curso buscarCurso(int codigo) {
		Optional<Curso> curso=cursos.getCursos().stream().filter(c -> c.getCodigo() == codigo).findFirst();
		return curso.get();
	}

}
