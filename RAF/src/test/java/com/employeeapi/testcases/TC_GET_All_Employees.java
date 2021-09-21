package com.employeeapi.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeapi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC_GET_All_Employees extends TestBase{
	
	@BeforeClass
	void getAllemployes() throws InterruptedException {
		logger.info("*************** Started TC_GET_All_Employees *******************");
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";
		httprequest = RestAssured.given();
		response = httprequest.request(Method.GET, "/employees");
		
		Thread.sleep(3);
	}
	
	@Test
	void checkResponseBody() {
		
		logger.info("**************** checkResponseBody **************************");
		
		String responseBody = response.getBody().asString();
		
		logger.info("Response Body ===>"+responseBody);
		
		Assert.assertTrue(responseBody!=null);
	}
	
	@Test
	void chechStatusCode() {
		
		logger.info("**************************** chechStatusCode ********************************");
		
		int statuscode =response.getStatusCode();
		
		logger.info("Status Code ===>"+statuscode);
		
		Assert.assertEquals(statuscode ,200);
	}
	
	@Test 
	void checkResponseTime() {
		
		logger.info("************************* checkResponseTime ********************************");
		
		long responsetime = response.getTime();
		
		logger.info("Response Time ==>"+responsetime);
		
		if(responsetime>6000)
			
			logger.warn("Response Time is greater then 6000");
		
		Assert.assertTrue(responsetime<6000);
		
	}
	
	@Test
	void checkStatusLine() {
		
		logger.info("*********************************** checkStatusLine ********************************");
		
		String statusline = response.getStatusLine();
		
		logger.info("Status Line ==>"+statusline);
		
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
	
	@Test
	void checkContentType() {
		
		logger.info("************************************** checkContentType ********************************************");
		
		String contentType = response.getContentType();
		
		logger.info("Content Type " + contentType);
		
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

}
