/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cake;
import model.CakeInfor;
import model.ImageUrl;
import model.Type;
import modelDAO.CakeDAO;
import modelDAO.ImageurlDAO;
import modelDAO.TypeDAO;

/**
 *
 * @author Duck
 */
@WebServlet(urlPatterns={"/shop"})

public class ShopController extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.sendRedirect(request.getContextPath() + "/shop.jsp");
        ProcessSys.setCharacterUTF8(request, response);
        
        HttpSession session = request.getSession();
        
        session.removeAttribute("products");
        
        try {
            ArrayList<Cake> list = CakeDAO.getAllCake();
            ArrayList<CakeInfor> products = new ArrayList<CakeInfor>();
            for(int i = 0; i < list.size(); i++){
                ArrayList<ImageUrl> urls = ImageurlDAO.getByCake(list.get(i));
                ArrayList<Type> types = TypeDAO.getByCake(list.get(i));
                products.add(new CakeInfor(list.get(i), types, urls));
            }
            session.setAttribute("products", products);
            
            if(session.getAttribute("cart") == null){
                ArrayList<CakeInfor> cart = new ArrayList<CakeInfor>();            
                session.setAttribute("cart", cart);
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(request.getContextPath() + "/shop.jsp");
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

	/**
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        @Override
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProcessSys.setCharacterUTF8(request, response);

    }
}
