package com.pokemon.textgame;

public class printClass {
    public static void println(String text, int time) {
        System.out.println(text);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
