package com.matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Dom4j dom4j = new Dom4j();
        ReadFile rf = new ReadFile();
        String input = "";
        String line = rf.readFile();
        System.out.println(line);
        String[] split = line.split(" ");
        for (int i = 0; i < split.length; i++) {
            input = split[i];

            System.out.println("=========="+input+"==========");

            char[] chs = input.toCharArray();

            System.out.println("----------" + Arrays.toString(chs) + "---------");

            for (int i1 = 0; i1 < chs.length; i1++) {
                String str = Character.toString(chs[i1]).toUpperCase();
                System.out.println(str);
                String res = dom4j.parse(str);
//            System.out.println(str);
                System.out.println(res);
            }


            /**
             *
             * TODO
             *
             * 1. split the " " and wirte the morse code to the file
             *
             * 2. investigate bug on switch statement default
             *
             *
             *
             *
             *
             *
             *
             */
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
