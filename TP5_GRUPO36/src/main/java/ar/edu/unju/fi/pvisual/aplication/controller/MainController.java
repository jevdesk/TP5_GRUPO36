package ar.edu.unju.fi.pvisual.aplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("/")
	public String getIndex() {		
		return "index";
	}
	
	@GetMapping("/agenda")
	public String getAgendaPage() {		
		return "agenda";
	}

	@GetMapping("/beneficios")
	public String getBeneficiosPage() {		
		return "beneficios";
	}
	
	@GetMapping("/contacto")
	public String getContactoPage() {		
		return "contacto";
	}
	@GetMapping("/design")
	public String getDesingPage() {		
		return "design";
	}

}
