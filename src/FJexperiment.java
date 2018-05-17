import java.util.concurrent.ForkJoinPool;

public class FJexperiment {



    public static void main(String[] args) {
        int Plevel;
        int Threadhold;

        if (args.length != 2){
            System.out.println("参数错误");
            return;
        }

        Plevel = Integer.parseInt(args[0]);
        Threadhold = Integer.parseInt(args[1]);

        long beginT,endT;

        ForkJoinPool fj = new ForkJoinPool(Plevel);

        double[] nums  = new double[1000000];
        for (int i = 0; i <nums.length ; i++)
            nums[i] = i++;


        Transform task = new Transform(Threadhold,nums,0,nums.length);

        beginT = System.nanoTime();

        fj.invoke(task);

        endT = System.nanoTime();

      //  Runtime runtime = new  Runtime();
        System.out.println("可用处理器数量 "+Runtime.getRuntime().availableProcessors());
        System.out.println("并行级别："+Plevel);
        System.out.println("临界点："+Threadhold);
        System.out.println("执行时间："+ (endT - beginT)+" ns");

        System.out.println(fj.getParallelism());




    }
}
