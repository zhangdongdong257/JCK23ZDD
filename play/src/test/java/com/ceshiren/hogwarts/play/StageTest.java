package com.ceshiren.hogwarts.play;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StageTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void attackFirst() {
        Stage stage = new Stage();
        Hero hero1 = new Hero("1","凯皇",500,50);
        Hero hero2 = new Hero("2","亚瑟",500,40);
        Hero hero3 = stage.attackFirst(hero1, hero2);
        Assertions.assertEquals(hero1,hero3);
    }

    @Test
    void postAttack() {
        Stage stage = new Stage();
        Hero hero1 = new Hero("1","鲁班",500,50);
        Hero hero2 = new Hero("2","亚瑟",600,40);
        Hero hero3 = stage.postAttack(hero1, hero2);
        Assertions.assertEquals(hero1,hero3);
    }

    @Test
    void getBackGround() {
        Stage.getBackGround();

    }

    @Test
    void selectBackGround() {
        Stage.getBackGround();//初始化场景
        Boolean b = Stage.selectBackGround(2);//选择场景1
        Assertions.assertEquals(b,false);

        Boolean b2 = Stage.selectBackGround(5);//超出选择返回，默认选择场景1
        Assertions.assertEquals(b2,false);
    }
}