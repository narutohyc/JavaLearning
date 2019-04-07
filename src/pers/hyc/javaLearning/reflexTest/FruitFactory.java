package pers.hyc.javaLearning.reflexTest;

class FruitFactory {
    public static Fruit getInstance(String ClassName) {
        Fruit fruit = null;
        try {
            fruit = (Fruit) Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fruit;
    }
}