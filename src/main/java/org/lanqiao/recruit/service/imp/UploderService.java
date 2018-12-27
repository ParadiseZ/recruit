package org.lanqiao.recruit.service.imp;

import org.lanqiao.recruit.dao.imp.UploaderDao;
import org.lanqiao.recruit.dao.inter.IUploaderDao;
import org.lanqiao.recruit.service.inter.IUploaderService;

import java.sql.SQLException;

public class UploderService implements IUploaderService {
    IUploaderDao uploaderDao = new UploaderDao();
    @Override
    public void insertInto(int id,int pid, String fileName) {
        try {
            uploaderDao.insertInto(id,fileName);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
