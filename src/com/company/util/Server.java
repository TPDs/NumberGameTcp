package com.company.util;

import com.company.Battle;
import com.company.User;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
// 10.111.176.1 5346


    public Battle server(User user) throws IOException {
        String host = "10.111.179.230";
        int port = 5346;
        InetAddress address = InetAddress.getByName(host);
        serverSocket = new ServerSocket(port,100,address);

        System.out.println("Server is live \n\n");
        Socket server = serverSocket.accept();
        DataInputStream in = new DataInputStream(server.getInputStream());
        DataOutputStream out = new DataOutputStream(server.getOutputStream());
        String player = in.readUTF();
        String totalscore = in.readUTF();
        String diceroll = in.readUTF();

        int playerTotalScore = Integer.parseInt(totalscore);
        int playerDiceRoll = Integer.parseInt(diceroll);
        User playerToReturn = new User(player,playerTotalScore,playerDiceRoll);

        out.writeUTF(user.getName());
        out.writeUTF(String.valueOf(user.getScore()));
        out.writeUTF(String.valueOf(user.getDichroll()));

        Battle game = new Battle(user,playerToReturn);

        server.close();
        return game;
    }
}
