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

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

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

		// 検索m－ルアドレス取得
		String inemail = request.getParameter("email");

		Connection con = null;
        try {

            // JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            // MySQLに接続
            con = DriverManager.getConnection("jdbc:mysql://localhost/hishitest", "", "!");
            System.out.println("MySQLに接続できました。");

            Statement stm = con.createStatement();
            String sql = "select * from userins where email like '" + inemail + "%'";
            ResultSet rs = stm.executeQuery(sql);

            ArrayList<ArrayList<String>> dblist = new ArrayList<ArrayList <String>>();

            while(rs.next()){
            	ArrayList<String> sub = new ArrayList<String>();

            	sub.add(rs.getString("email"));
            	sub.add(rs.getString("passwd"));
            	String insdate = String.valueOf(rs.getInt("insdate"));
            	sub.add(insdate);
            	String upddate = String.valueOf(rs.getInt("upddate"));
            	sub.add(upddate);
            	dblist.add(sub);

                System.out.println("取得結果 -> email:" + rs.getString("email") + " passwd:" + rs.getString("passwd") + " insdate:" + insdate + " upddate:" + upddate);
            }

    		// Gsonオブジェクトを作成
            Gson gson = new Gson();

            // クライアントにDBからのデータリストを返す
            PrintWriter out = response.getWriter();
            out.println(gson.toJson(dblist));


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








		// MySQl接続
//		MysqlConnect Mysql = new MysqlConnect();
//		try {
//			Mysql.Connect();
//		} catch (JSONException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}




		//doGet(request, response);
	}

}
