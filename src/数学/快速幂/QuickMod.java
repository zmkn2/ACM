package 数学.快速幂;

/**
 * Created by zmkn2 on 2017/4/3.
 */
public class QuickMod {
    public static void main(String[] args) {
        long a = pow_mod(3,3,10);
        System.out.println(a);
        System.out.println(pow_mod(4,10,6));
    }
    public static long pow_mod (long a, long i , long n){
        if( i == 0) return 1% n;
        long temp = pow_mod(a, i >> 1, n);
        temp = temp * temp % n;
        if( (i & 1) > 0 )temp = temp * a % n;
        return temp;
    }
}
