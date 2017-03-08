package ua.nure.client;

import ua.nure.entities.Player;
import ua.nure.entities.Team;

import java.util.List;


public interface RestClient {

    void update(String updatableId, Team team);

    void deleteTeam(String teamId);

    Team findTeam(String teamId);

    int getPlayersCount(String teamId);

    int getMaxPlayerCost(String teamId);

    Player findPlayer(String teamId, String playerId);

    void deletePlayer(String teamId, String playerId);

    List<Player> getPlayersByCountry(String teamId, String country);

}
