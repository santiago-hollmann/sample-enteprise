package com.shollmann.enterprise.app.model;

import java.util.Random;

public class Race {
    private String name;
    private Position bestSkill;
    private Position goodSkill;
    private Position regularSkill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getBestSkill() {
        return bestSkill;
    }

    public void setBestSkill(Position bestSkill) {
        this.bestSkill = bestSkill;
    }

    public Position getGoodSkill() {
        return goodSkill;
    }

    public void setGoodSkill(Position goodSkill) {
        this.goodSkill = goodSkill;
    }

    public Position getRegularSkill() {
        return regularSkill;
    }

    public void setRegularSkill(Position regularSkill) {
        this.regularSkill = regularSkill;
    }

    public static Race generateRace() {
        Random rnd = new Random();
        int number = rnd.nextInt(3);
        Race race = new Race();
        switch (number) {
            case 0:
                race.setName("Betazoid");
                race.setBestSkill(Position.ENGINEER);
                race.setGoodSkill(Position.SCIENTIST);
                race.setRegularSkill(Position.COMMANDER);
                break;
            case 1:
                race.setName("Human");
                race.setBestSkill(Position.COMMANDER);
                race.setGoodSkill(Position.ENGINEER);
                race.setRegularSkill(Position.SCIENTIST);
                break;
            case 2:
                race.setName("Vulcans");
                race.setBestSkill(Position.SCIENTIST);
                race.setGoodSkill(Position.ENGINEER);
                race.setRegularSkill(Position.COMMANDER);
                break;
        }
        return race;


    }

    public short getMultiplierForPosition(Position position) {
        if (position == bestSkill) {
            return 3;
        } else if (position == goodSkill) {
            return 2;
        } else if (position == regularSkill) {
            return 1;
        }
        return 0;
    }
}
