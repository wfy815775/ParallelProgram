package CallBack;

public class C  extends B{
    @Override
    public void b() {
        System.out.println("ssss");
    }

    @Override
    public void a(String s) {
        if (s.equalsIgnoreCase("hlj"))
        super.a(s);
        else
            System.out.println("不知道哪里人");
    }

    public static void main(String[] args) {
        C c =  new C();

        c.a("HLJ1");
    }
}
