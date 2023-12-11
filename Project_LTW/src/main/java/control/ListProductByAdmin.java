package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.Account;
import entity.Product;

/**
 * Servlet implementation class ListProductByAdmin
 */
@WebServlet(urlPatterns = "/listByAdmin")
public class ListProductByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductByAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String  aid = request.getParameter("sid");
			
		Account acc = DAO.getInstance().getAccountBySellID(aid);
		int sid = acc.getId();
		List<Product> list = DAO.getInstance().getProductBySellID(sid);

        request.setAttribute("listP", list);
		//response.sendRedirect("manager");
		request.getRequestDispatcher("ManagerProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
