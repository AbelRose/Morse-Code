package com.matrix;

import java.io.*;

/**
 * Created by Nickwong on 31/07/2018.
 * 根据1-8楼的建议，优化了代码
 */
public class ReadFile {
//    public static void main(String args[]) {
//        readFile();
//        writeFile();
//    }
    /**
     * 读入TXT文件
     */
    public static String readFile() {
        String pathname = "src/main/resources/test.txt"; // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
//                System.out.println(line);
                return line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "No File";
    }
    /**
     * 写入TXT文件
     */
    public static void writeFile(String str) {
        try {
            File writeName = new File("output.txt"); // 相对路径，如果没有则要建立一个新的output.txt文件
            writeName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            try (FileWriter writer = new FileWriter(writeName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                // 持续化输出
                out.write(str); // \r\n即为换行

                /**
                 * Todo
                 *
                 * 注意在写数据的时候:
                 *
                 * 是否写成功? 是否有损坏? 是否会被篡改?
                 *
                 */
//                    out.write("我会写入文件啦2\r\n"); // \r\n即为换行
                out.flush(); // 把缓存区内容压入文件
                }
//
            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
