package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Product;

/**
 * Servlet implementation class SubControl
 */
@WebServlet(urlPatterns = "/sub")
public class SubControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		try (PrintWriter out = response.getWriter()) {
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			String pid = request.getParameter("id");
			ArrayList<Product> cart_list = (ArrayList<Product>) request.getSession().getAttribute("list");
			
			Product p = DAO.getInstance().getProductByID(pid);
			double total = 0;
			if (action != null && id >= 1) {
				if (action.equals("add")) {
					for (Product c : cart_list) {
						if (c.getId() == id) {
							c.setAmount(c.getAmount()+1);
							c.setPrice(p.getPrice()*c.getAmount());
							
							for(Product c1 : cart_list) {
								total = total+ c1.getPrice();
								session.setAttribute("total", total);	
							}
									
							

							double totalP = total - (total * 0.1);
							session.setAttribute("totalP", totalP);
							response.sendRedirect("Cart.jsp");
						}
					}
				}

				if (action.equals("s")) {
					for (Product c : cart_list) {
						if (c.getId() == id && c.getAmount() > 1) {
							c.setAmount(c.getAmount()-1);
							c.setPrice(p.getPrice()*c.getAmount());						
							for(Product c1 : cart_list) {
								total = total+ c1.getPrice();
								session.setAttribute("total", total);	
							}
							double totalP = total - (total * 0.1);
							session.setAttribute("totalP", totalP);
							break;
						}
					}
					response.sendRedirect("Cart.jsp");
				}
			} else {
				response.sendRedirect("Cart.jsp");
			}
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
