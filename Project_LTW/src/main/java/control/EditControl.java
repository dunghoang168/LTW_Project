package control;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;

/**
 * Servlet implementation class EditControl
 */
@WebServlet(urlPatterns = "/editControl")
public class EditControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String pid = request.getParameter("id");
		String aid = request.getParameter("aid");
		
		String user =  request.getParameter("user");
		String pass =  request.getParameter("pass");
		int isSell =  Integer.parseInt(request.getParameter("isSell")) ;
		int isAdmin =   Integer.parseInt(request.getParameter("isAdmin")) ;
		
		String name = request.getParameter("name");
		String image = request.getParameter("image");
		String price = request.getParameter("price");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		
		
		
		if(pid != null) {
			DAO.getInstance().editProduct(name, image, price, title, description, category, pid);
			response.sendRedirect("manager");
		}

		if(aid != null) {
		DAO.getInstance().editAccount(user, pass, isSell, isAdmin , aid);
		response.sendRedirect("managerAccount");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
