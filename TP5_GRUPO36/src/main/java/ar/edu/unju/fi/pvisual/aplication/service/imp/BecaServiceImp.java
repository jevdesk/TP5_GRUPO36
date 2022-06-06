package ar.edu.unju.fi.pvisual.aplication.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.pvisual.aplication.model.Beca;
import ar.edu.unju.fi.pvisual.aplication.service.IBecaService;
import ar.edu.unju.fi.pvisual.aplication.util.ListaBecas;

@Service
public class BecaServiceImp implements IBecaService {
	
	@Autowired
	private ListaBecas listaBeca;

	
	/**
	 * Retorna un objeto vacío de Tipo Beca
	 */
	@Override
	public Beca getBeca() {		
		return new Beca();
	}

	/**
	 * Guarda un objeto Beca en la Lista de Becas
	 * Devuelve verdadero si logró agregar el objeto a la lista
	 */
	@Override
	public boolean guardarBeca(Beca beca) {
		//boolean respuesta = listaBeca.getListaBecas().add(beca);
		//return respuesta;
		return this.listaBeca.getListaBecas().add(beca);
	}

	/**
	 * Procedimiento que modifica la beca que se introduce por parámetro
	 */
	@Override
	public void modificarBeca(Beca beca) {
		for(Beca becaHallada: listaBeca.getListaBecas()) {
			if(becaHallada.getCodigo() == beca.getCodigo()) {
				becaHallada.setCurso(beca.getCurso());
				becaHallada.setEstado(beca.getEstado());
				becaHallada.setFechaInicio(beca.getFechaInicio());
				becaHallada.setFechaCierre(beca.getFechaCierre());
			}
		}
	}
	
	/**
	 * Procedimiento que elimina al objeto beca, ubicado por código
	 */
	@Override
	public void eliminarBeca(int codigo) {
		for(Beca becaUbicada: this.listaBeca.getListaBecas()) {
			if(becaUbicada.getCodigo() == codigo) {
				listaBeca.getListaBecas().remove(becaUbicada);
				break;
			}
		}
	}

	/**
	 * Retorna un objeto que contiene a la Lista de Becas
	 */
	@Override
	public ListaBecas getListaBecas() {		
		return this.listaBeca;
	}

	/**
	 * Busca una Beca por su código y devuelve el objeto Beca encontrado
	 */
	@Override
	public Beca buscarBeca(int codigo) {
		Optional<Beca> labeca = this.listaBeca.getListaBecas().stream().filter(beca->beca.getCodigo()==codigo).findFirst();
		return labeca.get();
//		boolean band=false;
//		for(Beca laBeca: this.listaBeca.getListaBecas()) {
//			if(laBeca.getCodigo()==codigo) {
//				band=true;
//				break;
//			}
//		}
//		return band;
	}
	
}
