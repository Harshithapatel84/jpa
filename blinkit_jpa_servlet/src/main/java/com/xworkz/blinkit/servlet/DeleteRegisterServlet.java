package com.xworkz.blinkit.servlet;

import com.xworkz.blinkit.service.RegisterServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteRegisterById")
public class DeleteRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("invoking delete register");
        Integer registerId=Integer.valueOf(req.getParameter("id"));
        System.out.println("registerId:"+registerId);

        Boolean deleteRegisterById=new RegisterServiceImpl().deleteRegisterById(registerId);
        if(deleteRegisterById){
            resp.sendRedirect(req.getContextPath()+"/readAll");
        }
        System.out.println("-----------contextPath-------"+req.getContextPath());


    }
}
