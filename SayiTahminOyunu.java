package java101_Oyunlar;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SayiTahminOyunu {
    public static void main(String[] args) {
        Random rand=new Random();
        int number = rand.nextInt(100);

        Scanner input = new Scanner(System.in);
        int tahmin;
        int hak=0;
        boolean isWin=false;
        boolean isWrong=false;
        int [] tahminlerArr = new int[5];

        System.out.println(number);

        while (hak<5){
            System.out.println("Lutfen tahmininizi giriniz");
            tahmin = input.nextInt();

            if (tahmin<1 || tahmin>99){
                System.out.println("Lutfen 0 - 100 arasinda bir sayi giriniz");
                if (isWrong){
                    hak++;
                    System.out.println("Cok fazla hatali giris yaptiniz. Kalan hak: " + (5-hak));
                }else {
                    isWrong=true;
                    System.out.println("Bir sonraki hatali girisinizde hakkiniz azalacaktir!");
                }
                continue;
            }

            if (tahmin == number){
                System.out.println("Tebrikler! \nTahmininiz dogru. \nKazandiniz!");
                isWin=true;
                break;
            }else {
                System.out.println("Yanlis tahmin! Denemeye devam et.");
                if (tahmin>number){
                    System.out.println("Ip ucu: " + tahmin + " sayisi gizli sayidan buyuktur.");
                }else {
                    System.out.println("Ip ucu: " + tahmin + " sayisi gizli sayidan kucuktur.");
                }
            }
            tahminlerArr[hak++] = tahmin;
            System.out.println("Kalan hakkiniz: " + (5-hak));
        }

        if (!isWin) {
            System.out.println("Kaybettiniz");
            if (!isWrong) {
                System.out.println("Tahminleriniz: " + Arrays.toString(tahminlerArr));
            }
        }

    }
}
