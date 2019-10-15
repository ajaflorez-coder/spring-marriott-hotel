package pe.edu.upn.marriott.controller;


import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import pe.edu.upn.marriott.models.entity.*;
import pe.edu.upn.marriott.models.repository.ClienteRepository;
import pe.edu.upn.marriott.service.*;
import pe.edu.upn.marriott.services.ClienteService;
import pe.edu.upn.marriott.services.HabitacionService;
import pe.edu.upn.marriott.services.TipoService;
import pe.edu.upn.marriott.services.VendedorService;

@Controller
@RequestMapping("/habitacion")
@SessionAttributes( {"habitacion", "tipo" } )
public class HabitacionesController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Habitacion> habitaciones = habitacionService.findAll();
			model.addAttribute("medicos", habitaciones);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitaciones/inicio";
	}
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> medico = habitacionService.findById(id);
			if(medico.isPresent()) {
				model.addAttribute("habitaicon", medico.get());
			} else {
				return "redirect:/habitacion";
			}
		} catch (Exception e) {

		}	
		
		return "/habitacion/info";
	}
	
	
}










