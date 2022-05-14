package com.practice.splitwise.commands;

import java.util.HashSet;
import java.util.Set;

public class CommandRegistry {

    private Set<Command> commands = new HashSet<>();

    public void register(Command command){
        commands.add(command);
    }

    public void deRegister(Command command){
        commands.remove(command);
    }

    public void execute(String incomingCommand){
        for(Command command : commands){
            if(command.matches(incomingCommand)){
                command.execute(incomingCommand);
            }

        }
        throw new RuntimeException("no command found");
    }
}
