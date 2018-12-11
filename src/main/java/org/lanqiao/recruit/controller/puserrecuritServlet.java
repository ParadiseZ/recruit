package org.lanqiao.recruit.controller;

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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@WebServlet("/rr.do")
public class puserrecuritServlet  extends HttpServlet {
    IPersonService iPersonService = new personServiecImpl();
    IRegisterLoginService registerLoginService = new RegisterLoginService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet( req, resp );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding( "UTF-8" );
        resp.setCharacterEncoding( "UTF-8" );
        String method = req.getParameter( "method" );
        switch (method) {
            case "getpersonalmessage":
                getpersonalmessage( req, resp );
        }
    }

    public void getpersonalmessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter( "username" );
        String passsword = req.getParameter( "password" );
        String hone = req.getParameter( "phone" );
        String sex = req.getParameter( "sex" );
        String born = req.getParameter( "born" );
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM" );
        Date bb = null;
        if (born != null && !"".equals( born )) {
            try {
                bb = sdf.parse( born );
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String ptime = req.getParameter( "gtime" );
        String pstate = req.getParameter( "position" );
        String school = req.getParameter( "pschool" );
        String major = req.getParameter( "xueli" );
        String exjob = req.getParameter( "pexjob" );
        String psrecord = req.getParameter( "zhuanye" );
        String psal = req.getParameter( "exsal" );
        String padvantage = req.getParameter( "pad" );
        String pemail = req.getParameter( "emial" );
        person_domain personDomain = new person_domain( hone, passsword, username, sex, bb, ptime, pstate, school, major, exjob, psrecord, psal, padvantage, pemail );
        iPersonService.addperson( personDomain );
        System.out.println( school );
        System.out.println( pemail );
      req.getRequestDispatcher( "/login.jsp" ).forward( req, resp );
    }


}