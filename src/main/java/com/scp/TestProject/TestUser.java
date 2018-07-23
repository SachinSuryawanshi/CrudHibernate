package com.scp.TestProject;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.scp.ConstantMsg.AppConstants.AppConstanst;
import com.scp.Service.UserService;
import com.scp.Service.Impl.copy.UserServiceImpl;
import com.scp.pojos.User;

public class TestUser {
public static Logger logger=Logger.getLogger(TestUser.class);
	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("demo changes");
		String log4jConfPath = "E:\\eclipse\\CrudHibernate\\src\\main\\java\\log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		//OFE WI DTA
			//	logger.setLevel(Level.ALL);
			//Sachin	Sushil
		
				for (int i=0;i<10;i++){
		
		logger.fatal("this is fatal");
		logger.error("This is error msg");
		logger.warn("This is warn msg");
		logger.info("This is info msg");
		logger.debug("This is debug msg");
		logger.trace("This is trace msg");
		
	TimeUnit.SECONDS.sleep(20);
				}
		if(true)
			return;
		
		User user1=new User(10,"Sachin","sa123",true);
		User user2=new User(11, "shivraj","123", true);
		//User user3=new User(12, "boman","123sa", true);
		UserService userSer=new UserServiceImpl();
		
	//	userSer.addUser(user2);
		//userSer.addUser(user3);
		boolean	u1=userSer.addUser(user1);
		System.out.println("is user1 added "+u1);
		System.out.println("----------------------------------------------------");
		
		
		User userfromdb=userSer.getUser(12);
		System.out.println("get user..........."+userfromdb);
		System.out.println("----------------------------------------------------");
		
	List<User>	userlist=userSer.getAllUser();
	System.out.println("list of all user"+userlist);
//			user2.setName("SSsss");
	//		userSer.upedateUser(user2);
	
	//	System.out.println(userlist);
		//userSer.searchUser(serachcriteria);
		
	HashMap<AppConstanst, String> hmap=new HashMap<AppConstanst, String>();
	hmap.put(AppConstanst.id,"10");
	hmap.put(AppConstanst.isActive,"Yes");
	System.out.println(userSer.searchUser(hmap));

}
	
	
	
}

