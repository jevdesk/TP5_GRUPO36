package ar.edu.unju.fi.pvisual.aplication.controller;

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

import ar.edu.unju.fi.pvisual.aplication.model.Docente;
import ar.edu.unju.fi.pvisual.aplication.service.IDocenteService;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	private IDocenteService docenteService;
	
	private static final Log LOGGER = LogFactory.getLog(DocenteController.class);
	
	@GetMapping("/lista")
	public String GetListaDocentePage(Model model) {
		model.addAttribute("docentes", this.docenteService.getListaDocentes().getListaDocentes());
		return "lista_docente";
	}
	
	@GetMapping("/nuevo")
	public ModelAndView getFormDocentePage() {
		ModelAndView mav = new ModelAndView("nuevo_docente");
		mav.addObject("docente", docenteService.getDocente());
		return mav;
	}

	@PostMapping("/guardar")
	public ModelAndView guardarDocente(@Validated @ModelAttribute("docente") Docente docente, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_docente");
			mav.addObject("docente", docente);
			return mav;
		}
		ModelAndView mav = new ModelAndView("lista_docente");
		LOGGER.info("nuevo docente: "+docente.getApellido()+", "+docente.getNombre());
		if(this.docenteService.guardarDocente(docente))
			LOGGER.info("Se guardó al docente en la lista de docentes");
		mav.addObject("docentes", this.docenteService.getListaDocentes().getListaDocentes());
		return mav;
	}
	
	@GetMapping("/editar/{legajo}")
	public ModelAndView getEditarDocentePage(@PathVariable("legajo") int legajo) {
		ModelAndView mav = new ModelAndView("edicion_docente");
		Docente docente = this.docenteService.buscarDocente(legajo);
		mav.addObject("docente", docente);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView modificarDocente(@Validated @ModelAttribute("docente") Docente docente, BindingResult validacion) {
		if(validacion.hasErrors()) {
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_docente");
			mav.addObject("docente", docente);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/docente/lista");
		this.docenteService.modificarDocente(docente);
		return mav;
	}
	
	@GetMapping("/eliminar/{legajo}")
	public ModelAndView eliminarDocente(@PathVariable("legajo") int legajo) {
		ModelAndView mav = new ModelAndView("redirect:/docente/lista");
		Docente docente = this.docenteService.buscarDocente(legajo);
		LOGGER.info("Docente eliminado: "+docente.getApellido()+docente.getNombre());
		this.docenteService.eliminarDocente(legajo);
		return mav;
	}
	
}
