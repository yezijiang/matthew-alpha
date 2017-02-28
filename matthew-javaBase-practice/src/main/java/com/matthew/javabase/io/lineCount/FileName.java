package com.matthew.javabase.io.lineCount;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-12-29 10:56
 */
public class FileName implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        File file = new File(dir, name);
        if(file.getName().toLowerCase().endsWith(".java")) {
            return true;
        }
        if(file.isDirectory()) {
            return true;
        }
        return false;
    }

}