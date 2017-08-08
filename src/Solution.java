
//任意2n个整数，从其中选出n个整数，使得选出的n个整数和同剩下的n个整数之和的差最小。
/**
 * 也就是说从2n中选出n个数最接近于sum/2
 * 动态规划
 * dp[m][n]前m个数中和为n的可能性
 * */
public class Solution {
	public static void main(String[] args){
		Solution m=new Solution();
		int[] array={1,2,3,4,5,6,7,8};
		System.out.println(m.test(array));
	}
	public int test(int[] array){
		int m=array.length;
		int n=0;
		for(int i=0;i<m;i++){
			n=n+array[i];
		}
		n=n/2;
		int[][] dp=new int[m+1][n+1];
		for(int i=0;i<m+1;i++){
			dp[i][0]=1;
		}
		for(int i=1;i<n+1;i++){
			dp[0][i]=0;
		}
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(dp[i-1][j]==1){
					dp[i][j]=1;
				}
				else if(i<m&&j>=array[i]&&dp[i-1][j-array[i]]==1){
					dp[i][j]=1;
				}
			}
		}
		while(n>=0&&dp[m][n]!=1){
			n--;
		}
		return n;
	}
}
