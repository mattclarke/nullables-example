package com.example.nullables.infrastructure;

import java.util.List;
import java.util.function.Function;

public class Console {
    private final SystemOutWrapper systemOutWrapper;

    public Console() {
        this(new RealSystemOut());
    }

    public Console(SystemOutWrapper systemOutWrapper) {
        this.systemOutWrapper = systemOutWrapper;
    }
    public <T> void writeStdOut(T output) {
        systemOutWrapper.writeStdOut(output);
    }

    public static Console create() {
        return new Console();
    }

    public static Console createNull(List<String> tracker) {
        return new Console(new StubbedSystemOut(tracker));
    }

    // Nullables

    public interface SystemOutWrapper {
        public <T> void writeStdOut(T output);
    }

    private static class RealSystemOut implements SystemOutWrapper{
        public <T> void writeStdOut(T output) {
            System.out.println(output);
        }
    }

    private static class StubbedSystemOut implements SystemOutWrapper{
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
}
