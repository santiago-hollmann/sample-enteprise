package model;

public class Race {
    private String name;
    private short bestSkillMultiplier;
    private short goodSkillMultiplier;
    private short regularSkillMultipler;
    private Position bestSkill;
    private Position goodSkill;
    private Position regularSkill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getBestSkillMultiplier() {
        return bestSkillMultiplier;
    }

    public void setBestSkillMultiplier(short bestSkillMultiplier) {
        this.bestSkillMultiplier = bestSkillMultiplier;
    }

    public short getGoodSkillMultiplier() {
        return goodSkillMultiplier;
    }

    public void setGoodSkillMultiplier(short goodSkillMultiplier) {
        this.goodSkillMultiplier = goodSkillMultiplier;
    }

    public short getRegularSkillMultipler() {
        return regularSkillMultipler;
    }

    public void setRegularSkillMultipler(short regularSkillMultipler) {
        this.regularSkillMultipler = regularSkillMultipler;
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
}
