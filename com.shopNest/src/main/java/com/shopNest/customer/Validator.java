package com.shopNest.customer;

import com.shopNest.dbHandler.DataFetcher;

public class Validator 
{
	public static boolean isValid(String uname, String pass) 
	{
		try {
			//collecting password from database by calling static method
			String dpPass = DataFetcher.fetchPass(uname);
			
			//Comparing dbData and form data
			if(pass.equals(dpPass))
			{
				return true;
			}
		} 
		catch (Exception e) {
			System.out.println("Problem in login");
			e.printStackTrace();
		}
		return false;
	}
}
