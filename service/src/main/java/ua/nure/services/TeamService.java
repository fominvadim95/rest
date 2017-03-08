package ua.nure.services;

import ua.nure.entities.Team;

public interface TeamService {

    void update(Team team);

    void delete(Team team);

    Team find(String id);

    int getPlayersCount(Team team);

    int getMaxPlayerCost(String id);

}
