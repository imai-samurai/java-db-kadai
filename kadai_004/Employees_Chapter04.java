package kadai.kadai_004;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employees_Chapter04 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement statement = null;
		
		try {
			//接続
			con = DriverManager.getConnection(
				"jdbc:mysql://localhost/challenge_java",
				"root",
				"提出用に消しました"
			);
			//テーブル作成
			statement = con.createStatement();
			String sql = """
						 CREATE TABLE employees (
						 	id INT(11) NOT NULL AUTO_INCREMENT PRIMARY KEY,
						 	name VARCHAR(60) NOT NULL,
						 	email VARCHAR(255) NOT NULL,
						 	age INT(11),
						 	address VARCHAR(255)
						 );
						 """;
			//SQLクエリ実行
			int rowCnt = statement.executeUpdate(sql);
			System.out.println("テーブルを作成" +rowCnt);
			
		} catch(SQLException e) {
			System.out.println("エラー発生");
		}finally {
			if(statement != null) {
				try {statement.close();} catch(SQLException ignore) {}
			}
			if(con != null) {
				try {con.close();} catch(SQLException ignore) {}
			}
		}
	}

}
