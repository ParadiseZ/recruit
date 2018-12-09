package org.lanqiao.recruit.service.imp;

import org.lanqiao.recruit.dao.imp.RegisterLoginDao;
import org.lanqiao.recruit.domain.CompanyUser;
import org.lanqiao.recruit.service.inter.IRegisterLoginService;

import java.sql.SQLException;
import java.util.Map;

public class RegisterLoginService implements IRegisterLoginService {
    RegisterLoginDao registerDao = new RegisterLoginDao();
    public void addCuser(CompanyUser companyUser) {
        try {
            registerDao.addCuser(companyUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCuser(CompanyUser companyUser) {
        try {
            registerDao.modifyCuser(companyUser);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //用户名登录
    public Map usernameLogin(String username,String password){
        Map resultMap = null;
        try {
            resultMap = registerDao.usernameLogin(username,password);
        } catch (SQLException e) {
            resultMap.put(3,0);
        }
        return resultMap;
    }

    //邮箱登录
    public Map emailLogin(String email,String password){
        Map resultMap = null;
        try {
            resultMap = registerDao.emailLogin(email,password);
        } catch (SQLException e) {
            resultMap.put(3,0);
        }
        return resultMap;
    }

    //检查用户名是否存在
    public boolean checkImfor(String username){
        boolean checkResult = false;
        try {
            checkResult = registerDao.checkImfor(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return checkResult;
    }
}
