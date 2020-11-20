package com.company.util;

import java.io.*;
import java.net.Socket;

import com.company.Battle;
import com.company.User;

public class Client {

    final static String serverName = "10.111.179.230"; // Dagens lokal ip på skolen.. TJEK MIG!
    final static int port = 5346;


    public Battle client(User user) throws IOException {

            Socket client = new Socket(serverName, port);

            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            DataInputStream inputStream = new DataInputStream(client.getInputStream());

            outputStream.writeUTF(user.getName());
            outputStream.writeUTF(String.valueOf(user.getScore()));
            outputStream.writeUTF(String.valueOf(user.getDichroll()));

            String serverName = inputStream.readUTF();
            String serverTotalScore = inputStream.readUTF();
            String serverDiceRoll = inputStream.readUTF();

            int serverTotal = Integer.parseInt(serverTotalScore);
            int serverDice = Integer.parseInt(serverDiceRoll);

            User serverUser = new User(serverName, serverTotal, serverDice);
            Battle game = new Battle(serverUser, user);

            client.close();
            return game;

        }
    }