package pers.hyc.javaLearning.designPattern;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class GetProperties {
    public static Properties getPro() {
        Properties pro = new Properties();
        File f = new File(".\\src\\pers\\hyc\\javaLearning\\designPattern\\abstractFactory.properties");
        try {
            if (f.exists()) {        //属性文件中已存在
                pro.load(new FileInputStream(f));//读取属性
            } else {      //建立一个新的属性文件，同时设置好默认内容
                pro.setProperty("user", "pers.hyc.javaLearning.designPattern.MysqlUser");
                pro.setProperty("login", "pers.hyc.javaLearning.designPattern.MysqlLogin");
                pro.store(new FileOutputStream(f), "FACTORY CLASS");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pro;
    }
}
