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
}
