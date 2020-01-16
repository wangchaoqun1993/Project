package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBUtilDemo {
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("���������֤���룺");
		String idcard=s.nextLine();
		// TODO �Զ����ɵķ������
		Connection conn=null;
		try {
			conn=DBUtil.getConnection();
			String sql="select staff_name from b_staff where staff_idcard=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, idcard);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String name=rs.getString("staff_name");
				System.out.println("��ӭ��"+name+"��¼ϵͳ");
			}else {
				System.out.println("���޴���");
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
	}

}
