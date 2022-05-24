package ar.edu.unju.fi.pvisual.aplication.controller;

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

import ar.edu.unju.fi.pvisual.aplication.util.ListaAlumnos;
import ar.edu.unju.fi.pvisual.aplication.model.Alumno;

@Controller
@RequestMapping("/alumno")

public class AlumnosController {
	
private static final Log LOGGER = LogFactory.getLog(AlumnosController.class);
	
	
	  @GetMapping("") 
	  public String paginaListaAlumnos(Model model) { 
	  ListaAlumnos listaA= new ListaAlumnos(); 
	  model.addAttribute("alumnos", listaA.getListaAlumnos());
	  return "lista_alumnos"; }
	 
	
	@GetMapping("/nuevo")
	public String getFormAlumnoPage(Model model) {
		model.addAttribute("alumno", new Alumno());
		return "nuevo_alumno";
	}
	
	
	@PostMapping("/guardar")
	public ModelAndView guardarAlumno(@Validated @ModelAttribute("alumno") Alumno alumno, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_alumno");
			mav.addObject("alumno", alumno);
			return mav;
		}
		ModelAndView mav = new ModelAndView("lista_alumnos");
		ListaAlumnos listaAlumno = new ListaAlumnos();
		
		if(listaAlumno.getListaAlumnos().add(alumno)) {
			LOGGER.info("Se guardó un objeto alumno en la lista de alumnos");
		}
		mav.addObject("alumnos", listaAlumno.getListaAlumnos());
		return mav;
	}
	
	@GetMapping("/lista_alumnos")
	public String getListaCursosPage(Model model) {
		ListaAlumnos listaAlumno = new ListaAlumnos();
		model.addAttribute("cursos", listaAlumno.getListaAlumnos());
		return "lista_alumnos";
	}
	

}
