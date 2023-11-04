package com.ceshiren.hogwarts.play;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Play {
    private static Scanner scanner = new Scanner(System.in);

    public void start(){
        System.out.println("-------------------欢迎进入回合制游戏-------------------");
        HeroFactory.getHeros(5);//创建5个英雄
        this.selectMenu();
    }

    public void selectMenu(){
        System.out.println("1.创建一个新的英雄");
        System.out.println("2.查看所有英雄的信息");
        System.out.println("3.查看英雄攻击力小于100的英雄");
        System.out.println("4.开始战斗吧");
        System.out.println("5.修改英雄信息");
        System.out.println("6.删除英雄信息");
        System.out.println("7.返回主菜单");
        System.out.println("8.退出游戏");
        Integer menu = scanner.nextInt();
        switch(menu){
            case 1:this.creatHero();
            case 2:this.showAllHero();
            case 3:this.showHeroByAttack();
            case 4:this.fight();
            case 5:this.updateHero();
            case 6:this.deleteHero();
            case 7:this.selectMenu();
            case 8:this.exit();
            default:this.selectMenu();
        }
    }

    public  void creatHero(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("创建一个新的英雄");
        System.out.println("请输入英雄ID");
        String id = scanner.nextLine();
        Hero oldhero = HeroFactory.getHeroById(id);
        int h1=1;
        while(oldhero!=null){
            if(h1>3){
                System.out.println("连续输入3次错误，返回主菜单");
                this.selectMenu();
                break;
            }
            System.out.println("请重新输入新的英雄ID");
            id = scanner.nextLine();
            oldhero = HeroFactory.getHeroById(id);
            h1++;
        }
        System.out.println("请输入英雄姓名");
        String name = scanner.nextLine();
        System.out.println("请输入英雄血量");
        Integer blood = scanner.nextInt();
        System.out.println("请输入英雄攻击值");
        Integer attack = scanner.nextInt();
        Hero hero = new Hero(id,name,blood,attack);
        HeroFactory.addHero(hero);
        System.out.println("新的英雄信息 ID:"+hero.getId()+" Name:"+hero.getName()+" Blood:"+hero.getBlood()+" Attack:" +hero.getAttack());
        System.out.println("继续创建一个新的英雄请输入1，返回主菜单请输入7");
        while(true) {
            Integer menu = scanner.nextInt();
            if (menu == 1) {
                this.creatHero();
                scanner.close();
                break;
            } else if (menu == 7) {
                this.selectMenu();
                scanner.close();
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
    }

    public void showAllHero(){
        HeroFactory.showAllHero();
        System.out.println("所有英雄信息已展示，如需返回主菜单请输入7");
        while(true) {
            Integer menu = scanner.nextInt();
            if (menu == 7) {
                this.selectMenu();
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
    }

    public void showHeroByAttack(){
        Integer attack = 60;
        HeroFactory.showHeroByAttack(attack);//小于100，可以修改参数
        System.out.println("以上英雄是攻击力小于"+attack+"的英雄，如需返回主菜单请输入7");
        while(true) {
            Integer menu = scanner.nextInt();
            if (menu == 7) {
                this.selectMenu();
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
    }

    public void fight(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("开始战斗，请选择战斗场景");
        Stage.getBackGround();

        Integer num = scanner.nextInt();
        boolean b = true;
        while (b){
            b = Stage.selectBackGround(num);
        }
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("开始选择对战英雄");
        System.out.println("请输入出站英雄ID");
        String id = scanner2.nextLine();
        Hero hero1 = HeroFactory.getHeroById(id);
        int h1=1;
        while(hero1==null){
            if(h1>3){
                System.out.println("连续输入3次错误，返回主菜单");
                this.selectMenu();
                break;
            }
            System.out.println("请重新输入出站英雄ID");
            id = scanner2.nextLine();
            hero1 = HeroFactory.getHeroById(id);
            h1++;
        }
        System.out.println("请输入对战英雄ID");
        String id2 = scanner2.nextLine();
        Hero hero2 = HeroFactory.getHeroById(id2);
        int h2 = 1;
        while(hero2==null){
            if(h2>3){
                System.out.println("连续输入3次错误，返回主菜单");
                this.selectMenu();
                break;
            }
            System.out.println("请重新输入出站英雄ID");
            id2 = scanner2.nextLine();
            hero2 = HeroFactory.getHeroById(id2);
            h2++;
        }

        Stage stage = new Stage();
        stage.attackFirst(hero1,hero2);


        System.out.println("继续战斗请输入4，返回主菜单请输入7");
        while(true) {
            Integer menu = scanner.nextInt();
            if (menu == 4) {
                this.fight();
                break;
            } else if (menu == 7) {
                scanner.close();
                scanner2.close();
                this.selectMenu();
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }

    }


    public void updateHero(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入修改英雄ID");
        Hero hero = null;
        int i = 1;
        boolean b = true;
        while(b) {
            if(i<4) {
                String id = scanner.nextLine();
                hero = HeroFactory.getHeroById(id);
                if(hero==null){
                    if(i<3) {
                        System.out.println("请重新输入");
                    }
                    i++;
                }else {
                    break;
                }
            }else {
                System.out.println("连续3次输入错误,返回主菜单");
                this.selectMenu();
                break;
            }
        }



        System.out.println("请输入修改英雄名字");
        String name = scanner.nextLine();
        hero.setName(name);
        System.out.println("请输入修改英雄血量");
        Integer blood = scanner.nextInt();
        hero.setBlood(blood);
        System.out.println("请输入修改英雄攻击力");
        Integer attack = scanner.nextInt();
        hero.setAttack(attack);
        System.out.println("英雄修改成功,修改后英雄： ID:"+hero.getId()+" Name:"+hero.getName()+" Blood:"+hero.getBlood()+" Attack:" +hero.getAttack());


        System.out.println("继续删除英雄输入5，返回主菜单请输入7");
        while(true) {
            Integer menu = scanner.nextInt();
            if (menu == 6) {
                this.deleteHero();
                break;
            } else if (menu == 7) {
                this.selectMenu();
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }
    }

    public void deleteHero(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入删除英雄ID");
        String id = scanner.nextLine();
        Boolean b = HeroFactory.deleteHero(id);
        if(b){
            System.out.println("英雄删除成功");
        }else {
            System.out.println("英雄删除失败");
        }

        System.out.println("继续删除英雄输入6，返回主菜单请输入7");
        while(true) {
            Integer menu = scanner.nextInt();
            if (menu == 6) {
                this.deleteHero();
                break;
            } else if (menu == 7) {
                this.selectMenu();
                break;
            } else {
                System.out.println("输入错误，请重新输入");
            }
        }


    }

    public void exit(){
        System.out.println("退出游戏");
        scanner.close();
        System.exit(0);
    }


}

