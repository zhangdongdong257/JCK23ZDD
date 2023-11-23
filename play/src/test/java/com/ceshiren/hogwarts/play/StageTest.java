package com.ceshiren.hogwarts.play;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StageTest {

    @BeforeEach
    void setUp() {
        System.out.println("befroeach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("teardown");
    }

    @BeforeAll
    static void befroAll(){
        System.out.println("befroALL");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("afterAll");
    }


    @Test
    @DisplayName("先手攻击测试")
    void attackFirstTest() {
        Stage stage = new Stage();
        Hero hero1 = new Hero("1","凯皇",500,50);
        Hero hero2 = new Hero("2","亚瑟",500,40);
        Hero hero3 = stage.attackFirst(hero1, hero2);
        Assertions.assertEquals(hero1,hero3);
    }

    @Test
    @DisplayName("后手攻击测试")
    void postAttackTest() {
        Stage stage = new Stage();
        Hero hero1 = getHero("1","鲁班",500,50);
        Hero hero2 = getHero("2","亚瑟",600,40);
        Hero hero3 = stage.postAttack(hero1, hero2);
        assertEquals(hero1,hero3);
    }

    @Step("获得一个新的英雄，{id},{name},{blood},{attack}")
    Hero getHero(String id, String name, Integer blood, Integer attack){
        Hero hero1 = new Hero(id,name,blood,attack);
        return hero1;
    }



    @Test
    @DisplayName("获取全部战斗地图")
    void getBackGroundTest() {
        Stage.getBackGround();

    }

    @Test
    @DisplayName("选择背景并添加测试步骤")
    void selectBackGroundTest() {
        Allure.step("初始化场景");
        Stage.getBackGround();//初始化场景
        Allure.step("选择场景2", () -> {
            Boolean b = Stage.selectBackGround(2);//选择场景1
            assertEquals(b, false);
        });

        Allure.step("超出选择返回，默认选择场景1", ()->{
            Boolean b2 = Stage.selectBackGround(5);//超出选择返回，默认选择场景1
            assertEquals(b2,false);
        });
    }
}