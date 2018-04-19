import java.util.Scanner;


public class uva_10137{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = 0;
		double[] ans = new double[10000];
		
		while(scan.hasNext()){
			double sum = 0,average = 0,different = 0,neg = 0,pos = 0;
			double answer = 0;
			n = scan.nextInt();
			if(n==0){
				break;
			}
			for(int i = 0;i<n;i++){
				ans[i] = scan.nextDouble();
				sum = sum+ans[i];
			}
			average = sum / n;
			for(int i = 0;i<n;i++){
				different = (double)(long)((ans[i]-average)*100.0)/100.0;
						if(different<0){
							neg = neg+(-1)*different;
						}else{
							pos = pos+different;
						}
			}
			if(neg>pos){
				answer = neg;
			}
			else if(pos>neg){
				answer = pos;
			}
			else if(pos == neg){
				answer = pos;
			}
			System.out.printf("$%.2f\n",answer);
			
		}
		
	}
}