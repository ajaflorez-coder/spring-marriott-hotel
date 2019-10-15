package pe.edu.upn.marriott.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.services.AlquilerServices;

@Controller
@RequestMapping("/alquiler")
@SessionAttributes( {"alquiler"} )
public class AlquilerController {

	
	@Autowired
	private AlquilerServices alquilerService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Alquiler> alquileres = alquilerService.findAll();
			model.addAttribute("alquileres", alquileres);//mismo nombre
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/Alquiler/inicio";
	}
	
	
}
