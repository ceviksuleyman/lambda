package practice_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambda03 {

    //TASK 01: Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.
    public static int toplaAmele(int i) { // Structured programming

        int sum = 0;
        for (int j = 1; j <= i; j++) {
            sum += j;
        }
        return sum;

    }//method son
    public static int toplaCincix(int x) { // Functional Programming

        return IntStream.rangeClosed(1, x).reduce(Math::addExact).getAsInt();

    }//method son

    //*******************************************************************************
    public static int toplaCift(int x) {

        //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

        return IntStream.rangeClosed(1, x).filter(t-> t % 2== 0).sum();

    }//method son


    public static int toplaIlkXCift(int x) {

        //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

        return 0;
    }

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x) {

        return 0;
    }

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x) {


    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void isteneSayiIlkXKuvvetPrint(int istenenSayi, int x) {


    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayiFactorial(int x) {

        return 0;
    }

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static double xKuvveti(int sayi, int x) {

        return 0;
    }

    static String[][] arr = {{"Ali", "Veli", "Ayse"}, {"Hasan", "Can"}, {"Suzan"}};
    public static List<String> mdArrayNaturalSirala(String[][] arr){
         /*
         TASK : 2 Boyutlu bir Multidimensional array i input kabul edip, arraydeki tüm elemanları bir listeye
         kopyalayan ve harf sırasına göre yazdıran bir METHOD yazınız.
         Eg : Input : {{Ali,Veli,Ayse},{Hasan,Can},{Suzan}}
         Output:[Ali, Ayse, Can, Hasan, Suzan, Veli]
         */

        List<String> list = Arrays.stream(arr).flatMap(Arrays::stream).sorted().collect(Collectors.toList());

        return list;
    }// method son

    public static void main(String[] args) {

        System.out.println(mdArrayNaturalSirala(arr));
        System.out.println(toplaAmele(5));
        System.out.println(toplaCincix(5));
        System.out.println(toplaCift(10));


    }
}
