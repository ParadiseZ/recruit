package org.lanqiao.recruit.service.imp;

import org.lanqiao.recruit.dao.imp.Register;
import org.lanqiao.recruit.service.inter.IRegisterService;

import java.sql.SQLException;

public class RegisterService implements IRegisterService {
    Register registerDao = new Register();
    public void addCuser(String username,String password) {
        try {
            registerDao.addCuser(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
