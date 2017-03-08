package ua.nure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.entities.Player;
import ua.nure.services.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/teamService/teams/{id}/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Player find(@PathVariable String id) {
        return playerService.find(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        playerService.delete(playerService.find(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Player> findByCountry(@RequestParam String country) {
        return playerService.getPlayersByCountry(country);
    }
}
