import java.util.Scanner;

/**
 * Created by fengy on 2017/8/11.
 * 易老师购买了一盒饼干，盒子中一共有k块饼干，但是数字k有些数位变得模糊了，看不清楚数字具体是多少了。易老师需要你帮忙把这k块饼干平分给n个小朋友，易老师保证这盒饼干能平分给n个小朋友。现在你需要计算出k有多少种可能的数值
 输入描述:
 输入包括两行：

 第一行为盒子上的数值k，模糊的数位用X表示，长度小于18(可能有多个模糊的数位)

 第二行为小朋友的人数n


 输出描述:
 输出k可能的数值种数，保证至少为1

 输入例子1:
 9999999999999X
 3

 输出例子1:
 4
 */
public class Cookie {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Cookie c=new Cookie();
        while(sc.hasNext()){
            String s=sc.next();
            int k=sc.nextInt();
            int res=c.cookieNum(s,k);
            System.out.print(res);
        }
    }
    public int cookieNum(String s, int k){
        int count=0;
        for(int i=0;i<10;i++){
            char c=String.valueOf(i).charAt(0);
            String temp=s.replace('X',c);
            if(Integer.parseInt(temp)%k==0){
                count++;
            }
        }
        return count;
    }
}
