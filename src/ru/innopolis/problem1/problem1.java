package com.company;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String log = "*Logs*";

        System.out.print("Input file access, f for false, t for true: ");

        int i = 0;
        while(i != 1){
            boolean access;
            Scanner scanner = new Scanner(System.in);
            String a = scanner.nextLine();
            if (Objects.equals(a, "t")) {
                access = true;
            } else access = false;

            FileHandler fileHandler = new FileHandler(null, access);
            ConsoleHandler consoleHandler = new ConsoleHandler(fileHandler, true);
            consoleHandler.Chain(log);

            System.out.print("\nInput new file access: ");
        }




    }
}

    abstract class Handler{
        Handler successor = null;

        boolean permission = false;

        boolean access = false;

        public Handler(Handler successor, boolean permission) {
            this.successor = successor;
            this.permission = permission;
        }

        void Chain(String log){
            DoRequest(permission);
            if(permission) Print(log);
            else System.out.println("Permission to file has been denied");
            if(successor != null) successor.Chain(log);
        }

        boolean DoRequest(boolean permission){
            if(permission) access = true;
            return access;
        }

        void Print(String log){
        }

    }

    class FileHandler extends Handler{

        public FileHandler(Handler successor, boolean permission) {
            super(successor, permission);
        }


        @Override
        void Print(String log){
            System.out.println("*Wrote logs to file*");
        }

    }

    class ConsoleHandler extends Handler{

        public ConsoleHandler(Handler successor, boolean permission) {
            super(successor, permission);
        }


        @Override
        void Print(String log){
            System.out.println("\n" + log);
        }
    }


