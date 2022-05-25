package ar.edu.unju.fi.pvisual.aplication.controller;

import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.pvisual.aplication.model.Beca;
import ar.edu.unju.fi.pvisual.aplication.model.Curso;
import ar.edu.unju.fi.pvisual.aplication.util.ListaAlumnos;
import ar.edu.unju.fi.pvisual.aplication.util.ListaBecas;
import ar.edu.unju.fi.pvisual.aplication.util.ListaCursos;

@Controller
@RequestMapping("/beca")
public class BecasController {
	
	private ListaBecas listaBecas = new ListaBecas();	
	private ListaAlumnos alumnos = new ListaAlumnos();	
	private static final Log LOGGER = LogFactory.getLog(BecasController.class);
	
	@GetMapping("")
	public String getFirstListBecasPage(Model model) {
		//ListaBecas listaBecas = new ListaBecas();
		model.addAttribute("becas", listaBecas.getListaBecas());
		return "lista_becas";
	}
	
	/**
	 * Función controller "Get" que muestra un formulario para Beca
	 * @param model Permite trabajar con los objetos beca y cursos
	 * @return Muestra la webPage nueva_beca
	 */
	@GetMapping("/nuevo")
	public String getFormBecaPage(Model model) {
		model.addAttribute("beca", new Beca());
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
		
		if(listaBecas.getListaBecas().add(beca))
			LOGGER.info("Se agregó un objeto al arrayList de becas");
		
		mav.addObject("becas",listaBecas.getListaBecas());
		return mav;
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
		model.addObject("beneficiados", listaBecas.getListaBecas());//objeto beneficiados para html
		model.addObject("alumnos", alumnos.getListaAlumnos());//objeto alumnos para html
		return model;
	}

}
