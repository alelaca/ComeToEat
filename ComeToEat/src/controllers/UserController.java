package controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import sqlutils.Query;
import controllers.responseservices.ResponseRegisterUser;
import entities.User;

@RestController
public class UserController {
	
	@RequestMapping(value="/registeruser/",method=RequestMethod.POST,headers="Accept=application/json")
	public ResponseRegisterUser registerUser(@RequestBody User user){
		
		ResponseRegisterUser response = new ResponseRegisterUser();
		
		Query query = new Query();
		
		String sqlInsert = String.format("INSERT INTO USER (USERID,USERNAME) VALUES (%1s,%2s);", user.getUserId(),user.getUserName());
		int cod = query.insert(sqlInsert);
		
		return response;
	}
}
