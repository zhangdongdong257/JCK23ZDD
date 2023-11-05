package com.ceshiren.hogwarts.play;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class HeroFactoryTest {

    @BeforeEach
    void setUp() {
        HeroFactory.getHeros(5);
    }

    @AfterEach
    void tearDown() {
        HeroFactory.heroes.clear();
        //HeroFactory.heroes.removeAll(Collections.emptyList());
    }

    @Test
    void getHeros() {
        Assertions.assertEquals(HeroFactory.heroes.size(),5);
    }

    @Test
    void addHero() {
        Hero hero = new Hero("6","阿珂",500,70);
        HeroFactory.addHero(hero);
        Assertions.assertEquals(HeroFactory.heroes.size(),6);
    }

    @Test
    void updateHero() {
        Hero oldHero = HeroFactory.getHeroById("1");
        Hero newHero = new Hero(oldHero.getId(),"阿珂",500,70);
        HeroFactory.updateHero(newHero);
        Hero updateHero = HeroFactory.getHeroById("1");
        Assertions.assertEquals(updateHero.getName(),"阿珂");
        Assertions.assertEquals(updateHero.getBlood(),500);
        Assertions.assertEquals(updateHero.getAttack(),70);
    }

    @Test
    void deleteHero() {
        HeroFactory.showAllHero();
        Boolean b =  HeroFactory.deleteHero("1");
        HeroFactory.showAllHero();
        Assertions.assertEquals(b,true);
    }

    @Test
    void getHeroById() {
        Hero hero = HeroFactory.getHeroById("1");
        Assertions.assertEquals(hero.getId(),"1");
    }

    @Test
    void showAllHero() {
        HeroFactory.showAllHero();
    }

    @Test
    void showHeroByAttack() {
        HeroFactory.showHeroByAttack(60);
    }
}