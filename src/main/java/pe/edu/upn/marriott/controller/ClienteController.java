package pe.edu.upn.marriott.controller;

import java.util.List;
import java.util.Optional;

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


import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.services.ClienteService;
import pe.edu.upn.marriott.services.HabitacionService;


@Controller
@RequestMapping("/cliente")
@SessionAttributes({"cliente","alquiler"})
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List <Cliente> clientes=clienteService.findAll();
			model.addAttribute("clientes",clientes);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/registrar";
		
	}
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cliente> optional = clienteService.findById(id);
			if (optional.isPresent()) {
				
				List<Habitacion> habitaciones
					=habitacionService.findAll();
				
				model.addAttribute("cliente", optional.get());
				model.addAttribute("habitaciones", habitaciones);
			} else {
				return "redirect:/cliente";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/cliente/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("Cliente") Cliente cliente, 
			Model model, SessionStatus status) {
		try {
			clienteService.save(cliente);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/cliente";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Cliente medico = new Cliente();
		model.addAttribute("medico", medico);
		try {
			List<Habitacion> habitaciones = 
					habitacionService.findAll();
			model.addAttribute("habitaciones", habitaciones);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/nuevo";
	}

}
