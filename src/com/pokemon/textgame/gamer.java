package com.pokemon.textgame;
import java.util.Scanner;

public class gamer extends pokemons {
    private static Scanner input = new Scanner(System.in);

    public gamer(String name, int hpMax, int ppMax, int powerMax) {
        super(name, hpMax, ppMax, powerMax);
    }

    public void chooseSkill(pokemons enemy) {
        if(!isParalyzed()) {
            System.out.println("[1] Tackle");
            System.out.println("[2] HealUp");
            System.out.println("[3] Paralyze");
            System.out.println("[4] BurnUp");
            System.out.println("[5] Flee");
            System.out.println("[*] Wait...");
            System.out.print("Command: ");
            String command = input.next();

            if(command.equals("1")) {
                castTackle(enemy);
            }
            else if (command.equals("2")) {
                castHealUp();
            }
            else if (command.equals("3")) {
                castParalyze(enemy);
            }
            else if (command.equals("4")) {
                castBurn(enemy);
            }
            else if (command.equals("5")) {
                hpActual = 0;
            }
        }
    }
}