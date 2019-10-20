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
@RequestMapping("/vendedor")
@SessionAttributes({ "vendedor", "alquiler" })
public class VendedorController {

	@Autowired
	private VendedorService vendedorService;

	@Autowired
	private AlquilerService alquilerService;

	@Autowired
	private ClienteService clienteService;

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
	public String save(@ModelAttribute("vendedor") Vendedor vendedor, Model model, SessionStatus status) {
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
			if (medico.isPresent()) {
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
			if (vendedor.isPresent()) {
				model.addAttribute("vendedor", vendedor.get());
			} else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {

		}

		return "/vendedor/info";
	}

	@GetMapping("/{id}/nuevoalquiler")
	public String nuevoAlquiler(@PathVariable("id") String id, Model model) {
		Alquiler alquiler = new Alquiler();
		try {
			Optional<Vendedor> vendedor = vendedorService.findById(id);
			if (vendedor.isPresent()) {

				List<Habitacion> habitaciones = habitacionService.findAll();
				List<Cliente> clientes = clienteService.findAll();
				alquiler.setVendedor(vendedor.get());
				model.addAttribute("alquiler", alquiler);

				model.addAttribute("habitaciones", habitaciones);
				model.addAttribute("clientes", clientes);

			} else {
				return "redirect:/vendedor";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/vendedor/nuevoalquiler";
	}

	@PostMapping("/savealquiler")
	public String saveAlquiler(@ModelAttribute("alquiler") Alquiler alquiler, Model model, SessionStatus status) {
		try {
			alquilerService.save(alquiler);
			status.setComplete();

		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/vendedor/info/" + alquiler.getVendedor().getId();
	}

}
