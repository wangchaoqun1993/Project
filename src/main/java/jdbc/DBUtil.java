package jdbc;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtil {
	private static BasicDataSource ds;
	static{
		try {
			//���������ļ�
			Properties p=new Properties();
			p.load(new FileInputStream("config.properties"));
			//��ȡ�ļ���Ϣ��ʼ��
			String drivername=p.getProperty("drivername");
			String url=p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			int maxActive=Integer.parseInt((p.getProperty("maxactive")));
			int maxWait=Integer.parseInt((p.getProperty("maxwait")));
			//ʵ�������ӳ�
			ds=new BasicDataSource();
			//��ʼ�����ӳ�
			ds.setDriverClassName(drivername);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setMaxActive(maxActive);
			ds.setMaxWait(maxWait);
		}  catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		/*BasicDataSource�ṩ�˾�̬����ֱ�ӻ�ȡ���ӵķ���
		 * Connection getConnection()�÷����Ὣ���ӳ��еĿ������ӷ��أ�
		 * ����ǰ���ӳ���û�п��ÿ������ӣ���ô�÷�����������
		 * ����ʱ����maxWaitָ����ֵ�������������ڼ����п������ӿ��û����̷��ظ����ӣ�
		 * ����ʱ����Ȼû�п������ӣ���ô�÷������׳���ʱ�쳣��
		 */
		return ds.getConnection();
	}
	public static void main(String[] args) throws SQLException {
		// TODO �Զ����ɵķ������
		DBUtil.getConnection();
	}

}
