package DesigPatterns.SingletonPattern;
/**
 *单例模式
 * 双检锁/双重校验锁
 *
 */
public class singleton {
private volatile static singleton singleton;

    private singleton() {
    }

    public static singleton getSingleton(){
        if (singleton == null){
            synchronized (DesigPatterns.SingletonPattern.singleton.class){

                if (singleton == null)
                    singleton = new singleton();


            }

        }
        return singleton;
    }


}
