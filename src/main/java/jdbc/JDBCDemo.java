package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.254.190:1521:orcl","yjj", "yjj");
			System.out.println("�ɹ������ݿ⽨�����ӣ�");
			Statement state=con.createStatement();
			String sql="select unit_name from B_UNIT";
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()) {
				String name=rs.getString("unit_name");
				System.out.println("��λ����:"+name);
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			if(con!= null){
				try {
					con.close();//�ر�����
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
}

