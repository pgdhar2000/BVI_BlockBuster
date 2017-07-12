package com.sci.bvi.resttest;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.text.html.parser.Entity;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

public class resttest {

	public static void main(String[] args) {
		
		//to get the authcode
		Client client = Client.create();
		WebResource webResource = client.resource("http://182.74.133.92:8080/BlockBuster/api/user/login?roleId=4");
		String input=" {\"username\":\"raagent\",\"password\":\"raagent123\"}";
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class, input);
		String output = response.getEntity(String.class);
		System.out.println("Output from Server ....Llogin");
		System.out.println(output);
		JsonParser parser = new JsonParser();
		JsonObject resultObject = (JsonObject) parser.parse(output);
		JsonObject obj = (JsonObject) resultObject;
		JsonObject obj1=obj.getAsJsonObject("responsePayload");
		
		String aut=obj1.get("authCode").toString().replace("\"", "");
		System.out.println(aut);
		// call the add incroporation 
		try {
			webResource=client.resource("http://182.74.133.92:8080/BlockBuster/api/incorporation/add");
			input="{ \"mbcLegalName\": \"Organization fourteen1\", \"mbcTotalShares\": \"1\", \"addressDetailsTbl\": {  \"streetAddress\": \"Street fourteen\",  \"city\": \"City fourteen\",  \"countryTbl\": {   \"countryId\": 103  },  \"zipcode\": \"500001\" }, \"mbcPhone\": \"91 9111 919 932\", \"mbcFax\": \"91 9999 919 919\", \"mbcPocEmail\": \"org.fourteen@org.com\", \"mbcWebUrl\": \"org.fourteen.com\", \"mbcGrossAssets\": 25000, \"mbcNumberEmployees\": 10, \"principalShareholderTbl\": {  \"firstName\": \"Principal first name\",  \"lastName\": \"Principal last name\",  \"countryTbl\": {   \"countryId\": 103  },  \"totalShares\": 1 }, \"participantShareholderTbl\": {  \"firstName\": \"Participant first name\",  \"lastName\": \"Participant last name\",  \"countryTbl\": {   \"countryId\": 103  },  \"totalShares\": 1 }, \"businessPurposeTbl\": {  \"businessPurposeId\": 1 }, \"raWrittenConfirmFlag\": \"Y\", \"raConsentFlag\": \"Y\", \"userTblByRegisteredAgentId\": {  \"userId\": 3 }, \"applicationFeeAmt\": 100,\"registrationFeeAmt\": 100}";
			response = webResource.type("application/json").header("authCode", obj1.get("authCode")).post(ClientResponse.class,input);
			output = response.getEntity(String.class);
			System.out.println("Output from Server ....Incorp");
			System.out.println(output);
		} catch (UniformInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// call logout
		String inurl="http://182.74.133.92:8080/BlockBuster/api/user/logout?authCode="+aut;
		webResource = client.resource(inurl);
		//input=" {\"username\":\"raadmin6\",\"password\":\"sciits\"}";
		response = webResource.type("application/json").post(ClientResponse.class);
		output = response.getEntity(String.class);
		System.out.println("Output from Server ....Logout");
		System.out.println(output);

	}
	
}
