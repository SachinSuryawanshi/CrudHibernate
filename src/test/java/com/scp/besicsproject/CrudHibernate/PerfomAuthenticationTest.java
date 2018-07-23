package com.scp.besicsproject.CrudHibernate;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.scp.Business.UserControler;
import com.scp.Util.ReadDataFromExcel;

public class PerfomAuthenticationTest {

	

@DataProvider
public Object[][] getTestData(){
	return ReadDataFromExcel.readTestData();
}


@Test(dataProvider="getTestData")
public void perfomLogin(String uname,String pwd,String msg){
	System.out.println(uname +"----" +pwd +" ---" +msg);
	
	UserControler UserC = new UserControler();
	String actualMsg = UserC.validateUserCredentails(uname, pwd);
	Assert.assertEquals(actualMsg, msg);
}


}