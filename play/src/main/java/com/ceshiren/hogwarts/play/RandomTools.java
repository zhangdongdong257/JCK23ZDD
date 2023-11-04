package com.ceshiren.hogwarts.play;

import java.util.Random;

public class RandomTools {
    private static RandomTools randomTools = null;
    private static Random r1 = new Random();

    private RandomTools() {
    }

    public static RandomTools getInstance() {
        synchronized (RandomTools.class) {
            if (null == randomTools) {
                randomTools = new RandomTools();
            }
        }
        return randomTools;
    }

    //to do 增加随机工具

    public static int getRandomInt(int min, int max) {
        int n2 = Math.abs(r1.nextInt(max - min) + max);
        return n2;
    }

    public static int getNum(int start, int end) {
        return (int) (Math.random() * (end - start + 1) + start);
    }

    public static String getRandomString(int length) {
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 随机生成手机号码
     *
     * @return 手机号
     */
    public static String getTelephone() {
        String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153".split(",");
        int index = getNum(0, telFirst.length - 1);
        String first = telFirst[index];
        String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
        String thrid = String.valueOf(getNum(1, 9100) + 10000).substring(1);
        return first + second + thrid;

    }

    public static int getRandomDuid() {
        int n2 = Math.abs(r1.nextInt());
        return n2;
    }

    public static String getHeroRandomName(int length){
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(26);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }


    public static Integer getHeroRanddomBlood(Integer num){
        if(num == null || num <=0) {
            num = RandomTools.getNum(1, 10);
        }
        Integer blood;
        switch (num){
            case 1:blood = 100; break;
            case 2:blood = 200; break;
            case 3:blood = 300; break;
            case 4:blood = 400; break;
            case 5:blood = 500; break;
            default:blood = 110;
        }
        return blood;

    }

    public static Integer getHeroRanddomBlood(){
        Integer   blood ;
        int randomNum = RandomTools.getNum(1, 10);
        switch (randomNum){
            case 1:blood = 200; break;
            case 2:blood = 300; break;
            case 3:blood = 400; break;
            case 4:blood = 500; break;
            case 5:blood = 600; break;
            default:blood = 210;
        }
        return blood;

    }

    public static Integer getHeroRanddomAttack(Integer num){
        Integer attack;
        if(num == null || num <=0) {
            num = RandomTools.getNum(1, 10);
        }
        switch (num){
            case 1:attack = 110; break;
            case 2:attack = 100; break;
            case 3:attack = 90; break;
            case 4:attack = 80; break;
            case 5:attack = 70; break;
            default:attack = 85;
        }
        return attack;

    }


    public static Integer getHeroRanddomAttack(){
        Integer attack;
        int randomNum = RandomTools.getNum(1,7);
        switch (randomNum){
            case 1:attack = 90; break;
            case 2:attack = 80; break;
            case 3:attack = 70; break;
            case 4:attack = 60; break;
            case 5:attack = 50; break;
            default:attack = 55;
        }
        return attack;

    }



    public static void main(String[] args) {
        System.out.println(RandomTools.getRandomDuid());
        System.out.println(RandomTools.getNum(1,1000));
    }



}
