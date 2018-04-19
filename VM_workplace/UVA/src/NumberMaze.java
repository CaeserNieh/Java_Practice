import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
 
public class NumberMaze {
    static int[][] maze = new int[1000][1000];
    static int[][] cost = new int[1000][1000];
    static int inf = 1 << 25;
    static boolean[][] vis = new boolean[1000][1000];
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    static int r, col;
 
    static class node implements Comparable<node> {
        int i, j, c;
 
        public node(int i, int j, int c) {
            this.i = i;
            this.j = j;
            this.c = c;
        }
 
        public int compareTo(node arg0) {
            return c - arg0.c;
        }
    }
 
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        int res;
        while (cases-- > 0) {
            r = Integer.parseInt(in.readLine());
            col = Integer.parseInt(in.readLine());
            for (int i = 0; i < r; i++) {
                String inp = in.readLine();
                int last = -1;
                for (int j = 0; j < col; j++) {
                    last++;
                    res = 0;
                    for (; last < inp.length() && inp.charAt(last) != ' '; last++)
                        res = res * 10 + inp.charAt(last) - '0';
                    maze[i][j] = res;
                   // System.out.printf("%d\n", maze[i][j]);
                    vis[i][j] = false;
                    cost[i][j] = inf;
                    //System.out.printf("%d\n", inf);
                }
            }
            node s = new node(0, 0, maze[0][0]);
            int ei = r - 1;
            int ej = col - 1;
            PriorityQueue<node> Q = new PriorityQueue<node>();
            Q.add(s);
            while (!Q.isEmpty()) {
                node c = Q.poll();
                System.out.println("\nwhile ");
                System.out.printf("poll node:%d %d\n", c.i,c.j);
                if (c.i == ei && c.j == ej) {
                    System.out.println(c.c);
                    break;
                } else if (!vis[c.i][c.j]) {
                    vis[c.i][c.j] = true;
                    for (int i = 0; i < 4; i++) {
                        int ni = c.i + dx[i];
                        int nj = c.j + dy[i];
                        if (ni >= 0 && ni < r && nj >= 0 && nj < col
                                && c.c + maze[ni][nj] < cost[ni][nj]) {
                            Q.add(new node(ni, nj, c.c + maze[ni][nj]));
                            System.out.printf("add node:%d %d = %d\n", ni,nj,maze[ni][nj]);
                            cost[ni][nj] = c.c + maze[ni][nj];
                        }
                    }
                }
            }
        }
    }
}