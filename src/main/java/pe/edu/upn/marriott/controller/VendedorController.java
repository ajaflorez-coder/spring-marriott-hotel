package pe.edu.upn.marriott.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

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
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.VendedorService;


@Controller
@RequestMapping("/vendedor")
@SessionAttributes( {"Vendedor", "alquiler" } )
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private AlquilerService alquilerService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Vendedor> Vendedores = vendedorService.findAll();
			model.addAttribute("Vendedors", Vendedores);
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
				model.addAttribute("Vendedor", optional.get());
			} else {
				return "redirect:/Vendedor";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/Vendedor/edit";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("Vendedor") Vendedor Vendedor, 
			Model model, SessionStatus status) {
		try {
			vendedorService.save(Vendedor);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/Vendedor";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Vendedor Vendedor = new Vendedor();
		model.addAttribute("Vendedor", Vendedor);
		return "/Vendedor/nuevo";
	}
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") String id, Model model) {
		try {
			Optional<Vendedor> Vendedor = vendedorService.findById(id);
			if(Vendedor.isPresent()) {
				vendedorService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Ingreso de datos incorrecto");
			try {
				List<Vendedor> Vendedores = vendedorService.findAll();
				model.addAttribute("Vendedores", Vendedores);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/Vendedor/inicio";
		}
		return "redirect:/Vendedor";
	}
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") String id, Model model) {
		try {
			Optional<Vendedor> Vendedor = vendedorService.findById(id);
			if(Vendedor.isPresent()) {
				model.addAttribute("Vendedor", Vendedor.get());
			} else {
				return "redirect:/Vendedor";
			}
		} catch (Exception e) {

		}	
		
		return "/Vendedor/info";
	}
	
	@GetMapping("/{id}/nuevoalquiler")
	public String nuevoPaciente(@PathVariable("id") String id, Model model) {
		Alquiler alquiler = new Alquiler();
		try {
			Optional<Vendedor> Vendedor = vendedorService.findById(id);
			if(Vendedor.isPresent()) {
				alquiler.setVendedor(Vendedor.get());
				model.addAttribute("alquiler", alquiler);
			} else {
				return "redirect:/Vendedor";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/Vendedor/nuevoalquiler";
	}
	
	@PostMapping("/savealquiler")
	public String savePaciente(@ModelAttribute("paciente") Alquiler alquiler, 
			Model model, SessionStatus status) {
		try {
			alquilerService.save(alquiler);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/Vendedor/info/" + alquiler.getVendedor().getId();
	}
	
}























