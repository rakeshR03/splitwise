package com.practice.splitwise.commands;

public interface Command {

    public boolean matches(String command);

    public boolean execute(String command);
}
