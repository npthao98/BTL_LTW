package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cake;
import model.Cake_Type;
import model.ImageUrl;
import model.Type;
import modelDAO.CakeDAO;
import modelDAO.CakeTypeDAO;
import modelDAO.ImageurlDAO;
import modelDAO.TypeDAO;

/**
 * Servlet implementation class DetailProduct
 */
@WebServlet("/DetailProduct")
public class DetailProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id=Integer.parseInt(request.getParameter("id"));
		Cake cake= CakeDAO.getByID(id);
		List<Cake_Type> cakeType = CakeTypeDAO.getByCakeID(cake.getID());
		List<Type> listType = new ArrayList<Type>();
		for(int i=0; i<cakeType.size(); i++) {
			Type t = TypeDAO.getByID(cakeType.get(i).getTypeID());
			listType.add(t);
		}
		request.setAttribute("cake", cake);
		request.setAttribute("listType", listType);
		request.getRequestDispatcher("/detailProduct.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
