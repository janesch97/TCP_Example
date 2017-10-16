import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by tomek on 16.10.2017..
 */
public class TCPServ {

    public static void main(String []args) throws Exception{

        TCPServ tcpServ = new TCPServ();
        tcpServ.run();
    }

    public void run() throws Exception{

        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = serverSocket.accept();

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String message = bufferedReader.readLine();
        System.out.println(message);

        String modifiedMessage = message.toUpperCase();

        if(message != null){
            PrintStream printStream = new PrintStream(socket.getOutputStream());
            printStream.println(modifiedMessage);
        }
    }
}
