package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.StatusBean;

public class StatusDAO {
	public List<StatusBean> selectAllStatus() throws SQLException, ClassNotFoundException{
		String sql = "select status_code,status_name from m_status";
		List<StatusBean> statusList = new ArrayList<StatusBean>();
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			ResultSet res=pstmt.executeQuery();
			while(res.next()) {
				StatusBean sb = new StatusBean();
				sb.setStatusCode(res.getString("status_code"));
				sb.setStatusName(res.getString("status_name"));
				statusList.add(sb);
			}
			
		}
		return statusList;
	}
}
