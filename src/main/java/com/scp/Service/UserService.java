package com.scp.Service;

import java.util.HashMap;
import java.util.List;

import com.scp.ConstantMsg.AppConstants;
import com.scp.pojos.User;

public interface UserService {
	 User getUser(int id);
	 boolean addUser(User u);
	 boolean deleteUser(int id);
	 boolean upedateUser(User user);
	 List<User> getAllUser();
	 List<User>	searchUser(HashMap<AppConstants.AppConstanst,String> serachcriteria);
  


}

