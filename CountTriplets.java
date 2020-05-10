package practice;

public class CountTriplets {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            for (int k = i + 1; k < n; k++) {
                cur ^= arr[k];
                if (cur == 0) {
                    res += k - i;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountTriplets solution = new CountTriplets();
        int[] arr = {2, 3, 1, 6, 7};

        int ans = solution.countTriplets(arr);
        System.out.println(ans);
    }

}
