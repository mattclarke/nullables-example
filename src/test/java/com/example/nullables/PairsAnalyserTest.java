package com.example.nullables;

import com.example.nullables.logic.PairsAnalyser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PairsAnalyserTest {
    @Test
    public void findsBiggestDifference() {
        // Standard test
        var input = new String[]{"1 2", "2 6", "6 7"};
        PairsAnalyser analyser = new PairsAnalyser(input);

        Assertions.assertEquals(4, analyser.getBiggestDiff());
    }

    // Other tests go here...
    // Edge cases, error cases, etc.
}
