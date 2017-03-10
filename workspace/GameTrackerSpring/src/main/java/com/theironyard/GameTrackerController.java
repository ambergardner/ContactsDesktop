package com.theironyard;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller

public class GameTrackerController {
    @Autowired
    GameRepository games;
    @Autowired
    UserRepository users;

    @PostConstruct
    public void init() {
        if (users.count() == 0){
            User user = new User();
            user.name = "John";
            user.password = "biker1";
            users.save(user);
        }
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName, String password) throws Exception {
        User user = users.findFirstByName(userName);
        if(user == null){
            users.save(new User(userName, password));
        }
        else if (! user.password.equals(password)) {
            throw new Exception("incorrect password");
        }

        session.setAttribute("userName", userName); //this checks the username
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate(); //this drops the session
        return "redirect:/";  //this takes you back to home page
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model, String genre, Integer releaseYear) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findFirstByName(userName);
        if (user != null){
            model.addAttribute("user", user);
        }

        List<Game> gamesList;
        if (genre != null) {
            gamesList = games.findByGenre(genre);
        } else if (releaseYear != null) {
            gamesList = games.findByReleaseYear(releaseYear);
//        } else if (search != null) {
//            gamesList = games.findByNameStartingWith(search);
        }else if (user != null){
            gamesList = games.findByUser(user);
        } else {
            gamesList = games.findAll();
        }
        model.addAttribute("games", gamesList);
        return "home";
    }

    @RequestMapping(path = "/add-game", method = RequestMethod.POST)
    public String addGame(HttpSession session, String gameName, String gamePlatform, String gameGenre, int gameYear) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findFirstByName(userName);

        Game game = new Game(gameName, gamePlatform, gameGenre, gameYear, user);
        games.save(game);
        return "redirect:/";
    }
}
