package com.company;

import com.company.util.Client;
import com.company.util.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Game {

    Roll roll;

    //Server opretter et game
    public void startGame() throws IOException {
        System.out.println("\nWaiting on client to connect..");
        Server.serverSetup();
    }

    //Metode for at joine et game
    public void joinGame() throws IOException, ClassNotFoundException {
        Client player2 = new Client();
        String name;
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nType in the player's name: ");
        name = scanner.next();
        scanner.close();
        player2.clientSetup(name);
    }

    public Battle gameRound(Battle game) {
        game.server.setDichroll(roll.roll());
        String roundInfo;
        game.setGameRound(game.getGameRound() + 1);
        if (game.server.getDichroll() > game.player.getDichroll()) {
            game.server.setScore(game.server.getScore() + game.server.getDichroll() - game.player.getDichroll());
            roundInfo = "Game server have won the round with a " + game.server.getDichroll() +
                    " (" + game.player.getName() + " had a " + game.player.getDichroll() + ")";
            System.out.println(roundInfo);
            game.setRoundInfo(roundInfo);
            return game;
        }
        if (game.server.getDichroll() < game.player.getDichroll()) {
            game.player.setScore(game.player.getScore() + game.player.getDichroll() - game.server.getDichroll());
            roundInfo = game.player.getName() + " have won the round with a " + game.player.getDichroll() +
                    " (Game server had a " + game.server.getDichroll();
        } else {
            roundInfo = "Draw round, both has rolled a " + game.server.getDichroll();
        }
        System.out.println(roundInfo);
        game.setRoundInfo(roundInfo);
        return game;
    }

    public void clientRound(Socket client) throws IOException, ClassNotFoundException {
        ObjectInputStream objIn = new ObjectInputStream(client.getInputStream());
        Battle battlegame = (Battle) objIn.readObject(); //Skal sendes fra server!
        int clientRoll=0;

        Scanner scanner = new Scanner(System.in);
        while (battlegame.getPlayer().getScore() < 100 && battlegame.getServer().getScore() < 100) {
            System.out.println("Please make your roll..\n\n");
            System.out.println("Press 1 to roll");
            scanner.nextInt();
            int input =0;

            while (input !=1) {
                // Tjek om scanner virker efter forkert input.
                if (scanner.nextInt() == 1) {
                    input=1;
                    clientRoll = roll.roll();
                    System.out.println("You have rolled a " + clientRoll);
                }
                else System.out.println("Wrong input, try again");
            }
            if (clientRoll <= 2){
                System.out.println("Wanna cheat? yes or no");
                String cheat = scanner.nextLine();
                switch (cheat) {
                    case "yes" -> {
                        battlegame.getPlayer().setDichroll(6);
                        System.out.println("Roll changed to 6, Winner Winner Chicken dinner!");
                    }
                    case "no" -> battlegame.getPlayer().setDichroll(clientRoll);

                }
            }

            client.getOutputStream().write(battlegame.getPlayer().getDichroll());
            battlegame = (Battle) objIn.readObject();
            printScore(battlegame);


        }
        if (battlegame.getServer().getScore()>=100) {
            winner(battlegame.getServer());


        }
        else winner(battlegame.getPlayer());

    }

    public void printScore(Battle game) {
        System.out.println("(*(*(*(*(*(*(*(*(*  " + game.getGameRound() + "   *)*)*)*)*)*)*)*)*)\n\n\n");
        System.out.println("ServerName: " + game.server.getName() + "\n Total: " + game.server.getScore() + "\n New Roll: " + game.server.getDichroll());
        System.out.println("--------------------------------------------------");
        System.out.println("PlayerName : " + game.player.getName() + "\n Total Score: " + game.player.getScore() + "\n New Roll: " + game.player.getDichroll() + "\n");

    }

    public void winner(User user) {
        if (user.getScore() == 100) {
            System.out.println("The winner of the Ultimate Dice Game is " + user.getName());
        }
    }

}
