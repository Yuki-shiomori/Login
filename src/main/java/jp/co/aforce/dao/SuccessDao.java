package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.bean.LoginBean;

public abstract class SuccessDao extends DAO {
	public LoginBean getId(String id,String password) throws Exception{
	Connection con =getConnection();
	
	PreparedStatement st = con.prepareStatement("");
	return null;
	
		
	}	
	}
	
	

