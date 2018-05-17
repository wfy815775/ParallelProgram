package DesigPatterns.ChainofResponsibilityPattern;

public abstract class AbstractLogger {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void LogMessage(int level,String message){

        if (this.level <= level){
            Write(message);}
        if (nextLogger != null){
            nextLogger.LogMessage(level,message);}

    }

    abstract protected void Write(String message);
}
