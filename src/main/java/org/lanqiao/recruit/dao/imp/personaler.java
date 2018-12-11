package org.lanqiao.recruit.dao.imp;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.recruit.dao.inter.IPersonal;
import org.lanqiao.recruit.domain.person_domain;
import org.lanqiao.recruit.utils.JDBCUtils;
import java.sql.SQLException;
import java.util.List;
public class personaler implements IPersonal {
    @Override
    public void addPuser(String pname, String password) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into person(pname,password) value(?,?)";
        qr.update(sql,pname,password);
    }
    //根据用boss页面传过来的id查询数据库信息
    public person_domain personalmessage(int pid) throws  SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
       String sql = "select * from person where pid=?";
      List<person_domain> personlist = qr.query(sql,new BeanListHandler<>(person_domain.class  ),pid);
        person_domain result = null;
      for(person_domain ps:personlist){
          result = ps;
      }
        return result;
    }
//将注册并完善的信息保存到数据库
    @Override
    public void instermessage(person_domain personDomain) throws SQLException {
        String sql = "INSERT INTO person(phone,password,pname,psex,pborn,ptime,pstate,pschool,pmajor,pexjob,psrecord,psal,padvantage,pemail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        QueryRunner qr = new QueryRunner( JDBCUtils.getDataSource() );
        qr.update( sql, personDomain.getPhone(), personDomain.getPassword(), personDomain.getPname(), personDomain.getPsex(), personDomain.getPborn(), personDomain.getPtime(), personDomain.getPstate(), personDomain.getPschool(), personDomain.getPmajor(), personDomain.getPexjob(), personDomain.getPsrecord(), personDomain.getPsal(), personDomain.getPadvantage(),personDomain.getPemail() );
   }

    @Override
    //判断该用户是否注册
    public boolean checkmessage(String pname, String password) throws SQLException {
        List<person_domain> person_domainList = null;
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        BeanListHandler<person_domain> person_domain = new BeanListHandler<>(person_domain.class);
        String sql = "select * from person where pname=?";
        person_domainList = queryRunner.query(sql,person_domain,pname);
        if (person_domainList.isEmpty()){
            return true;
        }else{
            return false;
        }

    }
    //修改个人信息
    @Override
    public boolean updateperson(person_domain personDomain) throws SQLException {
        String sql="update person set phone=?,pname=?,password=?,psex=?,pborn=?,ptime=?,pstate=?,pmajor=?,pexjob=?,pschool=?,psrecord=?,psal=?,padvantage=?,pemail=? where pid=?";
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());


        System.out.println(personDomain+"----personDomnai");
        qr.update( sql, personDomain.getPhone(),personDomain.getPname(),personDomain.getPassword(),personDomain.getPsex(),personDomain.getPborn(),personDomain.getPtime(),personDomain.getPstate(),personDomain.getPmajor(),personDomain.getPexjob(),personDomain.getPschool(),personDomain.getPsrecord(),personDomain.getPsal(),personDomain.getPadvantage(),personDomain.getPemail(),personDomain.getPid());
        return false;
    }

}
