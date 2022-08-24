package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;


@WebListener
public class JDBCListener implements ServletContextListener {
     	private static DataSource dataSource;
    	
    	@Override
    	public void contextInitialized(ServletContextEvent sce) {
    		
    		// 웹 어플리케이션 첫 구동 시 필요한 설정을 할 수 있음.
    		ServletContext context = sce.getServletContext();
    		
    		String driver = context.getInitParameter("driver");
    		String DBurl = context.getInitParameter("DBurl");
    		String DBid = context.getInitParameter("DBid");
    		String DBpw = context.getInitParameter("DBpw");	
    		
    		BasicDataSource ds = new BasicDataSource();
    		ds.setDriverClassName(driver);
    		ds.setUrl(DBurl);
    		ds.setUsername(DBid);
    		ds.setPassword(DBpw);
    		
    		dataSource = ds;
    	}
    	
    	public static Connection getConnection() throws SQLException {
    		return dataSource.getConnection();
    		// 이렇게 쓰는 이유: 다쓰면 자동으로 반환함!!!
    	}
    	
    	public static void closeConn(Connection conn) {
    		if (conn != null) {
    			try {
    				conn.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    		}
    	}
    	
    	public static void closeStmt(Statement stmt) {
    		if (stmt != null)
    			try {
    				stmt.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    	}
    	
    	public static void closeRs(ResultSet rs) {
    		if (rs != null)
    			try {
    				rs.close();
    			} catch (SQLException e) {
    				e.printStackTrace();
    			}
    	}
}
