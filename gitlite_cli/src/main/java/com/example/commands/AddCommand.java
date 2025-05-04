package com.example.commands;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class AddCommand implements Command {
    private final String filePath;

    public AddCommand(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void execute() throws IOException {
        File source = new File(filePath);
        File dest = new File(".vcs/staging", source.getName());

        if (!source.exists()) {
            System.out.println("File not found: " + filePath);
            return;
        }

        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Added " + filePath);
    }
}
