package com.sp.vo;

public class ActorVo {

    private int actorid;
    private String actorname;
    private String actorcategory;
    private float actorfee;

    // ✅ Default constructor
    public ActorVo() {}

    // ✅ Parameterized constructor
    public ActorVo(int actorid, String actorname, String actorcategory, float actorfee) {
        this.actorid = actorid;
        this.actorname = actorname;
        this.actorcategory = actorcategory;
        this.actorfee = actorfee;
    }

    public int getActorid() {
        return actorid;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }

    public String getActorname() {
        return actorname;
    }

    public void setActorname(String actorname) {
        this.actorname = actorname;
    }

    public String getActorcategory() {
        return actorcategory;
    }

    public void setActorcategory(String actorcategory) {
        this.actorcategory = actorcategory;
    }

    public float getActorfee() {
        return actorfee;
    }

    public void setActorfee(float actorfee) {
        this.actorfee = actorfee;
    }
}