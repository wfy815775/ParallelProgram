package CallBack;

public class Tom implements Student {
CallBack callBack;

    public Tom() {

    }

       @Override
    public void doTask(CallBack callBack){
        this.callBack = callBack;
        System.out.println(this.getClass().getName()+" 开始做卷子");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
           System.out.println("完卷子了");
        callBack.Callme();
    }
}
