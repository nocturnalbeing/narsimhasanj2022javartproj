/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.keybank.dao;

import com.keybank.model.EnrollmentDaoRequest;
import com.keybank.model.EnrollmentDaoResponse;

/**
 * @author YNBR 14-Mar-2022
 *
 */
public interface EnrollmentDao {
 
	public EnrollmentDaoResponse enrollment(EnrollmentDaoRequest daorequest);
}
