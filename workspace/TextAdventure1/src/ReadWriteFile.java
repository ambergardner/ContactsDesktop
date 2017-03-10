import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class ReadWriteFile {
    public static void main(String[] args) throws IOException {
        File f = new File("names.txt");
        FileWriter fw = new FileWriter(f);
        fw.write("Alice\n");
        fw.write("Bob\n");
        fw.write("Charlie\n");
        fw.close();

        // read line by line
        Scanner scanner = new Scanner(f);
        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();


        // read the entire file
        scanner = new Scanner(f);
        scanner.useDelimiter("\\Z"); // end of file marker
        String contents = scanner.next();
        System.out.println( contents );
        scanner.close();
    }
}
