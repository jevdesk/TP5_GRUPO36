package ar.edu.unju.fi.pvisual.aplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.pvisual.aplication.util.ListaCursos;


@Controller
public class MainController {
	
	private ListaCursos losCursos = new ListaCursos();
		
//	@GetMapping("/")
//	public String getIndex() {		
//		return "index";
//	}
	
	@GetMapping("/agenda")
	public String getAgendaPage() {		
		return "agenda";
	}

	@GetMapping("/contacto")
	public String getContactoPage() {		
		return "contacto";
	}
	
	@GetMapping("/design")
	public String getDesingPage() {		
		return "design";
	}
		
	@GetMapping("/")
	public ModelAndView getIndexCursos() {
		ModelAndView model = new ModelAndView("index");		
		model.addObject("cursos", losCursos.getCursos());//objeto cursos para html
		return model;
	}
	
	@RequestMapping("/formulario")
    public String capturar() {
        return "contacto";
    }
	
}
