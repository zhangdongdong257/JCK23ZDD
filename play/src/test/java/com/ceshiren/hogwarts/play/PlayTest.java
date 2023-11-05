package com.ceshiren.hogwarts.play;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayTest {

    @BeforeEach
    void setUp() {
        HeroFactory.getHeros(5);//创建5个英雄
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void selectMenu() {
        Play paly = new Play();
        paly.selectMenu();

    }

    @Test
    void creatHero() {
    }

    @Test
    void showAllHero() {
    }

    @Test
    void showHeroByAttack() {
    }

    @Test
    void fight() {
    }

    @Test
    void updateHero() {
    }

    @Test
    void deleteHero() {
    }

    @Test
    void exit() {

    }
}