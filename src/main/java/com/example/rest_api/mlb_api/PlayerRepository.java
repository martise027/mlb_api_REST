package com.example.rest_api.mlb_api;

import com.example.rest_api.mlb_api.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,String> {

    List<Player> findByNameContainingIgnoreCaseAndPosition(String name,String position);
    List<Player> findByNameContainingIgnoreCaseAndTeam(String name,String team);
    List<Player> findByPositionAndHLessThanEqual(String position, int h);
    List<Player> findByPositionAndHGreaterThanEqual(String position,int h);
    List<Player> findByPositionAndHomerunLessThanEqual(String position, int homerun);
    List<Player> findByPositionAndHomerunGreaterThanEqual(String position, int homerun);
    List<Player> findByTeamAndHLessThanEqual(String team, int h);
    List<Player> findByTeamAndHGreaterThanEqual(String team,int h);
    List<Player> findByTeamAndHomerunLessThanEqual(String team, int homerun);
    List<Player> findByTeamAndHomerunGreaterThanEqual(String team, int homerun);

    List<Player> findByNameContainingIgnoreCase(String name);
    List<Player> findByPosition(String position);
    List<Player> findByTeam(String team);
    List<Player> findByGGreaterThanEqual(int G);

    List<Player> findByABGreaterThanEqual(int ab);
    List<Player> findByhGreaterThanEqual(int h);
    List<Player> findByhLessThanEqual(int h);
    List<Player> findByDHitsGreaterThanEqual(int d_hits);
    List<Player> findByTHitsGreaterThanEqual(int t_hits);
    List<Player> findByHomerunGreaterThanEqual(int homerunmore);
    List<Player> findByHomerunLessThanEqual(int homerunless);






}