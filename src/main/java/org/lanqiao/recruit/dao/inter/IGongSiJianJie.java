package org.lanqiao.recruit.dao.inter;

import org.lanqiao.recruit.domain.GongSiJianJie;

import java.sql.SQLException;

public interface IGongSiJianJie {
    //从前端添加数据到数据库
    public Integer addData(GongSiJianJie gongSiJianJie) throws SQLException;
    //通过titlecon搜索刚创建的数据
    public GongSiJianJie selectByTitlecon(String titlecon) throws SQLException;
}
