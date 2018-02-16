package com.example.bevofuzzball.controllers;

import com.example.bevofuzzball.models.Teams;
import com.example.bevofuzzball.models.data.TeamsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "team")

public class TeamController {

    @Autowired
    private TeamsDao teamsDao;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String displayTeams(Model model){
        model.addAttribute("title", "Teams");
        model.addAttribute("teams", teamsDao.findAll());
        return "team/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddTeam(Model model){
        model.addAttribute("title", "Add Team");
        model.addAttribute("teams", new Teams());

        return "team/addteam";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddTeam(@ModelAttribute @Valid Teams newTeam, Model model){
        model.addAttribute("title", "Add Team");

        teamsDao.save(newTeam);
        return "redirect:";
    }
}
