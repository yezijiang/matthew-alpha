package com.matthew.javabase.io.lineCount;

import java.io.*;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-12-29 10:55
 */
public class CodeStatistics {
    //总的有效代码行数
    private static int codeLineCount = 0;
    //java源文件数
    private static int fileCount = 0;

    public static void main(String[] args) {
        String filePath ="";

        String msg = "文件数量：" + fileCount + "\n代码行数：" + codeLineCount +
                "\n-------------------------------------\n作者：哈松儿";
        javax.swing.JOptionPane.showMessageDialog(null, msg);
    }

    /**
     * 统计java源文件数和有效代码行数
     * @param file
     */
    public static void statistics(File file) {
        if(file.isFile()) {
            codeLineCount += count(file);
            fileCount++;
        } else {
            File[] filenames = file.listFiles(new FileName());
            if(filenames != null) {
                for (File f : filenames) {
                    statistics(f);
                }
            }
        }
    }

    /*
     * 统计file文件的有效代码行数：剔除空行和注释
     */
    private static int count(File file) {
        BufferedReader br = null;
        //有效代码计数器
        int count = 0;
        try {
            try {
                br = new BufferedReader(new FileReader(file));
                String line = "";
                while((line = br.readLine()) != null) {
                    //按照编码规范剔除空行和注释行
//                    if (!line.trim().equals("")) {
//                        if(!line.trim().startsWith("/**") && !line.trim().startsWith("*") && !line.trim().startsWith("*/") &&  !line.trim().startsWith("//")) {
                            count++;
//                        }
//                    }
                }

            } finally {
                if(br != null)
                    br.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return count;

    }

}
