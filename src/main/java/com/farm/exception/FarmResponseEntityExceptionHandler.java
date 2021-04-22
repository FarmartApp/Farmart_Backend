/*
Copyright [2020] [Apptimus Tech (Pvt) Ltd.]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

/**
 * 
 */
package com.farm.exception;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.farm.settings.FarmGenericResponse;
import com.farm.settings.Constants;


@ControllerAdvice
@RestController
public class FarmResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage())
				.collect(Collectors.toList());
		return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED).msg(errors.get(0))
				.statusCode(Constants.HTTP_BAD_REQUEST_CODE).isSuccess(Constants.HTTP_RESULT_FAILED_BOOL)
				.error(errors.toString()).entity();
	}



	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED).msg(ex.getLocalizedMessage())
				.statusCode(Constants.HTTP_METHOD_NOT_ALLOWED).isSuccess(Constants.HTTP_RESULT_FAILED_BOOL)
				.error(ex.toString()).entity();

	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED).msg(ex.getLocalizedMessage())
				.statusCode(Constants.HTTP_INTERNAL_SERVER_ERROR_CODE).isSuccess(Constants.HTTP_RESULT_FAILED_BOOL)
				.error(ex.toString()).entity();
	}

	@Override
	protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		return FarmGenericResponse.builder().status(Constants.HTTP_RESULT_FAILED).msg(ex.getLocalizedMessage())
				.statusCode(Constants.HTTP_NOTFOUND_CODE).isSuccess(Constants.HTTP_RESULT_FAILED_BOOL)
				.error(ex.toString()).entity();
	}
}
