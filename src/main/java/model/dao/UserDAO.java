package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {
	
	public UserBean logincheck(String userId) throws ClassNotFoundException, SQLException {
		
		String sql = "SELECT password, user_name FROM m_user WHERE user_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setString(1, userId);
			
			ResultSet res = pstmt.executeQuery();
			
			UserBean bean =null;
			
			while(res.next()) {
				
				String pass = res.getString("password");
				String name = res.getString("user_name");
				
				bean = new UserBean();
				
				bean.setPassword(pass);
				bean.setUserName(name);
			}
			return bean;
		}
		
	}
	
	

}
