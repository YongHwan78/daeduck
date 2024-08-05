package kr.or.ddit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String loginForm(String error, String logout, Model model) {
		log.info("loginForm() 실행...!");
		
		if(error != null) {
			model.addAttribute("error", "Login Error!");
		}
		if(logout != null) {
			model.addAttribute("logout", "Logout!");
		}
		
		return "loginForm";
	}
	
	@RequestMapping(value="/logoutForm", method = RequestMethod.GET)
	public String logoutForm() {
		return "logoutForm";
	}
}
























