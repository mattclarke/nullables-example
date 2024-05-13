package com.example.nullables.infrastructure;

public class StubbedBufferedReader implements BufferedReaderWrapper{
    private final String[] data;
    public StubbedBufferedReader(String[] data) {
        this.data = data;
    }
    @Override
    public String[] read() {
        return data;
    }
}
