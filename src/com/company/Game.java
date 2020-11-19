package com.company;

import com.company.util.Connections;
import com.company.util.Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    ArrayList<Integer> player1Rolls = new ArrayList<>();
    ArrayList<Integer> player2Rolls = new ArrayList<>();
    Connections connection;

    public void startGame() throws IOException {

        System.out.println("\n" +
                " .----------------. .----------------. .----------------. .----------------.   .----------------. .-----------------.\n"  +
                "| .--------------. | .--------------. | .--------------. | .--------------. | | .--------------. | .--------------. |\n" +
                "| |  ________    | | |     _____    | | |     ______   | | |  _________   | | | |     ____     | | | ____  _____  | |\n" +
                "| | |_   ___ `.  | | |    |_   _|   | | |   .' ___  |  | | | |_   ___  |  | | | |   .'    `.   | | ||_   \\|_   _| | |\n" +
                "| |   | |   `. \\ | | |      | |     | | |  / .'   \\_|  | | |   | |_  \\_|  | | | |  /  .--.  \\  | | |  |   \\ | |   | |\n" +
                "| |   | |    | | | | |      | |     | | |  | |         | | |   |  _|  _   | | | |  | |    | |  | | |  | |\\ \\| |   | |\n" +
                "| |  _| |___.' / | | |     _| |_    | | |  \\ `.___.'\\  | | |  _| |___/ |  | | | |  \\  `--'  /  | | | _| |_\\   |_  | |\n" +
                "| | |________.'  | | |    |_____|   | | |   `._____.'  | | | |_________|  | | | |   `.____.'   | | ||_____|\\____| | |\n" +
                "| |              | | |              | | |              | | |              | | | |              | | |              | |\n" +
                "| '--------------' | '--------------' | '--------------' | '--------------' | | '--------------' | '--------------' |\n" +
                " '----------------' '----------------' '----------------' '----------------'   '----------------' '----------------' \n" +
                "\n" +
                "\n" +
                "By Michael Petersen & That guy");

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n Type in player's name... \n");
        String player1 = scanner.next();
        System.out.println("Welcome " + player1 +"\n");
        System.out.println("\nWaiting on client to connect..");
        connection  = Server.serverSetup();
        String player2 = connection.getIn().readUTF();
        System.out.println(player2 + " has connected");

    }


}
