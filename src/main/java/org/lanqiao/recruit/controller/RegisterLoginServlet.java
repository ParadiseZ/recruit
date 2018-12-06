package org.lanqiao.recruit.controller;

import org.lanqiao.recruit.service.imp.RegisterLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerLogin.do")
public class RegisterLoginServlet extends HttpServlet {
    RegisterLoginService registerService = new RegisterLoginService();
    String username;
    String password;
    String userKind;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        username = req.getParameter("username");
        password = req.getParameter("password");
        userKind = req.getParameter("userKind");
        if("puser".equals(userKind)){
            //添加个人用户
        }else if("cuser".equals(userKind)){
            //添加企业用户
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("username",username);
            httpSession.setAttribute("password",password);
            req.getRequestDispatcher("/perfectimformationcuser.jsp").forward(req,resp);
        }else if("usernameLogin".equals(userKind)){
            registerService.usernameLogin(username,password);
        }else if("emailLogin".equals(userKind)){

        }
    }
}
