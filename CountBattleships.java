package practice;

public class CountBattleships {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'X') {
                    continue;
                }
                if (i > 0 && board[i-1][j] == 'X') {
                    continue;
                }
                if (j > 0 && board[i][j-1] == 'X') {
                    continue;
                }
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountBattleships solution = new CountBattleships();
        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'x'}
        };
        int ans = solution.countBattleships(board);
        System.out.println(ans);
    }
}
