package com.matthew.lucune.test;

import org.apache.commons.io.FileUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.FSDirectory;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2017-08-10 16:52
 */
public class LuneceTestOne {
    @Test
    public void importIndex() throws IOException {

        //获得索引库
        Path path = Paths.get("F:\\yaoyaohao\\solr\\lunece6\\index_loc");
        //打开水印库
        FSDirectory dir = FSDirectory.open(path);
        //创建分词器
        Analyzer aly = new StandardAnalyzer();
        //创建索引的写入配置对象
        IndexWriterConfig  iwc = new IndexWriterConfig(aly);
        //创建索引的Writer
        IndexWriter iw = new IndexWriter(dir,iwc);


        //采集原始文档
        File sourceFiles = new File("F:\\yaoyaohao\\solr\\lunece6\\sourcefiles");
        //获得文件夹下面的所有文件
        File[] files = sourceFiles.listFiles();
        //遍历每一个文件
        for(File file:files){
            //获得file的信息
            String fileName = file.getName();
            String content = FileUtils.readFileToString(file);
            long size = FileUtils.sizeOf(file);
            String pathStr = file.getPath();

            Field fName= new TextField("fileName",fileName,Field.Store.YES);
            Field fContent = new TextField("content",content, Field.Store.YES);
            Field fSize = new StringField("size",Long.toString(size),Field.Store.YES);
            Field fPath = new TextField("pathStr",pathStr, Field.Store.YES);

            //创建文档对象
            Document doc = new Document();
            doc.add(fName);
            doc.add(fContent);
            doc.add(fSize);
            doc.add(fPath);

            //把文档写入索引库
            iw.addDocument(doc);
        }
        iw.commit();
        iw.close();
        //获得原始文档



    }

}
