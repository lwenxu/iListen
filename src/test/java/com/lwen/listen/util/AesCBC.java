package com.lwen.listen.util;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesCBC {
    /*已确认
    * 加密用的Key 可以用26个字母和数字组成
    * 此处使用AES-128-CBC加密模式，key需要为16位。
    */
    private static String sKey = "1234567890123456";
    private static String ivParameter = "1234567890123456";
    private static AesCBC instance = null;

    //private static
    private AesCBC() {

    }

    public static AesCBC getInstance() {
        if (instance == null)
            instance = new AesCBC();
        return instance;
    }

    // 加密
    public String encrypt(String sSrc, String encodingFormat, String sKey, String ivParameter) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        byte[] raw = sKey.getBytes();
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec iv = new IvParameterSpec(ivParameter.getBytes());//使用CBC模式，需要一个向量iv，可增加加密算法的强度
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(encodingFormat));
        return new BASE64Encoder().encode(encrypted);//此处使用BASE64做转码。
    }
}