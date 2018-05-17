package CallBack;

public abstract class B implements A{
    @Override
    public void a(String s) {
        System.out.println("黑龙江");
    }

    @Override
    public abstract void b();
}
