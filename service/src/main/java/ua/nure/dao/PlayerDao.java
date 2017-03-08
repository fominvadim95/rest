package ua.nure.dao;

import ua.nure.entities.Player;

import java.util.List;

public interface PlayerDao {

    Player find(String id);

    void delete(Player player);

    List<Player> getPlayersByCountry(String country);

}
