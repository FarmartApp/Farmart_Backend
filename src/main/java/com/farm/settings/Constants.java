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
package com.farm.settings;


public class Constants {
	// Common Contant
	public static final String BASE_URI = "/api";
	public static final String BASE_URI_AUTH = "/api/v1/auth";

	// HTTP Status Codes
	public static final Integer HTTP_SUCCESS_CODE = 200;
	public static final Integer HTTP_BAD_REQUEST_CODE = 400;
	public static final Integer HTTP_UNAUTHORIZED_CODE = 401;
	public static final Integer HTTP_FORBBIDEN_CODE = 403;
	public static final Integer HTTP_NOTFOUND_CODE = 404;
	public static final Integer HTTP_METHOD_NOT_ALLOWED = 405;
	public static final Integer HTTP_EXPECTATION_FAILED_CODE = 417;
	public static final Integer HTTP_INTERNAL_SERVER_ERROR_CODE = 500;

	// HTTP Status
	public static final String HTTP_RESULT_SUCCESS = "SUCCESS";
	public static final String HTTP_RESULT_FAILED = "FAILED";
	public static final boolean HTTP_RESULT_SUCCESS_BOOL = true;
	public static final boolean HTTP_RESULT_FAILED_BOOL = false;
	public static final String HTTP_EXPECTATION_FAILED_MESSAGE = "Something went wrong!!!";

	// Pagination
	public static final Integer PAGINATION_LIMIT = 5;

	// Roles

	public final static String ROLE_ADMIN = "ROLE_ADMIN";
	public final static String ROLE_USER = "ROLE_USER";

	// JWT
	public final static String KEY_JWT_AUTH_HEADER = "${jwt.auth.header}";
	public final static String KEY_JWT_EXPIRE_HOURS = "${jwt.expire.hours}";
	public final static String KEY_JWT_SECRET = "${jwt.secret}";

}
