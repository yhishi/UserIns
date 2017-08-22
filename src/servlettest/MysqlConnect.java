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

            // JDBC�h���C�o�̃��[�h - JDBC4.0�iJDK1.6�j�ȍ~�͕s�v
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            // MySQL�ɐڑ�
            con = DriverManager.getConnection("jdbc:mysql://localhost/hishitest", "root", "***");
            System.out.println("MySQL�ɐڑ��ł��܂����B");

            Statement stm = con.createStatement();
            String sql = "select * from userins";
            ResultSet rs = stm.executeQuery(sql);

            while(rs.next()){
                String email = rs.getString("email");
                String passwd = rs.getString("passwd");
                int insdate = rs.getInt("insdate");
                int upddate = rs.getInt("upddate");

                System.out.println("�擾���� -> email:" + email + " passwd:" + passwd + " insdate:" + insdate + " upddate:" + upddate);

                // JSONObject��JS�ɕԂ�
                JSONObject result = new JSONObject();
                result.put("email", email);
                result.put("passwd", passwd);
                result.put("insdate", insdate);
                result.put("upddate", upddate);

            }


        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("JDBC�h���C�o�̃��[�h�Ɏ��s���܂����B");
        } catch (SQLException e) {
            System.out.println("MySQL�ɐڑ��ł��܂���ł����B");
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("MySQL�̃N���[�Y�Ɏ��s���܂����B");
                }
            }
        }
	}
}
