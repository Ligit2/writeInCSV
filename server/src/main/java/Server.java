import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            Socket accept = serverSocket.accept();
            System.out.println("Client connected");
            InputStream inputStream = accept.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Gson gson = new Gson();
            List<String> strings = (ArrayList<String>) objectInputStream.readObject();
            List<Person> people = new ArrayList<>();
            strings.forEach(each -> people.add(gson.fromJson(each, Person.class)));
            CSVFileWriter.writeCsvFile("users.csv", people);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
