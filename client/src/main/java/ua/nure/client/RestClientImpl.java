package ua.nure.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ua.nure.entities.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestClientImpl implements RestClient {

    @Autowired
    private RestTemplate template;

    public RestClientImpl() {
    }

    public void update(String updatableId, Team team) {
        String url = "http://localhost:8080/teamService/teams/" + updatableId;
        template.put(url, team);
    }

    public void deleteTeam(String teamId) {
        String url = "http://localhost:8080/teamService/teams/" + teamId;
        template.delete(URI.create(url));
    }

    public Team findTeam(String teamId) {
        String url = "http://localhost:8080/teamService/teams/" + teamId;
        return template.getForObject(URI.create(url), Team.class);
    }

    public int getPlayersCount(String teamId) {
        String url = "http://localhost:8080/teamService/teams/" + teamId + "/playersCount";
        return template.getForObject(URI.create(url), int.class);
    }

    public int getMaxPlayerCost(String teamId) {
        String url = "http://localhost:8080/teamService/teams/" + teamId + "/maxPlayerCost";
        return template.getForObject(URI.create(url), int.class);
    }

    public Player findPlayer(String teamId, String playerId) {
        String url = "http://localhost:8080/teamService/teams/" + teamId + "/players/" + playerId;
        return template.getForObject(URI.create(url), Player.class);
    }

    public void deletePlayer(String teamId, String playerId) {
        String url = "http://localhost:8080/teamService/teams/" + teamId + "/players/" + playerId;
        template.delete(URI.create(url));
    }

    public List<Player> getPlayersByCountry(String teamId, String country) {
        String url = "http://localhost:8080/teamService/teams/" + teamId + "/players?country="+country;
        return template.getForObject(url, List.class);
    }
}
