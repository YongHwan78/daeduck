package kr.or.ddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger log = LoggerFactory.getLogger(CustomLoginSuccessHandler.class);
	
	private RequestCache requestCache = new HttpSessionRequestCache();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("# onAuthenticationSuccess() 실행...!");
		
		User customUser = (User) authentication.getPrincipal();
		log.info("username : " + customUser.getUsername());
		log.info("password : " + customUser.getPassword());
		
		// 시큐리티 내 발생한 에러 세션정보들을 삭제
		clearAuthenticationAttribute(request);
		
		// 요청이 가지고 있는 request 내 타겟 정보
		// 타겟정보가 존재한다면 타겟으로 이동시켜준다.
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		String targetUrl = "";
		
		if(savedRequest != null) {
			targetUrl = savedRequest.getRedirectUrl();
		}else {
			targetUrl = "/";
		}
		
		log.info("Login Success targetUrl : " + targetUrl);
		response.sendRedirect(targetUrl);
	}

	private void clearAuthenticationAttribute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session == null) {
			return;
		}
		
		// SPRING_SECURITY_LAST_EXCEPTION 값에 해당하는 KEY
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

}



















