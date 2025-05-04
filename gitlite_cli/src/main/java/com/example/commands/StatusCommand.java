package com.example.commands;

import java.io.File;

import com.example.constants.AnsiColors;

public class StatusCommand implements Command {

    @Override
    public void execute() {

        File stagingDir = new File(".vcs/staging");
        File[] files = stagingDir.listFiles();

        System.out.println("Staged files:");
        if (files == null || files.length == 0) {
            System.out.println("  (none)");
            return;
        }

        for (File file : files) {
            System.out.println("  " + AnsiColors.GREEN + file.getName() + AnsiColors.RESET);
        }

        System.out.println("\nUntracked files:");
        File currentDir = new File(".");
        File[] allFiles = currentDir.listFiles(file -> !file.getName().equals(".vcs") && // exclude .vcs
                !file.isDirectory() // exclude directories for simplicity
        );

        boolean hasUntracked = false;
        if (allFiles != null) {
            for (File file : allFiles) {
                File stagedFile = new File(".vcs/staging", file.getName());
                if (!stagedFile.exists()) {
                    System.out.println("  " + AnsiColors.RED + file.getName() + AnsiColors.RESET);
                    hasUntracked = true;
                }
            }
        }

        if (!hasUntracked) {
            System.out.println("  (none)");
        }

    }
}
