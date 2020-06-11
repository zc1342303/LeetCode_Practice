package practice;

public class EquationsPossible {
    private int[] vars;
    public boolean equationsPossible(String[] equations) {
        // 查并集
        int n = equations.length;
        vars = new int[26];

        for (int i = 0; i < 26; i++) {
            vars[i] = i;
        }

        for (int i = 0; i < 2 * n; i++) {
            String equation = equations[i%n];
            int var1 = equation.charAt(0) - 'a';
            int var2 = equation.charAt(3) - 'a';
            char sign = equation.charAt(1);

            if (i < n && sign == '=') {
                vars[find(var2)] = find(var1);
            }
            else if (i >= n && sign == '!') {
                if (var1 == var2) {
                    return false;
                }
                if (find(vars[var1]) == find(vars[var2])) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            System.out.println(vars[i]);
        }
        return true;
    }

    private int find(int var) {
        if (vars[var] == var) {
            return var;
        }
        vars[var] = find(vars[var]);
        return vars[var];
    }
}
