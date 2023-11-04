package com.ceshiren.hogwarts.play;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Stage {
    private static Map<Integer,String> backGrounds = new HashMap<Integer,String>();
    private static String backGround;
    private Hero winHero;


    public void attackFirst(Hero hero1, Hero hero2){
        Integer blood1, blood2, blood3, blood4;
        blood3 = hero1.getBlood();
        blood4 = hero2.getBlood();
        Integer i=1;
        System.out.println("----战斗开始----");
        while(hero1.getBlood() > 0 && hero2.getBlood() >0 ){
            blood2 = hero2.getBlood() - hero1.getAttack();//英雄hero1攻击英雄hero2
            if(blood2 >0){
                hero2.setBlood(blood2);
            }else{
                hero2.setBlood(blood2);
                this.winHero = hero1;
                System.out.println("第 "+i+" 轮攻击后英雄: "+hero1.getName()+" 剩余血量"+hero1.getBlood()+"   英雄:"+hero2.getName()+"  剩余血量: "+blood2);
                System.out.println("英雄:"+hero1.getName()+" 胜出");
                hero1.setBlood(blood3);
                hero2.setBlood(blood4);
                break;
            }
            blood1 = hero1.getBlood() - hero2.getAttack();//英雄hero2攻击英雄hero1

            if(blood1 >0){
                hero1.setBlood(blood1);
                System.out.println("第 "+i+" 轮攻击后英雄: "+hero1.getName()+" 剩余血量"+blood1+"   英雄:"+hero2.getName()+"  剩余血量: "+blood2);
            }else{
                hero1.setBlood(blood1);
                this.winHero = hero2;
                System.out.println("第 "+i+" 轮攻击后英雄: "+hero1.getName()+" 剩余血量"+hero1.getBlood()+"   英雄:"+hero2.getName()+" 剩余血量: "+blood2);
                System.out.println("英雄: "+hero2.getName()+" 胜出");
                hero1.setBlood(blood3);
                hero2.setBlood(blood4);
                break;
            }
            i++;

        }
    }

    public  void postAttack(Hero hero1, Hero hero2){
        Integer blood1, blood2, blood3, blood4;
        blood3 = hero1.getBlood();
        blood4 = hero2.getBlood();
        Integer i=1;
        System.out.println("----战斗开始----");
        while(hero1.getBlood() > 0 && hero2.getBlood() >0 ){
            blood1 = hero1.getBlood() - hero2.getAttack();//英雄hero2攻击英雄hero1

            if(blood1 >0){
                hero1.setBlood(blood1);
            }else{
                hero1.setBlood(blood1);
                this.winHero = hero2;
                System.out.println("第 "+i+" 轮攻击后英雄: "+hero1.getName()+" 剩余血量"+hero1.getBlood()+"   英雄:"+hero2.getName()+" 剩余血量: "+hero2.getBlood());
                System.out.println("英雄: "+hero2.getName()+" 胜出");
                hero1.setBlood(blood3);
                hero2.setBlood(blood4);
                break;
            }

            blood2 = hero2.getBlood() - hero1.getAttack();//英雄hero1攻击英雄hero2
            if(blood2 >0){
                hero2.setBlood(blood2);
                System.out.println("第 "+i+" 轮攻击后英雄: "+hero1.getName()+" 剩余血量"+hero1.getBlood()+"   英雄:"+hero2.getName()+"  剩余血量: "+hero2.getBlood());
            }else{
                hero2.setBlood(blood2);
                this.winHero = hero1;
                System.out.println("第 "+i+" 轮攻击后英雄: "+hero1.getName()+" 剩余血量"+hero1.getBlood()+"   英雄:"+hero2.getName()+"  剩余血量: "+blood2);
                System.out.println("英雄:"+hero1.getName()+" 胜出");
                hero1.setBlood(blood3);
                hero2.setBlood(blood4);
                break;
            }
            i++;

        }
    }

    public static void  getBackGround(){
        if(backGrounds.size()==0) {
            backGrounds.put(1, "城市大道");
            backGrounds.put(2, "海边沙滩");
            backGrounds.put(3, "紫金之巅");
            backGrounds.put(4, "华山峰顶");
        }
        for (int i=1;i<=backGrounds.size();i++) {
            System.out.println("序号"+i+" "+"决战场地："+backGrounds.get(i));
        }
    }

    public static boolean selectBackGround(Integer num){
        boolean b = false;
        if(num>0 && num<=backGrounds.size()) {
            backGround = backGrounds.get(num);
        }else {
            System.out.println("超出选择范围，默认选择1");
            backGround = backGrounds.get(1);
        }
        if(backGround==null || backGround.equals("")){
            b = true;
            return b;
        }
        System.out.println("您选择战斗场景是："+backGround);
        return b;
    }

}
