package org.lanqiao.recruit.controller;

import org.lanqiao.recruit.dao.imp.Register;
import org.lanqiao.recruit.service.imp.RegisterService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
    RegisterService registerService = new RegisterService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userKind = req.getParameter("userKind");
        if("puser".equals(userKind)){
            //添加个人用户
        }else if("cuser".equals(userKind)){
            //添加企业用户
            registerService.addCuser(username,password);
        }
    }
}
