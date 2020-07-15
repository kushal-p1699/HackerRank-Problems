import java.sql.SQLOutput;
import java.util.*;

public class Main {

    // function for factorial
    static int fact(int n){
        if(n == 0 || n == 1)
            return  1;
        else
            return n * fact(n-1);
    }


    static int __G(int n){
        int res = 0;
        res = __SF(n);
        int sum = 0;
        while(res > 0){
            int rem = res % 10;
            sum += fact(rem);
            res /= 10;
        }
        return sum;
    }

    static int __SF(int n){
        int rem = 0, res = 0;
        while(n > 0){
            rem = n % 10;
            //System.out.println(rem);
            res += fact(rem);
            System.out.println(res);
            n /= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = 3;
        int mod = 1000000;

        int res = 0;
        for(int i=1; i<=n; i++){
            res += __G(i);
        }

        System.out.println(res);

    }
}
