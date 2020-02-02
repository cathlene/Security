package springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/showMyLoginPage") // komt uit de DemoSecurityConfig class
	public String showLoginPage() {
		return "fancy-login";
	}
	
	@GetMapping("/access-denied") // komt uit de DemoSecurityConfig class
	public String accessDeniedPage() {
		return "access-denied";
	}
	
	
	
}
