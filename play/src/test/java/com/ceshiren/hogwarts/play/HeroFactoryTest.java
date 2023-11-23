package com.ceshiren.hogwarts.play;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("HeroFactory的测试类")
class HeroFactoryTest {

    @BeforeEach
    @DisplayName("每个测试方法执行前初始5个英雄")
    void setUp() {
        HeroFactory.getHeros(5);
    }

    @AfterEach
    @DisplayName("每个测试方法执行后销毁所有的英雄")
    void tearDown() {
        HeroFactory.heroes.clear();
        //HeroFactory.heroes.removeAll(Collections.emptyList());
    }

    @Test
    @DisplayName("获取当前所有的英雄信息")
    void getHeros() {
        Assertions.assertEquals(HeroFactory.heroes.size(),5);
    }

    @DisplayName("添加新的英雄")
    @ParameterizedTest(name="{1}，编号{0},血量{2},攻击力{3}")
    @MethodSource()
    void addHero(String num, String name, Integer blood, Integer attack) {
        Hero hero = new Hero(num,name,blood,attack);
        int oldSize = HeroFactory.heroes.size();
        HeroFactory.addHero(hero);
        Assertions.assertEquals(HeroFactory.heroes.size(),oldSize+1);
    }

    static Stream<Object> addHero(){
        return Stream.of(
                Arguments.of("6","阿珂",500,70),
                Arguments.of("7","蔡文姬",1000,20)
        );
    }

    @DisplayName("修改英雄")
    @ParameterizedTest
    @CsvSource({"1,阿珂,500,70","2,孙悟空,600,90"})
    void updateHero(String num, String name, Integer blood, Integer attack) {
        Hero oldHero = HeroFactory.getHeroById(num);
        Hero newHero = new Hero(oldHero.getId(),name,blood,attack);
        HeroFactory.updateHero(newHero);
        Hero updateHero = HeroFactory.getHeroById(num);
        Assertions.assertEquals(updateHero.getName(),name);
        Assertions.assertEquals(updateHero.getBlood(),blood);
        Assertions.assertEquals(updateHero.getAttack(),attack);
    }

    @Test
    void deleteHero() {
        HeroFactory.showAllHero();
        Boolean b =  HeroFactory.deleteHero("1");
        HeroFactory.showAllHero();
        Assertions.assertEquals(b,true);
    }

    @TestFactory
    List<DynamicTest> getHeroById() {
        List<String> inputList = Arrays.asList("1", "2", "3");
        return inputList.stream().map(str -> DynamicTest.dynamicTest("根据英雄ID：" + str + "获取英雄", () ->
                        {
                        Hero hero = HeroFactory.getHeroById(str);
                        assertEquals(hero.getId(),str);
                    })
        ).collect(Collectors.toList());

    }


    @DisplayName("展示所有英雄的名称")
    @Test
    void showAllHero() {
        Allure.getLifecycle().updateTestCase(testResult -> testResult.setName("我要修改一下测试用例的名称"));
        HeroFactory.showAllHero();
    }

    @Test
    void showHeroByAttack() {
        HeroFactory.showHeroByAttack(60);
    }



}