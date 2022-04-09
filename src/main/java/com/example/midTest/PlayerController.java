package com.example.midTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(path = "/")
    public String getHomePage(Model model) {
        List<Player> playerList = playerService.getAllPlayers();
        model.addAttribute("playerList", playerList);
        return "home";
    }

    @GetMapping(path = "/newGamer")
    public String newGamerPage(Model model){
        model.addAttribute("player", new Player());
        return "newGamer";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String savePlayer(@ModelAttribute ("player") Player player){
    playerService.addNewPlayer(player);
    return "redirect:/";
    }

    @RequestMapping(path = "/edit/{playerId}")
    public ModelAndView editPlayer(@PathVariable("playerId") Long playerId){
    ModelAndView modelAndView = new ModelAndView("newGamer");
    Player player = playerService.getPlayerById(playerId).get();
    modelAndView.addObject("player", player);
    return modelAndView;
    }

    @RequestMapping(path = "/delete/{playerId}")
    public String deletePlayer(@PathVariable("playerId") Long playerId){
        playerService.deletePlayer(playerId);
        return "redirect:/";
    }

}
