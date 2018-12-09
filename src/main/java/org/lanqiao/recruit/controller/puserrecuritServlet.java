package org.lanqiao.recruit.controller;

import org.lanqiao.recruit.domain.person_domain;
import org.lanqiao.recruit.service.imp.personServiecImpl;
import org.lanqiao.recruit.service.inter.IPersonService;

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
    IPersonService iPersonService=new personServiecImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet( req, resp );
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        String username = (String)req.getAttribute( "username" );
//        String username = req.getParameter("username");
//
//        String passsword = req.getParameter( "password" );
//        System.out.println(username);
//        //phone=? ,psex=?,pborn=? ,ptime=?,pstate=?,pschool=?,pmajor=?,exjob=?,psrecord=?,psal=?,padvantage=?
//         String hone=req.getParameter("phone"  );
//
////         String phon = String.valueOf( hone );
////        Integer pho = 0;
////        if(hone !=null && !"".equals(hone)){
////            pho =Integer.parseInt(phon);
////        }
//         String sex=req.getParameter( "sex" );
//         String born=req.getParameter( "born" );
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//        Date bb=null;
//        if(born !=null && !"".equals(born)){
//            try {
//                bb= sdf.parse(born);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        String ptime=req.getParameter("gtime"  );
//        String pstate=req.getParameter( "position" );
//        String school=req.getParameter( "pschool" );
//        String major=req.getParameter("xueli"  );
//        String exjob=req.getParameter( "exjob" );
//        String psrecord=req.getParameter( "zhuanye" );
//        String psal=req.getParameter("exsal"  );
//        String padvantage=req.getParameter( "pad" );
//        String pemail = req.getParameter( "emial" );
//        person_domain personDomain = new person_domain(hone,passsword,username,sex,bb,ptime,pstate,school,major,exjob,psrecord,psal,padvantage,pemail);
//        iPersonService.addperson(personDomain);
//       System.out.println(school);
//
//        System.out.println(pemail);
//        req.getRequestDispatcher( "/login.jsp" ).forward( req,resp );
        String method=req.getParameter( "method" );
        switch(method){
            case "getpersonalmessage":
                getpersonalmessage(req, resp );
                break;
//            case"UpdateServlet":
//                UpdateServlet(req, resp );
//                break;
        }
    }
    public void getpersonalmessage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");

        String passsword = req.getParameter( "password" );
        System.out.println(username);
        //phone=? ,psex=?,pborn=? ,ptime=?,pstate=?,pschool=?,pmajor=?,exjob=?,psrecord=?,psal=?,padvantage=?
        String hone=req.getParameter("phone");

//         String phon = String.valueOf( hone );
//        Integer pho = 0;
//        if(hone !=null && !"".equals(hone)){
//            pho =Integer.parseInt(phon);
//        }
        String sex=req.getParameter( "sex" );
        String born=req.getParameter( "born" );
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        Date bb=null;
        if(born !=null && !"".equals(born)){
            try {
                bb= sdf.parse(born);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        String ptime=req.getParameter("gtime"  );
        String pstate=req.getParameter( "position" );
        String school=req.getParameter( "pschool" );
        String major=req.getParameter("xueli"  );
        String exjob=req.getParameter( "exjob" );
        String psrecord=req.getParameter( "zhuanye" );
        String psal=req.getParameter("exsal"  );
        String padvantage=req.getParameter( "pad" );
        String pemail = req.getParameter( "emial" );
        person_domain personDomain = new person_domain(hone,passsword,username,sex,bb,ptime,pstate,school,major,exjob,psrecord,psal,padvantage,pemail);
        iPersonService.addperson(personDomain);
        System.out.println(school);

        System.out.println(pemail);
        req.getRequestDispatcher( "/login.jsp" ).forward( req,resp );
    }



//    public void UpdateServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("username");
//        String passsword = req.getParameter( "password" );
//        String hone=req.getParameter("phone"  );
//        String sex=req.getParameter( "sex" );
//        String born=req.getParameter( "born" );
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//        Date bb=null;
//        if(born !=null && !"".equals(born)){
//            try {
//                bb= sdf.parse(born);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//        String ptime=req.getParameter("gtime"  );
//        String pstate=req.getParameter( "position" );
//        String school=req.getParameter( "pschool" );
//        String major=req.getParameter("xueli"  );
//        String exjob=req.getParameter( "exjob" );
//        String psrecord=req.getParameter( "zhuanye" );
//        String psal=req.getParameter("exsal"  );
//        String padvantage=req.getParameter( "pad" );
//        String pemail = req.getParameter( "emial" );
//        person_domain personDomain = new person_domain(hone,passsword,username,sex,bb,ptime,pstate,school,major,exjob,psrecord,psal,padvantage,pemail);
//        //调用更新方法
//        iPersonService.updatePerson(hone,passsword,sex,ptime,pstate,major,exjob,psrecord,psal,padvantage,pemail );
//       boolean result=iPersonService.updatePerson( hone,passsword,sex,ptime,pstate,major,exjob,psrecord,psal,padvantage,pemail );
//         req.getRequestDispatcher( "/login.jsp" ).forward( req,resp );
//    }
}
