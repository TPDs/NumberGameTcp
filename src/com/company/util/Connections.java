package com.company.util;

import java.io.*;
import java.net.Socket;

public class Connections {

    Socket server;

    {
        Server.serverSetup();
    }

    DataInputStream in;
    DataOutputStream out;
    ObjectOutputStream objOut;
    ObjectInputStream objIn;

    public Connections(Socket server, DataOutputStream out, DataInputStream in, ObjectOutputStream objOut, ObjectInputStream objIn) throws IOException {
        this.server = server;
        this.out=out;
        this.in = in;
        this.objIn=objIn;
        this.objOut=objOut;
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
