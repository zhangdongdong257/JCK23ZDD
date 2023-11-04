package com.ceshiren.hogwarts.play;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HeroFactory {

    public static List<Hero> heroes = new ArrayList<Hero>();

    public static List<Hero> getHeros(Integer number){
        for(int i=0;i<number;i++){
            Hero hero = new Hero(i+1+"",RandomTools.getHeroRandomName(6),RandomTools.getHeroRanddomBlood(),RandomTools.getHeroRanddomAttack());
            heroes.add(hero);
        }

        return heroes;
    }

    public static List<Hero> addHero(Hero hero){
        heroes.add(hero);
        return heroes;
    }

    public static Boolean updateHero(Hero hero){
        Boolean b = true;
        Hero updateHero = HeroFactory.getHeroById(hero.getId());

        if(hero==null){
            b = false;
        }else{
            updateHero.setName(hero.getName());
            updateHero.setBlood(hero.getBlood());
            updateHero.setAttack(hero.getAttack());
        }

        return b;

    }

    public static boolean deleteHero(String id){
        Boolean b = true;
        Hero hero = HeroFactory.getHeroById(id);
        if(hero==null){
            b = false;
        }else{
            heroes.remove(hero);
        }

        return b;
    }

    public static Hero getHeroById(String heroId){
        Hero hreo1 = null;
        Boolean exit = true;
        for(Hero hero :HeroFactory.heroes ){
            if(hero.getId().equals(heroId)){
                hreo1 = hero;
                System.out.println("ID:"+hero.getId()+" Name:"+hero.getName()+" Blood:"+hero.getBlood()+" Attack:" +hero.getAttack());
                exit = false;
            }
        }

        if(exit){
            System.out.println("输入的ID不存在");
        }

        return hreo1;
    }

    public static void showAllHero(){
        System.out.println("ID    名字        血量       攻击力");
        for(Hero hero :HeroFactory.heroes ) {
            System.out.println("ID:" + hero.getId() + " Name:" + hero.getName() + " Blood:" + hero.getBlood() + " Attack:" + hero.getAttack());
        }
    }

    public static void showHeroByAttack(Integer attack){
//        for(Hero hero :HeroFactory.heroes ){
//            if(hero.getAttack()<attack) {
//                System.out.println("ID:" + hero.getId() + " Name" + hero.getName() + " Blood" + hero.getBlood() + " Attack" + hero.getAttack());
//            }
//        }

        List<String> names = HeroFactory.heroes.stream() //创建流
                .filter(hero -> hero.getAttack() < attack)//过滤攻击力低于100的英雄
                .sorted((hero1,hero2) -> Integer.compare(hero1.getAttack(),hero2.getAttack()))//根据攻击力进行排序
                .map(Hero::getName)//按照姓名加入集合
                .collect(Collectors.toList());//流转变成List集合
        System.out.println(names);
    }




}
