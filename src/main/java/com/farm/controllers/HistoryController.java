
package com.farm.controllers;


import com.farm.entities.Product;
import com.farm.entities.User;
import com.farm.services.ProductService;
import com.farm.settings.Constants;
import com.farm.settings.FarmGenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import  com.farm.services.HistoryService;
import  com.farm.entities.History;
import java.util.List;


@RestController
@RequestMapping(Constants.BASE_URI)
public class HistoryController {

	@Autowired
	private HistoryService historyService;

	@GetMapping("/hisory")
	public ResponseEntity<?> getAllHistory(@RequestParam(required = false) Integer buyerId,@RequestParam(required = false) Integer sellerId) {
		try {
			List<History> prolist= historyService.filterHistory(buyerId,sellerId);

			return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS)
					.msg("Users get successfully!").statusCode(Constants.HTTP_SUCCESS_CODE)
					.isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL).data("hello").entity();

		} catch (Exception e) {

			return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED)
					.msg(Constants.HTTP_EXPECTATION_FAILED_MESSAGE).statusCode(Constants.HTTP_EXPECTATION_FAILED_CODE)
					.isSuccess(Constants.HTTP_RESULT_FAILED_BOOL).error(e.toString()).entity();
		}
	}
	@PostMapping("/hisory")
	public ResponseEntity<?> addProduct(@RequestBody History history) {




		History saveUser = historyService.saveHistory(history);
		return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_SUCCESS).msg("Product added successfully!!!")
				.statusCode(Constants.HTTP_SUCCESS_CODE).isSuccess(Constants.HTTP_RESULT_SUCCESS_BOOL).data(saveUser)
				.entity();

	}




}

