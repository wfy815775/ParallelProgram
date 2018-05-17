package DesigPatterns.FlyweightPattern;

import java.util.Random;

public class FlyweightPatternDemo {
    private static final String name[] =
            { "王XX", "孙XX", "徐X", "李X", "刘XX" };
    private  static final Random random = new Random();
    private static String getRandomStudent() {
        return name[random.nextInt(5)];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            student student = StudentFactory.getStudent( getRandomStudent() );

            student.answer();

        }
    }
}
