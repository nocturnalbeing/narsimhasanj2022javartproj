/**@Copyright 2022 keybank pvt ltd.
 * All rights are reserved,you should 
*disclose the information outside
* otherwise terms and condition will apply
 */
package com.keybank.svcClient;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.keybank.model.O2ServiceRequest;
import com.keybank.model.O2ServiceResponse;

/**
 * @author YNBR 14-Mar-2022
 *
 */
@Component
public class O2ServiceClientImpl implements O2ServiceClient{

	@Override
	public O2ServiceResponse enrollemnt(O2ServiceRequest request) {
		System.out.println("----------enter into O2 service client---Enrollment-");
		// TODO Auto-generated method stub
		//get the request from service
		//prepare the request for o2 service like add headers,body
		//create RestTemplate and make call to O2Service ,get the response
		String uri="http://localhost:8686/v1/mobile/verify";
		RestTemplate restTemplate=new RestTemplate();
		restTemplate.getMessageConverters()
		.add(new MappingJackson2HttpMessageConverter());
		 HttpHeaders header = new HttpHeaders();
		 header.setContentType(MediaType.APPLICATION_JSON);
	      header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      header.setContentType(MediaType.APPLICATION_JSON);
			header.set("clientId", "hdfc");
			header.set("messageTs", new Date().toString());
			header.set("requestId", "aasasa");
			header.set("version", "1.0");
	      HttpEntity <O2ServiceRequest> entity = new HttpEntity<O2ServiceRequest>(request,header);
			
	      System.out.println("----------Exit into O2 service client---Enrollment-");

	      return restTemplate.exchange(uri, HttpMethod.POST, entity, O2ServiceResponse.class).getBody();
		 
		//return response.getBody();
	}
public static void main(String[] args) {
	O2ServiceClientImpl service=new O2ServiceClientImpl();
	O2ServiceRequest req=new O2ServiceRequest();
	req.setMobileNum("999999999");
	service.enrollemnt(req);
}
}
