package com.company;

import com.company.util.Server;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer> serverrolls = new ArrayList<>();
        ArrayList<Integer> playerrolls = new ArrayList<>();
        int total= 0;
        String name = "Michael";
        int serverScore = 10;
        int serverRoll;

        Roll diceroll = new Roll();
        int myroll = diceroll.roll();
        serverRoll=myroll;
        serverrolls.add(myroll);
        User server = new User(name,serverScore,serverRoll);

        for ( int i = 0; i < serverrolls.size();i++) {
            total = total+serverrolls.get(i);

        }

        Server startServer = new Server();


        Battle battle;
        battle = startServer.server(server);
        playerrolls.add(battle.player.getDichroll());

        System.out.println("ServerName: " + battle.server.getName() + "\n Total: "+ battle.server.getScore() + "\n New Roll: " + battle.server.getDichroll());
        System.out.println("--------------------------------------------------");
        System.out.println("PlayerName : " + battle.player.getName() + "\n Total Score: "+ battle.player.getScore() + "\n New Roll: " + battle.player.getDichroll() +"\n");





    }
}
