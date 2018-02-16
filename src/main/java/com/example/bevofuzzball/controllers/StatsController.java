package com.example.bevofuzzball.controllers;


import com.example.bevofuzzball.models.data.OffenseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "stats")
public class StatsController {

    @Autowired
    private OffenseDao offenseDao;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String displayStats(Model model) {

        model.addAttribute("title", "FuzzBall Statistics");
        model.addAttribute("stats", offenseDao.findAll());

        return "stats/index";
    }
}
