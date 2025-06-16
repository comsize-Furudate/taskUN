package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CategoryBean;

public class CategoryDAO {
	public List<CategoryBean> selectAllCategory() throws SQLException, ClassNotFoundException{
		String sql = "select category_id,category_name from m_category";
		List<CategoryBean> categoryList = new ArrayList<CategoryBean>();
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				CategoryBean cb = new CategoryBean();
				cb.setCategoryId(res.getInt("category_id"));
				cb.setCategoryName(res.getString("category_name"));
				categoryList.add(cb);
			}
			
		}
		return categoryList;
	}
	
}
