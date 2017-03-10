import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by amber on 2/9/17.
 */
public class Main {
    public static ArrayList<Post> readFile() {
        ArrayList<Post> posts = new ArrayFile<>();

        //read all posts
        File f = new File("posts.txt");
        Scanner scanner = new Scanner(f);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] columns = line.split("\\|");
            Post post = new Post(Integer.parseInt(columns[0]), columns[1], columns[2]);
            posts.add(post);
        }

        Scanner consoleScanner = new Scanner(System.in);

        int replyID = -1;
        while (true) {
            //loop over post and print the ones with the correctreply id
            int id = 0;
            for (Post post : posts) {
                if (replyID == post.replyId) {
                    System.out.printf("(%d) %s by %s\n", id, post.text, post.author);

                }
                id++;
            }
            //ask the user to enter a new reply id
            System.out.println("please type to id ou wan to see replies to:");
            replyID = Integer.parseInt(consoleScanner.nextLine());
        }
    }
}
//for tonights homework he wants us to use
// Hashmap<String, ArrayList<Obj>>
// to add to git, in Terminal, git add *.txt src/