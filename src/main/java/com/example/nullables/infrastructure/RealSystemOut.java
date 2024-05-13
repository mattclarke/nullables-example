package com.example.nullables.infrastructure;

public class RealSystemOut implements SystemOutWrapper{
    public <T> void writeStdOut(T output) {
        System.out.println(output);
    }
}
