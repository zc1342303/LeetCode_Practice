package leetcode;

public class IsPrefixOfWord {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] senArr = sentence.split(" ");
        for (int i = 0; i < senArr.length; i++) {
            if (senArr[i].indexOf(searchWord) == 0)
                return i + 1;
        }
        return -1;
    }
}
