package com.example.nullables.infrastructure;

public interface SystemOutWrapper {
    public <T> void writeStdOut(T output);
}
