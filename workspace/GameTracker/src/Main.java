import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;

public class Main {
    static HashMap<String, User> users = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Starting GameTracker...");
        //how to make a get route
        Spark.init();
        Spark.get("/",
                (request, response) -> {
                    Session session = request.session();
                    String name = session.attribute("userName");
                    User user = users.get(name);

                    HashMap m = new HashMap();
                    if (user == null) {
                        return new ModelAndView(m, "login.html");
                    } else {
                        return new ModelAndView(user, "home.html");
                    }
                },
                new MustacheTemplateEngine()
        );

        Spark.post("/create-game", (request, response) -> {
            Session session = request.session();
            String name = session.attribute("userName");
            User user = users.get(name);
            if (user == null) {
                throw new Exception("User is not logged in");
            }

            String gameName = request.queryParams("gameName");
            String gameGenre = request.queryParams("gameGenre");
            String gamePlatform = request.queryParams("gamePlatform");
            int gameYear = Integer.parseInt(request.queryParams("gameYear"));

            Game game = new Game(gameName, gameGenre, gamePlatform, gameYear);
            user.games.add(game);
            response.redirect("/");
            return "";
        });

        Spark.post("/logout", (request, response) -> {
            Session session = request.session();
            session.invalidate();
            response.redirect("/");
            return "";
        });

        Spark.post("/login", (request, response) -> {
            String name = request.queryParams("loginName");
//            User user = users.get(name);
//            if (user == null){
//                user = new User(name);
//                users.put(name, user);
//            }
            users.putIfAbsent(name, new User(name)); //this is a simpler way to Register new user, replaces the last 4 lines!

            Session session = request.session();
            session.attribute("userName", name);

            response.redirect("/");
            return "";

        });
    }
}
