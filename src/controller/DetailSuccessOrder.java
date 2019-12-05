package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Client;
import modelDAO.OrderClientDAO;
import modelDAO.OrderDAO;
import model.Order;
import model.Order_Client;

/**
 * Servlet implementation class DetailSuccessOrder
 */
@WebServlet("/DetailSuccessOrder")
public class DetailSuccessOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailSuccessOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client = null;
		client = (Client)session.getAttribute("user");
		if(client == null) {
			response.sendRedirect("/BTL_LTW/login");
		}
		else {
			int id=Integer.parseInt(request.getParameter("id"));
			Order order = OrderDAO.getByID(id);
			System.out.println(id);
			System.out.println(order);
			Order_Client order_client = OrderClientDAO.getByOrderID(1);
			if(order_client.getClientID() != client.getID()) {
				response.setContentType("text/html");
				PrintWriter writter = response.getWriter();
				writter.println("Don hang khong ton tai");
			}
			else {
				request.getRequestDispatcher("/detailOrderSuccess.jsp").forward(request, response);
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
