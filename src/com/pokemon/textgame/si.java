package com.pokemon.textgame;
import java.util.concurrent.ThreadLocalRandom;

public class si extends pokemons {
    public si(String name, int hpMax, int ppMax, int powerMax) {
        super(name, hpMax, ppMax, powerMax);
    }
        //check if paralyze is active or has no more pp
    public void chooseSkill(pokemons si) {
        if(isParalyzed()) {
            return;
        }

        if (hpActual == 0) {
           hpActual = 0;
            printClass.println(getName() + " faints because of no more available moves.", 1000);
            return;
        }

        // skill decision
        int decision;
        while(true) {
            decision = ThreadLocalRandom.current().nextInt(0, 4);
            if((decision == 1 && healUp.getppRequirement() > ppActual)
                    || (decision == 1 && hpMax == hpActual)
                    || (decision == 2 && paralyze.getppRequirement() > ppActual)
                    || (decision == 3 && slowBurn.getppRequirement() > ppActual)) {
                continue;
            }
            else {
                break;
            }
        }

        // casting the ability
        if(decision == 0) {
            castTackle(si);
        }
        else if (decision == 1) {
            castHealUp();
        }
        else if (decision == 2) {
            castParalyze(si);
        }
        else if (decision == 3) {
            castBurn(si);
        }
    }
}