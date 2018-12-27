package org.lanqiao.recruit.dao.imp;

import org.lanqiao.recruit.dao.inter.IUploaderDao;
import org.lanqiao.recruit.utils.JDBCUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UploaderDao implements IUploaderDao {
    @Override
    public void insertInto(int id,int pid,String fileName) throws SQLException, ClassNotFoundException {
        Connection conn = JDBCUtils.getUpConnection();
        String sql = "insert into upload values(?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        InputStream in = UploaderDao.class.getClassLoader().getResourceAsStream(fileName);
        pst.setInt(1,id);
        pst.setInt(2,pid);
        pst.setAsciiStream(3,in);
        pst.executeUpdate();
        JDBCUtils.releaseSource(conn,pst,null);
    }
}
