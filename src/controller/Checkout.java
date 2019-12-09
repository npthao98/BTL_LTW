package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CakeInfor;
import model.Client;
import modelDAO.CakeOrderDAO;
import modelDAO.OrderClientDAO;
import modelDAO.OrderDAO;

/**
 * Servlet implementation class Checkout
 */
@WebServlet("/Checkout")
public class Checkout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Checkout() {
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
	                response.sendRedirect(request.getContextPath()+"/login");
	        }
	        else {
	        	request.setAttribute("client", client);
	        	List<CakeInfor> list = (List<CakeInfor>) session.getAttribute("cart");
	        	System.out.println(list.get(0).getDem());
	        	request.setAttribute("list", list);
	        	request.getRequestDispatcher("/checkout.jsp").forward(request, response);
	        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client = null;
        client = (Client)session.getAttribute("user");
		List<CakeInfor> list = (List<CakeInfor>) session.getAttribute("cart");
		
		String address = request.getParameter("address");
		System.out.println(address);
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date1 = df.format(date);
		int total=0;
		for(int i=0; i<list.size(); i++) {
			total = total+ list.get(i).getPrice()*list.get(i).getDem();
		}
		int state = 0;
		int order_id = OrderDAO.insert(date1, total, address, state);
		OrderClientDAO.insert(order_id, client.getID());
		for(int i=0; i<list.size(); i++) {
			CakeOrderDAO.insert(order_id, list.get(i).getIDCake(), list.get(i).getDem());
		}
		
		response.sendRedirect(request.getContextPath()+"/DetailSuccessOrder?id="+order_id);
	}

}
