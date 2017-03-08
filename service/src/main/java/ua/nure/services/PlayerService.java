package ua.nure.services;

import ua.nure.entities.Player;

import java.util.List;

public interface PlayerService {

    Player find(String id);

    void delete(Player player);

    List<Player> getPlayersByCountry(String country);

}
