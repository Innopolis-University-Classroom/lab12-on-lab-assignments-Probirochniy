package com.company;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int stocks = 100;
        Scanner scanner = new Scanner(System.in);
        int i = 1;

        CommandHistory history = new CommandHistory();


        while(i != 0) {
            System.out.print("You have " + stocks + " stocks! Print s to sell or b to buy. h - to show history: ");
            String a = scanner.nextLine();
            Command buttons = new Command(stocks);
            switch (a){
                case ("s"):
                    stocks = buttons.Sell();
                    history.Push(buttons);
                    break;

                case ("b"):
                    stocks = buttons.Buy();
                    history.Push(buttons);
                    break;

                case ("h"):
                    history.ShowHistory();
                    System.out.println();
                    break;


            }

        }
    }

}

class Command{
    int stocks = 0;

    String command;

    Command(int stocks){
        this.stocks = stocks;
    }

    int Buy(){
        stocks += 1;
        command = "buy";
        return stocks;
    }

    int Sell(){
        stocks -= 1;
        command = "sell";
        return stocks;
    }


}


class CommandHistory{
    ArrayList<Command> history = new ArrayList<>();

    void Push(Command c){
        history.add(c);
    }

    void ShowHistory(){
        for(int i = 0; i < history.size(); i++){
            System.out.print(history.get(i).command + "-");
        }
    }

}
