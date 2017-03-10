
import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;


public class Main {

    static HashMap<String, User> users = new HashMap<>();
    static ArrayList<Message> messages = new ArrayList<>();

    public static void main(String[] args) {
        addTestUser();
        addTestMessages();
        Spark.init();

        Spark.post("/create-message", (request, response) -> {
            String text = request.queryParams("messageText");
            String replyId = request.queryParams("replyId");
            if ( text == null || replyId == null) {
                throw new Exception("Did not get necessary query parameters.");
            }
            Session session = request.session();
            String userName = session.attribute("userName");
            if (userName == null){
                session.attribute("errorMsg", "No user is logging in");
            }
            else if (text.isEmpty() && userName != null) {
                session.attribute("errorMsg", "Missing inputs");
            }

            //message(int id, int replyId, String author, String text)
            if  ( (! text.isEmpty()) && userName != null) {
                int replyIdNum = Integer.valueOf(replyId);
                Message m = new Message(messages.size(), replyIdNum, userName, text);
                messages.add(m);
            }
            response.redirect(request.headers("Referer"));
            return "";
        } );

        Spark.post("/login", (request, response) -> {
            String userName = request.queryParams("loginName");
            if (userName == null) {
                throw new Exception("Login name not found.");
            }
            User user = users.get(userName);
            if (user == null) {
                user = new User(userName);
                users.put(userName, user);
            }
            Session session = request.session();
            session.attribute("userName", userName);

            response.redirect("/");
            return "";
        });
        Spark.post("/logout", (request, response) -> {
            Session session = request.session();
            session.invalidate();
            response.redirect("/");
            return "";
        });


        Spark.get("/", (request, response) -> {
                    String replyId = request.queryParams("replyId");
//                    int replyIdNum = -1;
//                    if (replyId != null) {
//                        replyIdNum = Integer.valueOf(replyId);
//                    }
                    int replyIdNum = (replyId != null) ? Integer.valueOf(replyId) : -1;
                    HashMap m = new HashMap();
                    ArrayList<Message> threads = new ArrayList<Message>();
                    for (Message message : messages) {
                        if (message.replyId == replyIdNum) {
                            threads.add(message);
                        }
                    }


                    // threads = (ArrayList<Message>) messages.stream().filter((msg) -> msg.replyId == -1);

                    Session session = request.session();
                    String userName = session.attribute("userName");

                    m.put("userName", userName);
                    m.put("messages", threads);
                    m.put("replyId", replyId);
                    return new ModelAndView(m, "home.html");
                },
                new MustacheTemplateEngine()
        );
    }

    static void addTestUser() {

        addUser("Alice");
        addUser("Bob");
        addUser("Charlie");

    }

    private static void addUser(String s) {
        users.put(s, new User(s));
    }

    static void addTestMessages() {
        messages.add(new Message(0, -1, "Alice", "Hellow world!"));
        messages.add(new Message(1, -1, "Bob", "This is another thread!"));
        messages.add(new Message(2, 0, "Charlie", "Cool thread, Alice."));
        messages.add(new Message(3, 2, "Alice", "Thanks"));
    }
}
