package pe.edu.upn.marriott.controllers;

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
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.ClienteService;
import pe.edu.upn.marriott.services.VendedorService;

@Controller
@RequestMapping("/cliente")
@SessionAttributes( {"cliente", "alquiler" } )
public class ClienteController {

	@Autowired
	private ClienteService clienteservice;
	
	@Autowired
	private VendedorService vendedorservice;
	
	@Autowired
	private AlquilerService alquilerservice;
	
	@GetMapping
	public String inicia(Model model) {
		try {
			List<Cliente> clientes = clienteservice.findAll();
			model.addAttribute("clientes", clientes);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/inicia";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cliente> optional = clienteservice.findById(id);
			if (optional.isPresent()) {
				
				List<Alquiler> alquileres 
					= alquilerservice.findAll(); 
				
				model.addAttribute("cliente", optional.get());
				model.addAttribute("alquileres", alquileres);
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
			clienteservice.save(cliente);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/cliente";
	}
	
	@GetMapping("/new")
	public String nuevo(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		try {
			List<Alquiler> alquiler = 
					alquilerservice.findAll();
			model.addAttribute("alquileres", alquiler);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/new";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cliente> cliente = clienteservice.findById(id);
			if(cliente.isPresent()) {
				clienteservice.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Cliente> clientes = clienteservice.findAll();
				model.addAttribute("clientes", clientes);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/cliente/inicia";
		}
		return "redirect:/cliente";
	}
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cliente> cliente = clienteservice.findById(id);
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
	

