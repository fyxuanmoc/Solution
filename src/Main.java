import java.util.*;
//有两个有序的集合，集合的每个元素都是一段范围，求其交集，例如集合{[4,8],[9,13]}和{[6,12]}的交集为{[6,8],[9,12]}
public class Main {
	public static void main(String[] args){
		section s1=new section(4,8);
		section s2=new section(9,13);
		section s3=new section(6,12);
		List<section> list1=new ArrayList();
		List<section> list2=new ArrayList();
		list1.add(s1);
		list1.add(s2);
		list2.add(s3);
		Main m=new Main();
		List<section>  res=m.test(list1,list2);
		for(int i=0;i<res.size();i++){
			System.out.println(res.get(i).left+","+res.get(i).right);
		}
	}
	public List<section> test(List<section> list1,List<section> list2){
		List<section> res=new ArrayList();
		int max=(list1.get(list1.size()-1).right>list2.get(list2.size()-1).right)?list1.get(list1.size()-1).right:list2.get(list2.size()-1).right;
		int[] array=new int[max];
		for(int i=0;i<list1.size();i++){
			section temp=list1.get(i);
			for(int j=temp.left;j<temp.right;j++){
				array[j]=array[j]+1;
			}
		}
		for(int i=0;i<list2.size();i++){
			section temp=list2.get(i);
			for(int j=temp.left;j<temp.right;j++){
				array[j]=array[j]+1;
			}
		}
		int left=-1;
		int right=-1;
		for(int m=0;m<max;m++){
			if(array[m]>1&&left==-1){
				left=m;
			}
			if(array[m]>1){
				right=m+1;
			}
			if(array[m]<=1&&left!=-1&&right!=-1){
				res.add(new section(left,right));
				left=-1;
				right=-1;
			}
		}
		return res;
		
	}
}
class section{
	int left;
	int right;
	public section(int a,int b){
		this.left=a;
		this.right=b;
	}
	public int getLeft() {
		return left;
	}
	public void setLeft(int left) {
		this.left = left;
	}
	public int getRight() {
		return right;
	}
	public void setRight(int right) {
		this.right = right;
	}
}