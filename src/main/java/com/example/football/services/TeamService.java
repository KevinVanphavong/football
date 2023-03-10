package com.example.football.services;

import com.example.football.pojos.League;
import com.example.football.pojos.Team;

public interface TeamService {

    Team getOneTeamById(Long idTeam);

    Iterable<Team> getTeamsFromLeague(League league);

    Iterable<Team> getAllTeamsRanked();
    Iterable<Team> getAllTeams();
    Iterable<Team> getAllTeamsRankedByLeague(League league);

    Team addNewTeam(Team team);
}
