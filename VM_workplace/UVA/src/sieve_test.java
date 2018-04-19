//線性篩法
public class sieve_test {
	public static void main(String[] args){
		int a[] = new int[501];
		int counter = 0;
		int prime[] = new int[300];
		int counterp = 0;
		boolean ba[] = new boolean[501];
					
		
		
		for(int i = 1;i<a.length;i++){
			a[i] = i;
			System.out.printf("%d ",a[i]);
			counter++;
			if(counter == 10){
				System.out.println();
				counter = 0;
			}
			
		}//for
		
		for(int p = 2;p*p< a.length;p++){
			if(ba[p] == false){
				for(int q = p;p*q<a.length;q++){
					if(ba[q] == false){		
						for(int m = p*q;m<a.length;m = p*m){
							ba[m] = true;
						}
					}
				}//for q
			}
		}//for p
		for(int i = 1;i<a.length;i++){
			if(ba[i] == false){
				prime[counterp] = i;
				counterp++;
			}
		}
		System.out.println( );
		System.out.println( );
		for(int i = 0;i<counterp;i++){
			System.out.printf("%d ",prime[i] );
		}
		
	}
}
