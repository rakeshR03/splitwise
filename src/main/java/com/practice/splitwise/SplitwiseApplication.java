package com.practice.splitwise;

import com.practice.splitwise.commands.CommandRegistry;
import com.practice.splitwise.commands.RegisterUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        CommandRegistry registry = new CommandRegistry();
        registry.register(new RegisterUser());

//        while(true){
//            Scanner sc = new Scanner(System.in);
//            String input1 = sc.nextLine();
//
//            try{
//                registry.execute(input1);
//            }catch(RuntimeException e){
//                System.out.println("Command not valid");
//            }
//        }
    }
}
