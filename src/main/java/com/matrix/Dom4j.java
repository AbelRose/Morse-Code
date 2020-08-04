package com.matrix;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * Dom4j解析xml
 *
 * @Author: AbelRose
 * @Date: 2020/7/29 20:39
 */
public class Dom4j {
//    String input = "";
    public static String parse(String input) throws Exception {
        //1.创建Reader对象
        SAXReader reader = new SAXReader();
        //2.加载xml
        String path = "src/main/resources/morse-code.xml";
        Document document = reader.read(new File(path));
        //3.获取根节点
        Element rootElement = document.getRootElement();
//        System.out.println("====== 根节点为: " + rootElement.getQualifiedName() + " ======");
        Iterator iterator = rootElement.elementIterator();

        // convert one two three to 1 2 3
        switch (input){
            case "0":
                input = "zero";
                break;
            case "1":
                input = "one";
                break;
            case "2":
                input = "two";
                break;
            case "3":
                input = "three";
                break;
            case "4":
                input = "four";
                break;
            case "5":
                input = "five";
                break;
            case "6":
                input = "six";
                break;
            case "7":
                input = "seven";
                break;
            case "8":
                input = "eight";
                break;
            case "9":
                input = "nine";
                break;
            case " ":
                input = "|";
                break;
                default:
                    // has problem !!!
//                    System.out.println("defalut");
                    break;
        }

        while (iterator.hasNext()){
            Element node = (Element) iterator.next();
//            List<Attribute> attributes = node.attributes();
//            System.out.println("======获取属性值======");
//            for (Attribute attribute : attributes) {
//                System.out.println(attribute.getValue());
//            }
//            System.out.println("====== 遍历节点: "+ node.getQualifiedName() +" ======");
            Iterator sub_iterator = node.elementIterator();
            while (sub_iterator.hasNext()){
                Element nodeChild = (Element) sub_iterator.next();
                String qualifiedName = nodeChild.getQualifiedName();
//                System.out.println(nodeChild.getName());
//                System.out.println(nodeChild.getStringValue());
                if(input.equals(qualifiedName)){
//                    System.out.println(nodeChild.getName());
//                    System.out.println(nodeChild.getStringValue());
                    return nodeChild.getStringValue();
                }
//                System.out.println("节点名：" + nodeChild.getName());
//                System.out.println("节点值：" + nodeChild.getStringValue());
//                return nodeChild.getStringValue();
            }
        }
        return "Not Morse Code";
    }
}
