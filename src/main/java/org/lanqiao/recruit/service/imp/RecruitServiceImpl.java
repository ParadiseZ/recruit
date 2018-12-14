package org.lanqiao.recruit.service.imp;




import org.lanqiao.recruit.dao.imp.RecruitDaoImpl;
import org.lanqiao.recruit.dao.inter.IRecruitDao;
import org.lanqiao.recruit.domain.Recruit;
import org.lanqiao.recruit.service.inter.IRecruitService;

import java.util.List;

public class RecruitServiceImpl implements IRecruitService {
    IRecruitDao recruitDao = new RecruitDaoImpl();
    @Override
    public List<Recruit> getRecruitList() {
        return recruitDao.getRecruitList();
    }

    @Override
    public void addRecruit(Recruit recruit) {
        recruitDao.addRecruit(recruit);
    }
}
