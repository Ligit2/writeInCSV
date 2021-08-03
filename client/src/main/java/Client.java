import com.google.gson.Gson;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Person> personList = GeneratePerson.generatePersonList();
        Gson gson = new Gson();
        try (Socket socket = new Socket("localhost", 8080);
             OutputStream outputStream = socket.getOutputStream()) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            ArrayList<String> strings = new ArrayList<>();
            personList.forEach(each -> {
                String json = gson.toJson(each, Person.class);
                strings.add(json);
            });
            objectOutputStream.writeObject(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
