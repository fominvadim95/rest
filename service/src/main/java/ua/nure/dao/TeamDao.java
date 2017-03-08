package ua.nure.dao;

import ua.nure.entities.Team;

public interface TeamDao {

    void update(Team team);

    void delete(Team team);

    Team find(String id);

    int getPlayersCount(Team team);

    int getMaxPlayerCost(String id);
}
