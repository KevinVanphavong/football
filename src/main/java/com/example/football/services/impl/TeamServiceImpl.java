package com.example.football.services.impl;

import com.example.football.pojos.League;
import com.example.football.pojos.Team;
import com.example.football.repository.TeamRepository;
import com.example.football.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team getOneTeamById(Long idTeam) {
        return teamRepository.findById(idTeam).orElse(null);
    }

    @Override
    public Iterable<Team> getTeamsFromLeague(League league) {
        return teamRepository.findTeamsByLeague(league);
    }

    @Override
    public Iterable<Team> getAllTeamsRanked() {
        return teamRepository.findAll(Sort.by("totalPoints").descending());
    }

    @Override
    public Iterable<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Iterable<Team> getAllTeamsRankedByLeague(League league) {
        return teamRepository.findAllByLeague(Sort.by("totalPoints").descending(), league);
    }

    @Override
    public Team addNewTeam(Team team) {
        return teamRepository.save(team);
    }
}
