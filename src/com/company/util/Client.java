package com.company.util;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import com.company.Battle;
import com.company.Game;
import com.company.User;

public class Client {

    final static String host = "10.111.179.230"; // Dagens lokal ip på skolen.. TJEK MIG!
    final static int port = 5346;
    public static Socket conn;

    Game game;


    // laves en conn til server socket via host og port med return
    public void clientSetup(String name) throws IOException, ClassNotFoundException {
        conn = new Socket(host, port);
        DataOutputStream out = new DataOutputStream(conn.getOutputStream());
        DataInputStream in = new DataInputStream(conn.getInputStream());
        out.writeUTF(name);
        game.clientRound(conn);


    }

}