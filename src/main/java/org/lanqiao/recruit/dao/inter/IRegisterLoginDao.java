package org.lanqiao.recruit.dao.inter;

import org.lanqiao.recruit.domain.CompanyUser;

import java.sql.SQLException;

public interface IRegisterLoginDao {
    //添加企业用户到数据库
    public void addCuser(CompanyUser companyUser) throws SQLException;

    //修改企业用户信息
    public void modifyCuser(CompanyUser companyUser) throws SQLException;
}
