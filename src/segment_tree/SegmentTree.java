package segment_tree;

/**
 * Created by zmkn2 on 2017/4/11.
 */
public class SegmentTree {
    static int maxind = 256;
    static int segTree[] = new int[maxind * 4 + 10];
    static int array[] = new int [maxind];

    static void build( int node, int begin, int end){//构建树,最小值
        if( begin == end ){
            segTree[node] = array[begin];
        }
        else{
            build(2 * node, begin, (begin + end) / 2);
            build(2 * node + 1, (begin + end) / 2 + 1, end);
            if(segTree[2 * node] <= segTree[2 * node + 1])
                segTree[node] = segTree[2 * node];
            else
                segTree[node] = segTree[2 * node + 1];
        }
    }

    static int query( int node, int begin, int end, int left, int right){
        int p1, p2;
        //查询区间和要求的区间没有交集
        if(left > end || right < begin)
            return -1;
        //begin end 范围在 left right 之间
        if( left <= begin && right >= end)
            return segTree[node];

        p1 = query( 2 * node, begin, (begin + end) / 2, left, right);
        p2 = query( 2 * node + 1, (begin + end) / 2 + 1, end, left, right);
        if(p1 == -1)
            return p2;
        if(p2 == -1)
            return p1;
        if(p1 <= p2)
            return p1;
        return p2;
    }
    static void update(int node, int left, int right, int index, int add){
        if( left == right){
            segTree[node] += add;
            return ;
        }
        int mid = (left + right) >> 1;
        if( index <= mid)
            update( node*2, left, mid, index,add);
        else
            update(node*2+1, mid + 1, right, index, add);
        segTree[node] = Math.min(segTree[node*2],segTree[node*2+1]);

    }

    static void build_sum( int node, int begin, int end){//构建树,子树和
        if( begin == end ){
            segTree[node] = array[begin];
        }
        else{
            build_sum(2 * node, begin, (begin + end) / 2);
            build_sum(2 * node + 1, (begin + end) / 2 + 1, end);
            segTree[node] =  segTree[2 * node] + segTree[2 * node + 1];
        }
    }

    static int query_sum( int node, int begin, int end, int left, int right){
        int p1, p2;
        //查询区间和要求的区间没有交集
        if(left > end || right < begin)
            return 0;
        //begin end 范围在 left right 之间
        if( left <= begin && right >= end)
            return segTree[node];

        p1 = query_sum( 2 * node, begin, (begin + end) / 2, left, right);
        p2 = query_sum( 2 * node + 1, (begin + end) / 2 + 1, end, left, right);

        return p1 + p2;
    }

    public static void sum(){
        array[0] = 1;array[1] = 2; array[2] = 2; array[3] = 4; array[4] = 1;array[5] = 3;
        build_sum(1, 0, 5);
        int a=query_sum(1,0,5,0,2);
        int b = query_sum(1,0,5, 2,5);
        System.out.println(a +" "+b);
    }
    public static void main(String[] args) {
        sum();
    }


}
