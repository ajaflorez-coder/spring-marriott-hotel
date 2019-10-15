package pe.edu.upn.marriott.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.ClienteService;

@Controller
@RequestMapping("/alquiler")
@SessionAttributes({"alquiler"})

public class AlquilerController {
	@Autowired
	private AlquilerService alquilerService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Alquiler> alquileres = alquilerService.findAll();
			model.addAttribute("alquileres", alquileres);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/alquiler/ListadoAlquiler";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Alquiler alquiler = new Alquiler();
		
		model.addAttribute("alquiler", alquiler);
		
		return "/alquiler/registroA";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("cliente") Alquiler alquiler, Model model, SessionStatus status) {
		try {
			alquilerService.save(alquiler);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/alquiler";
	}

}
