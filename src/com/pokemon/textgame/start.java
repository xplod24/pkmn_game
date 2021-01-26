package com.pokemon.textgame;
import java.util.Scanner;
import java.lang.Math;

public class start {

    // okraslanie zmiennych
    private gamer gracz;
    private si ai;
    String nameEnemy;
    String myIs;
    int hpEnemy;
    int ppEnemy;
    int powerEnemy;
    int hpMy;
    int ppMy;
    int powerMy;

    // randomizer
    int randomWithRange(int min, int max){
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    //losowanie mojego pokemona
    public void myPokemon()
    {
        int rand = randomWithRange(1,3);
        switch (rand) {
            case 1: {
                myIs = "Charmander";
                hpMy = 24;
                ppMy = 14;
                powerMy = 6;
            }
            break;
            case 2: {
                myIs = "Squirtle";
                hpMy = 34;
                ppMy = 11;
                powerMy = 4;
            }
            break;
            case 3: {
                myIs = "Bulbasaur";
                hpMy = 21;
                ppMy = 19;
                powerMy = 4;
            }
            break;
        }
    }

    //losowanie przecwnika
    public void enemyType() {

        {
                int rand = randomWithRange(1,5);
                switch (rand) {
                    case 1: {
                        nameEnemy = "Pidgey";
                        hpEnemy = 10;
                        ppEnemy = 5;
                        powerEnemy = 5;
                    }
                    break;
                    case 2: {
                        nameEnemy = "Rattata";
                        hpEnemy = 15;
                        ppEnemy = 10;
                        powerEnemy = 5;
                    }
                    break;
                    case 3: {
                        nameEnemy = "Pikachu";
                        hpEnemy = 20;
                        ppEnemy = 15;
                        powerEnemy = 5;
                    }
                    break;
                    case 4: {
                        nameEnemy = "Weedle";
                        hpEnemy = 25;
                        ppEnemy = 20;
                        powerEnemy = 5;
                    }
                    break;
                    case 5: {
                        nameEnemy = "Mewtwo";
                        hpEnemy = 50;
                        ppEnemy = 50;
                        powerEnemy = 5;
                    }
                    break;
                }
            }
        }

    // staty gracza i przeciwnika
    public start()
    {
        myPokemon();
        enemyType();
        gracz = new gamer(myIs, 20, 20, 10);
        ai = new si(nameEnemy,20 , 20, 10);
    }

    public boolean fight() {
            printClass.println(gracz.getName() + " fights against " + ai.getName(), 1000);
            int rounds = 1;

            while (gracz.getHp() > 0 && ai.getHp() > 0) {
                printClass.println(" --- Round " + rounds + " --- \n", 1000);
                printClass.println(gracz.getName() + " Stats", 0);
                printClass.println("HP: " + gracz.getHp() + "/" + gracz.getHpMax(), 0);
                printClass.println("PP: " + gracz.getPp() + "/" + gracz.getPpMax() + "\n", 1000);
                printClass.println(ai.getName() + " Stats", 0);
                printClass.println("HP: " + ai.getHp() + "/" + ai.getHpMax(), 0);
                printClass.println("PP: " + ai.getPp() + "/" + ai.getPpMax() + "\n", 1000);
                gracz.isBurned();
                if (gracz.getHp() <= 0) break;
                gracz.chooseSkill(ai);
                if (ai.getHp() <= 0 || gracz.getHp() <= 0) break;
                ai.isBurned();
                if (ai.getHp() <= 0) break;
                if (ai.getPp() <= 0) break;
                ai.chooseSkill(gracz);
                rounds++;
            }

            if (gracz.getHp() > 0 && ai.getHp() <= 0 && ai.getPp() == 0) {
                printClass.println("YOU HAVE WON!", 2000);
                printClass.println("THANK YOU FOR PLAYING!", 2000);
                return true;
            } else
                return false;
        }

    public void mainLoop()
    {
        while( fight() );
    }


    public static void main(String[] args) {
        // Output is different everytime this code is executed
        System.out.println("Test randomizera: " + Math.random());
        start start = new start();
        Scanner trainerName = new Scanner(System.in);
        System.out.println("Enter trainer name:");
        String iAm = trainerName.nextLine();
        printClass.println("Hello trainer: " + iAm + " - Welcome to world of Pokemon!", 1000);
        printClass.println("Where you can find a lot of wonderful different creatures!", 1000);
        printClass.println("You'll be given a pokemon at random selction", 1000);
        printClass.println("Possible Pokemon are: Charmander, Squirtle ,Bulbasaur", 1000);
        printClass.println("You are given:", 1000);
        printClass.println(start.myIs, 1000);
        printClass.println("Your enemy is:", 1000);
        printClass.println(start.nameEnemy, 1000);
        start.mainLoop();
    }
}
