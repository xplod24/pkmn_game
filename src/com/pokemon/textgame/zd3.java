////--
//package com.pokemon.textgame;
//
//public class zd3 {
//
//	public static void main(String[] args) {
//		//System.out.println("n!=" + silnia(5));
//		int[] tablica;
//		int r = 7;
//		tablica = losTab(r);
//		wyswietl(tablica,r);
//		System.out.print("Suma: " + sumaTab(tablica, r));
//
//	}
//
//	public static int sumaTab(int tab[], int rozmiar) {
//		int suma = 0;
//		for(int i = 0; i < rozmiar; i++) {
////			suma = suma + tab[i];
//			suma += tab[i];
//		}
//		return suma;
//	}
//
//
//	public static int[] losTab(int rozmiar) {
//		int [] tab = new int [rozmiar];
//		for(int i = 0; i < rozmiar; i++)
//		{
//			tab[i] = los(1,10);
//		}
//		return tab;
//	}
//
//	public static void wyswietl(int tab[], int rozmiar) {
//		for(int i = 0; i < rozmiar; i++)
//		{
//			System.out.println("tablica[" + i + "]=" + tab[i]);
//		}
//
//
//	}
//
//
//	public static int los(int a, int b) {//zad2
//		int liczba;
//		liczba = a + (int)(Math.random() * (b - a + 1));
//		return liczba;
//	}
//
//	public static int silnia(int n) {
//		if(n == 1)
//			return 1;
//		else
//			return n*silnia(n-1);
//	}
//
//}//
