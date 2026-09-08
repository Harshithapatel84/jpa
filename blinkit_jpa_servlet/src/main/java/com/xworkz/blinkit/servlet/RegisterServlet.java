package com.xworkz.blinkit.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(loadOnStartup = 1,urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

  public   RegisterServlet()
    {
        System.out.println("register servlet constructor created");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("running doPost");
      String name = req.getParameter("name");
      String PhNumber=req.getParameter("PhNumber");
      String Email=req.getParameter("Email");
      String Password=req.getParameter("Password");
        System.out.println("name:"+name);
        System.out.println("PhNumber:"+PhNumber);
        System.out.println("Email:"+Email);
        System.out.println("Password:"+Password);

        String message=name+" "+"contact was successfully saved";
        System.out.println(message);

        req.setAttribute("message",message);
        RequestDispatcher request=req.getRequestDispatcher("register.jsp");

        request.forward(req,resp);

    }
}
