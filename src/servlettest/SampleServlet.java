package servlettest;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.mysql.jdbc.MySQLConnection;

/**
 * Servlet implementation class SampleServlet
 */
@WebServlet("/sample")
public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SampleServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("text/html;charset=UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		//String email = request.getParameter("email"); ����ʓI�ȃp�����[�^�擾���@

		// ���͕����f�[�^���܂Ƃ߂Ď擾
		String input = request.getParameter("input");
		Gson gson = new Gson();

		// insdata[]�N���X�ɕϊ�
		insdata[] insdata = gson.fromJson(input,insdata[].class);

		// DB�o�^
		Connection con = null;
        try {

            // JDBC�h���C�o�̃��[�h - JDBC4.0�iJDK1.6�j�ȍ~�͕s�v
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // MySQL�ɐڑ�
            con = DriverManager.getConnection("jdbc:mysql://localhost/hishitest", "r", "!");
            System.out.println("MySQL�ɐڑ��ł��܂����B");

            Statement stm = con.createStatement();

            // ���sSQL�쐬
            String sql = "insert into userins values ";
            for(int i=0; i<insdata.length; i++) {
            	if(i+1==insdata.length) {
            		sql += "('"+ insdata[i].email + "','" + insdata[i].passwd + "','" + insdata[i].insdate + "','" + insdata[i].upddate +"')";
            		continue;
            	}
            	sql += "('"+ insdata[i].email + "','" + insdata[i].passwd + "','" + insdata[i].insdate + "','" + insdata[i].upddate +"'),";
            }
            sql += ";";

            // �N�G�����s
            int num = stm.executeUpdate(sql);

            stm.close();

        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println("JDBC�h���C�o�̃��[�h�Ɏ��s���܂����B");
        } catch (SQLException e) {
            System.out.println("SQL�̎��s�Ɏ��s���܂����B");
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
