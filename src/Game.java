import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Game {
    Socket clientSocket;
    private DataInputStream dis;
    private DataOutputStream dos;

    public Game(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        dis = new DataInputStream(clientSocket.getInputStream());
        dos = new DataOutputStream(clientSocket.getOutputStream());
    }

    public void startGame() throws IOException{
        byte header;
        boolean gameEnded = false;

        while (!gameEnded){

            header = dis.readByte();
            System.out.println("------------" + header);

            switch (header){
                case 0x01:
                    System.out.println("New Game Created");

                    int whoBegins = 1;

                    dos.writeByte(0x01);
                    dos.writeInt(whoBegins);

                    if(whoBegins == 1) {
                        dos.writeByte(0x02);
                        dos.writeInt(1);
                        dos.writeInt(1);
                    }
                    break;

                case 0x02:
                    int cord1 = dis.readInt();
                    int cord2 = dis.readInt();

                    break;
                default:
                    System.out.println("Header not valid");
            }
        }
        clientSocket.close();
    }
}
