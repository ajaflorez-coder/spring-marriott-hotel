package pe.edu.upn.marriott.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.services.ClienteServices;

@org.springframework.stereotype.Controller
@RequestMapping("/Cliente")
public class ControllerCliente {
	@Autowired
	private ClienteServices clienteService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Cliente> clientes = clienteService.findAll();
			model.addAttribute("clientes",clientes);
		}catch(Exception e) {}
		return "/Cliente/index";
	}
	@GetMapping("/Editar{id}")
	public String editar(@PathVariable("id") int id,Model model) {
		try {
			Optional<Cliente> optional= clienteService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("cliente",optional.get());
			}else {
				return "redirect:/Cliente";
			}
		}catch(Exception e) {
			
		}
		return "/Cliente/Editar";
	}
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int id,Model model) {
		try {
			Optional<Cliente> optional=clienteService.findById(id);
			if(optional.isPresent()) {
				model.addAttribute("clientes",optional.get());
			}else {
				return "redirect:/Cliente";
			}
		}catch(Exception e) {
			
		}
		return "/Cliente/delete";
	}
	
	
}
