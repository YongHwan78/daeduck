package kr.or.ddit.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler{

	private static final Logger log = LoggerFactory.getLogger(CustomAccessDeniedHandler.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		log.info("#[handle] 접근 거부가 일어났습니다! accessError로 리다이렉트합니다!");
		// CommonController에서 만들어둔 컨트롤러 메소드를 실행한다.(접근 거부 에러 페이지)
		response.sendRedirect("/accessError");
	}

}
