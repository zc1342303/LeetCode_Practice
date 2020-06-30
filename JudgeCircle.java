package leetcode;

public class JudgeCircle {
    public boolean judgeCircle(String moves) {
        int row = 0, col = 0;
        for (int j = 0; j < moves.length(); j++) {
            char c = moves.charAt(j);
            switch (c) {
                case 'L':
                    col--;
                    break;
                case 'R':
                    col++;
                    break;
                case 'U':
                    row--;
                    break;
                case 'D':
                    row++;
                    break;
                default:
                    break;
            }
        }
        return row == 0 && col == 0;
    }

    public static void main(String[] args) {
        JudgeCircle solution = new JudgeCircle();
        String moves = "UD";
        boolean ans = solution.judgeCircle(moves);
        System.out.println(ans);
    }
}
