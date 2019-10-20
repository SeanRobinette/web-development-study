package com.robinette.jokes.controllers;

import com.robinette.jokes.services.JokeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {
    private JokeService jokeService;
    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }
    @RequestMapping("/")
    public String getJoke(Model model) {
        model.addAttribute("joke", jokeService.getRandomQuote());
        return "chucknorris";
    }
}