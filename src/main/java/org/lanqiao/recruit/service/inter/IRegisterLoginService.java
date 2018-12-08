package org.lanqiao.recruit.service.inter;

import org.lanqiao.recruit.domain.CompanyUser;

public interface IRegisterLoginService {
    //添加企业用户到数据库
    public void addCuser(CompanyUser companyUser);
}
