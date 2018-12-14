package org.lanqiao.recruit.dao.inter;


import org.lanqiao.recruit.domain.Recruit;

import java.util.List;

public interface IRecruitDao {
    //获取招聘信息列表
    public List<Recruit> getRecruitList();
    public void addRecruit(Recruit recruit);
}
