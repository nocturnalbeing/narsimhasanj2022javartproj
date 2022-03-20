/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.keybank.service;

import com.keybank.exception.BusinessException;
import com.keybank.exception.O2ServiceException;
import com.keybank.exception.SystemException;
import com.keybank.model.EnrollmentRequest;
import com.keybank.model.EnrollmentResponse;

/**
 * @author YNBR 14-Mar-2022
 *
 */
public interface EnrollmentService {
public  EnrollmentResponse enollment(EnrollmentRequest req) throws BusinessException, SystemException,O2ServiceException;

}
