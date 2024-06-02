package com.example.rest_api.mlb_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.rest_api.mlb_api.PlayerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService{

    private PlayerRepository playerRepository;

    private static final Logger logger = LoggerFactory.getLogger(PlayerService.class);

    @Autowired
    public PlayerService(PlayerRepository playerRepository){
        this.playerRepository = playerRepository;
    }

    public List<Player> findALlPlayers(){return playerRepository.findAll();}
    public List<Player> findByNameContainingIgnoreCaseAndPosition(String name,String position){return playerRepository.findByNameContainingIgnoreCaseAndPosition(name,position);}
    public List<Player> findByNameContainingIgnoreCaseAndTeam(String name,String team){return playerRepository.findByNameContainingIgnoreCaseAndTeam(name,team);}
    public List<Player> findByPositionAndHLessThanEqual(String position, int h){return playerRepository.findByPositionAndHLessThanEqual(position,h);}
    public List<Player> findByPositionAndHGreaterThanEqual(String position,int h){return playerRepository.findByPositionAndHGreaterThanEqual(position,h);}
    public List<Player> findByPositionAndHomerunLessThanEqual(String position, int homerun){return playerRepository.findByPositionAndHomerunLessThanEqual(position,homerun);}
    public List<Player> findByPositionAndHomerunGreaterThanEqual(String position, int homerun){return playerRepository.findByPositionAndHomerunGreaterThanEqual(position,homerun);}
    public List<Player> findByTeamAndHLessThanEqual(String team, int h){return playerRepository.findByTeamAndHLessThanEqual(team,h);}
    public List<Player> findByTeamAndHGreaterThanEqual(String team,int h){return playerRepository.findByTeamAndHGreaterThanEqual(team,h);}
    public List<Player> findByTeamAndHomerunLessThanEqual(String team, int homerun){return  playerRepository.findByTeamAndHomerunLessThanEqual(team,homerun);}
    public List<Player> findByTeamAndHomerunGreaterThanEqual(String team, int homerun){return playerRepository.findByTeamAndHomerunGreaterThanEqual(team,homerun);}


    public List<Player> findByName(String name){return playerRepository.findByNameContainingIgnoreCase(name);}
    public List<Player> findByPosition(String position){ return playerRepository.findByPosition(position);}
    public List<Player> findByTeam(String team){return playerRepository.findByTeam(team);}
    public List<Player> findByGameGreaterThanEqual(int g){return playerRepository.findByGGreaterThanEqual(g);}
    public List<Player> findByAbGreaterThanEqual(int ab) {return playerRepository.findByABGreaterThanEqual(ab);}
    public List<Player> findByhGreaterThanEqual(int h){return playerRepository.findByhGreaterThanEqual(h);}
    public List<Player> findByhLessThanEqual(int h){return playerRepository.findByhLessThanEqual(h);}
    public List<Player> findByDHitsGreaterThanEqual(int d_hits){return playerRepository.findByDHitsGreaterThanEqual(d_hits);}
    public List<Player> findByTHitsGreaterThanEqual(int t_hits){return playerRepository.findByTHitsGreaterThanEqual(t_hits);}
    public List<Player> findByHomerunGreaterThanEqual(int homerunmore) {return playerRepository.findByHomerunGreaterThanEqual(homerunmore);}
    public List<Player> findbyHomerunLessThanEqual(int homerunless){return  playerRepository.findByHomerunLessThanEqual(homerunless);}





    public ResponseEntity<String> createPlayer(Player req) {
        Optional<Player> optionalPlayer = playerRepository.findById(req.getName());
        if(!optionalPlayer.isPresent()) {
            Player player = new Player();
            player.setName(req.getName());
            player.setTeam(req.getTeam());
            player.setPosition(req.getPosition());
            player.setG(req.getG());
            player.setAB(req.getAB());
            player.setR(req.getR());
            player.setH(req.getH());
            player.setdHits(req.getdHits());
            player.settHits(req.gettHits());
            player.setHomerun(req.getHomerun());
            player.setRBI(req.getRBI());
            player.setBB(req.getBB());
            player.setSO(req.getSO());
            player.setSB(req.getSB());
            player.setCS(req.getCS());
            player.setAVG(req.getAVG());
            player.setOBP(req.getOBP());
            player.setSLG(req.getSLG());
            player.setOPS(req.getOPS());
            playerRepository.save(player);

            return ResponseEntity.status(HttpStatus.OK).body("Player created successfully");
        }else{
            return ResponseEntity.status(HttpStatus.FOUND).body("Player already exist");
        }

    }

    public ResponseEntity<String> updatePlayer(Player req){
        Optional<Player> optionalPlayer = playerRepository.findById(req.getName());

        if(optionalPlayer.isPresent()){
            Player existingPlayer = optionalPlayer.get();

            if(req.getTeam() != null) existingPlayer.setTeam(req.getTeam());
            if(req.getPosition() != null) existingPlayer.setPosition(req.getPosition());
            if(req.getG() != null) existingPlayer.setG(req.getG());
            if(req.getAB() != null) existingPlayer.setAB(req.getAB());
            if(req.getR() != null) existingPlayer.setR(req.getR());
            if(req.getH() != null) existingPlayer.setH(req.getH());
            if(req.getdHits() != null) existingPlayer.setdHits(req.getdHits());
            if(req.gettHits() != null) existingPlayer.settHits(req.gettHits());
            if(req.getHomerun() != null) existingPlayer.setHomerun(req.getHomerun());
            if(req.getRBI() != null) existingPlayer.setRBI(req.getRBI());
            if(req.getBB() != null) existingPlayer.setBB(req.getBB());
            if(req.getSO() != null) existingPlayer.setSO(req.getSO());
            if(req.getSB() != null) existingPlayer.setSB(req.getSB());
            if(req.getCS() != null) existingPlayer.setCS(req.getCS());
            if(req.getAVG() != null) existingPlayer.setAVG(req.getAVG());
            if(req.getOBP() != null) existingPlayer.setOBP(req.getOBP());
            if(req.getSLG() != null) existingPlayer.setSLG(req.getSLG());
            if(req.getOPS() != null) existingPlayer.setOPS(req.getOPS());

            playerRepository.save(existingPlayer);

            return  ResponseEntity.status(HttpStatus.OK).body("Player updated successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found with name " + req.getName());
        }
    }

    public ResponseEntity<String> deletePlayer(String name){

        System.out.println("Trying to find:" +name);
        boolean exist = playerRepository.existsById(name);


        if(exist) {
            playerRepository.deleteById(name);
            return ResponseEntity.status(HttpStatus.OK).body("Player deleted successfully");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Player not found with name " + name);
        }


    }

}