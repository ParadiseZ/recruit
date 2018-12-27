package org.lanqiao.recruit.dao.inter;

import java.sql.SQLException;

public interface IUploaderDao {
    //文件写入数据库
    public void insertInto(int id,String fileName) throws SQLException, ClassNotFoundException;
}
