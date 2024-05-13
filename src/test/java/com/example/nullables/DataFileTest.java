package com.example.nullables;
import com.example.nullables.infrastructure.DataFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class DataFileTest {
    @Test
    public void readRealFile() throws IOException {
        // Integration test using real file
        String[] expected = new String[]{"1 2", "2 4", "6 9", "9 10", "10 11", "11 12"};

        DataFile dataFile = DataFile.create("data.dat");

        Assertions.assertArrayEquals(expected, dataFile.readFile());
    }

    @Test
    public void nullableReturnsInput() throws IOException {
        String[] expected = new String[]{"1 2", "2 4", "6 9", "9 10", "10 11", "11 12"};

        DataFile dataFile = DataFile.createNull(expected);

        Assertions.assertArrayEquals(expected, dataFile.readFile());
    }
}
