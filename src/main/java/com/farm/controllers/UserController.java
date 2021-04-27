
package com.farm.controllers;



import com.farm.settings.Constants;
import com.farm.settings.FarmGenericResponse;



import org.springframework.http.ResponseEntity;



import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping(Constants.BASE_URI)
public class UserController {


	








	@GetMapping("/users")
	public ResponseEntity<?> getAllUsers() {
		try {
		

			return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS)
					.msg("Users get successfully!").statusCode(Constants.HTTP_SUCCESS_CODE)
					.isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL).data("hello").entity();

		} catch (Exception e) {

			return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
					.msg(Constants.HTTP_EXPECTATION_FAILED_MESSAGE).statusCode(Constants.HTTP_EXPECTATION_FAILED_CODE)
					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error(e.toString()).entity();
		}
	}
	

	
}

