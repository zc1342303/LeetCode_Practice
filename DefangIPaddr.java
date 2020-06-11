package practice;

public class DefangIPaddr {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        int n = address.length();
        for (int i = 0; i < n; i++) {
            char c = address.charAt(i);
            if (c == '.') {
                res.append("[.]");
            }
            else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
