package kr.or.ddit.controller;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	private PasswordEncoder pw;
	
	@PostConstruct
	public void init() {
		log.info("## password : " + pw.encode("1234"));
	}

	@PreAuthorize("permitAll")
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list() {
		log.info("list() 실행...!");
		return "board/list";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_MEMBER','ROLE_ADMIN')")
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerForm() {
		log.info("registerForm() 실행...!");
		return "board/register";
	}
	
}















