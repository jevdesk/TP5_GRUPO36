package ar.edu.unju.fi.pvisual.aplication.controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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


import ar.edu.unju.fi.pvisual.aplication.model.Curso;
import ar.edu.unju.fi.pvisual.aplication.model.Docente;
import ar.edu.unju.fi.pvisual.aplication.service.ICursoService;
import ar.edu.unju.fi.pvisual.aplication.util.ListaCursos;
import ar.edu.unju.fi.pvisual.aplication.util.ListaDocentes;

@Controller
@RequestMapping("/curso")

public class cursosController {
	
	@Autowired
	@Qualifier("cursoServiceList")
	private ICursoService cursoService;
	
	private static final Log LOGGER = LogFactory.getLog(cursosController.class);
	
	ListaDocentes listaDocente = new ListaDocentes();
	
	/* redireccionamiento a pagina lista_cursos */
	
	
	  @GetMapping("/lista") 
	  public String paginaListaCursos(Model model) { 
	  model.addAttribute("cursos", cursoService.listaCursos().getCursos());
	  return "listaCursos"; 
	  }
	 
	
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
			
			mav.addObject("docentes", listaDocente.getListaDocentes());
			return mav;
		}
		ModelAndView mav = new ModelAndView("listaCursos");
		
		
		Optional<Docente> docente = listaDocente.getListaDocentes().stream().filter(d -> d.getLegajo() == curso.getDocente().getLegajo()).findFirst();
		curso.setDocente(docente.get());
		if(cursoService.listaCursos().getCursos().add(curso)) {
			LOGGER.info("Se guardó un objeto curso en la lista de cursos");
		}
		mav.addObject("cursos", cursoService.listaCursos().getCursos());
		return mav;
	}
	
	
	
	  @GetMapping("editar/{codigo}") 
	  	  public ModelAndView paginaEditCurso(@PathVariable ("codigo") int codigo) { 
		  ModelAndView mav = new ModelAndView("editar_curso"); 
		  mav.addObject("curso",cursoService.buscarCurso(codigo)); 
		  
		  mav.addObject("docentes",listaDocente.getListaDocentes()); 
		  return mav; 
	  
	  }
	  
	  @PostMapping("/modificar")
	  public ModelAndView ModificarCurso(@Validated @ModelAttribute ("curso") Curso curso,BindingResult bindingResult ) {
		  if(bindingResult.hasErrors()) {
				LOGGER.error("No se cumplen las reglas de validación");
				ModelAndView mav = new ModelAndView("editar_curso");
				mav.addObject("curso", curso);
				mav.addObject("docentes", listaDocente.getListaDocentes());
				return mav;
			}
		  
		  
		  ModelAndView mav = new ModelAndView("redirect:/curso/lista");
		  cursoService.modificarCurso(curso);
		  return mav;
	  }
	 
	
	  @GetMapping("eliminar/{codigo}")
	  public ModelAndView eliminarCurso(@PathVariable ("codigo") int codigo) {
		  ModelAndView mav = new ModelAndView("redirect:/curso/lista");
		  cursoService.eliminarCurso(codigo);
		  return mav;
	  }
}
