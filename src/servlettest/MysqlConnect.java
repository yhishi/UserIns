package servlettest;

import java.sql.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

public class MysqlConnect {

	public void Connect() throws JSONException {
		Connection con = null;
        try {

            // JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost/hishitest", "root", "***");
            System.out.println("MySQLに接続できました。");

            Statement stm = con.createStatement();
            String sql = "select * from userins";
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                String email = rs.getString("email");
                String passwd = rs.getString("passwd");
                int insdate = rs.getInt("insdate");
                int upddate = rs.getInt("upddate");

                System.out.println("取得結果 -> email:" + email + " passwd:" + passwd + " insdate:" + insdate + " upddate:" + upddate);

                // JSONObjectにJSに返す
                JSONObject result = new JSONObject();
                result.put("email", email);
                result.put("passwd", passwd);
                result.put("insdate", insdate);
                result.put("upddate", upddate);

            }


        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("JDBCドライバのロードに失敗しました。");
        } catch (SQLException e) {
            System.out.println("MySQLに接続できませんでした。");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("MySQLのクローズに失敗しました。");
                }
            }
        }
	}
}
