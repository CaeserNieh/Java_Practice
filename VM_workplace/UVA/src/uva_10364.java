import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//DFS
public class uva_10364 {
	public static boolean ans;
	public static int input;
	public static int divide;
	public static int testcase;
	public static boolean visit[];
	public static int ansarray[];
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		input = scan.nextInt();
		int sum;
		divide = 0;		
		for(int i = 0;i<input;i++){
			sum = 0;
			testcase = scan.nextInt();
			ansarray = new int[testcase];
			visit = new boolean[testcase];
			for(int j = 0;j<testcase;j++){
				ansarray[j] = scan.nextInt();
				sum = sum+ansarray[j];
			}  //for j
			divide = sum/4;
			if(sum%4 != 0){
				System.out.println("no");
			}else{
				ans = false;
				DFS(0,0,0);
				
				if(ans == true){
					System.out.println("yes");
				}
				else{
					System.out.println("no");
				}
			}
		}   //for i
	}

	private static void DFS(int counter, int begin, int sum) {
		System.out.printf("begin:%d\n", begin);
		if(counter == 3){
			ans =true;
			return;
		}
		if(sum >divide){
			return;
		}
		if(sum == divide){
			DFS(counter+1,0,0);
		}
		
			for(int i = begin;i<testcase;i++){
				if(visit[i] == false){
					visit[i] = true;
					System.out.printf("i:%d\n",i);
					DFS(counter,i,ansarray[i]+sum);
					visit[i] = false;
				}
			}
				
	}
}