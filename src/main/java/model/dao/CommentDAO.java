package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.CommentBean;

public class CommentDAO {
	
	public List<CommentBean> selectComment(int taskId) throws SQLException, ClassNotFoundException{
		String sql = "select * from t_comment where task_id = ?";
		List<CommentBean> commentList = new ArrayList<CommentBean>();
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, taskId);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				CommentBean bean = new CommentBean();
				bean.setCommentId(res.getInt("comment_id"));
				bean.setTaskId(res.getInt("task_id"));
				bean.setUserId(res.getString("user_id"));
				bean.setComment(res.getString("comment"));
				bean.setUpdateDateTime(res.getTimestamp("update_datetime").toLocalDateTime());
				commentList.add(bean);
			}
		}
		return commentList;
	}
	
	public int insertComment(CommentBean bean) throws ClassNotFoundException, SQLException {
		String sql= "insert into t_comment (task_id,user_id,comment) values (?,?,?)";
		int count = 0;
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, bean.getTaskId());
			pstmt.setString(2, bean.getUserId());
			pstmt.setString(3, bean.getComment());
			
			count = pstmt.executeUpdate();
		}
		return count;
	}
	
	public int deleteComment(int commentId) throws ClassNotFoundException, SQLException {
		
		String sql= "DELETE FROM t_comment WHERE comment_id=?";
		int count = 0;
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			pstmt.setInt(1, commentId);
			
			
			count = pstmt.executeUpdate();
		}
		return count;
	}
	
	public int deleteAllComment(int taskId) throws ClassNotFoundException, SQLException {
		String sql = "delete from t_comment where task_id = ?";
		int count =0;
		try(Connection con = ConnectionManager.getConnection();
						PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, taskId);
			count = pstmt.executeUpdate();
				
		}
		
		return count;
		
	}

}
