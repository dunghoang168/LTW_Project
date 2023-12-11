package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entity.Product;

/**
 * Servlet implementation class DeleteCartControl
 */
@WebServlet(urlPatterns = "/delCart")
public class DeleteCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteCartControl() {
		super();
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
			String id = request.getParameter("id");

			if (id != null) {

				ArrayList<Product> cart_list = (ArrayList<Product>) request.getSession().getAttribute("list");
				if (cart_list != null) {

					for (Product c : cart_list) {
						double total = 0;
						if (c.getId() == Integer.parseInt(id)) {
							cart_list.remove(cart_list.indexOf(c));
							for (Product c1 : cart_list) {
								total += c1.getPrice();
								request.getSession().setAttribute("total", total);
								double totalP = total - (total * 0.1);
								request.getSession().setAttribute("totalP", totalP);
							}
							request.getSession().setAttribute("quanlity", cart_list.size());
							break;

						}

					}
				}
				if(cart_list.size() == 0) {
					request.getSession().setAttribute("total", 0.);
					request.getSession().setAttribute("totalP", 0.);
				}
				response.sendRedirect("Cart.jsp");

			} else {

				response.sendRedirect("Cart.jsp");
			}

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

}