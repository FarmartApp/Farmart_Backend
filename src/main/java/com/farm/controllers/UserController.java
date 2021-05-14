
package com.farm.controllers;



import com.farm.entities.User;
import com.farm.entities.requestbodies.FileSaveResponse;
import com.farm.services.UserService;
import com.farm.settings.Constants;
import com.farm.settings.FarmGenericResponse;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.farm.settings.FileStore;
import com.farm.entities.requestbodies.FileSaveResponce;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(Constants.BASE_URI)
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private FileStore filestore;


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

	@PostMapping("/editUser")
	public ResponseEntity<?> EditUser( @RequestBody User user) {

		try {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			String email = authentication.getName();
			User uuser = userService.getOneByEmail(email);
			Integer id=uuser.getId();
			User saveUser = userService.updateUser(id, user);


			return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS)
					.msg("Users get successfully!").statusCode(Constants.HTTP_SUCCESS_CODE)
					.isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL).data("he llo").entity();

		} catch (Exception e) {

			return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
					.msg(Constants.HTTP_EXPECTATION_FAILED_MESSAGE).statusCode(Constants.HTTP_EXPECTATION_FAILED_CODE)
					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error(e.toString()).entity();
		}
	}
	@PutMapping("/users/avatar")
	public ResponseEntity<?> updateuseravatar(@RequestParam(value = "avatar", required = false) MultipartFile avatar) {
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		User getuser = userService.getOneByEmail(email);


		if (getuser == null) {
			return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
					.msg("User get  not found").statusCode(Constants.HTTP_NOTFOUND_CODE)
					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Not found").entity();

		}
		System.out.println("hhkhkhkhk");

		FileSaveResponse saveavatar = filestore.useravatarSave(avatar);
		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		if(!saveavatar.isImageValid()) {
			return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
					.msg(saveavatar.getError().toString()).statusCode(Constants.HTTP_BAD_REQUEST_CODE)
					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error(saveavatar.getError().toString()).entity();
		}

		User user=new User();
		user.setAvatar(saveavatar.getImageUrl());

		Integer id=getuser.getId();

		User update= userService.updateUserpic(id, user);
		return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS)
				.msg("User avatar added successfully!").statusCode(Constants.HTTP_SUCCESS_CODE)
				.isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL).data(update).entity();

	}






}

