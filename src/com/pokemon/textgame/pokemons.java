package com.pokemon.textgame;

public class pokemons {
    // basic values
    private String name;

    protected int hpMax;
    protected int ppMax;
    protected int powerMax;

    protected int hpActual;
    protected int ppActual;
    protected int powerActual;

    // skills
    protected Skill tackle;
    protected Skill paralyze;
    protected Skill healUp;
    protected Skill slowBurn;

    // state values
    protected boolean alive;
    protected boolean isParalyzed;
    protected int[] isBurned;

    public pokemons(String name, int hpMax, int ppMax, int powerMax) {
        this.name = name;
        this.hpMax = hpMax;
        this.ppMax = ppMax;
        this.powerMax = powerMax;

        this.hpActual = hpMax;
        this.ppActual = ppMax;
        this.powerActual = powerMax;

        // skills
        tackle = new Skill(this, "Tackle", 1, 1, 1);
        paralyze = new Skill(this, "Paralyze", 1, 0.5, 2);
        healUp = new Skill(this, "Heal Wounds", 1, 2, 3);
        slowBurn = new Skill(this, "BurnUP", 1, 0.2, 3);

        // state values
        alive = true;
        isParalyzed = false;

        // how many rounds, how big is damage
        isBurned = new int[2];
    }
    @Override
    public String toString() {
        String text = "";
        text += name + "\n";
        text += "HP:  " + hpActual + " / " + hpMax + "\n";
        text += "PP:  " + ppActual + " / " + ppMax + "\n";
        text += "Power: " + powerMax + " / " + powerMax + "\n";
        return text;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hpMax;
    }

    public int getHpMax() {
        return hpMax;
    }

    public int getPp() {
        return ppActual;
    }

    public int getPpMax() {
        return ppMax;
    }

    public int getPower() {
        return powerActual;
    }

    public boolean isParalyzed() {
        if(isParalyzed) {
            printClass.println(name + " is Paralyzed out and can't move!\n", 1000);
            isParalyzed = false;
            return true;
        } else {
            return false;
        }
    }

    public void isBurned() {
        if(isBurned[0] > 0) {
            printClass.println(name + " is burned!", 1000);
            sustainDamage(isBurned[1]);
            isBurned[0]--;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void sustainDamage(int value) {
        if(value > 0) {
            hpActual -= value;
            printClass.println(name + " has gotten " + value + " damage!\n", 1000);
        }

        if (hpActual <= 0) {
            alive = false;
        }
    }

    public boolean usePp(int value) {
        if(value <= ppActual) {
            ppActual -= value;
            printClass.println(name + " has " + value + " pp decreased!", 1000);
            return true;
        } else {
            printClass.println(name + " has not enough pp!", 1000);
            return false;
        }
    }

    public void cure(int value) {
        int difference = hpMax - hpActual;
        if(value >= difference) {
            hpActual = hpMax;
            printClass.println(name + " is fully healed.", 1000);
        } else {
            hpActual += value;
            printClass.println(name + " has healed " + value + " HP.", 1000);
        }
    }

    public void castTackle(pokemons enemy) {
        printClass.println(name + " uses " + tackle.getName() + " on " + enemy.getName() + "!", 1000);
        if(usePp(tackle.getppRequirement())) {
            enemy.sustainDamage(tackle.getValue());
        }
    }


    public void castHealUp() {
        printClass.println(name + " uses " + healUp.getName() + " !", 1000);
        if(usePp(healUp.getppRequirement())) {
            cure(healUp.getValue());
        }
    }

    public void castParalyze(pokemons enemy) {
        printClass.println(name + " uses " + paralyze.getName() + " on " + enemy.getName() + "!", 1000);
        if(usePp(paralyze.getppRequirement())) {
            enemy.sustainDamage(paralyze.getValue());
            enemy.isParalyzed = true;
            printClass.println(enemy.getName() + " PARALYZED!", 1000);
        }
    }

    public void castBurn(pokemons enemy) {
        printClass.println(name + " uses " + slowBurn.getName() + " on " + enemy.getName() + "!", 1000);
        if(usePp(slowBurn.getppRequirement())) {
            enemy.sustainDamage(powerActual / 2);
            enemy.isBurned[0] = slowBurn.getLevel() + 2;
            enemy.isBurned[1] = slowBurn.getValue();
        }
    }
}
