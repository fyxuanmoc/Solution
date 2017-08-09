import java.util.Scanner;

/**
 * Created by fengy on 2017/8/9.
 * 终于到周末啦！小易走在市区的街道上准备找朋友聚会，突然服务器发来警报,小易需要立即回公司修复这个紧急bug。
 * 假设市区是一个无限大的区域，每条街道假设坐标是(X，Y)，小易当前在(0，0)街道，办公室在(gx,gy)街道上。
 * 小易周围有多个出租车打车点，小易赶去办公室有两种选择，一种就是走路去公司，
 * 另外一种就是走到一个出租车打车点，然后从打车点的位置坐出租车去公司。
 * 每次移动到相邻的街道(横向或者纵向)走路将会花费walkTime时间，打车将花费taxiTime时间。
 * 小易需要尽快赶到公司去，现在小易想知道他最快需要花费多少时间去公司。
 输入描述:
 输入数据包括五行:
 第一行为周围出租车打车点的个数n(1 ≤ n ≤ 50)
 第二行为每个出租车打车点的横坐标tX[i] (-10000 ≤ tX[i] ≤ 10000)
 第三行为每个出租车打车点的纵坐标tY[i] (-10000 ≤ tY[i] ≤ 10000)
 第四行为办公室坐标gx,gy(-10000 ≤ gx,gy ≤ 10000),以空格分隔
 第五行为走路时间walkTime(1 ≤ walkTime ≤ 1000)和taxiTime(1 ≤ taxiTime ≤ 1000)
 输出描述:
 输出一个整数表示，小易最快能赶到办公室的时间
 输入例子1:
 2
 -2 -2
 0 -2
 -4 -2
 15 3
 输出例子1:
 42
 */
public class Taxi {
    public static void main(String[] args){
        Taxi t=new Taxi();
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int taxiNum = sc.nextInt();
            int[] taxiRow = new int[taxiNum];
            int[] taxiCol = new int[taxiNum];
            for(int i=0;i<taxiNum;i++){
                taxiRow[i] = sc.nextInt();
            }
            for(int i=0;i<taxiNum;i++){
                taxiCol[i] = sc.nextInt();
            }
            int[] office=new int[2];
            for(int i=0;i<2;i++){
                office[i] = sc.nextInt();
            }
            int walkTime = sc.nextInt();
            int taxiTime = sc.nextInt();
            t.mostFast(taxiRow,taxiCol,office,walkTime,taxiTime);
        }

    }
    public int mostFast(int[] taxiRow,int[] taxiCol,int[] office,int walkTime,int taxiTime){
        int res=0;
        //走着去office的时间
        int walkAll=walkTime*(Math.abs(office[0])+Math.abs(office[1]));
        //先到最近搭车点(还有一种情况，走到的搭车点不是最近的，但是最后时间是最小的)
        int min=Integer.MAX_VALUE;
        for(int i=0;i<taxiRow.length;i++){
            int walkTaxi=walkTime*(Math.abs(taxiRow[i])+Math.abs(taxiCol[i]));
            int taxiAll=walkTaxi+taxiTime*(Math.abs(taxiRow[i]-office[0])+Math.abs(taxiCol[i]-office[1]));
            if(taxiAll<min){
                min=taxiAll;
            }
        }
        return walkAll>min?min:walkAll;
    }
}
