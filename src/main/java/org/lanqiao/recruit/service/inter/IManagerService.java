package org.lanqiao.recruit.service.inter;

import org.lanqiao.recruit.domain.ManagerUser;

import java.util.List;

public interface IManagerService {
    //获取管理员用户信息
    public ManagerUser getImforFromDao(String username,String password);

    //获取用户信息
    public List getImforUser(String userKind);

    //删除用户信息
    public void deleteImfor(String userKind,int id);

    //根据用户名查找用户信息
    public List findImforUser(String userKind,String username);

    //统计用户数量
    public int countNumOfUser(String userKind);

    //批量删除用户信息
    public void deleteAll(String userKind,int a[]);

    //分页查询
    public List getPageImfor(String userKind,int startIndex,int pageSize);
}
