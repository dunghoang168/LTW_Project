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
import entity.Category;
import entity.Product;

/**
 * Servlet implementation class LoadControl
 */
@WebServlet(urlPatterns = "/load")
public class LoadControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("pid");
		String aid = request.getParameter("aid");
		
        Product p = DAO.getInstance().getProductByID(id);
        Account acc = DAO.getInstance().getAccountByID(aid);
        
        List<Category> listC = DAO.getInstance().getAllCategory();

        request.setAttribute("listCC", listC);
        request.setAttribute("detail", p);
        request.setAttribute("detailAcc", acc);
        
        if(id != null) {      	
        request.getRequestDispatcher("Edit.jsp").forward(request, response);
        }
        if(aid != null) {
        request.getRequestDispatcher("EditAccount.jsp").forward(request, response);	
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
