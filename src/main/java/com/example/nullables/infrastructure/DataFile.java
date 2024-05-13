package com.example.nullables.infrastructure;

import java.io.IOException;

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
}
