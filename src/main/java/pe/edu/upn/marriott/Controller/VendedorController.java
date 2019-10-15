package pe.edu.upn.marriott.Controller;

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
import pe.edu.upn.marriott.models.entity.Vendedor;
import pe.edu.upn.marriott.services.VendedorService;

@Controller
@RequestMapping("/vendedor")
public class VendedorController {
	List<Vendedor> vendedores;
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping
	public String listado(Model model) {
		try {
			vendedores = vendedorService.findAll();
			model.addAttribute("vendedores", vendedores);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "/Vendedor/listado";
	}
	
	@GetMapping("/register")
	public String registro(Model model) {
		Vendedor vendedor = new Vendedor();
		
		model.addAttribute("vendedor", vendedor);
		
		return "/Vendedor/register";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("vendedor") Vendedor vendedor, Model model,SessionStatus status){
		try {
			vendedorService.save(vendedor);
			status.setComplete();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return "redirect:/vendedor";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") String id,Model model) {
		try {
			Optional<Vendedor> optional = vendedorService.findById(id);
			
			if(optional.isPresent()) {
				model.addAttribute("vendedor", optional.get());
			}else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return "/Vendedor/edit";
	}
	
	@GetMapping("/del/{id}")
	public String delete(@PathVariable("id") String id, Model model) {
		try {
			Optional<Vendedor> producto = vendedorService.findById(id);
			if(producto.isPresent()) {
				vendedorService.deleteById(id);
			}
		}catch(Exception e) {
			model.addAttribute("dangerDel", "ERROR - Violacion contra el principio de integridad referencial");
			return "/vendedor";
		}
		return "redirect:/vendedor";
	}
}
