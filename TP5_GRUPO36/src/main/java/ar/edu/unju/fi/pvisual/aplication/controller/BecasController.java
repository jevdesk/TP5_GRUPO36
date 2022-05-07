package ar.edu.unju.fi.pvisual.aplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.pvisual.aplication.util.ListaAlumnos;
import ar.edu.unju.fi.pvisual.aplication.util.ListaBecas;

@Controller
public class BecasController {
	
	private ListaBecas becas = new ListaBecas();	
	private ListaAlumnos alumnos = new ListaAlumnos();
	
	@GetMapping("/beneficios")
	public ModelAndView mostrarListado() {
		ModelAndView model = new ModelAndView("beneficios");		
		model.addObject("beneficiados", becas.getListaBecas());//objeto beneficiados para html
		model.addObject("alumnos", alumnos.getListaAlumnos());//objeto alumnos para html
		return model;
	}

}
