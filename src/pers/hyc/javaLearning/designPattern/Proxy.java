package pers.hyc.javaLearning.designPattern;

interface GiveGift {
    void giveDolls();

    void giveFlowers();
}

class SchoolGirl {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Pursuit implements GiveGift {
    private SchoolGirl mm;

    public Pursuit(SchoolGirl mm) {
        this.mm = mm;
    }

    public void giveDolls() {
        System.out.println(mm.getName() + " 送你洋娃娃");
    }

    public void giveFlowers() {
        System.out.println(mm.getName() + " 送你鲜花");
    }
}

class GiftProxy implements GiveGift {
    private Pursuit gg;

    public GiftProxy(SchoolGirl mm) {
        gg = new Pursuit(mm);
    }

    @Override
    public void giveDolls() {
        gg.giveDolls();
    }

    @Override
    public void giveFlowers() {
        gg.giveFlowers();
    }
}

/**
 * 代理模式按照使用目的可以分为以下几种：
 *
 * 远程（Remote）代理：为一个位于不同的地址空间的对象提供一个局域代表对象。这个不同的地址空间可以是本电脑中，也可以在另一台电脑中。最典型的例子就是——客户端调用Web服务或WCF服务。
 *
 * 虚拟（Virtual）代理：根据需要创建一个资源消耗较大的对象，使得对象只在需要时才会被真正创建。
 *
 * Copy-on-Write代理：虚拟代理的一种，把复制（或者叫克隆）拖延到只有在客户端需要时，才真正采取行动。
 *
 * 保护（Protect or Access）代理：控制一个对象的访问，可以给不同的用户提供不同级别的使用权限。
 *
 * 防火墙（Firewall）代理：保护目标不让恶意用户接近。
 *
 * 智能引用（Smart Reference）代理：当一个对象被引用时，提供一些额外的操作，比如将对此对象调用的次数记录下来等。
 *
 * Cache代理：为某一个目标操作的结果提供临时的存储空间，以便多个客户端可以这些结果。
 *
 * ===========================================================================
 *
 * 优点：
 *
 * 代理模式能够将调用用于真正被调用的对象隔离，在一定程度上降低了系统的耦合度；
 *
 * 代理对象在客户端和目标对象之间起到一个中介的作用，这样可以起到对目标对象的保护。代理对象可以在对目标对象发出请求之前进行一个额外的操作，例如权限检查等。
 *
 * 缺点：
 *
 * 由于在客户端和真实主题之间增加了一个代理对象，所以会造成请求的处理速度变慢
 *
 * 实现代理类也需要额外的工作，从而增加了系统的实现复杂度。
 */
public class Proxy {
    public static void main(String[] args) {
        SchoolGirl girl = new SchoolGirl();
        girl.setName("娇娇");
        GiftProxy proxy = new GiftProxy(girl);
        proxy.giveDolls();
        proxy.giveFlowers();
    }

}
