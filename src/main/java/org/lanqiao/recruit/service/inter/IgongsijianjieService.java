package org.lanqiao.recruit.service.inter;

import org.lanqiao.recruit.dao.imp.GongSiJianJieDao;
import org.lanqiao.recruit.domain.GongSiJianJie;

import java.sql.SQLException;

public interface IgongsijianjieService {
    //添加
    public Integer addGongsijianjie(GongSiJianJie gongSiJianJie) throws SQLException;
    //通过titlecon搜索当前数据
    public GongSiJianJie selectByTitlecon(String titlecon) throws SQLException;
}
