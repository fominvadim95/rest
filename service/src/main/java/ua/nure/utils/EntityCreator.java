package ua.nure.utils;

import org.springframework.stereotype.Component;
import ua.nure.entities.*;

@Component
public class EntityCreator {

    private Teams teams = new Teams();

    private Players players = new Players();

    private Coach coach = new Coach();

    private Sponsors sponsors = new Sponsors();

    private Stadium stadium = new Stadium();


    public Teams createTeams() {
        teams.getTeam().add(createTeam());
        return teams;
    }

    public CoachInfo createCoachInfo() {
        CoachInfo info = new CoachInfo();
        info.setAge(44);
        info.setCountry("France");
        info.setName("Zidane");
        return info;
    }

    public Info createSponsorInfo() {
        Info info = new Info();
        info.setCountry("UAE");
        info.setName("Emirates Airlines");
        return info;
    }

    public StadiumInfo createStadiumInfo() {
        StadiumInfo info = new StadiumInfo();
        info.setCountry("Spain");
        info.setCity("Madrid");
        info.setName("Santiago Bernabeu");
        return info;
    }

    public Info createTeamInfo() {
        Info info = new Info();
        info.setCountry("Spain");
        info.setName("Real Madrid");
        return info;
    }

    public Coach createCoach() {
        coach.setId("c1");
        coach.setGeneral(createCoachInfo());
        coach.setExperience(7);
        return coach;
    }

    public Sponsors createSponsors() {
        if (sponsors.getSponsor().size() == 0) {
            sponsors.getSponsor().add(createSponsor());
        }
        return sponsors;
    }

    public Players createPlayers() {
        if (players.getPlayer().size() == 0) {

            Player player = new Player();
            player.setId("p1");
            PlayerInfo info = new PlayerInfo();
            info.setAge(28);
            info.setCountry("Portugal");
            info.setName("Coentrao");
            player.setGeneral(info);
            player.setCost(40);
            player.setPosition(Position.CB);
            players.getPlayer().add(player);

            player = new Player();
            player.setId("p2");
            info = new PlayerInfo();
            info.setAge(32);
            info.setCountry("Portugal");
            info.setName("Ronaldo");
            player.setGeneral(info);
            player.setCost(110);
            player.setPosition(Position.FM);
            players.getPlayer().add(player);

            player = new Player();
            player.setId("p3");
            info = new PlayerInfo();
            info.setAge(28);
            info.setCountry("Brazil");
            info.setName("Marcelo");
            player.setGeneral(info);
            player.setCost(70);
            player.setPosition(Position.CM);
            players.getPlayer().add(player);
        }
        return players;
    }

    public Stadium createStadium() {
        stadium.setId("st1");
        stadium.setGeneral(createStadiumInfo());
        stadium.setCapacity(81044);
        return stadium;
    }

    private Sponsor createSponsor() {
        Sponsor sponsor = new Sponsor();
        sponsor.setId("sp1");
        sponsor.setGeneral(createSponsorInfo());
        sponsor.setYear(2020);
        return sponsor;
    }

    private Team createTeam() {
        Team team = new Team();
        team.setId("t1");
        team.setGeneral(createTeamInfo());
        team.setCoach(createCoach());
        team.setStadium(createStadium());
        team.setPlayers(createPlayers());
        team.setSponsors(createSponsors());
        return team;
    }

}
