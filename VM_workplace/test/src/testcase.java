import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;


public class testcase {
	
	public static void main(String[] args){
		/*Scanner scan = new Scanner(System.in);
		String inputstr = scan.nextLine();
		int input = scan.nextInt();
		String answer = addminute(inputstr,input);
		System.out.printf("%s\n",answer);*/
	}
	public static String addminute(String str,int min){

		String[] input_string = new String[2];//"0:9:13 1:AM"
		String[] time = new String[2];//0:9 1:13
		
		input_string = str.split(" ");
		time = input_string[0].split(":");
		
		int temp_min = Integer.parseInt(time[1]);
		int temp_hr = Integer.parseInt(time[0]);
		
		if(input_string[1].equals("AM")){
			int temp_s = min/60;
			int temp_r = min%60;
			temp_hr = temp_hr + temp_s;
			temp_min = temp_min + temp_r;
			if(temp_min>=60){
				temp_min = temp_min - 60;
				temp_hr = temp_hr + 1;
				if(temp_min == 0){
					time[1] = "00";
				}else{
					if(temp_min <=9){
						time[1] = "0"+ String.valueOf(temp_min);
					}else{
						time[1] = String.valueOf(temp_min);
					}
				}
			}else{
				
				
				if(temp_min <=9){
					time[1] = "0"+ String.valueOf(temp_min);
				}else{
					time[1] = String.valueOf(temp_min);
				}
			}
			
			if(temp_hr>12){
				temp_hr = temp_hr-12;
				time[0] = String.valueOf(temp_hr);
				input_string[1] = "PM";
			}else{
				time[0] = String.valueOf(temp_hr);
			}
			String answerf = time[0]+":"+time[1]+" "+input_string[1];
			return answerf;
		}else{
			temp_hr = temp_hr + 12;
			int temp_s = min/60;
			int temp_r = min%60;
			temp_hr = temp_hr + temp_s;
			temp_min = temp_min + temp_r;
			if(temp_min>=60){
				temp_min = temp_min - 60;
				temp_hr = temp_hr + 1;
				if(temp_min == 0){
					time[1] = "00";
				}else{
					if(temp_min <=9){
						time[1] = "0"+ String.valueOf(temp_min);
					}else{
						time[1] = String.valueOf(temp_min);
					}
				}
			}else{
				if(temp_min <=9){
					time[1] = "0"+ String.valueOf(temp_min);
				}else{
					time[1] = String.valueOf(temp_min);
				}
			}
			if(temp_hr>=24){
				temp_hr = temp_hr-24;
				time[0] = String.valueOf(temp_hr);
				input_string[1] = "AM";
			}else{
				time[0] = String.valueOf(temp_hr);
			}
			String answerf = time[0]+":"+time[1]+" "+input_string[1];
			return answerf;
		}	
	
	}
	@Test
	public void test() {
		testcase ts = new testcase();
		Assert.assertEquals("6:00 AM",ts.addminute("6:00 AM",0) );
	}
	@Test
	public void test2() {
		testcase ts = new testcase();
		Assert.assertEquals("6:01 AM",ts.addminute("6:00 AM",1) );
	}
	@Test
	public void test3() {
		testcase ts = new testcase();
		Assert.assertEquals("12:05 AM",ts.addminute("11:50 AM",15) );
	}
	@Test
	public void test4() {
		testcase ts = new testcase();
		Assert.assertEquals("0:00 AM",ts.addminute("9:59 PM",121) );
	}
}




