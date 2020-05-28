package practice;

public class DecodeString {
    public String decodeString(String s) {
        String res = "";
        String times = "";
        int t = 1;
        int n = s.length();
        int depth = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                times += c;
            }
            else if (c == '[') {
                t = Integer.parseInt(times);
                int start = i + 1;
                do {
                    if (s.charAt(i) == '[') {
                        depth++;
                    }
                    else if (s.charAt(i) == ']') {
                        depth--;
                    }
                    i++;
                } while (depth != 0);
                i--;
                int end = i;
                String sub = s.substring(start, end);
                String decodeSub = decodeString(sub);
                for (int j = 0; j < t; j++) {
                    res += decodeSub;
                }
                times = "";
            }
            else {
                res += c;
            }
        }
        return res;
    }
}
