package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.Product;

/**
 * Servlet implementation class ShowCartControll
 */
@WebServlet(urlPatterns = "/show")
public class AddToCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<Product> list = new ArrayList<>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToCartControl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");	
		try (PrintWriter out = response.getWriter()) {
		HttpSession session = request.getSession();
		ArrayList<Product> cart_list = (ArrayList<Product>) session.getAttribute("list");
		ArrayList<Product> list = new ArrayList<>();
		int id = Integer.parseInt(request.getParameter("id"));
		DAO dao = new DAO();
		Product cm = dao.getProductByID(id+"");
		int quanlity ;
	
		
		
		if (cart_list == null) {
			list.add(cm);
			quanlity = 0;
			session.setAttribute("list", list);
			response.sendRedirect("home");
			
		} else {
			
			list = cart_list;
			boolean exist = false;
			
			for (Product c : cart_list) {
				if (c.getId() == id) {
					exist = true;
					c.setPrice(c.getPrice()/c.getAmount());
					c.setAmount(c.getAmount() + 1);
					c.setPrice(c.getPrice()*c.getAmount());
					//out.println("<h3 style='color:crimson; text-align: center'>Item Already in Cart. <a href='Cart.jsp'>GO to Cart Page</a></h3>");
				}
				
				
			}
			
			
			if (!exist) {
				list.add(cm);
				response.sendRedirect("home");
			}
			quanlity = cart_list.size();
			session.setAttribute("quanlity", quanlity);
		}

		
		double total = 0;
		for (Product c : list) {
			total += c.getAmount() * c.getPrice();
			session.setAttribute("total", total);	
		}

		double totalP = total - (total * 0.1);
		session.setAttribute("totalP", totalP);

	}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	// Test

}
