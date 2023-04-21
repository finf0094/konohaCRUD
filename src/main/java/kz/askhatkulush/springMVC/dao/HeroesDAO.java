package kz.askhatkulush.springMVC.dao;

import kz.askhatkulush.springMVC.konoha.Heroes;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HeroesDAO {
    private ArrayList<Heroes> heroes = null;
    private int id = 0;

    {
        heroes = new ArrayList<>();
        heroes.add(new Heroes(++id, "Naruto", "Hokage"));
        heroes.add(new Heroes(++id, "Sasuke", "Hokage"));
        heroes.add(new Heroes(++id, "Sakura", "dzhunin"));
        heroes.add(new Heroes(++id, "Boruto", "dzhunin"));
        heroes.add(new Heroes(++id, "Gaara", "Kage"));
    }

    public ArrayList<Heroes> getHeroes() {
        return heroes;
    }

    public void addHero(Heroes hero) {
        hero.setId(++id);
        heroes.add(hero);
    }

    public Heroes getHero(int id) {
        return heroes.stream().filter(h -> h.getId() == id).findAny().orElse(null);
    }

    public ArrayList<Heroes> getHokages() {
        ArrayList<Heroes> hokages = new ArrayList<>();

        for (Heroes hero : heroes) {
            if (hero.getRang() == "Hokage") {
                hokages.add(hero);
            }
        }

        return hokages;
    }

    public void deleteHero(int id) {
        heroes.removeIf(h -> h.getId() == id);
    }

}
