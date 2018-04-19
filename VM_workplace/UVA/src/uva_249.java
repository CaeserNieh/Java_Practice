import java.util.Scanner;


public class uva_249{
	public static void main(String[] args){
		int prime[] = new int[31624];
		int top = 0;
		for(int i = 2;i<31624;i++){
			int judge = 1;
			
			for(int j = 2;j*j<=i;j++){
			
				if(i%j == 0){
				
					judge = 0;
					break;
				}
			}
			if(judge == 1){
				
				prime[top] = i;
				
				top++;
			}
		}
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		for(int time = 0;time<n;time++){
			int MAX = 0;
			int index = 0;
			int la = scan.nextInt();
			int lb = scan.nextInt();
			for(int i = la;i<=lb;i++){
				int answer = 1;
				int sum = i;
				//System.out.printf("i : %d\n",i);
				for(int j = 0;j<top && sum>1;j++){
					int count = 0;
					while(sum%prime[j] == 0){
						count++;
						sum = sum / prime[j];
						
					}
					
					answer = answer*(count+1);
					
				}
				if(answer>MAX){
					MAX = answer;
					index = i;
				}
			}
			System.out.printf("Between %d and %d, %d has a maximum of %d divisors.\n", la, lb, index, MAX);

		}
	}
}