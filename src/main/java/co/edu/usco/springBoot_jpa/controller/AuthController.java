package co.edu.usco.springBoot_jpa.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String inicio(Model model, Authentication authentication) {
		model.addAttribute("username", authentication.getName());
		model.addAttribute("roles", authentication.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.toList());
		return "inicio";
	}


	@RequestMapping("/403")
	public String error403() {
		return "403";
	}
}