package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	* JSP�̃x�[�X�f�B���N�g���B
	*/
	private static final String JSP_BASE = "/WEB-INF/jsp/";

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

		// �v������action�p�����[�^���擾
		String action = request.getParameter("action");

		String forward = null;
		if ("login".equals(action)) {
			// ���O�C����ʂ̏���
			// login.jsp�փt�H���[�h����
			forward = JSP_BASE + "login.jsp";
		} else {
			// �s���ȃA�N�V�����̏ꍇ
			throw new ServletException("�s���ȃ��N�G�X�g�ł�");
		}

		// JSP�ւ̃t�H���[�h
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
