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
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.ClienteService;
import pe.edu.upn.marriott.services.HabitacionService;
import pe.edu.upn.marriott.services.VendedorService;

@Controller
@RequestMapping("/cliente")
@SessionAttributes( {"cliente","alquiler"} )
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AlquilerService alquilerService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private VendedorService vendedorService;

	@GetMapping
	public String inicio(Model model) {
		try {
			List<Cliente> cliente = clienteService.findAll();
			model.addAttribute("clientes", cliente);
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
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Cliente> cliente = clienteService.findById(id);
			if(cliente.isPresent()) {
				clienteService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad ");
			try {
				List<Cliente> cliente = clienteService.findAll();
				model.addAttribute("cliente", cliente);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/cliente/inicio";
		}
		return "redirect:/cliente";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		try {
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/nuevo";
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
	
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model , Model model1) {
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
	
	@GetMapping("/{id}/nuevoalquiler/")
	public String nuevoAquiler(@PathVariable("id") int id, Model model) {
		Alquiler alquiler = new Alquiler();
		try {
			Optional<Cliente> cliente = clienteService.findById(id);
			
			
			if(cliente.isPresent()) {
				
				List<Habitacion> habitaciones = habitacionService.findAll();
				List<Vendedor> vendedor = vendedorService.findAll();
				
				alquiler.setCliente(cliente.get());
				model.addAttribute("alquiler", alquiler);
				
				model.addAttribute("habitaciones", habitaciones);
				model.addAttribute("vendedores", vendedor);
				
			} else {
				return "redirect:/cliente";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/cliente/nuevoalquiler";
	}
	
	@PostMapping("/savealquiler")
	public String saveAlquiler(@ModelAttribute("alquiler") Alquiler alquiler, Model model, SessionStatus status) {
		try {
			alquilerService.save(alquiler);
			status.setComplete();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/cliente/info/" + alquiler.getCliente().getId();
	}

	

	

}
