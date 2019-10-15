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
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.ClienteService;
import pe.edu.upn.marriott.services.VendedorService;


@Controller
@RequestMapping("/vendedor")
@SessionAttributes({"vendedor", "habitaciones"})
public class VendedorController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Vendedor> vendedores = vendedorService.findAll();
			model.addAttribute("Vendedores", vendedores);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return "/vendedor/inicio";
	}
	
	
	

}
