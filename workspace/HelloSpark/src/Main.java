import spark.ModelAndView;
import spark.Session;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;

public class Main {
    static HashMap<String, User> users = new HashMap<>();


    public static void main(String[] args) {
        Spark.init();

        Spark.get("/",
                (request, response) -> {
                    HashMap m = new HashMap();
                    //this next line is setting the session to get.
                    Session session = request.session();
                    String userName = session.attribute("userName");
                    User user = users.get(userName);

                    if (user == null) {
                        return new ModelAndView(m, "login.html");
                    } else {
                        m.put("name", user.name);
                        return new ModelAndView(m, "home.html");
                    }

                },
                new MustacheTemplateEngine()
        );
        Spark.post("/login", (request, response) -> {
            String name = request.queryParams("loginName");
            User user = users.get(name);
            if (user == null){
                user = new User(name);
                users.put(name, user);
            }
            //setting the session to be stored. basically the setter.
            Session session = request.session();
            session.attribute("userName", name);

            response.redirect("/");
            return "";
        });

        Spark.post("/logout", (request, response) -> {
            Session session = request.session();
            session.invalidate(); //forgets everything about the session, because youre logging out
            response.redirect("/");  //this line redirects to the login page
            return "";

        });
    }
}
