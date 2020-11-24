package com.company.util;

import com.company.Battle;
import com.company.User;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server  {
    final static String host = "192.168.1.6";
    final static int port = 5346;
    static Socket socket;
    static Vector<Connections> ar = new Vector<>();
    private static ServerSocket serverSocket;
    private static Connections conn = null;

    // Start server med host og port til et socket.
    public static void serverSetup() throws IOException {
        if (conn == null) {
            InetAddress address = InetAddress.getByName(host);
            serverSocket = new ServerSocket(port, 100, address);
        }

        while (true) {
            System.out.println("0");
            socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("accepted");
               // DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                System.out.println("0");
             //   DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("0");
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                System.out.println("2");
                Connections clientT = new Connections(socket, objectOutputStream, objectInputStream);
               // Connections clientT = new Connections(socket, outputStream, inputStream, objectOutputStream, objectInputStream);
                // Connections clientT = new Connections(socket, inputStream,outputStream , objectOutputStream);
                Thread t = new Thread(clientT);
                ar.add(clientT);
                System.out.println(ar.size() + 1 + " client(s) is connected");
                t.start();
            } catch (Exception E) {
                assert socket != null;
                socket.close();
                System.out.println("Connection closed..");
            }


        }


    }

    public Battle server(User user) throws IOException {

        InetAddress address = InetAddress.getByName(host);
        serverSocket = new ServerSocket(port, 100, address);

        System.out.println("Server is live \n\n");

        Socket server = serverSocket.accept();
        DataInputStream in = new DataInputStream(server.getInputStream());
        DataOutputStream out = new DataOutputStream(server.getOutputStream());

        String player = in.readUTF();
        String totalscore = in.readUTF();
        String diceroll = in.readUTF();


        int playerTotalScore = Integer.parseInt(totalscore);
        int playerDiceRoll = Integer.parseInt(diceroll);
        User playerToReturn = new User(player, playerTotalScore, playerDiceRoll);

        out.writeUTF(user.getName());
        out.writeUTF(String.valueOf(user.getScore()));
        out.writeUTF(String.valueOf(user.getDichroll()));

        Battle game = new Battle(user, playerToReturn);

        server.close();
        return game;
    }
}

