package pers.hyc.javaLearning.designPattern;

interface Person {
    void Show();
}

/**
 * 创建实现了 Person 接口的抽象装饰类
 */
class Finery implements Person {
    protected Person component;

    public void Decorate(Person component) {
        this.component = component;
    }

    @Override
    public void Show() {
        if (component != null) {
            component.Show();
        }
    }
}

/**
 * 创建扩展了 Finery 类的实体装饰类
 */
class TShirts extends Finery {
    @Override
    public void Show() {
        System.out.println("大T恤");
        super.Show();
    }
}

class BigTrouser extends Finery {
    @Override
    public void Show() {
        System.out.println("垮裤");
        super.Show();
    }
}

class Sneaker extends Finery {
    @Override
    public void Show() {
        System.out.println("破球鞋");
        super.Show();
    }
}

class Suit extends Finery {
    @Override
    public void Show() {
        System.out.println("西装");
        super.Show();
    }
}

class LeatherShoes extends Finery {
    @Override
    public void Show() {
        System.out.println("皮鞋");
        super.Show();
    }
}

class Tie extends Finery {
    @Override
    public void Show() {
        System.out.println("领带");
        super.Show();
    }
}

/**
 * 适用场景：
 *
 * 扩展一个类的功能。
 * 动态增加功能，动态撤销。
 * 优缺点：
 *
 * 优点：
 *
 * 装饰类和被装饰类可以独立发展，不会相互耦合
 * 动态的将责任附加到对象身上。
 * 缺点：
 *
 * 多层装饰比较复杂。
 *
 * https://www.cnblogs.com/shenbo-/p/9074032.html
 */
public class Decorator {
    public static void main(String[] args) {
        Person xc = new Finery();

        System.out.println("第一种装扮");
        Sneaker pqx = new Sneaker();
        BigTrouser kk = new BigTrouser();
        TShirts dtx = new TShirts();
        pqx.Decorate(xc);//先给xc这个人穿上pqx
        kk.Decorate(pqx);//再给穿着pqx的xc穿上kk
        dtx.Decorate(kk);//再给穿着pqx和kk的xc穿上dtx
        dtx.Show();//最后将穿着pqx kk和 dtx的xc 显示出来

        System.out.println("\n第二种装扮");
        LeatherShoes px = new LeatherShoes();
        Tie id = new Tie();
        Suit xz = new Suit();
        px.Decorate(xc);
        id.Decorate(px);
        xz.Decorate(id);
        xz.Show();
    }
}
