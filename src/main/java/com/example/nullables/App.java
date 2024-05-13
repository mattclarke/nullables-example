package com.example.nullables;

import com.example.nullables.infrastructure.Console;
import com.example.nullables.infrastructure.DataFile;
import com.example.nullables.logic.PairsAnalyser;

import java.io.IOException;

public class App {
    private final DataFile dataFile;
    private final Console console;
    public App() {
        this(DataFile.create("data.dat"), Console.create());
    }

    public App(DataFile dataFile, Console console) {
        this.dataFile = dataFile;
        this.console = console;
    }

    public void run() throws IOException {
        String[] input = dataFile.readFile();
        PairsAnalyser analyser = new PairsAnalyser(input);
        console.writeStdOut(analyser.getBiggestDiff());
    }

    public static void main(String[] args) {
        try {
            App app = new App();
            app.run();
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}
