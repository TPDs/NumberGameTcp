package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) throws IOException {

        Game game = new Game();
        System.out.println("\n" + ANSI_YELLOW +
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
                ANSI_RED + "By Michael Petersen & Christian Haugaard" + ANSI_RESET);

        System.out.println("\nTast 1 for Server \n\nTast 2 for spiller \n");
        System.out.print("Input: ");
        Scanner sc = new Scanner(System.in);
        switch (sc.nextInt()) {
            case 1 -> game.startGame();
            case 2 -> game.joinGame();
        }

        /*
        User server = new User(name,serverScore,serverRoll);

        Server startServer = new Server();

        Battle battle;
        battle = startServer.server(server);
        playerrolls.add(battle.player.getDichroll());

        System.out.println("ServerName: " + battle.server.getName() + "\n Total: "+ battle.server.getScore() + "\n New Roll: " + battle.server.getDichroll());
        System.out.println("--------------------------------------------------");
        System.out.println("PlayerName : " + battle.player.getName() + "\n Total Score: "+ battle.player.getScore() + "\n New Roll: " + battle.player.getDichroll() +"\n");
*/
    }
}
