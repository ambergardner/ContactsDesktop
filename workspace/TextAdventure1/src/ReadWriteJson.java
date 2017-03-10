import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ReadWriteJson {
    public static void main(String[] args) throws IOException {
        Person p = new Person();
        p.name = "Alice Smith";
        p.age = 38;

        File f = new File("person.json");

        // write json
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(p);
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();

        // read json
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();
        s.close();
        JsonParser parser = new JsonParser();
        Person p2 = parser.parse(contents, Person.class);

        System.out.println(p2);
    }
}
