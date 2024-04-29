package com.github.vladimirbabin.leetcode;

public class StringPermutations {

    public void permutations(String s) {
        permutations(s, "");
    }

    private void permutations(String s, String prefix) {
        if (s.isEmpty()) {
            System.out.println(prefix);
        }

        for (int i = 0; i < s.length(); i++) {
            String rem = s.substring(0, i) + s.substring(i + 1);
            permutations(rem, prefix + s.charAt(i));
        }
    }


}
