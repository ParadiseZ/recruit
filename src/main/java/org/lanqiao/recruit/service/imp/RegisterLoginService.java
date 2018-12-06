package org.lanqiao.recruit.service.imp;

import org.lanqiao.recruit.dao.imp.RegisterLoginDao;
import org.lanqiao.recruit.service.inter.IRegisterLoginService;

import java.sql.SQLException;
import java.util.Map;

public class RegisterLoginService implements IRegisterLoginService {
    RegisterLoginDao registerDao = new RegisterLoginDao();
    public void addCuser(String username,String password) {
        try {
            registerDao.addCuser(username,password);
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
}
