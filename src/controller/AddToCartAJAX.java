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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CakeInfor;
import model.Client;
import model.User;
import modelDAO.ClientDAO;
import modelDAO.UserDAO;

/**
 *
 * @author Duck
 */

@WebServlet("/addtocart")
        
public class AddToCartAJAX extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public AddToCartAJAX() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
//		ServletOutputStream out = response.getOutputStream();
        ProcessSys.setCharacterUTF8(request, response);
        
        HttpSession session = request.getSession();
        
        // Thêm sản phẩm vào giỏ hàng
        String IDCake = request.getParameter("idCake");
        int ID = Integer.valueOf(IDCake);
        System.out.println(IDCake);
        ArrayList<CakeInfor> list = (ArrayList<CakeInfor>)session.getAttribute("products"),
                             cart = (ArrayList<CakeInfor>)session.getAttribute("cart");
        int dem = 0;
        
        for(int i = 0; i < cart.size(); i++){
            if(cart.get(i).getIDCake() == ID){
                cart.get(i).tangDem();
                dem = cart.get(i).getDem();
                break;
            }
        }
        if(dem == 0){
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).getIDCake() == ID){
                    cart.add(list.get(i));
                    dem = list.get(i).getDem();
                    break;
                }
            }
        }
        dem = 0;
        dem = cart.size();
        dem *= 10;
//        for(int i = 0; i < cart.size(); i++){
//            dem += cart.get(i).getDem();
//        }
        response.getWriter().write(IDCake);
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
		// TODO Auto-generated method stub	
        ProcessSys.setCharacterUTF8(request, response);
        HttpSession session = request.getSession();
        
        
		
    }

}

