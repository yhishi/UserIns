package servlettest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//response.setContentType("text/html;charset=UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		// ����m�|���A�h���X�擾
		String inemail = request.getParameter("email");




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
        } catch (JSONException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		} finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.out.println("MySQL�̃N���[�Y�Ɏ��s���܂����B");
                }
            }
        }








		// MySQl�ڑ�
//		MysqlConnect Mysql = new MysqlConnect();
//		try {
//			Mysql.Connect();
//		} catch (JSONException e) {
//			// TODO �����������ꂽ catch �u���b�N
//			e.printStackTrace();
//		}




		//doGet(request, response);
	}

}
