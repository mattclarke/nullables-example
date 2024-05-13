package com.example.nullables;

import com.example.nullables.infrastructure.Console;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

public class ConsoleTest {
    // How much value is there in testing the nullables?
    // It depends!
    // It is production code after all...
    @Test
    public void nullableConsoleDoesNotWriteToSysOut() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream outPrintStream = new PrintStream(byteArrayOutputStream);
        PrintStream originalOutStream = System.out;
        System.setOut(outPrintStream);

        var console = Console.createNull(new ArrayList<>());
        console.writeStdOut("hello");
        console.writeStdOut("goodbye");

        // Put it back!
        System.setOut(originalOutStream);

        Assertions.assertEquals("", byteArrayOutputStream.toString());
    }

    @Test
    public void nullableConsoleTracksOutput() {
        ArrayList<String> tracker = new ArrayList<>();
        var console = Console.createNull(tracker);
        console.writeStdOut("hello");
        console.writeStdOut("goodbye");

        Assertions.assertArrayEquals(tracker.toArray(new String[0]), new String[]{"hello", "goodbye"});
    }

    @Test
    public void consoleWritesToSysOut() {
        // Integration test
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream outPrintStream = new PrintStream(byteArrayOutputStream);
        PrintStream originalOutStream = System.out;
        System.setOut(outPrintStream);

        var console = Console.create();
        console.writeStdOut("hello");
        console.writeStdOut("goodbye");

        // Put it back!
        System.setOut(originalOutStream);

        Assertions.assertEquals("hello\ngoodbye\n", byteArrayOutputStream.toString());
    }
}
