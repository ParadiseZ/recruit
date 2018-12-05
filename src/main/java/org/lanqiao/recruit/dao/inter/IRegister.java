package org.lanqiao.recruit.dao.inter;

public interface IRegister {
    //添加企业用户到数据库
    public void addCuser(String username,String password,String userKind);
}
