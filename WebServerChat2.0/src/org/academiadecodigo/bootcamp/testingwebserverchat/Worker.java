package org.academiadecodigo.bootcamp.testingwebserverchat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class Worker implements Runnable {


    private Socket clientSocket;
    private Vector<Worker> clientList;

    public Worker(Socket clientSocket, Vector<Worker> clientList) {

        this.clientSocket = clientSocket;
        this.clientList = clientList;

    }
    @Override
    public void run () {


        while(true){

            BufferedReader in = null;

            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            String message = null;
            try {
                message = in.readLine();  //read message from client
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.println("NEW MESSAGE: " + message);

            // send the message to all other connected clients
            for (int i = 0; i < clientList.size(); i++) {

                if(clientList.get(i) == this){
                    continue;  //skip sending message to sender/self

                }
                clientList.get(i).send(message);

            }




        }


    }
    
    private void send (String message){

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            //send message to the client
            out.println(clientSocket.getInetAddress().getHostAddress() + " " + message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

