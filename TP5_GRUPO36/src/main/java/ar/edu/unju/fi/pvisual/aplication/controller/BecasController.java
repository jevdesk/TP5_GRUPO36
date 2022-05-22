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

import ar.edu.unju.fi.pvisual.aplication.model.Beca;
import ar.edu.unju.fi.pvisual.aplication.model.Curso;
import ar.edu.unju.fi.pvisual.aplication.util.ListaAlumnos;
import ar.edu.unju.fi.pvisual.aplication.util.ListaBecas;
import ar.edu.unju.fi.pvisual.aplication.util.ListaCursos;

@Controller
@RequestMapping("/beca")
public class BecasController {
	
	private ListaBecas listaBecasb = new ListaBecas();	
	private ListaAlumnos alumnos = new ListaAlumnos();	
	private static final Log LOGGER = LogFactory.getLog(BecasController.class);
	
	@GetMapping("")
	public String getFirstListBecasPage(Model model) {
		ListaBecas listaBecas = new ListaBecas();
		model.addAttribute("becas", listaBecas.getListaBecas());
		return "lista_becas";
	}
	
	@GetMapping("/nuevo")
	public String getFormBecaPage(Model model) {
		model.addAttribute("beca", new Beca());
		ListaCursos cursos = new ListaCursos();
		model.addAttribute("cursos", cursos.getCursos());
		return "nueva_beca";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaBecasPage(@Validated @ModelAttribute("beca") Beca beca, BindingResult bindingResult) {
		//El objeto bindingResult contiene el resultado de la validación,
		//los errores que pueden haber ocurrido
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nueva_beca");
			mav.addObject("beca", beca);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("lista_becas");
		ListaBecas listaBecas = new ListaBecas();
		//ListaCursos listaCursos = new ListaCursos();
		LOGGER.info("new beca: " + beca.getCurso().getCodigo() + "," + beca.getCurso().getTitulo()+","+beca.getCurso().getCantidadHoras()+
				"hs,"+beca.getCurso().getModalidad());
		if(listaBecasb.getListaBecas().add(beca))
			LOGGER.info("Se agregó un objeto al arrayList de becas");
		//mav.addObject("cursos", listaCursos.getCursos());
		mav.addObject("becas",listaBecasb.getListaBecas());
		return mav;
	}

	
	@GetMapping("/beneficios")//url->/beca/beneficios
	public ModelAndView mostrarListado() {
		ModelAndView model = new ModelAndView("beneficios"); //en pagina beneficios.html
		ListaBecas listaBecas = new ListaBecas();
		//ListaAlumnos alumnos = new ListaAlumnos();
		model.addObject("beneficiados", listaBecasb.getListaBecas());//objeto beneficiados para html
		model.addObject("alumnos", alumnos.getListaAlumnos());//objeto alumnos para html
		return model;
	}

}
