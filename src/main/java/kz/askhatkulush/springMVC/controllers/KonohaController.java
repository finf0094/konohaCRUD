package kz.askhatkulush.springMVC.controllers;

import kz.askhatkulush.springMVC.dao.HeroesDAO;
import kz.askhatkulush.springMVC.hibernate.Hibernate;
import kz.askhatkulush.springMVC.konoha.Heroes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/konoha")
public class KonohaController {

//    @Autowired
//    HeroesDAO heroesDAO = new HeroesDAO();

    Hibernate hibernate = new Hibernate();

    @RequestMapping()
    public String getHeroes(Model model) {

        model.addAttribute("heroes", hibernate.getHeroes());

        return "konoha/heroes";

    }

//    @RequestMapping("/{id}")
//    public String getHero(Model model, @PathVariable("id") int id) {
//        model.addAttribute("hero", heroesDAO.getHero(id));
//
//        return "konoha/hero";
//    }

//    @RequestMapping("/hokage")
//    public String getHokage(Model model) {
//        model.addAttribute("hokages", heroesDAO.getHokages());
//
//        return "konoha/hokages";
//    }

    @GetMapping("/newHero")
    public String newHero(Model model) {
        model.addAttribute("hero", new Heroes());
        return "/konoha/newHero";
    }

    @PostMapping()
    public String addHero(@ModelAttribute("hero") Heroes heroes) {
        hibernate.addHero(heroes);
        return "redirect:/konoha";
    }

    @DeleteMapping("/{id}")
    public String deleteHero(@PathVariable("id") int id) {
        hibernate.deleteHero(id);
        return "redirect:/konoha";
    }

}
