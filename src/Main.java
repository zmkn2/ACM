import java.util.*;
public class Main{
    public static void main(String arg[]){
        //输入为 k,l,m,n
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int T = in.nextInt();
        T++;
        int x[][] = new int[T][N];
        int y[][] = new int[T][N];

        for( int  i = 0; i < T; i++){
            for( int j = 0; j < N; j ++){
                x[i][j] = in.nextInt();
                y[i][j] = in.nextInt();
            }
        }
        Long ans = 0L;
        for( int  i = 1; i < T; i++) {
            for (int j = 0; j < N; j++) {
                long tmp = Math.abs(x[i][j]-x[i-1][j]) + Math.abs(y[i][j]-y[i-1][j]);
                ans +=tmp;
            }
        }
        System.out.println(ans);
        return ;
    }


}