package model;

public class Member {
    private String name;
    private Race race;
    private Position position;

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
        return "";
    }
}
