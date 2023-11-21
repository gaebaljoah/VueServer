package com.lime.framework.common;


import com.lime.framework.common.encrypt.AES256;
import com.lime.framework.common.encrypt.EncryptField;
import com.lime.framework.common.encrypt.SHA512;

import java.lang.reflect.InvocationTargetException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CommonUtils {
    /* 시퀀스로 다음 코드 생성 */
    public static String getNextCode(String seq){
        if(seq == null){
            seq = "0";
        }
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyMMdd"));
        seq = "0".repeat((6 - String.valueOf(Integer.parseInt(seq) + 1).length())) + (Integer.parseInt(seq) + 1);
        String code = now + seq;
        return code;
    }

    public static Map makeResult(List list, int listCnt){
        Map result = new HashMap();
        result.put("list", list);
        result.put("listCnt", listCnt);
        return result;
    }

    public static Map makeResult(Object data){
        Map result = new HashMap();
        result.put("data", data);
        return result;
    }

    public static Map makeResult(Object data, List list, int listCnt){
        Map result = new HashMap();
        result.put("data", data);
        result.put("list", list);
        result.put("listCnt", listCnt);
        return result;
    }

    public static Map makeResult(List list){
        Map result = new HashMap();
        result.put("list", list);
        result.put("listCnt", list.size());
        return result;
    }

//    public static <T> void setUserInfo(UserDto user, T object) {
//        try {
//            object.getClass()
//                  .getMethod("setRegUser", String.class)
//                  .invoke(object, user.getUserId());
//            object.getClass()
//                  .getMethod("setModUser", String.class)
//                  .invoke(object, user.getUserId());
//        }catch (NoSuchMethodException | InvocationTargetException |IllegalAccessException e) {
//            e.printStackTrace();
//        }
//    }

    public static <T> void encrypt(T object) {
        Iterator itor =  Arrays.stream(EncryptField.SHA512.values()).iterator();
        while(itor.hasNext()){
            String key = itor.next().toString();
            try {
                String val = SHA512.encodeSha512(String.valueOf(object.getClass().getMethod("get"+key).invoke(object)));
                object.getClass().getMethod("set"+key, String.class).invoke(object, val);
            }catch (NoSuchMethodException | InvocationTargetException |IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        itor =  Arrays.stream(EncryptField.AES256.values()).iterator();
        while(itor.hasNext()){
            String key = itor.next().toString();
            try {
                String val = AES256.encrypt(String.valueOf(object.getClass().getMethod("get"+key).invoke(object)));
                object.getClass().getMethod("set"+key, String.class).invoke(object, val);
            }catch (NoSuchMethodException | InvocationTargetException |IllegalAccessException e) {
//                e.printStackTrace();
            } catch (Exception e) {
//                throw new RuntimeException(e);
            }
        }
    }

    public static <T> void decrypt(T object) {
        Iterator itor =  Arrays.stream(EncryptField.AES256.values()).iterator();
        while(itor.hasNext()){
            String key = itor.next().toString();
            try {
                String val = AES256.decrypt(String.valueOf(object.getClass().getMethod("get"+key).invoke(object)));
                object.getClass().getMethod("set"+key, String.class).invoke(object, val);
            }catch (NoSuchMethodException | InvocationTargetException |IllegalAccessException e) {
//                e.printStackTrace();
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
    }

}