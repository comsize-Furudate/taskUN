package model.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import model.entity.TaskBean;

public class TaskDAOTest {
	
	@Test
	void TestInsertSuccess() {
		
		int count = 0;
		String taskName = "テストコード作成";
		int categoryId = 1;
		LocalDate limit = LocalDate.of(2025, 6, 16);
		String statusCode = "00";
		String userId = "azusa04";
		String memo = "登録機能のテストコード作成";
		TaskBean bean =new TaskBean();
		
		bean.setTaskName(taskName);
		bean.setCategoryId(categoryId);
		bean.setLimit(limit);
		bean.setUserId(userId);
		bean.setStatusCode(statusCode);
		bean.setMemo(memo);
		
		TaskDAO dao = new TaskDAO();
		try {
			count = dao.insert(bean);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println(count);
		assertEquals(1,count);
	}
	
	@Test
	void TestInsertFailure() {
		
		int count = 0;
		String taskName = "テストコード作成";
		int categoryId = 1;
		LocalDate limit = LocalDate.of(2025, 6, 16);
		String statusCode = "00";
		String userId = "azusa04";
		String memo = "直近の現場ですが通信会社向け顧客管"
				+ "理システム開発に22か月携わ"
				+ "りました。 "
				+ "通信サービスの新規サ"
				+ "ービス追加に伴いWEBサイトにて申し込みを"
				+ "行えるように、既存システムの主にビジ"
				+ "ネスロaaaaaaaaaaaaaaaる部分の改修を要件定";
		TaskBean bean =new TaskBean();
		
		bean.setTaskName(taskName);
		bean.setCategoryId(categoryId);
		bean.setLimit(limit);
		bean.setUserId(userId);
		bean.setStatusCode(statusCode);
		bean.setMemo(memo);
		
		TaskDAO dao = new TaskDAO();
		try {
			count = dao.insert(bean);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println(count);
		assertEquals(0,count);
	
	}

}
