package com.matthew.javabase.rpc.nio;

import javax.naming.event.ObjectChangeListener;
import java.io.*;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-11-07 16:48
 */
public class SerializableUtil {
    public static byte[] serialize(Object object){
        byte[] result = null;
        if(object == null){
            return new byte[0];
        }
        ByteArrayOutputStream byteStream = null;
        ObjectOutputStream objectStream = null;
        if(!(object instanceof Serializable)){
            throw new IllegalArgumentException("SerializableUtil.rerialize(Objcet) requires a Serializable payload"
            +"but received an object of ("+object.getClass().getName()+")");
        }

        try {
            byteStream = new ByteArrayOutputStream(128);
            objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(object);
            objectStream.flush();
            result = byteStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                objectStream.close();
                objectStream = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                byteStream.close();
                byteStream = null;
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }
    /**
     * 反序列操作
     *
     * @param bytes
     * @return
     */
    public static Object deserialize(byte[] bytes) {
        Object result = null;
        if(bytes == null || bytes.length == 0)
            return null;
        ByteArrayInputStream byteStream = null;
        ObjectInputStream objectStream = null;
        try{
            byteStream = new ByteArrayInputStream(bytes);
            objectStream = new ObjectInputStream(byteStream);
            result = objectStream.readObject();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                objectStream.close();
                objectStream = null;
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                byteStream.close();
                byteStream = null;
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
