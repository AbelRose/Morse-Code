package com.matrix.hadoop;

import java.io.*;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.junit.Test;

public class FileUpload {

    private static String SOURCE_PATH = "D:\\IdeaProjects\\Morse-Code\\src\\main\\resources\\hadoop.txt";
    private static String DEST_PATH = "/home/sherlock/uploadfile/hadoop.txt";
    private static String MASTER_URI = "hdfs://192.168.217.137:9000";

    /**
     * 测试上传文件
     * 如果下述代码抛出异常：
     * org.apache.hadoop.security.AccessControlException: Permission denied: user=xxx, access=WRITE。
     * 则表明上传文件的用户没有权限。解决方式如下：
     * 1.配置环境变量HADOOP_USER_NAME， 并设置值为有访问hadoop集群有权限的用户，比如：hadoop。源码调试发现hadoop会首先从环境变量中去查找上传文件的用户名。查找不到会议pc的名字作为用户名。
     * 2.赋予hdfs上的文件夹/hbase/upload/读写权限。 命令是：hadoop fs -chmod 777  /hbase/upload。这样，可以保证上传文件到该目录成功，但上传到其他目录依然无权限。
     *
     * @throws Exception
     * @author lihong10 2017年12月9日 上午10:42:30
     */
    @Test
    public void testUpload() throws Exception {

        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(new URI(MASTER_URI), conf);
        InputStream in = new FileInputStream(SOURCE_PATH);
        OutputStream out = fs.create(new Path(DEST_PATH), new Progressable() {
            @Override
            public void progress() {
                System.out.println("上传完一个设定缓存区大小容量的文件！");
            }
        });
        IOUtils.copyBytes(in, out, conf);

      /*byte[] buffer = new byte[1024];
        int len = 0;
		while((len=in.read(buffer))>0){
			out.write(buffer, 0, len);
		}
		out.flush();
		in.close();
		out.close();*/
    }



    public static void cat(Configuration conf, String uri, String remoteFile) throws IOException {
        Path path = new Path(remoteFile);
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        FSDataInputStream fsdis = null;
        System.out.println("cat: " + remoteFile);
        try {
            fsdis = fs.open(path);
            IOUtils.copyBytes(fsdis, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(fsdis);
            fs.close();
        }
    }

    @Test
    public void testCat() throws IOException {
        //hbase/hbase.version 这个文件已经存在
        cat(new Configuration(), MASTER_URI, "/hbase/hbase.version");
    }

    /**
     * 查看目录下面的文件
     * @param conf
     * @param uri
     * @param folder
     * @throws IOException
     */
    public static void ls(Configuration conf, String uri, String folder) throws IOException {
        Path path = new Path(folder);
        FileSystem fs = FileSystem.get(URI.create(uri), conf);
        FileStatus[] list = fs.listStatus(path);
        System.out.println("ls: " + folder);
        System.out.println("==========================================================");
        for (FileStatus f : list) {
            System.out.printf("name: %s, folder: %s, size: %d\n", f.getPath(), f.isDirectory(), f.getLen());
        }
        System.out.println("==========================================================");
        fs.close();
    }

    @Test
    public void testLs() throws IOException {
        ls(new Configuration(), MASTER_URI, "/hbase/upload");
    }

}