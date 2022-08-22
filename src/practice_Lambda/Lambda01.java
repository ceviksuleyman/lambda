package practice_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Lambda01 {

    static ArrayList<String> names = new ArrayList<>(Arrays.asList("Tulay", "Zekeriya", "Hasan", "ismail", "osman", "Ersin", "Mevlut"));

    static List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 6, 23, 11, 4, 22, 12, 23, 45, 44, -22, -55, 11, 11));

    public static void aHarfiIcerenleriSil(ArrayList<String> list) {

        /* TASK :
         * Input olarak verilen listteki isimlerden
         * icinde 'a' harfi bulunanlari silen bir code create ediniz.
         * INPUT : list1={"Ali","Veli","Ayse","Fatma","Omer"}
         * OUTPUT : [Veli,Omer]
         */

        // 1. Yontem
        System.out.println(list.stream(). // akis
                map(String::toLowerCase).// hepsi kucuk harf yapildi
                filter(t -> !t.contains("a")). // a harfi icermeyenleri filtreledi
                collect(Collectors.toList())); // liste cevirdi

        // 2.yontem
        //System.out.println(list.stream().filter(t -> !t.contains("a") && !t.contains("A")).collect(Collectors.toList()));


        // 3.yontem
        //list.removeIf(t -> t.contains("a") || t.contains("A"));
        //System.out.println(list);

    }// method son

    public static void getMaxEleman(List<Integer> list) {

        //Task : List'deki en buyuk elemani bulun

        //1.yontem
        Optional<Integer> max = list.stream().reduce(Math::max);
        System.out.println(max);

        //2.yontem
        Integer max2 = list.stream().reduce(Integer::max).get();
        System.out.println("max2 = " + max2);

    }// method son

    public static void listElemanlarinToplami(List<Integer> list) {

        // Task : listteki elemanlarin toplamini yazdirin

        //1.yontem
        System.out.println(list.stream().reduce(0, (t, u) -> t + u));

        //2.yontem
        System.out.println(list.stream().reduce((t, u) -> t + u).get());

        //3.yontem
        System.out.println(list.stream().reduce(0, Integer::sum));

        //4.yontem
        System.out.println(list.stream().reduce(Math::addExact).get());

        //5.yontem
        System.out.println(list.stream().reduce(0, Math::addExact));

        //6.yontem
        System.out.println(list.stream().reduce(Integer::sum));//get yazarsak direk sayiyi yazdirir.

    }

    public static void listCiftElemanlarinCarpimi(List<Integer> list) {

        // Task : List'teki cift elemanlarin carpimini  yazdiriniz.

        //1.yontem method reference
        Integer carpim = list.stream().filter(Methods::getCiftEleman).reduce(Math::multiplyExact).get();
        System.out.println(carpim);

        //2.yontem lambda expression
        System.out.println(list.stream().filter(t -> t % 2 == 0).reduce(1, (t, u) -> t * u));

    }
}
