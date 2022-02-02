import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private final static int PORT = 5001;

    public static void main(String[] args) {

        try {
            //Socket de servidor para esperar peticiones de la red
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Servidor> Servidor iniciado");
            System.out.println("Servidor> En espera de cliente...");

            //Socket de cliente
            Socket clientSocket;

            while(true){
                //en espera de conexion, si existe la acepta
                clientSocket = serverSocket.accept();
                System.out.println("Client connected with address " + clientSocket.getInetAddress());
                Game game = new Game(clientSocket);
                game.startGame();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
