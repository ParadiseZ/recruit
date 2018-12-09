package org.lanqiao.recruit.controller;

import org.apache.commons.dbutils.QueryRunner;
import org.lanqiao.recruit.dao.imp.personaler;
import org.lanqiao.recruit.dao.inter.IPersonal;
import org.lanqiao.recruit.domain.person_domain;
import org.lanqiao.recruit.service.imp.personServiecImpl;
import org.lanqiao.recruit.service.inter.IPersonService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
//抛弃的servlet
//@WebServlet("/rr.do")
public class personalServlet  extends HttpServlet {
    IPersonService iPersonService=new personServiecImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doPost( req,resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String username=(String) req.getAttribute("username");
        String password=(String)req.getAttribute("password");
        List<person_domain> personDomainList=iPersonService.addpuser(username,password);
//        req.setCharacterEncoding("UTF-8");
//        String username=req.getParameter("username");
//        String password=req.getParameter("password");
//        System.out.println(password+"====");
//        System.out.println(username+"====");
       req.getRequestDispatcher( "/personal.jsp" ).forward( req,resp );


}
public void personalmessage(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
//    req.setCharacterEncoding("UTF-8");

//    String pname = req.getParameter("value");
}
}