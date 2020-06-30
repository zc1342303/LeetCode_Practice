package leetcode;

public class BusyStudent {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (queryTime >= startTime[i] && queryTime <= endTime[i]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BusyStudent solution = new BusyStudent();
        int[] startTime = {1, 2, 3};
        int[] endTime = {3, 2, 7};
        int queryTime = 4;
        int ans = solution.busyStudent(startTime, endTime, queryTime);
        System.out.println(ans);
    }
}
