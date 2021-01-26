package com.pokemon.textgame;

public class Skill {
    private pokemons caster;
    private String name;
    private int level;
    private double value;
    private int ppRequirement;

    public Skill(pokemons caster, String name, int level, double value, int ppRequirement) {
        this.caster = caster;
        this.name = name;
        this.level = level;
        this.value = value;
        this.ppRequirement = ppRequirement;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return (int)(caster.getPower() * value * level);
    }

    public int getLevel() {
        return level;
    }

    public int getppRequirement() {
        return ppRequirement * level;
    }
}
