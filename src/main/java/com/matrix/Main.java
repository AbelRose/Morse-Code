package com.matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
//        Dom4j dom4j = new Dom4j();
//        ReadFile rf = new ReadFile();
        String input = "";
        String line = ReadFile.readFile(); //String line = rf.readFile();
//      1 a B       System.out.println(line);
        String[] split = line.split(" ");
        StringBuilder output = new StringBuilder();
        for (String s : split) { // for (int i = 0; i < split.length; i++)
            input = s;
//      ==========1==========   System.out.println("=========="+input+"==========");
            char[] chs = input.toCharArray();
//      ----------[1]---------  System.out.println("----------" + Arrays.toString(chs) + "---------");
            for (char ch : chs) { // for (int i1 = 0; i1 < chs.length; i1++) {
                String str = Character.toString(ch).toUpperCase();
//      1                System.out.println(str);
                String res = Dom4j.parse(str); // String res = dom4j.parse(str);
                output.append(res).append(" | "); // output += res + " | ";
//                rf.writeFile(res);
//      1            System.out.println(str);
//      ．━ ━ ━ ━    System.out.println(res);
//      ．━
//      ━ ．．．
            }
            ReadFile.writeFile(output.substring(0, output.length() - 3)); // 去掉最后的 " | " 字符 总共三个
//            rf.writeFile(" | ");
//            System.out.println(" | "); // 作为空格的分割
        }
//        Scanner sc = new Scanner(System.in);
//        String input = sc.next();
//        System.out.println(input);
//        if(input == code){
//            System.out.println(); // getValue
//        }else {
//            System.out.println("Illegal Input !");
//        }
    }
}
