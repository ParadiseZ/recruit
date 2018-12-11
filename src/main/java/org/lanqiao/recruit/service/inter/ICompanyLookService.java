package org.lanqiao.recruit.service.inter;

import org.lanqiao.recruit.domain.Company_profile;

import java.sql.SQLException;
import java.util.List;

public interface ICompanyLookService {
    public List<Company_profile> selectAll() throws SQLException;
}
