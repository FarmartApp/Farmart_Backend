
package com.farm.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import com.farm.settings.FarmGenericResponse;
import com.farm.settings.Constants;

@Component
public class FarmAccessDeniedHandler implements AccessDeniedHandler {
	@Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        
		String message = FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED).msg("Access Denied")
				.statusCode(Constants.HTTP_FORBBIDEN_CODE).isSuccess(Constants.HTTP_RESULT_FAILED_BOOL)
				.error(accessDeniedException.toString()).json();
		response.setStatus(Constants.HTTP_FORBBIDEN_CODE);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(message);
    }
}
