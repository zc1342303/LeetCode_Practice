package practice;

import java.util.*;

public class PeopleIndexes {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> result = new ArrayList<>();
        int n = favoriteCompanies.size();
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                List<String> companies1 = favoriteCompanies.get(i);
                List<String> companies2 = favoriteCompanies.get(j);
                Set<String> set = new HashSet<>(companies2);
                if (set.containsAll(companies1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result.add(i);
            }
        }
        return result;
    }
}
