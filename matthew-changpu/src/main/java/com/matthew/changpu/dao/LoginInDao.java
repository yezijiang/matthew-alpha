package com.matthew.changpu.dao;

import com.matthew.changpu.entity.Loginlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-03-01 17:05
 */
@Repository
public class LoginInDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(Loginlog loginlog){
        String sqlStr ="insert into t_wine_login_log(user_id,login_ip,login_datetime) values(?,?,now());";
        jdbcTemplate.update(sqlStr,new Object[]{loginlog.getUserId(),loginlog.getLoginIp()});
    }

}
