package org.lanqiao.recruit.dao.inter;

import java.sql.SQLException;

public interface IUploaderDao {
    //文件写入数据库
    public void insertInto(int id,int pid,String fileName) throws SQLException, ClassNotFoundException;

    //搜索简历
//    public selectRecruit(int id);
}
