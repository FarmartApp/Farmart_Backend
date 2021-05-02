
package com.farm.controllers;




import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.farm.entities.Product;
import com.farm.entities.User;
import com.farm.services.ProductService;
import com.farm.settings.Constants;
import com.farm.services.UserService;
import com.farm.settings.FarmGenericResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
@RestController
@RequestMapping(Constants.BASE_URI)
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private UserService userService;


	@PostMapping("/product")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String email = authentication.getName();
		User user = userService.getOneByEmail(email);


		System.out.println(user.getId());
		product.setUser(user);
		Product saveUser = productService.saveProduct(product);
		return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS).msg("Product added successfully!!!")
				.statusCode(Constants.HTTP_SUCCESS_CODE).isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL).data(saveUser)
				.entity();

	}}

//	@GetMapping("/users")
//	public ResponseEntity<?> getAllUsers(@RequestParam(defaultValue = "0", required = false) Integer page) {
//		try {
//
//			Page<?> getUser = userService.getAllUsers(Pagination.paginationRequest(page));
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS)
//					.msg("Users get successfully!").statusCode(Constants.HTTP_SUCCESS_CODE)
//					.isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL).data(Pagination.paginatedData(getUser)).entity();
//
//		} catch (Exception e) {
//
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//					.msg(Constants.HTTP_EXPECTATION_FAILED_MESSAGE).statusCode(Constants.HTTP_EXPECTATION_FAILED_CODE)
//					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error(e.toString()).entity();
//		}
//	}
//
//	@PutMapping("/change-password")
//	public ResponseEntity<?> changepassword(@Valid @RequestBody ChangePassword passwords) {
//		 String email = SecurityContextHolder.getContext().getAuthentication().getName();
//
//			User user = userService.getOneByEmail(email);
//
//			System.out.println(passwordEncoder.matches(passwords.getCurrentPassword(),user.getPassword()));
//
//		if(passwordEncoder.matches(passwords.getCurrentPassword(),user.getPassword())==true) {
//			System.out.println(passwords.getNewPassword().equals(passwords.getConfirmPassword()));
//			if(passwords.getNewPassword().equals(passwords.getConfirmPassword())) {
//				 user.setPassword(passwords.getNewPassword());
//				 User saveUser = userService.saveUser(user);
//
//
//				 return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS)
//							.msg("password changed").statusCode(Constants.HTTP_SUCCESS_CODE)
//							.isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL).data(saveUser).entity();
//
//
//			}
//
//
//
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//			.msg("Password not match").statusCode(Constants.HTTP_BAD_REQUEST_CODE)
//		.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Password not match").entity();
//
//		}
//
//
//		return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//				.msg("Enter Correct password").statusCode(Constants.HTTP_BAD_REQUEST_CODE)
//				.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Enter Correct password").entity();
//	}
//
//
//
//
//	@PutMapping("/users/avatar")
//	public ResponseEntity<?> updateuseravatar(@RequestParam(value = "avatar", required = false) MultipartFile avatar) {
//		String email = SecurityContextHolder.getContext().getAuthentication().getName();
//		User getuser = userService.getOneByEmail(email);
//
//
//		if (getuser == null) {
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//					.msg("User get  not found").statusCode(Constants.HTTP_NOTFOUND_CODE)
//					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Not found").entity();
//
//		}
//
//	      FileSaveResponce saveavatar = filestore.useravatarSave(avatar);
//
//		if(!saveavatar.isImageValid()) {
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//					.msg(saveavatar.getError().toString()).statusCode(Constants.HTTP_BAD_REQUEST_CODE)
//					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error(saveavatar.getError().toString()).entity();
//			}
//
//		User user=new User();
//		user.setAvatar(saveavatar.getImageUrl());
//
//		Integer id=getuser.getId();
//
//		User update= userService.updateUserpic(id, user);
//		return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS)
//				.msg("User avatar added successfully!").statusCode(Constants.HTTP_SUCCESS_CODE)
//				.isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL).data(update).entity();
//
//	}
//
//	@PutMapping("/users/cover_image")
//	public ResponseEntity<?> updateusercoverphoto(@RequestParam(value = "cover_image", required = false) MultipartFile cover_image) {
//
//		String email = SecurityContextHolder.getContext().getAuthentication().getName();
//		User getuser = userService.getOneByEmail(email);
//		if (getuser == null) {
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//					.msg("User  not found").statusCode(Constants.HTTP_NOTFOUND_CODE)
//					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Not found").entity();
//
//		}
//		Integer id=getuser.getId();
//
//	      FileSaveResponce savecoverimage = filestore.usercoverphotoSave(cover_image);
//
//		if(!savecoverimage.isImageValid()) {
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//					.msg(savecoverimage.getError().toString()).statusCode(Constants.HTTP_BAD_REQUEST_CODE)
//					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error(savecoverimage.getError().toString()).entity();
//			}
//
//		User user=new User();
//		user.setCoverImage(savecoverimage.getImageUrl());
//
//		User update= userService.updateUserpic(id, user);
//		return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS)
//				.msg("User coverphoto added successfully!").statusCode(Constants.HTTP_SUCCESS_CODE)
//				.isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL).data(update).entity();
//
//	}
//
//	@PostMapping("/forgot-password")
//	public ResponseEntity<?> forgotPassword( @RequestBody User user) {
//
//		User getAlreadyExistUserEmail = userService.getOneByEmail(user.getEmail());
//
//
//		if (getAlreadyExistUserEmail != null) {
//
//			Integer ifExistVerification=verifyService.checkExistingVerification(user.getEmail());
//			if(ifExistVerification!=null) {
//			verifyService.deleteVerification(ifExistVerification);
//			}
//			Random rnd = new Random();
//		    int number = rnd.nextInt(999999);
//
//		     Verify verify=new Verify();
//		     verify.setCode(number);
//		     verify.setEmail(user.getEmail());
//
//
//		  Verify saveVerify= verifyService.save(verify);
//
//		  try {
//				notificationService.sendEmail(verify.getEmail(),verify.getCode().toString());
//			} catch (MailException mailException) {
//				System.out.println(mailException);
//			}
//
//
//
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS).msg("OTP Send to your Email Account!!!")
//					.statusCode(Constants.HTTP_SUCCESS_CODE).isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL)
//					.entity();
//		}
//
//
//		return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//				.msg("Your Email did not return any user").statusCode(Constants.HTTP_BAD_REQUEST_CODE)
//				.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Invalid Email").entity();
//
//	}
//
//
//	@PostMapping("/verify")
//	public ResponseEntity<?> verifyCode(@Valid @RequestBody Verify verify) {
//
//
//		User getAlreadyExistUserEmail = userService.getOneByEmail(verify.getEmail());
//
//
//		if (getAlreadyExistUserEmail != null) {
//			Integer getVerifyId=verifyService.checkVerify(verify.getEmail(),verify.getCode());
//		   if (getVerifyId!=null) {
//			   verifyService.deleteVerification(getVerifyId);
//			   verified=true;
//			   return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS).msg("Verified successfully!!!")
//						.statusCode(Constants.HTTP_SUCCESS_CODE).isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL)
//						.entity();
//		   }
//		   return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//					.msg("Verification code invalid").statusCode(Constants.HTTP_BAD_REQUEST_CODE)
//					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Invalid verification").entity();
//		}
//
//
//		return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//				.msg("Your Email did not return any user").statusCode(Constants.HTTP_BAD_REQUEST_CODE)
//				.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Invalid Email").entity();
//
//	}
//
//	@PutMapping("/reset-password")
//	public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPassword passwords) {
//		ApptimusJwtRequest apptimusJwtRequest=new ApptimusJwtRequest();
//
//		User getAlreadyExistUserEmail = userService.getOneByEmail(passwords.getEmail());
//		if(verified==true) {
//		if (getAlreadyExistUserEmail != null) {
//
//			if(passwords.getNewPassword().equals(passwords.getConfirmPassword())) {
//				getAlreadyExistUserEmail.setPassword(passwords.getNewPassword());
//				 User saveUser = userService.saveUser(getAlreadyExistUserEmail);
//				 apptimusJwtRequest.setEmail(saveUser.getEmail());
//				 apptimusJwtRequest.setPassword(passwords.getConfirmPassword());
//
//				 try {
//						authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(apptimusJwtRequest.getEmail(),
//								apptimusJwtRequest.getPassword()));
//					} catch (DisabledException e) {
//						return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED).msg("User Inactive")
//								.statusCode(Constants.HTTP_UNAUTHORIZED_CODE).isSuccess(Constants.HTTP_RESULT_FAILED_BOOL)
//								.error(e.getLocalizedMessage()).entity();
//					} catch (BadCredentialsException e) {
//						return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//								.msg("Invalid Email or Password").statusCode(Constants.HTTP_UNAUTHORIZED_CODE)
//								.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error(e.getLocalizedMessage()).entity();
//					}
//
//				 UserDetails userDetails = apptimusUserDetailsService.loadUserByUsername(apptimusJwtRequest.getEmail());
//					String userEmail = userDetails.getUsername();
//					System.out.println(userDetails.getUsername());
//					User user = userService.getOneByEmail(userEmail);
//
//					String token = apptimusJwtTokenUtil.generateToken(user);
//					userService.updateUserToken(user.getId(), token);
//					return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS).msg(" Password Changed & login successfully!!!")
//							.statusCode(Constants.HTTP_SUCCESS_CODE).isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL)
//							.data(new ApptimusJwtResponse(token, user)).entity();
//
//		}
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//					.msg("Password not match").statusCode(Constants.HTTP_BAD_REQUEST_CODE)
//				.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Password not match").entity();
//
//			}
//
//
//
//		return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//				.msg("Your Email did not return any user").statusCode(Constants.HTTP_BAD_REQUEST_CODE)
//				.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Invalid Email").entity();
//
//
//
//	}
//
//	return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//			.msg("please verify your account").statusCode(Constants.HTTP_BAD_REQUEST_CODE)
//			.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Invalid Verification").entity();
//
//}
//
//	@PostMapping("/resend-code")
//	public ResponseEntity<?> ResendCode( @RequestBody User user) {
//
//		User getAlreadyExistUserEmail = userService.getOneByEmail(user.getEmail());
//
//
//		if (getAlreadyExistUserEmail != null) {
//
//			Integer ifExistVerification=verifyService.checkExistingVerification(user.getEmail());
//			if(ifExistVerification!=null) {
//			verifyService.deleteVerification(ifExistVerification);
//			}
//			Random rnd = new Random();
//		    int number = rnd.nextInt(999999);
//
//		     Verify verify=new Verify();
//		     verify.setCode(number);
//		     verify.setEmail(user.getEmail());
//
//
//		  Verify saveVerify= verifyService.save(verify);
//
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS).msg("OTP Send to your Email Account!!!")
//					.statusCode(Constants.HTTP_SUCCESS_CODE).isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL)
//					.entity();
//		}
//
//
//		return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//				.msg("Your Email did not return any user").statusCode(Constants.HTTP_BAD_REQUEST_CODE)
//				.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Invalid Email").entity();
//
//	}
//
//	@DeleteMapping("/logout")
//	public ResponseEntity<?> logoutUser() {
//		try {
//			String email = SecurityContextHolder.getContext().getAuthentication().getName();
//			User user = userService.getOneByEmail(email);
//			if (user == null) {
//				return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//						.msg("Auth user not found").statusCode(Constants.HTTP_NOTFOUND_CODE)
//						.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error("Not found").entity();
//			}
//
//			String logout=userService.deleteToken(user.getId());
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS).msg("logout")
//					.statusCode(Constants.HTTP_SUCCESS_CODE).isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL)
//					.data(logout).entity();
//
//		} catch (Exception e) {
//			return ApptimusGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
//					.msg(Constants.HTTP_EXPECTATION_FAILED_MESSAGE).statusCode(Constants.HTTP_EXPECTATION_FAILED_CODE)
//					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error(e.toString()).entity();
//
//		}
//	}
//
//


