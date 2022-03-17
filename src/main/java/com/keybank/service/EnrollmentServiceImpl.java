/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.keybank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.keybank.dao.EnrollmentDao;
import com.keybank.model.EnrollmentDaoRequest;
import com.keybank.model.EnrollmentDaoResponse;
import com.keybank.model.EnrollmentRequest;
import com.keybank.model.EnrollmentResponse;
import com.keybank.model.O2ServiceRequest;
import com.keybank.model.O2ServiceResponse;
import com.keybank.svcClient.O2ServiceClient;

/**
 * @author YNBR 14-Mar-2022
 *
 */
@Component
public class EnrollmentServiceImpl implements EnrollmentService {
	@Autowired
	O2ServiceClient o2Serviceclient;
	@Autowired
	EnrollmentDao enrollmentDao;

	@Override
	public EnrollmentResponse enollment(EnrollmentRequest req) {
		System.out.println("------Enter into Serive layer---Enrollment---");
		// TODO Auto-generated method stub
		//6. get request from controller
		//7prepare the request for telecom provider like o2 and airtel etc
		O2ServiceRequest o2ServiceRequest=new O2ServiceRequest();
		//8 call 02 service  and get response
		O2ServiceResponse	o2ServiceResponse=o2Serviceclient.enrollemnt(o2ServiceRequest);
		//9 if the response is success than do dao call  else throw the user defined exception
		EnrollmentDaoRequest enrollmentDaoRequest=new EnrollmentDaoRequest();
		EnrollmentDaoResponse enrollmentDaoResponse = null ;
		if("0".equals(o2ServiceResponse.getRespCode())) {
			enrollmentDaoResponse= enrollmentDao.enrollment(enrollmentDaoRequest);
		}
		
		
		//15. now got resp  from 02 and dao get intg response from intg layer
 
		EnrollmentResponse enrollmentResponse=new EnrollmentResponse();
	    enrollmentResponse.setEnrollmentStatus(enrollmentDaoResponse.getEnrollmentStatus());
	    enrollmentResponse.setRespCode(enrollmentDaoResponse.getRespCode());
	    enrollmentResponse.setRespMsg(enrollmentDaoResponse.getRespMsg());
		
		//16. perform some business logic likesorting,paging pagination, ---- etc
		//17  prepare the final service response
		//18. send service response to controller
		System.out.println("------Exit into Service layer---Enrollment---");
		return enrollmentResponse;
	}

}
