package com.example.nullables;

import com.example.nullables.infrastructure.Console;
import com.example.nullables.infrastructure.DataFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;


public class SmokeTest {
    @Test
    public void basicSmokeTest() throws IOException {
        // Basic nullable test that checks everything works together
        // Don't need much more than this test.
        var dataFile = DataFile.createNull(new String[]{"1 2", "2 6", "6 7"});
        var tracker = new ArrayList<String>();
        var console = Console.createNull(tracker);

        var app = new App(dataFile, console);
        app.run();

        Assertions.assertEquals("4", tracker.get(0));
    }
}
