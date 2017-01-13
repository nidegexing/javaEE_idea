package com.oracle.proce;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/***
 *
 * 测试 jdbc 连接 oracle 存储过程 返回游标
 *
 * @author wei
 *
 */
public class Procedures {
	public static void main(String[] args) throws Exception {
		String strDate = "20170111";
		Date cuurDate = new Date();
		DateFormat format = new SimpleDateFormat("yyyyMMdd");
		String s;
		// 字符串-->Date
		Date date = format.parse(strDate);
		System.out.println("字符串-->Date:" + date.toString());
		// 字符串-->字符串
		s = format.format(format.parse(strDate));
		System.out.println("字符串-->字符串:" + s);
		// Date-->字符串
		s = format.format(cuurDate);
		System.out.println("Date-->字符串:" + s);
		// Date-->Date
		Date date2 = format.parse(format.format(date));
		System.out.println("Date-->Date:" + date2.toString());
		// Date-->java.sql.Date
		java.sql.Date sd = new java.sql.Date(cuurDate.getTime());
		System.out.println("Date-->java.sql.Date:" + sd.toString());
		// 日期计算
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		System.out.println("NextMonthDate:" + cal.get(Calendar.MONTH + 1));
	}

	public void callRouting(String startDate, String endDate) {
		try {
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

	public void callPersonDetail(String currDate) {
		Connection conn = null;
		CallableStatement proc = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.88.158.39:1521:oracle";
			String username = "crm_zjl";
			String password = "crm_zjl";
			conn = DriverManager.getConnection(url, username, password);
			proc = conn.prepareCall("{ Call KPG_PERSONDETAIL.SP_CBJS(?) }");
			// java.sql.Date date = java.sql.Date.valueOf(currDate);
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(df.parse(currDate));
			// 获取前一天的日期
			calendar.add(Calendar.DATE, -1);
			System.out.println("sendDate:" + df.format(calendar.getTime()));// 今天的日期
			// Date d = df.parse(currDate);
			proc.setDate(1, new java.sql.Date(calendar.getTime().getTime()));
			proc.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (proc != null) {
					proc.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
			}
		}
	}
}