package kr.or.ddit.controller;

import java.security.Principal;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.vo.CrudMember;
import kr.or.ddit.vo.CustomUser;

@Controller
@RequestMapping("/notice")
public class NoticeController {

	private static final Logger log = LoggerFactory.getLogger(NoticeController.class);

	@PreAuthorize("permitAll")
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list() {
		log.info("list() 실행...!");
		return "notice/list";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public String registerForm(Principal principal) {
		log.info("registerForm() 실행...!");
		
		// 방법 1 - principal 객체 이용하여 인증된 정보 꺼내기
		log.info("## principal.getName() : " + principal.getName());
		
		// 방법 2 - SecurityContextHolder 객체 이용하여 인증된 정보 꺼내기
		CustomUser user = 
				(CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info("## user.id : " + user.getUsername());
		log.info("## user.pw : " + user.getPassword());
		Iterator<GrantedAuthority> ite = user.getAuthorities().iterator();
		while(ite.hasNext()) {
			log.info("user.auth : " + ite.next().getAuthority());
		}
		
		CrudMember member = user.getMember();
		log.info("## member.id : " + member.getUserId());
		log.info("## member.pw : " + member.getUserPw());
		log.info("## member.name : " + member.getUserName());
		
		return "notice/register";
	}
	
}















