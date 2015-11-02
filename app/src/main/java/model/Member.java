package model;

import java.util.Random;

public class Member {
    private String name;
    private Race race;
    private Position position;

    public Member(int creationId) {
        race = Race.generateRace();
        position = generatePosition();
        name = generateName(creationId);
    }

    private Position generatePosition() {
        Random rnd = new Random();
        switch (rnd.nextInt(3)) {
            case 0:
                return Position.COMMANDER;
            case 1:
                return Position.SCIENTIST;
            case 2:
                return Position.ENGINEER;
        }
        return Position.COMMANDER;
    }

    private String generateName(int creationId) {
        Random rnd = new Random();
        switch (rnd.nextInt(3)) {
            case 0:
                return "Pipi Romagnoli " + creationId;
            case 1:
                return "Julio Buffarini " + creationId;
            case 2:
                return "Emanuel Mas " + creationId;
        }
        return "Pichi Mercier " + creationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getRaceName() {
        return race.getName();
    }


    public String getSkillMultiplierForPosition() {
        return race.getMultiplierForPosition(position) + "X";
    }
}
