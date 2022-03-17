/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.keybank.dao;

import org.springframework.stereotype.Component;

import com.keybank.model.EnrollmentDaoRequest;
import com.keybank.model.EnrollmentDaoResponse;

/**
 * @author YNBR 14-Mar-2022
 *
 */
@Component
public class EnrollmentDaoImpl implements EnrollmentDao {

	@Override
	public EnrollmentDaoResponse enrollment(EnrollmentDaoRequest daorequest) {
		System.out.println("---Enter into DAO Layer  Enrollment--------");
		// TODO Auto-generated method stub stub
		//10 . get request from service
		//11 prepare request for database
		//12  call database and get response from db
		//validate the response
		//a if response is valid then prepare dao resp
		//b if response invalid then prepare error resp
		//13 prepare tthe integration  response
		//14 send intg response  to service
		EnrollmentDaoResponse enrollmentDaoResponse=new EnrollmentDaoResponse();
		enrollmentDaoResponse.setEnrollmentStatus("SUCCESS");
		enrollmentDaoResponse.setRespCode("0");
		enrollmentDaoResponse.setRespMsg("Erollment Done");
		System.out.println("---Exit into DAO Layer----Enrollment");

		return enrollmentDaoResponse;
		
	}

}
