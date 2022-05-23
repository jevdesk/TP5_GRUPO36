package ar.edu.unju.fi.pvisual.aplication.controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.pvisual.aplication.model.Curso;
import ar.edu.unju.fi.pvisual.aplication.model.Docente;
import ar.edu.unju.fi.pvisual.aplication.util.ListaCursos;
import ar.edu.unju.fi.pvisual.aplication.util.ListaDocentes;

@Controller
@RequestMapping("/curso")

public class cursosController {
	
	private static final Log LOGGER = LogFactory.getLog(cursosController.class);
	
	
	
	/* redireccionamiento a pagina lista_cursos */
	
	
	  @GetMapping("") 
	  public String paginaListaCursos(Model model) { 
	  ListaCursos listaC= new ListaCursos(); 
	  model.addAttribute("cursos", listaC.getCursos());
	  return "listaCursos"; }
	 
	
	@GetMapping("/nuevo")
	public String formularioNuevoCurso(Model model) {
		model.addAttribute("curso", new Curso());
		ListaDocentes listaD= new ListaDocentes();
		
		model.addAttribute("docentes",listaD.getListaDocentes());
		return "nuevo_curso";
	}
	
	
	@PostMapping("/guardar")
	public ModelAndView guardarCurso(@Validated @ModelAttribute("curso") Curso curso, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_curso");
			mav.addObject("curso", curso);
			ListaDocentes listaDocente = new ListaDocentes();
			mav.addObject("docentes", listaDocente.getListaDocentes());
			return mav;
		}
		ModelAndView mav = new ModelAndView("listaCursos");
		ListaCursos listaCurso = new ListaCursos();
		ListaDocentes listaDocente = new ListaDocentes();
		Optional<Docente> docente = listaDocente.getListaDocentes().stream().filter(d -> d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
		curso.setDocente(docente.get());
		if(listaCurso.getCursos().add(curso)) {
			LOGGER.info("Se guardó un objeto curso en la lista de cursos");
		}
		mav.addObject("cursos", listaCurso.getCursos());
		return mav;
	}
	
	@GetMapping("/listaCursos")
	public String getListaCursosPage(Model model) {
		ListaCursos listaCurso = new ListaCursos();
		model.addAttribute("cursos", listaCurso.getCursos());
		return "listaCursos";
	}
	

}
