package practice;

public class MyPow {
    public double myPow(double x, int n) {
        if (n == -2147483648) {
            return 1.0 / (pow(x, 2147483647) * x);
        }
        else if (n < 0) {
            return 1.0 / pow(x, -n);
        }
        else if (n == 0) {
            return 1.0;
        }
        return pow(x, n);
    }
    public double pow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        double half = pow(x, n/2);
        if (n % 2 == 1) {
            return half * half * x;
        }
        return half * half;
    }
    public static void main(String[] args) {
        MyPow solution = new MyPow();
        double x = 2.0;
        int n = 2;
        double ans = solution.myPow(x, n);
        System.out.println(ans);
    }
}
