
package com.farm.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import com.farm.settings.FarmGenericResponse;

import com.farm.settings.Constants;


@Component
public class FarmAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		String message = FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED).msg("Unauthorize")
				.statusCode(Constants.HTTP_UNAUTHORIZED_CODE).isSuccess(Constants.HTTP_RESULT_FAILED_BOOL)
				.error(authException.toString()).json();
		response.setStatus(Constants.HTTP_UNAUTHORIZED_CODE);
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(message);

	}

}
