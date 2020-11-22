package com.company.util;

import com.company.Battle;
import com.company.Game;
import com.company.User;

import java.io.*;
import java.net.Socket;

public class Connections extends Thread {

    Socket server;

    {
        Server.serverSetup();
    }

    DataInputStream in;
    DataOutputStream out;
    ObjectOutputStream objOut;
    ObjectInputStream objIn;
    Game game;

    public Connections(Socket server, DataOutputStream out, DataInputStream in, ObjectOutputStream objOut,
                       ObjectInputStream objIn) throws IOException {
        this.server = server;
        this.out = out;
        this.in = in;
        this.objIn = objIn;
        this.objOut = objOut;
    }

    @Override
    public void run() {
        System.out.println("Thread made");
        String player2;
        try {
            player2 = getIn().readUTF();
            System.out.println(player2 + " has connected");
            String player1 = "ServerMasterRace";
            System.out.println("Welcome " + player1 + "\n");
            User user1 = new User(player1, 0, 0);
            User user2 = new User(player2, 0, 0);
            Battle battleGame = new Battle(user1, user2);

            while (user2.getScore() < 100 && user1.getScore() < 100) {
                System.out.println("waiting for player2 roll");
                user2.setDichroll(in.readInt());
                game.gameRound(battleGame);
                battleGame.getPlayer().setDichroll(in.readInt());
                //getOut().writeUTF(battleGame.getRoundInfo());
                objOut.writeObject(battleGame);
                game.printScore(battleGame);
            }
            if (user1.getScore() > 100) {
                game.winner(battleGame.getServer());
                closeGame();
                // Play again method?
            } else
                game.winner(battleGame.getPlayer());
            closeGame();
            // Play again method?
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void closeGame() throws IOException {
        in.close();
        out.close();
        objOut.close();
        objIn.close();
        server.close();

    }


    public Connections() throws IOException {
    }

    public ObjectOutputStream getObjOut() {
        return objOut;
    }

    public void setObjOut(ObjectOutputStream objOut) {
        this.objOut = objOut;
    }

    public ObjectInputStream getObjIn() {
        return objIn;
    }

    public void setObjIn(ObjectInputStream objIn) {
        this.objIn = objIn;
    }

    public Socket getServer() {
        return server;
    }

    public void setServer(Socket server) {
        this.server = server;
    }

    public DataInputStream getIn() {
        return in;
    }

    public void setIn(DataInputStream in) {
        this.in = in;
    }

    public DataOutputStream getOut() {
        return out;
    }

    public void setOut(DataOutputStream out) {
        this.out = out;
    }
}
