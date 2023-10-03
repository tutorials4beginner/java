import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {

	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs = null;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	static void exec(String sql) {
		try {
			con = DriverManager.getConnection(
					"jdbc:mysql://127.0.0.1:3306/test", "root", "iltwat");
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String args[]) {
		String sql = "select * from tab1";
		exec(sql);
	}
}
