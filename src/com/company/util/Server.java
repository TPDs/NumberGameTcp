package com.company.util;

import com.company.Battle;
import com.company.User;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket serverSocket;
    // final static String host = "5.103.132.221";
    final static String host = "192.168.1.6";

    final static int port = 5346;
    private static Connections conn;

    public Battle server(User user) throws IOException {

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

    public static Connections serverSetup() throws IOException {
       if (conn!=null) return conn;
        InetAddress address = InetAddress.getByName(host);

        serverSocket = new ServerSocket(port,100,address);
        Socket socket = serverSocket.accept();
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        conn.setServer(socket);
        conn.setIn(inputStream);
        conn.setOut(outputStream);
        conn.setObjIn(objectInputStream);
        conn.setObjOut(objectOutputStream);
        return conn;
    }

}
