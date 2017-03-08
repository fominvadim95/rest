package ua.nure.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.nure.dao.PlayerDao;
import ua.nure.entities.Player;
import ua.nure.entities.Players;
import ua.nure.utils.EntityCreator;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerDaoImpl implements PlayerDao {

    @Autowired
    private EntityCreator entityCreator;

    private Players players = new Players();

    public PlayerDaoImpl() {
    }

    @PostConstruct
    public void init() {
        players = entityCreator.createPlayers();
    }

    @Override
    public void delete(Player player) {
        int index = getIndex(player);
        players.getPlayer().remove(index);
    }

    @Override
    public Player find(String id) {
        for (Player player: players.getPlayer()) {
            if (player.getId().equals(id)) {
                return player;
            }
        }
        return new Player();
    }

    @Override
    public List<Player> getPlayersByCountry(String country) {
        List<Player> result = new ArrayList<>();
        for (int i = 0; i < players.getPlayer().size(); i++){
            if (players.getPlayer().get(i).getGeneral().getCountry().equals(country)){
                result.add(players.getPlayer().get(i));
            }
        }
        return result;
    }

    private int getIndex(Player player) {
        int index = -1;
        for (int i = 0; i < players.getPlayer().size(); i++) {
            if (players.getPlayer().get(i).getId().equals(player.getId())) {
                index = i;
                break;
            }
        }
        return index;
    }
}
