import java.util.concurrent.ForkJoinPool;

public class RecurTaskDemo {

    public static void main(String[] args) {
        ForkJoinPool fj = new ForkJoinPool();

        double[] nums = new double[5000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = (double) ((i%2) == 0 ? i: -i);


        }
        Sum task = new Sum(nums,0,nums.length);

        double summation = fj.invoke(task);


        System.out.println("summation "+summation);
    }
}
