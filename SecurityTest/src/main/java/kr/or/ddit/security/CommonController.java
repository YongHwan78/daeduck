package kr.or.ddit.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	private static final Logger log = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping(value="/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("accessDenied() 실행...!");
		
		// auth의 출력 정보
		// org.springframework.security.authentication.UsernamePasswordAuthenticationToken@8ae115:
		// Principal : org.springframework.security.core.userdetails.User@bf344fha
		// Username : member;
		// Password : [PROTECTED];
		// Enabled : true;
		// AccountNonExpired : true;
		// credentialNonExpired: true;
		// AccountNonLocked : true;
		// Granted Authorities : ROLE_MEMBER;
		// Credentials: [PROTECTED];
		// Authenticated: true;
		// Details : org.springframework.security:web.authentication.WebAuthenticationDetails@
		// SessionId: B4854844B4H343H83483HRHR874;
		// Granted Authorities : ROLE_MEMBER
		log.info("Access Denied : " + auth);
		
		model.addAttribute("msg", "Access Denied");
	}
	
}
















