package ar.edu.unju.fi.pvisual.aplication.controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import ar.edu.unju.fi.pvisual.aplication.model.Curso;

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
		model.addAttribute("curso", listaC.getCursos());
		return "listaCursos";
	}
	
	@GetMapping("/nuevo")
	public String formularioNuevoCurso(Model model) {
		model.addAttribute("curso", new Curso());
		ListaDocentes listaD= new ListaDocentes();
		model.addAttribute("docente",listaD.getListaDocentes());
		return "nuevo_curso";
	}
	
	
	@PostMapping("/guardar")
	public ModelAndView getPageListaCursos(@ModelAttribute (value = "curso")Curso curso) {
		
		ModelAndView mav= new ModelAndView("listaCursos");
		// creo un objeto de la clase listaCursos, donde está el arrayList
		ListaCursos listC = new ListaCursos();
		if(listC.getCursos().add(curso)) {
			LOGGER.info("Se agregó un objeto al arrayList de CURSOS");
		}
		//enviar el arrayList de alumnos a la página lista_alumnos
		mav.addObject("curso", listC.getCursos());
		return mav;
	}
	
	
	

}
