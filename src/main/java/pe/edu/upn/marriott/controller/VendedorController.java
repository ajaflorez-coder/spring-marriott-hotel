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
import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.AlquilerService;
import pe.edu.upn.marriott.services.HabitacionService;
import pe.edu.upn.marriott.services.VendedorService;

@Controller
@RequestMapping("/vendedor")
@SessionAttributes({"habitacion", "alquiler"})
public class VendedorController {

	
	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private AlquilerService alquilerService;
	
	@Autowired
	private HabitacionService habitacionService;
	
	
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
				
				List<Alquiler> alquileres 
					= alquilerService.findAll(); 
				
				model.addAttribute("vendedor", optional.get());
				model.addAttribute("alquileres", alquileres);
			} else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/medico/edit";
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
		model.addAttribute("vendedor",vendedor);
		try {
			List<Alquiler> alquileres = alquilerService.findAll();
			model.addAttribute("alquileres",alquileres);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/vendedor/nuevo";
	}
	
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") String id, Model model) {
		try {
			Optional<Vendedor> vendedor = vendedorService.findById(id);
			if(vendedor.isPresent()) {
				vendedorService.deleteById(id);
			}
		} catch (Exception e) {
			model.addAttribute("dangerDel","ERROR - violacion contra el principio de integridad referencial");
			
			try {
				List<Vendedor> vendedor = vendedorService.findAll();
				model.addAttribute("vendedores",vendedor);
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
				model.addAttribute("vendedor",vendedor.get());
			}else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {
		
		}
		
		
		return "/vendedor/info";
		
	}
	
	








}
