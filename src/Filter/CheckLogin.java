/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filter;

import controller.ProcessSys;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.CakeInfor;
import model.Client;
import model.User;
import modelDAO.ClientDAO;
import modelDAO.UserDAO;

/**
 *
 * @author Duck
 */
@WebFilter("/check_login")

public class CheckLogin implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ProcessSys.setCharacterUTF8(request, response);
        
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        ProcessSys.setCharacterUTF8(req, rep);
        
        HttpSession session = req.getSession();
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String pass = ProcessSys.decodeSHA(password);
        
        Client user = (Client) req.getAttribute("user");
        
        if(user != null){
            rep.sendRedirect(req.getContextPath() + "/home.jsp");
        }
        
        if(username != null && pass != null){
            Account account = new Account(username, pass);
            try {
                User t = UserDAO.getUserByAccount(account);
                if(t == null){
                    session.setAttribute("error", "Account is wrong !!!");
                    rep.sendRedirect(req.getContextPath() + "/login");
                }else{
                    Client client = ClientDAO.checkAccountExid(t);
                    if(t.getRole() == 1){
                        session.setAttribute("user", client);
                        ArrayList<CakeInfor> cart = (ArrayList<CakeInfor>) session.getAttribute("cart");
                        if(cart == null){
                            cart = new ArrayList<CakeInfor>();
                            session.setAttribute("cart", cart);
                        }
                         rep.sendRedirect(req.getContextPath() + "/home.jsp");
                    }else{
                        session.setAttribute("error", "Account is wrong !!!");
                        rep.sendRedirect(req.getContextPath() + "/login");
                    }
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(CheckLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            rep.sendRedirect(req.getContextPath() + "/login");
        }
    }

    public void destroy() {
        
    }
    
}
