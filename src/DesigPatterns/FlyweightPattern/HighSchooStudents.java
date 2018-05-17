package DesigPatterns.FlyweightPattern;

public  class HighSchooStudents implements student {
    private String name;

    public HighSchooStudents(String name) {
        this.name = name;
    }

    @Override
    public void answer() {
        System.out.println(name+" 回答");
    }
}
