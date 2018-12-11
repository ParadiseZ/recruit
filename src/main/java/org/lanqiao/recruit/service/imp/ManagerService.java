package org.lanqiao.recruit.service.imp;

import org.lanqiao.recruit.dao.imp.ManagerDao;
import org.lanqiao.recruit.dao.inter.IManagerDao;
import org.lanqiao.recruit.domain.ManagerUser;
import org.lanqiao.recruit.service.inter.IManagerService;

import java.sql.SQLException;
import java.util.List;

public class ManagerService implements IManagerService {
    IManagerDao managerDao = new ManagerDao();
    @Override
    public ManagerUser getImforFromDao(String username,String password) {
        ManagerUser mm = null;
        try {
            mm = managerDao.getImfor(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mm;
    }

    @Override
    public List getImforUser(String userKind) {
        List resultList = null;
        try {
            resultList = managerDao.getImforUser(userKind);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultList;
    }

    @Override
    public void deleteImfor(String userKind, int id) {
        try {
            managerDao.deleteImfor(userKind,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List findImforUser(String userKind, String username) {
        List resultFind = null;
        try {
            resultFind = managerDao.findImforUser(userKind,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultFind;
    }

    @Override
    public int countNumOfUser(String userKind) {
        int num = 0;
        try {
            num = managerDao.getCount(userKind);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
