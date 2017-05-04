package 数学.素数筛法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zmkn2 on 2017/4/3.
 */

/**
 * ans[]是素数表 ,第0项是0, 不是素数
 */
public class GetPrime {
    public static final int maxn = 1000000;
    public static boolean valid[] = new boolean[maxn+1];//记录是否为素数
    //public static int ans[] = new int[maxn+1];
    public static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        ans.add(0);//把第0项加进去
        for( int i = 0; i <= maxn; i++){
            valid[i] = true;
        }
        getPrime(maxn, 0);

    }
    /**
     *  素数筛法O(n)
     * @param N 所需素数的范围
     * @param tot 素数的总数
     */
    static void getPrime(int N, int tot){
        for( int i =2; i <= N; i++){
            if(valid[i]){
                tot++;
                //ans[tot] = i;
                ans.add(tot,i);
            }
            for( int j = 1; ((j <= tot) && (i * ans.get(j) <= N)); j++){
                valid[i * ans.get(j)] = false;
                if((i % ans.get(j)) == 0) {
                    break;
                }
            }
        }
    }
}
