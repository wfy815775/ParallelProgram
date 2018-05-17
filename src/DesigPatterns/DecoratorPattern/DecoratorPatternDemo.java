package DesigPatterns.DecoratorPattern;

public class DecoratorPatternDemo {
    public static void main(String[] args) {
        Hero victor = new victor();

        GalacticWarriors galacticWarriors = new GalacticWarriors(victor);

        galacticWarriors.init();

    }
}
