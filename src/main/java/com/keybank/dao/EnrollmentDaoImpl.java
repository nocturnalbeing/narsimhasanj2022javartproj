/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.keybank.dao;

import org.springframework.stereotype.Component;

import com.keybank.exception.BusinessException;
import com.keybank.exception.SystemException;
import com.keybank.model.EnrollmentDaoRequest;
import com.keybank.model.EnrollmentDaoResponse;

/**
 * @author YNBR 14-Mar-2022
 *
 */
@Component
public class EnrollmentDaoImpl implements EnrollmentDao {

	@Override
	public EnrollmentDaoResponse enrollment(EnrollmentDaoRequest daorequest) throws BusinessException, SystemException{
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
		String dbRespcode="0";
		String dbRespMsg="Success";
		EnrollmentDaoResponse enrollmentDaoResponse=new EnrollmentDaoResponse();
		try {
				if("0".equals(dbRespcode)) {
					//TODO: convert database resp  to Dao Response
					enrollmentDaoResponse.setEnrollmentStatus("SUCCESS");
					enrollmentDaoResponse.setRespCode("0");
					enrollmentDaoResponse.setRespMsg("Erollment Done");
					System.out.println("---Exit into DAO Layer----Enrollment");
					
				}
				else if("100".equals(dbRespcode)||"101".equals(dbRespcode)||"102".equals(dbRespcode)) {
					throw new BusinessException(dbRespcode,dbRespMsg);
				}
				else {
					throw new SystemException(dbRespcode,dbRespMsg);
				}
		}
		catch(BusinessException e) {
			throw e;
		}
		catch(SystemException ee) {
			throw ee;
		}
		return enrollmentDaoResponse;
		
		
		

		
		
	}

}
