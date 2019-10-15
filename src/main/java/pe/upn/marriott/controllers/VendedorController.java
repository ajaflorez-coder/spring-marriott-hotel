package pe.upn.marriott.controllers;

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
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.demo.model.entity.Especialidad;
import pe.edu.upn.demo.model.entity.Medico;
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.VendedorService;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Vendedor> vendedores = vendedorService.findAll();
			model.addAttribute("vendedor", vendedores);
		} catch (Exception e) {
		
		}
		return "/vendedores/lista";
	}
	
	@GetMapping("/edit/{id}")
	public String editar (@PathVariable("id") int id, Model model) {
		try {
			Optional<Vendedor> optional = vendedorService.findById("id");
			if (optional.isPresent()) {
				
				List<Habitaciones> habitaciones 
					= habitacionesService.findAll(); 
				
				model.addAttribute("vendedores", optional.get());
				model.addAttribute("habitaciones", habitaciones);
			} else {
				return "redirect:/vendedores";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("vendedor") Vendedor vendedor, 
			Model model, SessionStatus status) {
		try {
			vendedorService.save(vendedor);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/vendedores";
	}
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Vendedor> vendedor = vendedorService.findById("id");
			if(medico.isPresent()) {
				vendedorService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Vendedor> vendedores = vendedorService.findAll();
				model.addAttribute("vendedores", vendedores);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/vendedores/inicio";
		}
		return "redirect:/vendedores";
	}
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Vendedor> vendedores = vendedorService.findById("id");
			if(vendedores.isPresent()) {
				model.addAttribute("vendedores", vendedores.get());
			} else {
				return "redirect:/vendedores";
			}
		} catch (Exception e) {

		}	
		
		return "/vendedores/info";
	}
	
}
