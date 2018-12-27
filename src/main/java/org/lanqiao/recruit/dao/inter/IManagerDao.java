package org.lanqiao.recruit.dao.inter;

import org.lanqiao.recruit.domain.ManagerUser;

import java.sql.SQLException;
import java.util.List;

public interface IManagerDao {
    //获取管理员用户信息
    public ManagerUser getImfor(String username,String password) throws SQLException;
    //获取用户信息
    public List getImforUser(String userKind) throws SQLException;
    //删除用户信息
    public void deleteImfor(String userKind,int id) throws SQLException;
    //查找根据用户名查找用户信息
    public List findImforUser(String userKind,String username) throws SQLException;
    //统计用户数量
    public int getCount(String userKind) throws SQLException;
    //批量删除用户信息
    public void deleteAll(String userKin,int a[]) throws SQLException;
    //分页查询
    public List getPageImfor(String userKind,int startIndex,int pageSize) throws SQLException;
}
