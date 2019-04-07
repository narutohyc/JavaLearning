package pers.hyc.javaLearning.designPattern;

import java.util.ArrayList;
import java.util.List;


/**
 * Aggregate聚集抽象类
 */
abstract class Aggregate {
    public abstract AbsIterator CreateIterator();
}

/**
 * Iterator迭代器抽象类
 */
abstract class AbsIterator {
    public abstract Object First();

    public abstract Object Next();

    public abstract boolean IsDone();

    public abstract Object CurrentItem();
}

/**
 * ConcreteIterator具体迭代器类，继承AbsIterator
 */
class ConcreteIterator extends AbsIterator {
    private ConcreteAggregate aggragate;
    private int current = 0;

    public ConcreteIterator(ConcreteAggregate aggragate) {
        this.aggragate = aggragate;
    }

    @Override
    public Object First() { //得到聚集的第一个对象
        return aggragate.getItems(0);
    }

    @Override
    public Object Next() { //得到聚集的下一个对象
        current++;
        if (current < aggragate.Count()) {
            return aggragate.getItems(current);
        }
        return null;
    }

    @Override
    public boolean IsDone() { //判断遍历是否到结尾
        return current >= aggragate.Count() ? true : false;
    }

    @Override
    public Object CurrentItem() { //返回遍历时的当前对象
        return aggragate.getItems(current);
    }
}

/**
 * ConcreteAggregate具体聚集类，继承Aggregate
 */
class ConcreteAggregate extends Aggregate {
    private List<Object> items = new ArrayList<>();

    @Override
    public AbsIterator CreateIterator() {
        return new ConcreteIterator(this);
    }

    public int Count() {
        return items.size(); //返回聚集总个数
    }

    public Object getItems(int index) {
        return items.get(index);
    }

    public void addItems(Object item) {
        items.add(item);
    }
}

/**
 * 迭代器模式应用的场景及意义
 * (1)访问一个聚合对象的内容而无需暴露它的内部表示
 * <p>
 * (2)支持对聚合对象的多种遍历
 * <p>
 * (3)为遍历不同的聚合结构提供一个统一的接口
 * <p>
 * 迭代器模式(Iterator)就是分离了集合对象的遍历行为，抽象出一个迭代器类来负责，这样不仅可以做到不暴露集合的内部结构，又可以让外部代码透明地访问内部的数据
 * <p>
 * 迭代器模式的优点有：
 * <p>
 * 简化了遍历方式，对于对象集合的遍历，还是比较麻烦的，对于数组或者有序列表，我们尚可以通过游标来取得，但用户需要在对集合了解很清楚的前提下，
 * 自行遍历对象，但是对于hash表来说，用户遍历起来就比较麻烦了。而引入了迭代器方法后，用户用起来就简单的多了。
 * 可以提供多种遍历方式，比如说对有序列表，我们可以根据需要提供正序遍历，倒序遍历两种迭代器，用户用起来只需要得到我们实现好的迭代器，就可以方便的对集合进行遍历了。
 * 封装性良好，用户只需要得到迭代器就可以遍历，而对于遍历算法则不用去关心。
 * 迭代器模式的缺点：
 * <p>
 * 对于比较简单的遍历（像数组或者有序列表），使用迭代器方式遍历较为繁琐，大家可能都有感觉，像ArrayList，我们宁可愿意使用for循环和get方法来遍历集合。
 */
public class Iterator {
    public static void main(String[] args) {
        ConcreteAggregate a = new ConcreteAggregate();
        a.addItems("小鸟");
        a.addItems("小菜");
        a.addItems("行李");
        a.addItems("老外");
        a.addItems("司机");
        a.addItems("售票员");

        AbsIterator iterator = new ConcreteIterator(a);
        while (!iterator.IsDone()) {
            System.out.println(iterator.CurrentItem() + " 请买票");
            iterator.Next();
        }
    }
}
