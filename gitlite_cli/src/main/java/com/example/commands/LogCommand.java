package com.example.commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LogCommand implements Command {

    @Override
    public void execute() throws IOException {
        Path logPath = Paths.get(".vcs/log.txt");
        if (!Files.exists(logPath)) {
            System.out.println("No commits yet.");
            return;
        }

        List<String> logs = Files.readAllLines(logPath);
        for (int i = logs.size() - 1; i >= 0; i--) {
            System.out.println(logs.get(i));
        }
    }
}
