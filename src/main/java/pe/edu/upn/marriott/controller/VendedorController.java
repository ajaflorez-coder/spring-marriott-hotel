package pe.edu.upn.marriott.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upn.marriott.models.entity.Alquiler;
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.AlquilerServices;
import pe.edu.upn.marriott.services.VendedorService;

@Controller
@RequestMapping("/vendedor")
@SessionAttributes( {"vendedor"} )
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@Autowired 
	private AlquilerServices alquilerService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Vendedor> vendedores = vendedorService.findAll();
			model.addAttribute("vendedores", vendedores);//mismo nombre
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/Vendedor/inicio";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("vendedor")Vendedor vendedor, 
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
		Vendedor vendedor=new Vendedor();
		model.addAttribute("vendedor",vendedor);
		try {
			List<Alquiler> alquileres = 
					alquilerService.findAll();
			model.addAttribute("alquileres", alquileres);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/Vendedor/nuevo";
	}
	
	
}
