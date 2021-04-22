

package com.farm.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import com.farm.entities.User;
import com.farm.exception.FarmAuthenticationExceptionHandler;
import com.farm.services.authentication.FarmUserDetailsService;


@Component
public class FarmJwtAuthenticationFilter extends BasicAuthenticationFilter {

	private FarmJwtTokenUtil farmJwtTokenUtil;

	private FarmUserDetailsService farmUserDetailsService;
	/**
	 * @param authenticationManager
	 * @param farmUserDetailsService2
	 */
	public FarmJwtAuthenticationFilter(AuthenticationManager authenticationManager,
			FarmJwtTokenUtil farmJwtTokenUtil, FarmUserDetailsService farmUserDetailsService) {
		super(authenticationManager);
		this.farmJwtTokenUtil = farmJwtTokenUtil;
		this.farmUserDetailsService = farmUserDetailsService;
	}

	

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String header = request.getHeader("Authorization");
		System.out.println(header);
		if (header == null || !header.startsWith("Bearer")) {
			throw new FarmAuthenticationExceptionHandler("No JWT token found in the request headers");
		}	

		String token = header.substring(7);

		farmJwtTokenUtil.validateToken(token);
		User user = farmJwtTokenUtil.getUser(token);
		UserDetails userDetails = farmUserDetailsService.loadUserByUsername(user.getEmail());

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities());
		usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		if (SecurityContextHolder.getContext().getAuthentication() == null) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		}

		filterChain.doFilter(request, response);
	}

}
