package com.scp.Business;

import java.util.List;

import com.scp.ConstantMsg.AppConstants;
import com.scp.Service.UserService;
import com.scp.Service.Impl.copy.UserServiceImpl;
import com.scp.pojos.User;


public class UserControler {

// comment added

public String validateUserCredentails(String username, String password){
	String dbUserName =null;
	String dbPassword = null;
	try {
		UserService service = new UserServiceImpl();
		List<User> users = service.getAllUser();
		for (User user1 : users) {
			dbUserName = user1.getName();
			dbPassword = user1.getPassword();
			break;

		} 
	} catch (Exception e) {
		
	}finally{
		if(dbUserName==null){
			dbUserName="";
		}
		if(dbPassword==null){
			dbPassword="";
		}
	}
	
	
	if(username==null){
		return AppConstants.USERNAME_CANNOT_BE_EMPTY;
	}else if(password==null){
		return AppConstants.PASSWORD_CANNOT_BE_EMPTY;
	}else if(dbUserName.equals(username) && dbPassword.equals(password)){
		return AppConstants.LOGIN_SUCCESS;
	}
	return AppConstants.INVALID_USERNAME_PASSWORD;
}
}
	