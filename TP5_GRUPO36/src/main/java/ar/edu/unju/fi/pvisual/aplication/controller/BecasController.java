package ar.edu.unju.fi.pvisual.aplication.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.pvisual.aplication.model.Beca;
import ar.edu.unju.fi.pvisual.aplication.model.Curso;
import ar.edu.unju.fi.pvisual.aplication.service.IBecaService;
import ar.edu.unju.fi.pvisual.aplication.util.ListaAlumnos;
//import ar.edu.unju.fi.pvisual.aplication.util.ListaBecas;
import ar.edu.unju.fi.pvisual.aplication.util.ListaCursos;

@Controller
@RequestMapping("/beca")
public class BecasController {
	
	@Autowired
	private IBecaService becaService;
	//private ListaBecas listaBecas = new ListaBecas();
	
	private ListaAlumnos alumnos = new ListaAlumnos();	
	private static final Log LOGGER = LogFactory.getLog(BecasController.class);
	
	@GetMapping("/listado")
	public String getFirstListBecasPage(Model model) {
		//ListaBecas listaBecas = new ListaBecas();//opción menos recomendada
		//model.addAttribute("becas", listaBecas.getListaBecas());
		model.addAttribute("becas", becaService.getListaBecas().getListaBecas());
		return "lista_becas";
	}
	
	/**
	 * Función controller "Get" que muestra un formulario para Beca
	 * @param model Permite trabajar con los objetos beca y cursos
	 * @return Muestra la webPage nueva_beca
	 */
	@GetMapping("/nuevo")
	public String getFormBecaPage(Model model) {
		//model.addAttribute("beca", new Beca());
		model.addAttribute("beca", becaService.getBeca());
		
		ListaCursos cursos = new ListaCursos();
		model.addAttribute("cursos", cursos.getCursos());
		return "nueva_beca";
	}
	
	/**
	 * Función controller "Post" que captura un objeto Beca del formulario y lo guarda en la lista de becas
	 * @param beca Objeto rescatado del post del formulario relacionado con la clase Beca
	 * @param bindingResult Permite validar formulario
	 * @return Se obtiene la tabla de becas con el objeto beca guardado
	 */
	@PostMapping("/guardar")
	public ModelAndView getListaBecasPage(@Validated @ModelAttribute("beca") Beca beca, BindingResult bindingResult) {
		//El objeto bindingResult contiene el resultado de la validación,
		//los errores que pueden haber ocurrido
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nueva_beca");
			mav.addObject("beca", beca);
			ListaCursos listCursos= new ListaCursos();
			mav.addObject("cursos", listCursos.getCursos());
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("lista_becas");
		//ListaBecas listaBecas = new ListaBecas();Error. Sobreescribe el registro anterior
		
		ListaCursos listaCursos = new ListaCursos();
		//Modo1 de agregar la propiedad de tipo Curso a la Beca
//		Curso curso = new Curso();
//		for(Curso c:listaCursos.getCursos()) {
//			if(c.getCodigo()==beca.getCurso().getCodigo()) {
////				curso.setCodigo(c.getCodigo());
////				curso.setTitulo(c.getTitulo());
////				curso.setCategoria(c.getCategoria());
////				curso.setFechaFinal(c.getFechaInicio());
////				curso.setFechaFinal(c.getFechaFinal());
////				curso.setCantidadHoras(c.getCantidadHoras());
////				curso.setModalidad(c.getModalidad());
////				curso.setDocente(c.getDocente());
//				curso = c;
//			}
//		}
//		beca.setCurso(curso);
		//Modo2 de agregar la propiedad de tipo Curso a la Beca
		Optional<Curso> curso = listaCursos.getCursos().stream().filter(c->c.getCodigo()==beca.getCurso().getCodigo()).findFirst();
		beca.setCurso(curso.get());		
		LOGGER.info("new beca: " + beca.getCurso().getCodigo() + "," + beca.getCurso().getTitulo() + "," +
					beca.getCurso().getCantidadHoras() + "hs,"+beca.getCurso().getModalidad());
		
		//if(listaBecas.getListaBecas().add(beca))
		if(becaService.guardarBeca(beca));
			LOGGER.info("Se agregó un objeto al arrayList de becas");		
		//mav.addObject("becas",listaBecas.getListaBecas());
		mav.addObject("becas", becaService.getListaBecas().getListaBecas());
		return mav;
	}

	/**
	 * Función controller que abre nueva pág. para editar el objeto beca seleccionado desde el listado	
	 * @param codigo que pertenece al objeto beca seleccionado, enviado en botón
	 * @return devuelve la pág. editar_beca y el objeto beca seleccionado
	 */
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarBeca(@PathVariable("codigo") int codigo) {
		ModelAndView mav = new ModelAndView("editar_beca");
		Beca becaAEditar = becaService.buscarBeca(codigo);
		ListaCursos cursos = new ListaCursos();
		
		mav.addObject("cursos", cursos.getCursos());
		mav.addObject("beca", becaAEditar);
		return mav;
	}
	
	/**
	 * Fción controller que modifica o no al objeto beca figurado en el form editar
	 * @param beca el objeto a modificar
	 * @param bindingResult verificación / validación de inputs
	 * @return retorna al listado sin error o vuelve a cargar el formulario editar por hallar error
	 */
	@PostMapping("/modificar")
	public ModelAndView modificarBeca(@Validated @ModelAttribute("beca") Beca beca, BindingResult bindingResult) {
		if(bindingResult.hasErrors()){
			LOGGER.info("Ocurrió un error: "+ beca);
			ModelAndView mav = new ModelAndView("editar_beca");
			mav.addObject("beca", beca);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/beca/listado");
		this.becaService.modificarBeca(beca);
		return mav;
	}
	
	/**
	 * Fción. controller que elimina al objeto beca seleccionado con el botón eliminar
	 * @param codigo del objeto beca que fue enviado con el botón eliminar
	 * @return Se actualiza el listado de becas
	 */
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView eliminarBeca(@PathVariable("codigo") int codigo) {
		ModelAndView modelav = new ModelAndView("redirect:/beca/listado");
		Beca beca = this.becaService.buscarBeca(codigo);
		LOGGER.info("Beca eliminada: "+beca.toString()+", al curso: "+beca.getCurso().getTitulo());
		this.becaService.eliminarBeca(codigo);		
		return modelav;
	}
	
	/**
	 * Función controller Get que muestra tabla de becas en la página beneficios
	 * (también puede mostrar tabla de alumnos)
	 * @return Devuelve la página beneficios
	 */
	@GetMapping("/beneficios")//url->/beca/beneficios
	public ModelAndView mostrarListado() {
		ModelAndView model = new ModelAndView("beneficios"); //en pagina beneficios.html
		//ListaBecas listaBecas = new ListaBecas();
		//ListaAlumnos alumnos = new ListaAlumnos();
		
		//model.addObject("beneficiados", listaBecas.getListaBecas());//objeto beneficiados para html
		model.addObject("beneficiados", this.becaService.getListaBecas().getListaBecas());
		
		model.addObject("alumnos", alumnos.getListaAlumnos());//objeto alumnos para html
		return model;
	}

}
