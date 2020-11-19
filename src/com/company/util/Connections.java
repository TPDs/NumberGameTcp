package com.company.util;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connections {

    Socket server;

    {
        Server.serverSetup();
    }

    DataInputStream in;
    DataOutputStream out;

    public Connections(Socket server, DataOutputStream out, DataInputStream in) throws IOException {
        this.server = server;
        this.out=out;
        this.in = in;
    }

    public Connections() throws IOException {
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
