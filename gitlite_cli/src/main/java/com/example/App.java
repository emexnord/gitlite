package com.example;

import com.example.commands.AddCommand;
import com.example.commands.Command;
import com.example.commands.CommitCommand;
import com.example.commands.InitCommand;
import com.example.commands.LogCommand;
import com.example.commands.StatusCommand;

public class App {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            System.out.println("Usage: gitlite <command> [options]");
            return;
        }

        Command cmd = switch (args[0]) {
            case "init" -> new InitCommand();
            case "add" -> new AddCommand(args[1]);
            case "commit" -> new CommitCommand(args[1]);
            case "log" -> new LogCommand();
            case "status" -> new StatusCommand();
            default -> {
                System.out.println("Unknown command.");
                yield null;
            }
        };
        if (cmd != null)
            cmd.execute();
    }
}
