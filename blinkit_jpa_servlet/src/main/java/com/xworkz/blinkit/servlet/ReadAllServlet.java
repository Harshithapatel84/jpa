package com.xworkz.blinkit.servlet;

import com.xworkz.blinkit.dto.RegisterDto;
import com.xworkz.blinkit.service.RegisterService;
import com.xworkz.blinkit.service.RegisterServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(urlPatterns = "/readAll")
public class ReadAllServlet extends HttpServlet {
    RegisterService service=new RegisterServiceImpl();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("readAll:servlet");
        List<RegisterDto> dtos = service.validateAndGetAllRegister();
        System.out.println(dtos);
        req.setAttribute("registerDtoList", dtos);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/readAll.jsp");
        dispatcher.forward(req, resp);
    }
}

