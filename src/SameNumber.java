import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by fengy on 2017/8/9.
 * 小易有一个长度为n序列，小易想移除掉里面的重复元素，但是小易想是对于每种元素保留最后出现的那个。小易遇到了困难,希望你来帮助他。
 输入描述:
 输入包括两行：
 第一行为序列长度n(1 ≤ n ≤ 50)
 第二行为n个数sequence[i](1 ≤ sequence[i] ≤ 1000)，以空格分隔


 输出描述:
 输出消除重复元素之后的序列，以空格分隔，行末无空格

 输入例子1:
 9
 100 100 100 99 99 99 100 100 100

 输出例子1:
 99 100
 */
public class SameNumber {
    public static void main(String[] args){
        SameNumber t=new SameNumber();
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int[] array=new int[n];
            for(int i=0;i<n;i++){
                array[i]=sc.nextInt();
            }
            Integer[] res=t.lastNumber(array);
            for(int i=0;i<res.length;i++)
                System.out.print(res[i]);
        }

    }

    private Integer[] lastNumber(int[] array) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];
            }
        }
        int[] map=new int[max+1];
        for(int i=0;i<max+1;i++){
            map[i]=-1;
        }
        for(int i=0;i<array.length;i++){
            if(map[array[i]]==-1){
                map[array[i]]=i;
            }else{
                array[map[array[i]]]=-1;
                map[array[i]]=i;
            }
        }
        List<Integer> list=new ArrayList<Integer>();
        int count=0;
        for(int i=0;i<array.length;i++){
            if(array[i]!=-1){
                list.add(array[i]);
                count++;
            }
        }
        Integer[] res=new Integer[count];
        list.toArray(res);
        return res;
    }
}
