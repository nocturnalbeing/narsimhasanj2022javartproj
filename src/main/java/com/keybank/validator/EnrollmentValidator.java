/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.keybank.validator;

import org.springframework.stereotype.Component;

import com.keybank.exception.EnrollmentRequestInvalidException;
import com.keybank.model.EnrollmentRequest;

/**
 * @author YNBR 17-Mar-2022
 *
 */
@Component
public class EnrollmentValidator {
	public void validateRequest(EnrollmentRequest request) throws EnrollmentRequestInvalidException {
		System.out.println("------------------Enter---------------validator---------------");
		//todo:validate the requesr ,if ir valid nothing return,else it will exception
		if(request==null) {
			throw new EnrollmentRequestInvalidException("err001", "No enrollmen Details");
		}
		if(request.getMobileNum()==null||"".equals(request.getMobileNum())) {
			throw new EnrollmentRequestInvalidException("err001", "MobileNumber Invalid Details");
		}
		System.out.println("------------------Exit---------------validator---------------");
		//todo :write valation for all the manditory elements
	}

}
