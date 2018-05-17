package DesigPatterns.ChainofResponsibilityPattern;

public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    protected void Write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
