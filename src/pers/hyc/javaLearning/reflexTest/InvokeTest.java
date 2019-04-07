package pers.hyc.javaLearning.reflexTest;

import java.lang.reflect.Method;
import java.util.Properties;

/**
 * invoke方法测试学习
 */
public class InvokeTest {
    public static void main(String[] args) throws Exception {
        Properties pro = GetProperties.getPro();
        String fruitClass = pro.getProperty("orange");
        Fruit fruit = FruitFactory.getInstance(fruitClass);

        String[] mds = {"wash", "eat"};
        for (String md : mds) {
            Method setPriceMethod = Class.forName(fruitClass).getMethod(md);
            setPriceMethod.invoke(fruit);
        }
    }
}
