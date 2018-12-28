package org.lanqiao.recruit.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.recruit.service.imp.UploderService;
import org.lanqiao.recruit.service.inter.IUploaderService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet("/upload.do")
public class jianliUpLoad extends HttpServlet {
    IUploaderService uploaderService = new UploderService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost( req, resp );
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //she置缓存的大小及目录
        DiskFileItemFactory factory = new DiskFileItemFactory(8*1024*1024,new File( "javax.servlet.context.tempdir" ));
        ServletContext servletContext = this.getServletConfig().getServletContext();
//        // 配置文件的存储仓库  临时目录
//        File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
//        System.out.println(repository);
        //创建文件上传的处理器
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        Date date=new Date(  );
        SimpleDateFormat sdf=new SimpleDateFormat( "yyyy-MM-dd" );
        String day=sdf.format( date );
        //解析请求
        try {
            List<FileItem> items = fileUpload.parseRequest(req);
            // 迭代请求
            Iterator<FileItem> iter = items.iterator();
            while (iter.hasNext()) {
                FileItem item = iter.next();
                if (item.isFormField()) {//判断fileItem是否是普通表单元素

                    String name = item.getFieldName();//表单元素的nanme属性
                    String value = item.getString("UTF-8");//表单元素的值
                } else {//对文件上传的控件的处理
                    String fieldName = item.getFieldName();//文件上传的表单元素的name属性
                    String fileName = item.getName();//要上传的文件的名称
                    String contentType = item.getContentType();//文件的类型

                    boolean isInMemory = item.isInMemory();
                    long sizeInBytes = item.getSize();
//                    String uploadPath = this.getServletContext().getRealPath("resources/");//设置上传的绝对路径 将上传的文件按日期分类存放
                    String uploadPath = "src/main/resources/";//设置上传的绝对路径 将上传的文件按日期分类存放

                    File dis = new File(uploadPath);
                    System.out.println(dis);
                    if(!dis.exists()){//如果目录不存在 则创建
                        dis.mkdirs();
                    }
                    String  newName =  UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf("."));
                    File uploadedFile = new File(dis,fileName);
//                    File uploadedFile = new File("E://upload",fileName);
                  item.write(uploadedFile);
                  uploaderService.insertInto( 1,1,fileName );
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher( "show.jsp" ).forward( req,resp );
    }
}
