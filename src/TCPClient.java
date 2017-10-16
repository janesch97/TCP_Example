import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by tomek on 16.10.2017..
 */
public class TCPClient {

    public static void main(String []args) throws Exception{

        TCPClient tcpClient = new TCPClient();
        tcpClient.run();
    }

    public void run() throws Exception{

        Socket socket = new Socket("localhost", 5000);

        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        PrintStream printStream = new PrintStream(socket.getOutputStream());
        printStream.println(message);

        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String fromServ = bufferedReader.readLine();
        System.out.println(fromServ);
    }
}
