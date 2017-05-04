package 图;

/**
 * Created by zmkn2 on 2017/4/5.
 */
public class Dijkstra {
    static final int MaxN = 1000; //节点的理论最大值
    static int dis[] = new int [MaxN]; //记录 0 点 到 其他任意节点的距离
    static boolean v[] = new boolean [MaxN]; // 这个节点是否已经遍历过
    static int g[][] = new int [MaxN][MaxN]; //邻接矩阵


    public static void main(String[] args) {

    }
    public static void dijkstra(int n){
        for( int i = 1; i <= n; i++){
            dis[i] = g[0][i];//赋初值,能从0到达的节点直接赋值, 否则应该赋为 MAX_VALUE
        }
        v[0] = true;//标记0 已经遍历过
        for( int i = 1; i <= n; i ++){
            int min = Integer.MAX_VALUE;
            int mark = 0;
            for( int j = 0; j <= n; j ++){//找到离0最近的, 且没有被遍历过的 节点
                if( !v[j] && dis[j] < min){
                    min = dis[j];
                    mark = j;
                }
            }
            v[mark] = true;
            for( int j = 1; j <= n; j ++){
                if(!v[j])
                    dis[j] = Math.min(dis[j], dis[mark] + g[mark][j]);
            }
        }
    }

}
