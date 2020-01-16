package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.254.190:1521:orcl","yjj", "yjj");
			System.out.println("成功与数据库建立连接！");
			Statement state=con.createStatement();
			String sql="select unit_name from B_UNIT";
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()) {
				String name=rs.getString("unit_name");
				System.out.println("单位名称:"+name);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			if(con!= null){
				try {
					con.close();//关闭连接
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}

