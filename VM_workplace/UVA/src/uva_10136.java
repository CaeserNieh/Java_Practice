import java.util.Scanner;


public class uva_10136 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		Scanner scannertest = new Scanner(System.in);
		int input = scan.nextInt();
		
		for(int bigcounter = 0;bigcounter<input;bigcounter++){
			String trash = scanner.nextLine();//*************************************************
			
			//System.out.printf("%d\n",MAX);
			int MAX = 1;
			double[] index_x = new double[500];
			double[] index_y = new double[500];
					
			String temp[] = new String[4];
			
			int n = 0;
			String str;
			while(true){
				str	= scannertest.nextLine();// ************************************************
				if(str.equals("")){
					break;
				}
				temp = str.split(" ");
				index_x[n] = Double.parseDouble(temp[0]);
				index_y[n] = Double.parseDouble(temp[1]);
				n++;
			}//while
			double dis,temp_x,temp_y,temp_z;
			int c_k = 0;
			for(int i = 1;i<n;i++){
				for(int j = 0;j<i;j++){
					if((index_x[i]==index_x[j])&&(index_y[i]==index_y[j])){
						continue;
					}
					dis = distence(index_x[i],index_y[i],index_x[j],index_y[j]);
					if(dis<=5){
						double cx = 0;
						double cy = 0;
						dis = Math.sqrt(6.25 - (dis*dis)/4.0);
						temp_x = index_y[j]-index_y[i];
						temp_y = index_x[i]-index_x[j];
						temp_z = Math.sqrt(temp_x*temp_x+temp_y*temp_y);
						temp_x = (temp_x/temp_z)*dis;
						temp_y = (temp_y/temp_z)*dis;
						
						cx = (index_x[i]+index_x[j])/2.0 + temp_x;
						cy = (index_y[i]+index_y[j])/2.0 + temp_y;
						int s = 0;
						for(int k = 0;k<n;k++){
							
							if(distence(cx,cy,index_x[k],index_y[k])<=2.5){
								s++;
								System.out.printf("s:%d\n",s);
							}
							if(s>MAX){
								MAX = s;
							}
						}
						
						cx = (index_x[i]+index_x[j])/2.0 - temp_x;
						cy = (index_y[i]+index_y[j])/2.0 - temp_y;
						s = 0;
						for(int k = 0;k<n;k++){
							
							if(distence(cx,cy,index_x[k],index_y[k])<=2.5){
								s++;
								System.out.printf("s:%d\n",s);
							}
							if(s>MAX){
								MAX = s;
							}
						}
					}
				}
			}
			/*int max= 1;
			for(int i = 0;i<c_k;i++){
				int s = 0;
				for(int j = 0;j<n;j++){
					if(distence(c_x[i],c_y[i],index_x[j],index_y[j]) <= 2.5){
						s++;
					}
					if(s>max){
						max = s;
					}
				}
			}*/
			
			System.out.printf("%d\n",MAX);
			if(bigcounter != input-1){
				System.out.println("out");
			}
		}//for
	}
	public static double distence(double a_x,double a_y,double b_x,double b_y){
		return Math.sqrt((a_x-b_x)*(a_x-b_x)+(a_y-b_y)*(a_y-b_y));
	}
}