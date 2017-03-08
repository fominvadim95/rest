package ua.nure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nure.entities.Team;
import ua.nure.services.TeamService;

@RestController
@RequestMapping("/teamService/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable String id, @RequestBody Team team) {
        team.setId(id);
        teamService.update(team);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String id) {
        teamService.delete(teamService.find(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Team find(@PathVariable String id) {
        return teamService.find(id);
    }

    @RequestMapping(value = "/{id}/playersCount", method = RequestMethod.GET)
    public int getPlayersCount(@PathVariable String id) {
        Team team = teamService.find(id);
        return teamService.getPlayersCount(team);
    }

    @RequestMapping(value = "/{id}/maxPlayerCost", method = RequestMethod.GET)
    public int getMaxPlayerCost(@PathVariable String id) {
        Team team = teamService.find(id);
        return teamService.getMaxPlayerCost(id);
    }
}
