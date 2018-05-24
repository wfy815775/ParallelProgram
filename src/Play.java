public class Play {
    public static void main(String[] args) {
        synchronized (args[0]){
            System.out.println(args[0]);
        }
    }
}
