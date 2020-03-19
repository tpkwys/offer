package com.tpk.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: offer
 * @description: 字符串替换
 * @author: tianpanke
 * @create: 2020-03-19
 **/
public class StringReplaceDemo {
    /**
     请实现一个函数，将一个字符串中的每个空格替换成“%20”。
     例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
     */

    // 本以为只要简单的把字符串按‘ ’分割，再以‘%20’拼接，便可顺利通过测试，但是其实这种解决方案无法处理首尾有空格
    // 的案例。所以只能通过一个字符一个字符判断和转换；另外解决方案就是String.replaceAll(卧槽！)；还有正则
    public static void main(String[] args) {
        StringReplaceDemo demo=new StringReplaceDemo();
        System.out.println(demo.replaceSpace(new StringBuffer("helloworld ")));
        System.out.println(demo.replaceSpace1(new StringBuffer("helloworld ")));
        System.out.println(demo.replaceSpace2(new StringBuffer("helloworld ")));
    }
    public String replaceSpace(StringBuffer str) {
        if(str==null){
            return null;
        }
        //java8优雅字符串拼接
        //return Arrays.stream(str.split(" ")).collect(Collectors.joining("%20"))；

//        String [] array=str.toString().split(" ");
//        StringBuffer sb=new StringBuffer();
//        for(int i=0;i<array.length;i++){
//            sb.append(array[i]);
//            if(i!=array.length-1){
//                sb.append("%20");
//            }
//        }
        char [] array=str.toString().toCharArray();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<array.length;i++){
            if(array[i]==' '){
                sb.append("%20");
            }else{
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
    public String replaceSpace1(StringBuffer str){
        if(str==null){
            return null;
        }
        return str.toString().replaceAll(" ","%20");
    }

    public String replaceSpace2(StringBuffer str){
        String space=" ";
        if(str==null) {
            return null;
        }
        Pattern p = Pattern.compile(space);
        Matcher m = p.matcher(str.toString());
        String result = m.replaceAll("%20");

        return result;
    }
}
