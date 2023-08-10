package com.matthew.javabase.excel;


import com.alibaba.excel.EasyExcel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : matthew
 * @description :
 * @date : 2023/5/29 10:28 AM
 **/
public class LogParser {
    public static void main(String[] args) {
        String filePath = "/Users/matthew/Downloads/atms_slowsql.txt";
        String excelFilePath = "/Users/matthew/Downloads/atms_slowsql.xlsx";

        try {
            writeExcel(filePath,excelFilePath);
            System.out.println("Log parsing and Excel export completed successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static List<LogEntry> parseLogFile(String filePath) throws IOException {
        List<LogEntry> logEntries = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            LogEntry logEntry = new LogEntry();

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("# Time:")) {
                    if(logEntry.getSql() != null){
                        logEntries.add(logEntry);
                        logEntry = new LogEntry();
                    }
                    logEntry.setTime(transferDate(line.substring(8).trim()));

                } else if (line.startsWith("# User@Host:")) {
                    String endStr = line.substring(13).trim();
                    logEntry.setUser(endStr.substring(0, endStr.indexOf("@")).trim());
                } else if (line.startsWith("# Query_time:")) {
                    logEntry.setQueryTime(Double.parseDouble(line.substring(14, line.indexOf("Lock_time")).trim()));
                    logEntry.setLockTime(Double.parseDouble(line.substring(line.indexOf("Lock_time")+10, line.indexOf("Rows_sent")).trim()));
                    logEntry.setRowsSent(Double.parseDouble(line.substring(line.indexOf("Rows_sent")+10, line.indexOf("Rows_examined")).trim()));
                    logEntry.setRowsExamined(Double.parseDouble(line.substring(line.indexOf("Rows_examined")+14, line.indexOf("Thread_id")).trim()));
                    // Add more logic to parse other fields as needed
                } else if (line.startsWith("# QC_Hit:")) {
                } else if (line.startsWith("SET timestamp=")) {
                }else{
                    if(logEntry.getSql() == null){
                        logEntry.setSql(new StringBuffer(line));
                    }else {
                        logEntry.setSql(logEntry.getSql().append(line));
                    }
                }
            }
        }

        return logEntries;
    }

    private static void writeExcel(String filePath,String excelFilePath) throws IOException {
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(excelFilePath, LogEntry.class)
                .sheet("模板")
                .doWrite(parseLogFile(filePath));
    }

    public static Date transferDate(String dateTimeString) {
        // 解析字符串为 LocalDateTime 对象
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        // 转换为带时区的 ZonedDateTime 对象
        ZonedDateTime zonedDateTime = localDateTime.atZone(java.time.ZoneId.systemDefault());
        // 转换为 Date 对象
        Date date = Date.from(zonedDateTime.toInstant());
        return date;
    }
}
