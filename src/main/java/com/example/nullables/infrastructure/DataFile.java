package com.example.nullables.infrastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFile {
    private final BufferedReaderWrapper bufferedReaderWrapper;
    public DataFile(BufferedReaderWrapper wrapper) {
        bufferedReaderWrapper = wrapper;
    }

    public String[] readFile() throws IOException {
        return bufferedReaderWrapper.read();
    }

    public static DataFile create(String filePath) {
        BufferedReaderWrapper wrapper = new RealBufferedReader(filePath);
        return new DataFile(wrapper);
    }

    public static DataFile createNull(String[] data) {
        return new DataFile(new StubbedBufferedReader(data));
    }

    // Nullables

    private interface BufferedReaderWrapper {
        public String[] read() throws IOException;
    }

    private record RealBufferedReader(String filePath) implements BufferedReaderWrapper {

        @Override
            public String[] read() throws IOException {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                List<String> lines = new ArrayList<>();
                String line = reader.readLine();
                while (line != null) {
                    lines.add(line);
                    line = reader.readLine();
                }
                reader.close();
                return lines.toArray(new String[0]);
            }
        }

    private record StubbedBufferedReader(String[] data) implements BufferedReaderWrapper {
        @Override
            public String[] read() {
                return data;
            }
        }
}
