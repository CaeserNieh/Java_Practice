import java.util.Arrays;
import java.util.Scanner;

public class uva_124{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String qar[] = new String[20];
			String car[] = new String[100];
			String answer[] = new String[26];
			int map[][];
			boolean[] use = new boolean[26];
			boolean[] character = new boolean[26];
			String inputa = scan.nextLine();
			String inputc = scan.nextLine();
			int la = (inputa.length()-1)/2;
			qar = inputa.split(" ");
			car = inputc.split(" ");
			Arrays.sort(car);
			for(int i = 0;i<qar.length;i++){
				character[(qar[i].charAt(0)-'a')] = true;
			}
			map = new int[26][26];
			for(int i = 0;i<car.length;i+=2){
				map[car[i].charAt(0)-'a'][car[i+1].charAt(0)-'a'] = 1;
				//System.out.printf("map[%d][%d] = %d ",car[i].charAt(0)-'a',car[i+1].charAt(0)-'a',1);
			}
			//System.out.println();
			dfs(map,use,character,0,answer,la);
			System.out.println();
		}
	}//main
	public static void dfs(int map[][],boolean use[],boolean character[],int counter,String answer[],int la){
		if(counter == la+1){
			for(int i = 0;i<=la;i++){
				System.out.printf("%s",answer[i]);
			}
			System.out.println();
			return;
		}
		else{
			for(int i = 0;i<26;i++){
				if(character[i] == true && use[i] == false){
					for(int j = 0;j<26;j++){
					//	System.out.printf("m[%d][%d] = %d ",i,j,map[i][j]);
//						System.out.println();
						
						if(map[i][j] == 1 && use[j] == true){
							//System.out.printf("j : %d",j);
							return;
						}
					}
					use[i] = true;
					answer[counter] = String.valueOf((char)(i+'a'));
					dfs(map,use,character,counter+1,answer,la);
					use[i] = false;
				}
			}
		}
	}
}