package leetcode;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int currTank = 0;
        int totalTank = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            currTank += gas[i] - cost[i];
            totalTank += gas[i] - cost[i];
            if (currTank < 0) {
                start = i + 1;
                currTank = 0;
            }
        }
        if (totalTank >= 0) {
            return start;
        }
        return -1;
    }
}
