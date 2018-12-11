package org.lanqiao.recruit.controller;

import org.lanqiao.recruit.domain.CompanyUser;
import org.lanqiao.recruit.domain.person_domain;
import org.lanqiao.recruit.service.imp.RegisterLoginService;
import org.lanqiao.recruit.service.imp.personServiecImpl;
import org.lanqiao.recruit.service.inter.IPersonService;
import org.lanqiao.recruit.service.inter.IRegisterLoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/registerLogin.do")
public class RegisterLoginServlet extends HttpServlet {
    IPersonService iPersonService=new personServiecImpl();
    IRegisterLoginService registerService = new RegisterLoginService();
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
            req.setAttribute( "username" ,username);
            req.setAttribute( "password",password );
            boolean bb = iPersonService.checkinfor(username,password );
            if (bb){
                req.getRequestDispatcher("/personal.jsp").forward(req,resp);
            } else {
                req.setAttribute("error","该用户已被注册！");
                req.getRequestDispatcher("/register.jsp").forward(req,resp);
            }
        }else if("cuser".equals(userKind)){
            //添加企业用户
            boolean checkUsername = registerService.checkImfor(username);
            if(!checkUsername){
                req.setAttribute("error","该用户名已存在！");
                req.getRequestDispatcher("/register.jsp").forward(req,resp);
            }else {
                CompanyUser companyUser = new CompanyUser();
                companyUser.setUserName(username);
                companyUser.setPassword(password);
                List<CompanyUser> companyUserList = new ArrayList<>();
                companyUserList.add(companyUser);
//            httpSession.setAttribute("userImformation",companyUserList);
                req.setAttribute("userImformation",companyUserList);
                req.getRequestDispatcher("/WEB-INF/pfimforcuser.jsp").forward(req,resp);
            }
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
        //获取企业用户信息
        if(!"".equals(method)&&  method!=null){
            String phoneBefore = req.getParameter("phone");
            String corporation = req.getParameter("corporation");
            String companyname = req.getParameter("companyname");
            String email = req.getParameter("email");
            String job = req.getParameter("job");
            if("registerFinal".equals(method)){//进行企业用户注册
                //判断该用户是否存在
                if(!"".equals(phoneBefore)||phoneBefore!=null){
                    long phoneAfter = Long.parseLong(phoneBefore);
                    CompanyUser cUser = new CompanyUser(username,password,phoneAfter,corporation,companyname,email,job);
                    registerService.addCuser(cUser);
                }
            }else if("modify".equals(method)){
                String usernameOld = req.getParameter("usernameOld");
                if(!usernameOld.equals(username)){
                    //如果用户名改变进行查询是否重复
                    boolean checkUsername = registerService.checkImfor(username);
                    if(!checkUsername){
                        req.setAttribute("error","该用户名已存在！修改失败");
                        req.getRequestDispatcher("/WEB-INF/pfimforcuser.jsp").forward(req,resp);
                    }else {
                        //如果不重复则进行修改
                        modifyImforAfter(req,resp,phoneBefore,username,password,corporation,companyname,email,job,httpSession);
                    }
                }else {
                    //如果用户名未改变直接进行修改
                    modifyImforAfter(req,resp,phoneBefore,username,password,corporation,companyname,email,job,httpSession);
                }
            }else if("logout".equals(method)){

                //退出登录，删除会话中的信息
                httpSession.setAttribute("userImformation",null);
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }else if("loginImfor".equals(method)){
                req.getRequestDispatcher("/WEB-INF/pfimforcuser.jsp").forward(req,resp);
            }
        }
    }
    //获取用户信息并保存在session中
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

    //检查是否重复后修改企业用户信息
    public void modifyImforAfter(HttpServletRequest req, HttpServletResponse resp,String phoneBefore,String username,String password,String corporation,String companyname,String email,String job,HttpSession httpSession){
        String getId = req.getParameter("id");
        if((!"".equals(phoneBefore)||phoneBefore!=null)&&(!"".equals(getId)||getId!=null)){
            long phoneAfter = Long.parseLong(phoneBefore);
            int id = Integer.parseInt(getId);
            CompanyUser cUser = new CompanyUser(id,username,password,phoneAfter,corporation,companyname,email,job);
            List<CompanyUser> companyUserList = new ArrayList<CompanyUser>();
            companyUserList.add(cUser);
            httpSession.setAttribute("userImformation",companyUserList);
            req.setAttribute("success","修改成功！");
            registerService.updateCuser(cUser);
            try {
                req.getRequestDispatcher("/WEB-INF/pfimforcuser.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
