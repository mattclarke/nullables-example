package com.example.nullables.infrastructure;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RealBufferedReader implements BufferedReaderWrapper{
    private String filePath;
    public RealBufferedReader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String[] read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> lines = new ArrayList<>();
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines.toArray(new String[0]);
    }
}
