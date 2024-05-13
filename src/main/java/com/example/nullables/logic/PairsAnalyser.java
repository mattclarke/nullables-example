package com.example.nullables.logic;

public class PairsAnalyser {
    private final String[] pairs;
    public PairsAnalyser(String[] pairs) {
        this.pairs = pairs;
    }
    public Integer getBiggestDiff() {
        int result = 0;

        for (var s : pairs) {
            var parts = s.split(" ");
            int value1 = Integer.parseInt(parts[0]);
            int value2 = Integer.parseInt(parts[1]);

            if (value2 - value1 > result) {
                result = value2 - value1;
            }
        }

        return result;
    }
}
