package com.example.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.UUID;

public class CommitCommand implements Command {
    private final String message;

    public CommitCommand(String message) {
        this.message = message;
    }

    @Override
    public void execute() throws IOException {
        File stagingDir = new File(".vcs/staging");
        File[] files = stagingDir.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files to commit.");
            return;
        }

        String commitId = UUID.randomUUID().toString();
        File commitDir = new File(".vcs/commits", commitId);
        commitDir.mkdirs();

        for (File file : files) {
            Files.copy(file.toPath(), new File(commitDir, file.getName()).toPath());
        }

        // Save commit message
        String logEntry = commitId + ": " + message + "\n";
        Files.write(Paths.get(".vcs/log.txt"), logEntry.getBytes(), StandardOpenOption.APPEND);

        // Clear staging
        for (File file : files)
            file.delete();

        System.out.println("Committed with ID: " + commitId);
    }
}
