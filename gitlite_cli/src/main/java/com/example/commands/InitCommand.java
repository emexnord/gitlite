package com.example.commands;

import java.io.File;
import java.io.IOException;

public class InitCommand implements Command {

    @Override
    public void execute() throws IOException {
        File gitLite = new File(".gitlite");
        if (gitLite.exists()) {
            System.out.println("Repository already initialized.");
            return;
        }

        // Create core directories
        new File(gitLite, "staging").mkdirs();
        new File(gitLite, "commits").mkdirs();

        // Create commits log
        new File(gitLite, "log.txt").createNewFile();

        System.out.println("Initialized empty repository in .gitlite/");
    }
}
