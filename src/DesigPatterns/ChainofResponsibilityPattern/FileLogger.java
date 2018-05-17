package DesigPatterns.ChainofResponsibilityPattern;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    protected void Write(String message) {
        System.out.println("File::Logger: " + message);

    }
}
