
package com.farm.controllers.authentication;



import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farm.config.FarmJwtTokenUtil;

import com.farm.entities.User;
import com.farm.entities.authentication.FarmJwtRequest;
import com.farm.entities.authentication.FarmJwtResponse;
import com.farm.exception.FarmAuthenticationExceptionHandler;

import com.farm.services.UserService;
import com.farm.services.authentication.FarmUserDetailsService;
import com.farm.settings.FarmGenericResponse;
import com.farm.settings.Constants;
import com.farm.settings.Validator;

@RestController
@RequestMapping(Constants.BASE_URI)
public class FarmAuthenticationController {

	@Autowired
	private FarmJwtTokenUtil farmJwtTokenUtil;

	@Autowired
	private FarmUserDetailsService farmUserDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;
	
	

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody FarmJwtRequest farmJwtRequest) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(farmJwtRequest.getEmail(),
					farmJwtRequest.getPassword()));
		} catch (DisabledException e) {
			return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED).msg("User Inactive")
					.statusCode(Constants.HTTP_UNAUTHORIZED_CODE).isSuccess(Constants.HTTP_RESULT_FAILED_BOOL)
					.error(e.getLocalizedMessage()).entity();
		} catch (BadCredentialsException e) {
			return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
					.msg("Invalid Email or Password").statusCode(Constants.HTTP_UNAUTHORIZED_CODE)
					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error(e.getLocalizedMessage()).entity();
		}

		UserDetails userDetails = farmUserDetailsService.loadUserByUsername(farmJwtRequest.getEmail());
		String userEmail = userDetails.getUsername();
		System.out.println(userDetails.getUsername());
		User user = userService.getOneByEmail(userEmail);
		
		
		String token = farmJwtTokenUtil.generateToken(user);
		userService.updateUserToken(user.getId(), token);
		return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS).msg("login successfully!!!")
				.statusCode(Constants.HTTP_SUCCESS_CODE).isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL)
				.data(new FarmJwtResponse(token, user)).entity();

	}

	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody User user) {
		User getAlreadyExistUser = userService.getOneByEmail(user.getEmail());

		if (getAlreadyExistUser != null) {
			return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
					.msg(Validator.uniqueValidationMessage("Email")).statusCode(Constants.HTTP_BAD_REQUEST_CODE)
					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Already taken").entity();
		}

		User saveUser = userService.saveUser(user);
		return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS).msg("Registered successfully!!!")
				.statusCode(Constants.HTTP_SUCCESS_CODE).isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL).data(saveUser)
				.entity();
	}
}
