package pers.hyc.javaLearning.designPattern;

abstract class Operation {
    protected double _numberA = 0;
    protected double _numberB = 0;

    public abstract double GetResult();
}

class OperationAdd extends Operation {
    @Override
    public double GetResult() {
        double result = 0;
        result = _numberA + _numberB;
        return result;
    }
}


class OperationSub extends Operation {
    @Override
    public double GetResult() {
        double result = 0;
        result = _numberA - _numberB;
        return result;
    }
}


class OperationMul extends Operation {
    @Override
    public double GetResult() {
        double result = 0;
        result = _numberA * _numberB;
        return result;
    }
}


class OperationDiv extends Operation {
    @Override
    public double GetResult() {
        double result = 0;
        if (_numberB == 0) {
            try {
                throw new Exception("除数不能为0.");
            } catch (Exception e) {
            }
        }
        result = _numberA / _numberB;
        return result;
    }
}

/**
 * 模块清晰化，每个部分都各司其职，分工明确，代码就实现最渐层意义上的“可维护”啦。
 * 说到缺点，当我们需要增加一产品，比如在计算机中加入一个新的功能，可以求M的N次方，这样个小功能我们就要去添加一个新的类，
 * 同时我们需要在Factory中改动到switch里面的代码，这是耦合性很高的表现啦，所以我们就有了“工厂模式”的出现啦。
 */
public class SimpleFactory {
    private static Operation createOperate(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }

    public static void main(String[] args) {
        Operation oper;
        oper = SimpleFactory.createOperate("-");
        oper._numberA = 11.2;
        oper._numberB = 2.2;
        double result = oper.GetResult();
        System.out.println(result);
    }
}
