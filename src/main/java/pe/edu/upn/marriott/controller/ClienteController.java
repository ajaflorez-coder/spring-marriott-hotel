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

@SessionAttributes({"cliente","habitacion"})
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Cliente> clientes = clienteService.findAll();
			model.addAttribute("clientes", clientes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/inicio";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cliente> optional = clienteService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("cliente", optional.get());
				
			} else {
				return "redirect:/cliente";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/cliente/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("cliente") Cliente cliente, 
			Model model, SessionStatus status) {
		try {
			clienteService.save(cliente);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/medico";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return "/cliente/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cliente> cliente = clienteService.findById(id);
			if(cliente.isPresent()) {
				clienteService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Cliente> clientes = clienteService.findAll();
				model.addAttribute("clientes", clientes);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/cliente/inicio";
		}
		return "redirect:/cliente";
	}
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cliente> cliente = clienteService.findById(id);
			if(cliente.isPresent()) {
				model.addAttribute("cliente", cliente.get());
			} else {
				return "redirect:/cliente";
			}
		} catch (Exception e) {

		}	
		
		return "/cliente/info";
	}
	@GetMapping("/{id}/nuevohabitacion")
	public String nuevoHabitacion(@PathVariable("id") int id, Model model) {
		Habitacion habitacion = new Habitacion();
		try {
			Optional<Cliente> cliente = clienteService.findById(id);
			if(cliente.isPresent()) {
			
				model.addAttribute("habitacion", habitacion);
			} else {
				return "redirect:/habitacion";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/nuevohabitacion";
	}
	
	@PostMapping("/savehabitacion")
	public String saveHabitacion(@ModelAttribute("habitacion") Habitacion habitacion, 
			Model model, SessionStatus status) {
		try {
			habitacionService.save(habitacion);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/cliente/info/";
	}
	
}
