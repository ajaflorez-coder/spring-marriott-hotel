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


import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Cliente;
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.repository.AlquilerRepository;
import pe.edu.upn.marriott.services.AlquilerService;
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
	
	@Autowired
	private AlquilerService alquilerService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List <Cliente> clientes=clienteService.findAll();
			model.addAttribute("clientes",clientes);
			
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
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		try {
			List<Alquiler> alquileres = 
					alquilerService.findAll();
			model.addAttribute("alquileres",alquileres);
		} catch (Exception e) {
			// TODO: handle exception
		}
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
			
			model.addAttribute("dangerDel", "ERROR - ViolaciÃ³n contra el principio de Integridad referencia");
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
