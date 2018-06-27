package com.matthew.changpu.dao;

import com.matthew.changpu.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-02-28 17:45
 */
@Repository//通过spring注解定义一个DAO
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int getMatchCount(String userName,String password){
        String sqlStr="SELECT COUNT(user_id) countNum FROM t_wine_user WHERE " +
                "user_name=? AND PASSWORD=?";
        Map rtmap= jdbcTemplate.queryForMap(sqlStr,new Object[]{userName,password});
        return Integer.parseInt(rtmap.get("countNum").toString());
    }
    public User findUserByUserName(String userName){
        String sqlStr="SELECT user_id,user_name,credits FROM t_wine_user WHERE user_name=?";
        final User user = new User();
        jdbcTemplate.query(sqlStr, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
                user.setUserId(rs.getInt("user_id"));
                user.setUserName(rs.getString("user_name"));
                user.setCredits(rs.getInt("credits"));
            }
        });
        return user;
    }
    public void updateLoginInfo(User user){
        String sqlStr="UPDATE t_wine_user SET last_visit=?,last_ip=?,credits=? " +
                "WHERE user_id =?";
        jdbcTemplate.update(sqlStr,new Object[]{user.getLastVisit(),user.getLastIp(),user.getCredits(),user.getUserId()});
    }
}
