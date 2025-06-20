package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.CommentBean;

public class CommentDAOTest {
	
	@Test
	void Testdeletecomment_success() {
		
		CommentDAO dao = new CommentDAO();
		int id = 17;
		int count = 0;
		
		try {
			
			count = dao.deleteComment(id);
			
		}catch(SQLException | ClassNotFoundException | NullPointerException e) {
			
			e.printStackTrace();
		}
		
		assertEquals(1,count);
		
		
	}
	
	@Test
	void Testdeletecomment_failure() {
		
		CommentDAO dao = new CommentDAO();
		int id = 17;
		int count = 0;
		
		try {
			
			count = dao.deleteComment(id);
			
		}catch(SQLException | ClassNotFoundException | NullPointerException e) {
			
			e.printStackTrace();
		}
		
		assertEquals(0,count);
		
		
	}

	@Test
	void TestDeleteAllComment_Success() {
		CommentDAO dao =new CommentDAO();
		int id = 20;
		int count =0;
		try {
			count = dao.deleteAllComment(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		assertNotEquals(0,count);
	}
	
	@Test
	void TestDeleteAllComment_Failure() {
		CommentDAO dao =new CommentDAO();
		
		int count =0;
		try {
			count = dao.deleteAllComment(15);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		assertEquals(0,count);
	}
	
	@Test
	void TestSelectComment_success() {
		int taskId = 16;
		
		CommentDAO dao = new CommentDAO();
		
		List<CommentBean> actualList = new ArrayList<CommentBean>();
		try {
			actualList = dao.selectComment(taskId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		assertNotNull(actualList);
	}
	@Test
	void TestSelectComment_Failure() {
		int taskId = 50;
		
		CommentDAO dao = new CommentDAO();
		
		List<CommentBean> actualList = new ArrayList<CommentBean>();
		List<CommentBean> expectedList = new ArrayList<CommentBean>();
		
		try {
			actualList = dao.selectComment(taskId);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		assertEquals(expectedList,actualList);
	}
	
	@Test
	public void TestInsertComment_success() {
	
		CommentDAO commentDAO = new CommentDAO();
		int test = 0;
		CommentBean comBean = new CommentBean();
		
		comBean.setTaskId(5);
		comBean.setUserId("yamada");
		comBean.setComment("成功");
		
		try {
			
			test = commentDAO.insertComment(comBean);
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		assertNotNull(test);
	}
	
	@Test
	public void TestInsertComment_failure() {
		
		CommentDAO commentDAO = new CommentDAO();
		int test = 0;
		CommentBean comBean = new CommentBean();
		
		comBean.setTaskId(5);
		comBean.setUserId("fail");
		comBean.setComment("失敗");
		
		try {
			
			test = commentDAO.insertComment(comBean);
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		assertNotNull(test);
	}

}
