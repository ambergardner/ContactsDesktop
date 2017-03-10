package com.theironyard;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {
    List<Game> findByGenre(String genre);
    List<Game> findAll();
    List<Game> findByReleaseYear(int gameYear);
    List<Game> findByUser(User user);

    @Query("SELECT g FROM Games g WHERE g.name LIKE %?1")
    List<Game> findyByNameEndsWith(String name);

    List<Game> findByNameStartingWith(String name);

}

