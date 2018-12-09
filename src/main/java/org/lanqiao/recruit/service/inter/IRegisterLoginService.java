package org.lanqiao.recruit.service.inter;

import org.lanqiao.recruit.domain.CompanyUser;

import java.util.Map;

public interface IRegisterLoginService {
    //添加企业用户到数据库
    public void addCuser(CompanyUser companyUser);

    //修改企业用户信息
    public void updateCuser(CompanyUser companyUser);

    //检查用户名是否存在
    public boolean checkImfor(String username);

    //用户名登录
    public Map usernameLogin(String username, String password);

    //邮箱登录
    public Map emailLogin(String email,String password);
}
