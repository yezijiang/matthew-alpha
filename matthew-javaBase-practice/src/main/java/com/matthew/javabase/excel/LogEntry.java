package com.matthew.javabase.excel;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author : matthew
 * @description :
 * @date : 2023/5/29 10:30 AM
 **/
@Setter
@Getter
public class LogEntry {
    private Date time;
    private String user;
    private double queryTime;
    private double LockTime;
    private double RowsSent;
    private double RowsExamined;
    private StringBuffer sql;
}
