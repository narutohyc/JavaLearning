package pers.hyc.javaLearning.reflexTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class GetProperties {
    public static Properties getPro() {
        Properties pro = new Properties();
        File f = new File(".\\src\\pers\\hyc\\javaLearning\\reflexTest\\fruit.properties");
        try {
            if (f.exists()) {        //属性文件中已存在
                pro.load(new FileInputStream(f));//读取属性
            } else {      //建立一个新的属性文件，同时设置好默认内容
                pro.setProperty("apple", "pers.hyc.javaLearning.reflexTest.Apple");
                pro.setProperty("orange", "pers.hyc.javaLearning.reflexTest.Orange");
                pro.store(new FileOutputStream(f), "FRUIT CLASS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pro;
    }
}
