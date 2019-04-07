package pers.hyc.javaLearning.designPattern;

/**
 * 球员
 */
abstract class Player {
    protected String name;

    public Player(String name) {
        this.name = name;
    }

    public abstract void attack();

    public abstract void defense();
}

/**
 * 前锋
 */
class Forwards extends Player {
    public Forwards(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("前锋 " + name + " 进攻");
    }

    @Override
    public void defense() {
        System.out.println("前锋 " + name + " 防守");
    }
}

/**
 * 中锋
 */
class Center extends Player {
    public Center(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("中锋 " + name + " 进攻");
    }

    @Override
    public void defense() {
        System.out.println("中锋 " + name + " 防守");
    }
}

/**
 * 后卫
 */
class Guards extends Player {
    public Guards(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("后卫 " + name + " 进攻");
    }

    @Override
    public void defense() {
        System.out.println("后卫 " + name + " 防守");
    }
}

/**
 * 中国中锋
 */
class ChinaCenter {
    private String name;

    public ChinaCenter(String name) {
        this.name = name;
    }

    public void jingong() {
        System.out.println("中锋 " + name + " 进攻");
    }

    public void fangshou() {
        System.out.println("中锋 " + name + " 防守");
    }
}

/**
 * 翻译者（适配器）
 */
class Translator extends Player {
    ChinaCenter center = null;

    public Translator(String name) {
        super(name);
        center = new ChinaCenter(name);
    }

    @Override
    public void attack() {
        center.jingong();
    }

    @Override
    public void defense() {
        center.fangshou();
    }
}

/**
 *    优点：
 *
 * 　　　　1：将目标类和适配者类解耦，通过引入一个适配器类来重用现有的适配者类，无需修改原有结构。
 *
 * 　　　　2：增加了类的透明性和复用性，将具体的业务实现过程封装在适配者类中，对于客户端类而言是透明的，而且提高了适配者的复用性，同一适配者类可以在多个不同的系统中复用。
 *
 * 　　　　3：灵活性和扩展性都非常好，通过使用配置文件，可以很方便的更换适配器，也可以在不修改原有代码的基础上 增加新的适配器，完全复合开闭原则。
 *
 * 　　缺点：
 *
 * 　　　　1：一次最多只能适配一个适配者类，不能同时适配多个适配者。
 *
 * 　　　　2：适配者类不能为最终类，在C#中不能为sealed类
 *
 * 　　　　3：目标抽象类只能为接口，不能为类，其使用有一定的局限性。
 */
public class Adapter {
    public static void main(String[] args) {
        Player b = new Forwards("巴蒂尔");
        b.attack();

        Player m = new Guards("麦克格雷迪");
        m.attack();

        Player ym = new Translator("姚明");
        ym.attack();
        ym.defense();
    }
}
