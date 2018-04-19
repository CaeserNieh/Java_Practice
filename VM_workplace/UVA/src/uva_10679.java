import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class uva_10679 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner scan = new Scanner(System.in);
		//Scanner scanr =new Scanner(System.in);
		
		int input = Integer.parseInt(br.readLine());//scan.nextInt();//幾個測資
		int answer[] = new int[10000000];
		int anscounter = 0;
		for(int ii = 0;ii<input;ii++){
			int index = 0;
			String question = br.readLine();
			char q[] = question.toCharArray();//題目
			int n = Integer.parseInt(br.readLine());//幾個待測項目
			String ans="";
			for(int i = 0;i<n;i++){
				ans = br.readLine();
				char[] ansq = ans.toCharArray();
				int lans = ansq.length;
				while(answer[anscounter] != 1 && index+ansq.length <= q.length){
					index = BM(q,ansq,index,lans,answer,anscounter);
				}
				anscounter++;
			}
		}
		
		for(int i = 0;i<anscounter;i++){
			if(answer[i] == 1){
				System.out.println("y");
			}else{
				System.out.println("n");
			}
		}
	}//main
	//BM沒問題
	public static int  BM(char[] q,char[] ans,int index,int lans,int answer[],int counter){
		int badchar = 0;//與greatsuffix比大小的數
		int greatsuffix = 0;
		int badindex = 0;
		int skip = 0;
		boolean done = false;
		boolean dones = false;
		boolean find = true;
		for(int i = lans-1;i>=0;i--){
				//badchar
			if((int)(q[index+i]) != (int)(ans[i])){
				badindex = i;
				for(int j = lans-1;j>=0;j--){
					if((int)(q[index+i]) == (int)(ans[j])){
						badchar = badindex - j;
						done = true;
						break;
					}
				}
				if(done==false){
					badchar = badindex+1;
				}
				//greatsuffix
				
				if(i != lans-1){
					for(int z = 0;z<lans;z++){
						if(ans[lans-1] == ans[z]){
							dones = true;
							greatsuffix = lans-1-z;
							dones = true;
							break;
						}
					}
					if(dones==false){
						greatsuffix = lans-1 + 1;

					}
				}				
				skip = Math.max(badchar, greatsuffix);
				index = index+skip;
				find = false;
				break;
			}
			
		}
		if(find == true){
			answer[counter] = 1;			
		}		
		return index;
	}
}