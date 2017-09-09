package servlettest;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		PrintWriter out = response.getWriter();
		String str = request.getParameter("text1");
		String email = request.getParameter("email");
		String passwd = request.getParameter("passwd");
		String insdate = request.getParameter("insdate");
		String upddate = request.getParameter("upddate");

		String name = request.getParameter("name");
		String age = request.getParameter("age");



	    String vals[] = request.getParameterValues("email");
	    if (vals != null){
	      for (int i = 0 ; i < vals.length ; i++){
	        out.println(vals[i]);
	        System.out.println(vals[i]);;
	      }
	    }

	    // JS‚ÌJSON‚ªŽæ“¾‚Å‚«‚È‚¢[[9/9

		// MySQlÚ‘±
		MysqlConnect Mysql = new MysqlConnect();
		//Mysql.Connect();


		//doGet(request, response);
	}

}
