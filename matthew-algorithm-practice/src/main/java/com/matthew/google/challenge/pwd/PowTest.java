package com.matthew.google.challenge.pwd;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author : matthew
 * @description :
 * @date : 2020/11/3 3:27 下午
 **/
public class PowTest {
    public static void main(String[] args) {
        String baseString = "transfar56";
        int nonce = 10000;

        while (nonce>0){
            String targetString = baseString +nonce;
            String powHash = getSHA256StrJava(targetString);
            if(powHash.startsWith("0000")){
                System.out.println(powHash);
                break;
            }
            nonce++;
        }
    }


    public static String getSHA256StrJava(String str) {

        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
