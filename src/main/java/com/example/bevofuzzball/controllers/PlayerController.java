package com.example.bevofuzzball.controllers;

import com.example.bevofuzzball.models.Offense;
import com.example.bevofuzzball.models.Pitch;
import com.example.bevofuzzball.models.Player;
import com.example.bevofuzzball.models.data.OffenseDao;
import com.example.bevofuzzball.models.data.PlayerDao;
import com.example.bevofuzzball.models.data.TeamsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "player")
public class PlayerController {

    @Autowired
    private TeamsDao teamsDao;

    @Autowired
    private PlayerDao playerDao;

    @Autowired
    private OffenseDao offenseDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayPlayers(Model model){
        model.addAttribute("players", playerDao.findAll());
        return "player/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddPlayer(Model model){
        model.addAttribute("title", "Add Player");
        model.addAttribute("players", new Player());
        model.addAttribute("teams", teamsDao.findAll());

        return "player/addplayer";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processplayeradd(@ModelAttribute @Valid Player newPlayer, @RequestParam int teamId, Model model){
        newPlayer.setTeamid(teamId);
        playerDao.save(newPlayer);

        return "redirect:addoffense/" + newPlayer.getId();
    }

    @RequestMapping(value = "addoffense/{id}", method = RequestMethod.GET)
    public String displayAddOffense(Model model, @PathVariable int id) {
        model.addAttribute("player", playerDao.findOne(id));
        model.addAttribute("offense", new Offense());
        return "player/addoffense";
    }

    @RequestMapping(value = "addoffense", method = RequestMethod.POST)
    public String processAddOffense(@ModelAttribute @Valid Offense newOffense, @RequestParam int id, Model model){
        newOffense.setPlayerId(id);
        newOffense.calcSlug(newOffense.getSingles(), newOffense.getDoubles(), newOffense.getTriples(), newOffense.getHomeRuns(), newOffense.getAtBats());
        newOffense.calcAvg(newOffense.getHits(), newOffense.getAtBats());
        newOffense.calcOnBase(newOffense.getHits(), newOffense.getAtBats(), newOffense.getWalks(), newOffense.getHitByPitch());
        newOffense.calcOPS(newOffense.getOnBase(), newOffense.getSlug());
        offenseDao.save(newOffense);

        return"redirect:addpitch/" + newOffense.getPlayerId();
    }

    @RequestMapping(value = "addpitch/{id}", method = RequestMethod.GET)
    public String displayAddPitch(Model model, @PathVariable int id) {
        model.addAttribute("player", playerDao.findOne(id));
        model.addAttribute("pitch", new Pitch());

        return "player/addpitch";
    }
}
