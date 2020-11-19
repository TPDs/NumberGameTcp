package com.company;

import com.company.util.Connections;
import com.company.util.Server;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = new Game();
        game.startGame();
        Connections connection = Server.serverSetup();




      //  User server = new User(name,serverScore,serverRoll);


/*
        Server startServer = new Server();

        Battle battle;
        battle = startServer.server(server);
        playerrolls.add(battle.player.getDichroll());

        System.out.println("ServerName: " + battle.server.getName() + "\n Total: "+ battle.server.getScore() + "\n New Roll: " + battle.server.getDichroll());
        System.out.println("--------------------------------------------------");
        System.out.println("PlayerName : " + battle.player.getName() + "\n Total Score: "+ battle.player.getScore() + "\n New Roll: " + battle.player.getDichroll() +"\n");
*/
       connection.getIn().readUTF();
       connection.getOut().writeUTF("hej");







    }
}
