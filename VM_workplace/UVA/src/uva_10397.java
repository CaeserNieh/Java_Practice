//10397
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class edge{
	int start;
	int end;
	double weight;
	public edge(int u,int v,double w){
		this.start = u;
		this.end = v;
		this.weight = w;
	}

}//class

class edgecomparator implements Comparator<edge>{
	@Override
	public int compare(edge o1,edge o2){
		if(o1.weight < o2.weight){
			return -1;
		}else if(o1.weight > o2.weight){
			return 1;
		}
		return 0;
	}
}//class compore

public class uva_10397{
	static int MAX = 760;
	static int x[] = new int[MAX];
	static int y[] = new int[MAX];
	static int p[] = new int[MAX*MAX];
    double weight[][] = new double[MAX][MAX];
        edge e[] = new edge[MAX * MAX];
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
			uva_10379 uva = new uva_10379();
                while(scan.hasNext()){
                        int input = scan.nextInt();
                        
                        for(int i = 1;i <= input;i++){
                                uva.x[i] = scan.nextInt();
                                uva.y[i] = scan.nextInt();
                        }

                        for(int i = 1;i<=input;i++){
                                for(int j = 1;j<=input;j++){
                                        if(i != j){
                                                uva.weight[i][j] = uva.weight[j][i] = uva.len(i,j);
                                        }
                                }
                        }//for i
                        int original = scan.nextInt();
                        for(int i = 0;i < original;i++){
                                int start = scan.nextInt();
                                int end = scan.nextInt();
                                uva.weight[start][end] = uva.weight[end][start] = 0;
                        }
                        int counter = 0;
                        for(int i = 1;i <= input;i++){
                                for(int j = i+1;j <= input;j++){
                                        uva.e[counter++] = new edge(i,j,uva.weight[i][j]);
                                }
                        }
                        for(int i = 0; i<= input*input;i++){
                                uva.p[i] = i; // go to that place
                        }
                        double ans = 0;
                        Arrays.sort(uva.e,0,counter,new edgecomparator());
                        for(int i = 0;i < counter;i++){
                        //	System.out.printf("%d : %d--%d\n",i, uva.e[i].start,uva.e[i].end);
                                int x = uva.find(uva.e[i].start);
                               // System.out.printf("%d : %d : x %d\n",i, uva.e[i].start,x);
                                int y = uva.find(uva.e[i].end);
                                //System.out.printf("%d : %d : y %d\n",i, uva.e[i].end,y);
                                if(x != y){
                                        ans = ans+uva.e[i].weight;
                                        uva.p[x] = y;
                                }
                        }
                        System.out.printf("%.2f\n",ans);
                }
	}//main

        public static double len(int i,int j){
                double ti = Math.pow(x[i] - x[j],2);
                double tj = Math.pow(y[i] - y[j],2);
                return Math.sqrt(ti+tj);
        }
        public static int find(int x){
        	//System.out.printf("find : %d : %d\n", x,p[x]);
                if(p[x] == x){
                        return x;
                }
                return p[x] = find(p[x]);
        }

}