package com.oracle.proce;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/***
 *
 * 测试 jdbc 连接 oracle 存储过程 返回游标
 *
 * @author wei
 *
 */
public class Procedures {
	public static void main(String[] args) {
		new Procedures().callRouting("20161201", "20161227");
	}

	private void callRouting(String startDate, String endDate) {
		try {
			// 来自class12.jar的JDBC
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.88.21.10:1521:orcl";
			String username = "scott";
			String password = "111111";
			Connection conn = DriverManager.getConnection(url, username,
					password);
			String sql = "{call PKG_ROUTING.TA_COUNT(?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, startDate);
			cstmt.setString(2, endDate);
			cstmt.registerOutParameter(3, oracle.jdbc.OracleTypes.CURSOR);
			cstmt.execute();
			ResultSet rs = (ResultSet) cstmt.getObject(3);
			while (rs.next()) {
				int col = rs.getMetaData().getColumnCount();
				for (int i = 1; i <= col; i++) {
					System.out.println(rs.getMetaData().getColumnName(i) + "--"
							+ rs.getString(i));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    @SuppressWarnings("unused")
	public void GED() throws Exception {
		Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:ORCL", "HH", "HH");
		CallableStatement cstmt = conn
				.prepareCall("{call TEST_CURSOR.TEST(?)}");
		cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR); // 输出参数需要注册
		cstmt.execute();
		ResultSet rs = (ResultSet) cstmt.getObject(1); // 注意是getObject,没有getCursor这种方法
		while (rs.next()) {
			System.out.println("id:" + rs.getInt(1) + " name:"
					+ rs.getString(2) + " grade:" + rs.getInt(3));
		}
	}
}