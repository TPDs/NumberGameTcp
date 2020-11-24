package com.company.util;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import com.company.Battle;
import com.company.Game;
import com.company.User;

public class Client {

    final static String host = "10.111.180.76"; // Dagens lokal ip på skolen.. TJEK MIG!
    final static int port = 5346;
    public static Socket conn;

    //Game game;


    // laves en conn til server socket via host og port med return
    public void clientSetup(String name) throws IOException, ClassNotFoundException, InterruptedException {
        conn = new Socket(host, port);
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        DataInputStream in = new DataInputStream(conn.getInputStream());
        System.out.println(in.readUTF());
        out.writeUTF(name);
        Game game = new Game();
        game.clientRound(conn);
    }

}