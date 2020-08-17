package com.matrix.todo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

class TextNoise {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNum = random.nextInt(5);
        char noise = '#';
        String str = "123456";
//        String res = "";
        char[] chars = str.toCharArray();
        System.out.println("随机数为:" + randomNum);
        System.out.println(chars);
        for (int i = 0; i < chars.length; i++) {
            if(i == randomNum){
                chars[i] = noise;
            }
        }

        System.out.println(chars);


//        String res = Arrays.toString(chars);


//        System.out.println(i);

//        generateFile("123");
    }

    /**
     * 写入TXT文件
     */
    public static void generateFile(String str) {
        try {
            File writeName = new File("generate.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write(str);
                out.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
