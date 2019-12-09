package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Client;
/**
 * Servlet implementation class StaffAddProduct
 */
@WebServlet("/StaffAddProduct")
public class StaffAddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StaffAddProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client1 = null;
		client1 = (Client)session.getAttribute("user");
		if(client1 == null) {
			response.sendRedirect(request.getContextPath()+"/staff_login");
		}
		else {
			request.getRequestDispatcher("/staff_add_product.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Client client1 = null;
		client1 = (Client)session.getAttribute("user");
		if(client1 == null) {
			response.sendRedirect(request.getContextPath()+"/staff_login");
		}
		else {
//			request.setCharacterEncoding("utf-8");
//			String img="assets/cake/";
//			String name=request.getParameter("name");
//			int price=Integer.parseInt(request.getParameter("price"));
//			String description=request.getParameter("description");
//			String img1=request.getParameter("img1");File f1=new File(img1);String im1=img+f1.getName();
//			String img2=request.getParameter("img2");File f2=new File(img2);String im2=img+f2.getName();
//			String img3=request.getParameter("img3");File f3=new File(img3);String im3=img+f3.getName();
//			String img4=request.getParameter("img4");File f4=new File(img4);String im4=img+f4.getName();
//			
			response.sendRedirect(request.getContextPath()+"/staff_manage/StaffListProducts");
		}
	}

}
