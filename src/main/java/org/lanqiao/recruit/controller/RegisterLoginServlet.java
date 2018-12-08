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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/registerLogin.do")
public class RegisterLoginServlet extends HttpServlet {
    RegisterLoginService registerService = new RegisterLoginService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        HttpSession httpSession = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String userKind = req.getParameter("userKind");
        String method = req.getParameter("method");
        if("puser".equals(userKind)){
            //添加个人用户
        }else if("cuser".equals(userKind)){
            //添加企业用户
            CompanyUser companyUser = new CompanyUser();
            companyUser.setUserName(username);
            companyUser.setPassword(password);
            List<CompanyUser> companyUserList = new ArrayList<>();
            companyUserList.add(companyUser);
//            httpSession.setAttribute("userImformation",companyUserList);
            req.setAttribute("userImformation",companyUserList);
            req.getRequestDispatcher("/pfimforcuser.jsp").forward(req,resp);
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
        if("pfimforcuser".equals(method)){
            String phoneBefore = req.getParameter("phone");
            long phoneAfter = 0;
            CompanyUser cUser = null;
            if(!"".equals(phoneBefore)||phoneBefore!=null){
                phoneAfter = Long.parseLong(phoneBefore);
                String corporation = req.getParameter("corporation");
                String companyname = req.getParameter("companyname");
                String email = req.getParameter("email");
                String job = req.getParameter("job");
                cUser = new CompanyUser(username,password,phoneAfter,corporation,companyname,email,job);
                registerService.addCuser(cUser);
            }
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
