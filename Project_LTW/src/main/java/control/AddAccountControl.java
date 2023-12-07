package control;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;

/**
 * Servlet implementation class AddAccountControl
 */
@WebServlet(urlPatterns = "/addAcc")
public class AddAccountControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAccountControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String sess = request.getParameter("session");
		
		HttpSession session = request.getSession();
	
		
		
		int isSell = 0; 
		int isAdmin = 0;
		
		int ranNum = ThreadLocalRandom.current().nextInt(1,101);
		if(sess.equals("seller")) {
			isSell = ranNum;
		}
		if(sess.equals("admin")) {
			isAdmin = 1;
		}
		
		DAO.getInstance().insertAccount(user, pass, isSell, isAdmin);	
		response.sendRedirect("managerAccount");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
