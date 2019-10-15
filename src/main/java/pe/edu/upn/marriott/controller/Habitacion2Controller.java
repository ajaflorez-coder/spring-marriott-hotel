package pe.edu.upn.marriott.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/habitacion2")
public class Habitacion2Controller {
	@GetMapping
	public String inicio (Model model) {
	return "index";
	}
}
