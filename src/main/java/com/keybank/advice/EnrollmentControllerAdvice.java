/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.keybank.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.keybank.exception.EnrollmentRequestInvalidException;
import com.keybank.model.EnrollmentResponse;


/**
 * @author YNBR 14-Mar-2022
 *
 */
@ControllerAdvice
public class EnrollmentControllerAdvice {
	@ExceptionHandler(value=EnrollmentRequestInvalidException.class)
	@ResponseBody
	public EnrollmentResponse handleException(EnrollmentRequestInvalidException e) {
		//prepare error resp to client
		EnrollmentResponse response=new EnrollmentResponse();
		response.setRespCode(e.getRespCode());
		response.setRespMsg(e.getRespMsg());
		return response;
	}

}
