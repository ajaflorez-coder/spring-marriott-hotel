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
import pe.edu.upn.marriott.services.ClienteService;
@Controller
@RequestMapping("/cliente")

@SessionAttributes("cliente")
public class ClienteController {
	@Autowired
	private ClienteService clienteService;
	
	
	
	
	
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
		return "redirect:/cliente";
	}
}
