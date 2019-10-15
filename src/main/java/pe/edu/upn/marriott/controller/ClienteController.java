package pe.edu.upn.marriott.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.services.ClienteService;
import pe.edu.upn.marriott.services.HabitacionService;

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
	
	
	@PostMapping("/save")
	public String save(@ModelAttribute("cliente") Cliente cliente, 
			Model model, SessionStatus status) {
		try {
			clienteService.save(cliente);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/cliente";
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
	
	
	
	
	

}
