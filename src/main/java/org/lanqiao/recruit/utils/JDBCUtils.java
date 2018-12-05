package org.lanqiao.recruit.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    private static DataSource ds ;
    private static Connection con;
    public static DataSource getDataSource(){
        ds = new ComboPooledDataSource("mvcdemo");
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        con = ds.getConnection();
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
