package org.lanqiao.recruit.controller;

import org.lanqiao.recruit.domain.CompanyUser;
import org.lanqiao.recruit.domain.person_domain;
import org.lanqiao.recruit.service.imp.RegisterLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

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
        HttpSession httpSession = req.getSession();
        username = req.getParameter("username");
        password = req.getParameter("password");
        userKind = req.getParameter("userKind");
        if("puser".equals(userKind)){
            //添加个人用户
        }else if("cuser".equals(userKind)){
            //添加企业用户
            httpSession.setAttribute("username",username);
            httpSession.setAttribute("password",password);
            req.getRequestDispatcher("/perfectimformationcuser.jsp").forward(req,resp);
        }else if("usernameLogin".equals(userKind)){
            //用户名登录
            Map resultMap = registerService.usernameLogin(username,password);
            if(resultMap.containsKey(0)){
                req.setAttribute("error","您的用户名或密码输入错误！");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
            getImformationFromService(req,resp,resultMap,httpSession);
        }else if("emailLogin".equals(userKind)){
            Map resultMap = registerService.emailLogin(username,password);
            if(resultMap.containsKey(0)){
                req.setAttribute("error","您的邮箱或密码输入错误！");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }
            getImformationFromService(req,resp,resultMap,httpSession);
        }
    }

    public void getImformationFromService(HttpServletRequest req, HttpServletResponse resp,Map resultMap,HttpSession httpSession){
        if(resultMap.containsKey(1)){
            List<CompanyUser> companyUserList = (List<CompanyUser>) resultMap.get(1);
            httpSession.setAttribute("userImformation",companyUserList);
            try {
                req.getRequestDispatcher("/boss.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(resultMap.containsKey(2)){
            List<person_domain> person_domainList = (List<person_domain>) resultMap.get(2);
            httpSession.setAttribute("userImformation",person_domainList);
            try {
                req.getRequestDispatcher("/boss.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(resultMap.containsKey(3)){
            req.setAttribute("error","查询该用户失败！");
            try {
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
