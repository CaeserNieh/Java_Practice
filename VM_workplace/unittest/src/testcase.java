import java.util.Scanner;



public class testcase{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String inputstr = scan.nextLine();
		int input = scan.nextInt();
		String answer = addminute(inputstr,input);
		System.out.printf("%s\n",answer);
	}
	public static String addminute(String str,int min){
		String[] input_string = new String[2];//"0:9:13 1:AM"
		String[] time = new String[2];//0:9 1:13
		
		input_string = str.split(" ");
		time = input_string[0].split(":");
		
		int temp_min = Integer.parseInt(time[1]);
		int temp_hr = Integer.parseInt(time[0]);
		
		if(input_string[1].equals("AM")){
			temp_min = temp_min + min;
			if(temp_min>=60){
				temp_min = temp_min - 60;
				temp_hr = temp_hr + 1;
				
				time[0] = String.valueOf(temp_hr);
				if(temp_min == 0){
					time[1] = "00";
				}else{
					time[1] = String.valueOf(temp_min);
				}
			}else{
				time[0] = String.valueOf(temp_hr);
				time[1] = String.valueOf(temp_min);
			}
			
			if(Integer.parseInt(time[0])>12){
				input_string[1] = "PM";
				time[0] = String.valueOf(Integer.parseInt(time[0])-12);
			}
			String answerf = time[0]+":"+time[1]+" "+input_string[1];
			return answerf;
		}else{
			temp_min = temp_min + min;
			if(temp_min>=60){
				temp_min = temp_min - 60;
				temp_hr = temp_hr + 1;
				
				time[0] = String.valueOf(temp_hr);
				if(temp_min == 0){
					time[1] = "00";
				}else{
					time[1] = String.valueOf(temp_min);
				}
			}else{
				time[0] = String.valueOf(temp_hr);
				time[1] = String.valueOf(temp_min);
			}
			if(Integer.parseInt(time[0])>=12){
				input_string[1] = "AM";
				time[0] = String.valueOf(Integer.parseInt(time[0])-12);
			}
			String answerf = time[0]+":"+time[1]+" "+input_string[1];
			return answerf;
		}	
	}
}