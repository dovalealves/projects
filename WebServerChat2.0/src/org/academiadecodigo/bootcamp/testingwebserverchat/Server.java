package org.academiadecodigo.bootcamp.testingwebserverchat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//TODO program developed during week 6 of a 14 week bootcamp

public class Server {

    private static ServerSocket serverSocket;  //socket for server

    public static final int DEFAULT_PORT = 8080;    // default port number

    private static Socket clientSocket;   //socket for client

    private Vector<Worker> clientList = new Vector<>();  // list of connected clients


    public static void main(String[] args) {

        Server server = new Server();   //instance server


        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);  // create a server socket


            while (true) {
                server.dispatch(serverSocket);  //Accept and handle client connection
                System.out.println("WAITING MESSAGE");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    // dispatches a worker to handle a client connection
    private void dispatch(ServerSocket serverSocket) {

        try {
            //accept a new client connection
            clientSocket = serverSocket.accept();

            //create a thread pool for workers
            ExecutorService cashedPool = Executors.newCachedThreadPool();

            //create a new worker instance for the client connection/socket
            Worker worker = new Worker(clientSocket, clientList);

            // add worker to ArrayList
            clientList.add(worker);

            // Submit the worker to the thread pool for execution
            cashedPool.submit(worker);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
