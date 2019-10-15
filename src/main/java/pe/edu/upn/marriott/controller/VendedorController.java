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

import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.VendedorService;

@Controller
@RequestMapping("/vendedor")
@SessionAttributes("vendedor")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Vendedor> vendedores = vendedorService.findAll();
			model.addAttribute("vendedores", vendedores);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/vendedor/inicio";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") String id, Model model) {
		try {
			Optional<Vendedor> optional = vendedorService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("vendedor", optional.get());
			} else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/vendedor/edit";
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
		return "redirect:/vendedor";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Vendedor vendedor = new Vendedor();
		model.addAttribute("vendedor", vendedor);
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/vendedor/nuevo";
	}
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") String id, Model model) {
		try {
			Optional<Vendedor> medico = vendedorService.findById(id);
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
			return "/vendedor/inicio";
		}
		return "redirect:/vendedor";
	}
	
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") String id, Model model) {
		try {
			Optional<Vendedor> vendedor = vendedorService.findById(id);
			if(vendedor.isPresent()) {
				model.addAttribute("vendedor", vendedor.get());
			} else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {

		}	
		
		return "/vendedor/info";
	}
	
	/*
	@GetMapping("/{id}/nuevopaciente")
	public String nuevoPaciente(@PathVariable("id") int id, Model model) {
		Paciente paciente = new Paciente();
		try {
			Optional<Medico> medico = medicoService.findById(id);
			if(medico.isPresent()) {
				paciente.setMedico(medico.get());
				model.addAttribute("paciente", paciente);
			} else {
				return "redirect:/medico";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/medico/nuevopaciente";
	}
	
	@PostMapping("/savepaciente")
	public String savePaciente(@ModelAttribute("paciente") Paciente paciente, 
			Model model, SessionStatus status) {
		try {
			pacienteService.save(paciente);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/medico/info/" + paciente.getMedico().getId();
	}*/
	
}























