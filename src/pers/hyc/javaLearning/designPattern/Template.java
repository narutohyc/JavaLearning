package pers.hyc.javaLearning.designPattern;

abstract class TestPaper {

    public void TestQuestion1() {
        System.out.println("第1题");
        System.out.println("答案" + Answer1());
    }

    public abstract String Answer1();

    public void TestQuestion2() {
        System.out.println("第2题");
        System.out.println("答案" + Answer2());
    }

    public abstract String Answer2();

    public void TestQuestion3() {
        System.out.println("第3题");
        System.out.println("答案" + Answer3());
    }

    public abstract String Answer3();
}

/**
 * 学生甲抄的试卷
 */
class TestPaperA extends TestPaper {
    @Override
    public String Answer1() {
        return "b";
    }

    @Override
    public String Answer2() {
        return "c";
    }

    @Override
    public String Answer3() {
        return "d";
    }
}

/**
 * 学生乙抄的试卷
 */
class TestPaperB extends TestPaper {
    @Override
    public String Answer1() {
        return "c";
    }

    @Override
    public String Answer2() {
        return "b";
    }

    @Override
    public String Answer3() {
        return "a";
    }
}

public class Template {
    public static void main(String[] args) {
        System.out.println("学生甲抄的试卷：");

        TestPaper studentA = new TestPaperA();
        studentA.TestQuestion1();
        studentA.TestQuestion2();
        studentA.TestQuestion3();

        System.out.println("\n学生乙抄的试卷：");
        TestPaper studentB = new TestPaperB();
        studentB.TestQuestion1();
        studentB.TestQuestion2();
        studentB.TestQuestion3();
    }
}
