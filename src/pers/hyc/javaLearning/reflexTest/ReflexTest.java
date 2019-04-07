package pers.hyc.javaLearning.reflexTest;

import java.util.Properties;

/**
 * 反射机制+工厂模式 学习
 */
public class ReflexTest {
    public static void main(String args[]) {
        Properties pro = GetProperties.getPro();
        Fruit fruit = FruitFactory.getInstance(pro.getProperty("orange"));
        if (fruit != null) {
            fruit.eat();
        }
    }
}
