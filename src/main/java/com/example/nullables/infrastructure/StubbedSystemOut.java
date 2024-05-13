package com.example.nullables.infrastructure;

import java.util.ArrayList;
import java.util.List;

public class StubbedSystemOut implements SystemOutWrapper{
    private final List<String> outputTracker;

    public StubbedSystemOut(List<String> tracker) {
        outputTracker = tracker;
    }
    @Override
    public <T> void writeStdOut(T output) {
        String asString = output.toString();
        if (outputTracker != null) {
            outputTracker.add(asString);
        }
    }
}
