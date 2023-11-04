package com.ceshiren.hogwarts.play;

public class Hero {

    private String id;
    private String name;
    private Integer blood;
    private Integer attack;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBlood() {
        return blood;
    }

    public void setBlood(Integer blood) {
        this.blood = blood;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Hero(String id, String name, Integer blood, Integer attack) {
        this.id = id;
        this.name = name;
        this.blood = blood;
        this.attack = attack;
    }
    public Hero() {
        this.id = id;
        this.name = name;
        this.blood = blood;
        this.attack = attack;
    }
}
