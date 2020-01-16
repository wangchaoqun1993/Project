package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBUtilDemo {
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("请输入身份证号码：");
		String idcard=s.nextLine();
		// TODO 自动生成的方法存根
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select staff_name from b_staff where staff_idcard=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, idcard);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String name=rs.getString("staff_name");
				System.out.println("欢迎您"+name+"登录系统");
			}else {
				System.out.println("查无此人");
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
	}

}
