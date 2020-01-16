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
			//加载配置文件
			Properties p=new Properties();
			p.load(new FileInputStream("config.properties"));
			//获取文件信息初始化
			String drivername=p.getProperty("drivername");
			String url=p.getProperty("url");
			String username=p.getProperty("username");
			String password=p.getProperty("password");
			int maxActive=Integer.parseInt((p.getProperty("maxactive")));
			int maxWait=Integer.parseInt((p.getProperty("maxwait")));
			//实例化连接池
			ds=new BasicDataSource();
			//初始化连接池
			ds.setDriverClassName(drivername);
			ds.setUrl(url);
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setMaxActive(maxActive);
			ds.setMaxWait(maxWait);
		}  catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException {
		/*BasicDataSource提供了静态方法直接获取连接的方法
		 * Connection getConnection()该方法会将连接池中的空闲连接返回，
		 * 若当前连接池中没有可用空闲连接，那么该方法会阻塞，
		 * 阻塞时间由maxWait指定的值决定，在阻塞期间若有空闲连接可用会立刻返回该连接，
		 * 若超时后仍然没有可用连接，那么该方法会抛出超时异常。
		 */
		return ds.getConnection();
	}
	public static void main(String[] args) throws SQLException {
		// TODO 自动生成的方法存根
		DBUtil.getConnection();
	}

}
