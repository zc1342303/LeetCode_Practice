package practice;

public class NextGreatestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        int l = 0, r = n;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] <= target) {
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        // System.out.println(l);
        // System.out.println(r);

        return l < n ? letters[l] : letters[0];
    }
}
