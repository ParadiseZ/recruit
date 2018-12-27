package org.lanqiao.recruit.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class JDBCUtils {
    static DataSource ds ;
    static {
        ds = new ComboPooledDataSource("mvcdemo");
    }
    public static DataSource getDataSource(){
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        Connection con = ds.getConnection();
        return con;
    }
    public static Connection getUpConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/recruit?useUnicode=true&characterEncoding=utf8&useSSL=false";
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,"root","root");
        return con;
    }
    public static void releaseSource(Connection con, Statement statement, ResultSet res){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(statement!=null){
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally {
                        if(res!=null){
                            try {
                                res.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
