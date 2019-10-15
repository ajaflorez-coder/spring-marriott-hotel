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

import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.VendedorService;

@Controller
@RequestMapping("/vendedor")
@SessionAttributes("vendedor")
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;
	
	@PostMapping("/save")
	public String save(@ModelAttribute("vendedor")Vendedor vendedor, Model model,SessionStatus status) {
	     try {
			vendedorService.save(vendedor);
			status.setComplete();
		} catch (Exception e) {
			// TODO: handle exception
		}
	     return "redirect:/";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Vendedor vendedor=new Vendedor();
		model.addAttribute("vendedor", vendedor);
		
		
		return "/vendedor/nuevo";
	}
	
}
