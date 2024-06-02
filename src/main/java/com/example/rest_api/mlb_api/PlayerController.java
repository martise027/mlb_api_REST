package com.example.rest_api.mlb_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v2/player")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> filter(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String team,
            @RequestParam(required = false, defaultValue ="-1") int game,
            @RequestParam(required = false, defaultValue ="-1") int ab,
            @RequestParam(required = false, defaultValue ="-1") int hitmore,
            @RequestParam(required = false, defaultValue ="-1") int hitless,
            @RequestParam(required = false, defaultValue ="-1") int d_hit,
            @RequestParam(required = false, defaultValue ="-1") int t_hit,
            @RequestParam(required = false, defaultValue ="-1") int homerunmore,
            @RequestParam(required = false, defaultValue ="-1") int homerunless
    ){
        if(name != null && position !=null){return playerService.findByNameContainingIgnoreCaseAndPosition(name,position);}
        else if(name!=null && team !=null){return playerService.findByNameContainingIgnoreCaseAndTeam(name,team);}
        else if(position !=null && hitless != -1){return playerService.findByPositionAndHLessThanEqual(position,hitless);}
        else if(position != null && hitmore != -1){return playerService.findByPositionAndHGreaterThanEqual(position,hitmore);}
        else if(position !=null && homerunless != -1){return playerService.findByPositionAndHomerunLessThanEqual(position,homerunless);}
        else if(position != null && homerunmore != -1){return  playerService.findByPositionAndHomerunGreaterThanEqual(position,homerunmore);}
        else if(team != null && hitless != -1){return playerService.findByTeamAndHLessThanEqual(team,hitless);}
        else if(team != null && hitmore != -1){return playerService.findByTeamAndHGreaterThanEqual(team,hitmore);}
        else if(team != null && homerunless != -1){return playerService.findByTeamAndHomerunLessThanEqual(team,homerunless);}
        else if(team != null && homerunmore != -1){return playerService.findByTeamAndHomerunGreaterThanEqual(team,homerunmore);}

        else if(name != null) return playerService.findByName(name);
        else if(position != null) return playerService.findByPosition(position);
        else if(team != null) return playerService.findByTeam(team);
        else if(game != -1) return playerService.findByGameGreaterThanEqual(game);
        else if(ab != -1) return  playerService.findByAbGreaterThanEqual(ab);
        else if(hitmore != -1) return playerService.findByhGreaterThanEqual(hitmore);
        else if(hitless != -1) return playerService.findByhLessThanEqual(hitless);
        else if(d_hit != -1) return playerService.findByDHitsGreaterThanEqual(d_hit);
        else if(t_hit != -1) return playerService.findByTHitsGreaterThanEqual(t_hit);
        else if(homerunmore != -1) return playerService.findByHomerunGreaterThanEqual(homerunmore);
        else if(homerunless != -1) return playerService.findbyHomerunLessThanEqual(homerunless);
        return playerService.findALlPlayers();
    }



    @PostMapping
    public ResponseEntity<String> createPlayer(@RequestBody Player request) {
        return playerService.createPlayer(request);
    }

    @PutMapping
    public ResponseEntity<String> updatePlayer(@RequestBody Player request){
        return playerService.updatePlayer(request);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePlayer(@RequestBody Player request){
        String name = request.getName();
        return playerService.deletePlayer(name);
    }


}