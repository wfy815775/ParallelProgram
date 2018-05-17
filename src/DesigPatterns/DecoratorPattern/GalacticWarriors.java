package DesigPatterns.DecoratorPattern;

public class GalacticWarriors extends HeroDecorator {
    private Hero heroDecorator;

    public GalacticWarriors(Hero heroDecorator) {
        super(heroDecorator);
    }

    @Override
    public void init() {
        super.init();
        setSkin();
    }

    private void setSkin(){
        System.out.println("皮肤:银河战士套装");
    }


}
