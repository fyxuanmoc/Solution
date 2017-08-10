import java.util.Scanner;

/**
 * Created by fengy on 2017/8/9.
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 输入描述:
 输入包括两行：
 第一行为整数n(1 ≤ n ≤ 50)
 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。


 输出描述:
 输出一个整数，表示最少需要处理的时间

 输入例子1:
 5
 3072 3072 7168 3072 1024

 输出例子1:
 9216
 */
public class CPU {
    public static void main(String[] args){
        CPU t=new CPU();
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
           int n=sc.nextInt();
           int[] array=new int[n];
           for(int i=0;i<n;i++){
               array[i]=sc.nextInt();
           }
           t.roundSum(array);
        }
    }
    public int roundSum(int[] array){
        int res=0;
        int sum=0;
        int max=0;
        for(int i=0;i<array.length;i++){
            if(max<array[i]){
                max=array[i];
            }
            sum=sum+array[i];
        }
        sum=sum/2;
        if(max>sum){
            return max;
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++){
            if(min>Math.abs(sum-max-array[i])){
                min=array[i];
            }
        }
        return max+min;
    }
}
