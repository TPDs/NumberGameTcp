package com.company;

import com.company.util.Connections;
import com.company.util.Server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    ArrayList<User> player1Rolls = new ArrayList<>();
    ArrayList<User> player2Rolls = new ArrayList<>();
    Connections connection;

    public void startGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nType in player's name... \n");
        String player1 = scanner.next();
        System.out.println("Welcome " + player1 +"\n");
        System.out.println("\nWaiting on client to connect..");
        connection  = Server.serverSetup();
        String player2 = connection.getIn().readUTF();
        System.out.println(player2 + " has connected");
        User user1 = new User(player1,0,0);
        User user2 = new User(player2,0,0);
        player1Rolls.add(user1);
        player2Rolls.add(user2);
    }

    public void joinGame(){
        //Metode for at joine et game
    }


}
