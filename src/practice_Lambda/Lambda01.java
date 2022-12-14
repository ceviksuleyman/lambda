package practice_Lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda01 {

    static ArrayList<String> names = new ArrayList<>(Arrays.asList("Tulay", "Zekeriya", "Hasan", "ismail", "osman", "Ersin", "Mevlut"));

    static List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 6, 3, 1, 4, 20, 12, 21, 2, 5, 11, 1, 10, 9));

    static List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "kusleme", "adana", "trilice", "havucdilim", "buryan", "kokorec", "kuzutandir", "guvec"));


    // TASK-1 : Input olarak verilen listteki isimlerden icinde 'a' harfi bulunanlari silen bir code create ediniz.
    // INPUT : list1={"Ali","Veli","Ayse","Fatma","Omer"}
    // OUTPUT : [Veli,Omer]
    public static void aHarfiIcerenleriSil(ArrayList<String> list) {

        System.out.print("TASK-1 =>  \n");
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


    //*****************************************************************************************************


    //Task 2 : List'deki en buyuk elemani bulun
    public static void getMaxEleman(List<Integer> list) {

        System.out.print("TASK-2 =>  \n");
        //1.yontem
        Optional<Integer> max = list.stream().reduce(Math::max);
        System.out.println(max);

        //2.yontem
        Integer max2 = list.stream().reduce(Integer::max).get();
        System.out.println("max2 = " + max2);

    }// method son


    //*****************************************************************************************************


    // Task-3 : listteki elemanlarin toplamini yazdirin
    public static void listElemanlarinToplami(List<Integer> list) {

        System.out.print("TASK-3 =>  \n");
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

    }//method son


    //*****************************************************************************************************


    // Task-4 : List'teki cift elemanlarin carpimini  yazdiriniz.
    public static void listCiftElemanlarinCarpimi(List<Integer> list) {

        System.out.print("TASK-4 =>  \n");
        //1.yontem method reference
        Integer carpim = list.stream().filter(Methods::getCiftEleman).reduce(Math::multiplyExact).get();
        System.out.println(carpim);

        //2.yontem lambda expression
        System.out.println(list.stream().filter(t -> t % 2 == 0).reduce(1, (t, u) -> t * u));

    }//method son


    //*****************************************************************************************************


    // Task-5 : tek sayilarin karesini buyukten kucuge yazdiran method.
    public static void teklerinKaresiBuyuktenKucuge(List<Integer> list) {

        System.out.print("TASK-5 =>  \n");
        list.stream().
                filter(t -> t % 2 != 0). // tek olan sayilari al
                map(t -> t * t). // tek sayilarin karesini al
                sorted(Comparator.reverseOrder()). // buyukten kucuge yazdirmak icin naturel sirayi terse cevirdik
                forEach(Methods::yazdirprint);

    }//method son


    //*****************************************************************************************************


    // Task-6 : list elemanlarini buyuk harf ve tekrarsiz print ediniz.
    public static void alfabetikBuyukHarfTekrarsiz(List<String> list) {

        System.out.print("TASK-6 =>  \n");
        list.stream().distinct().map(String::toUpperCase).forEach(Methods::yazdirprint);

    }//method son


    //*****************************************************************************************************

    public static void strKarakterSayisiYazdir(List<String> list) { // TODO

        // Task-7 : list elemanlarinin character sayisini sirali olarak tekrarsiz yazdirin.

        System.out.print("TASK-7 =>  \n");
        list.stream().distinct().
                sorted(Comparator.comparing(String::length)).
                forEach(t -> System.out.print(t + " "));

        System.out.println();

        list.stream().
                map(String::length).
                sorted().distinct().
                forEach(Methods::yazdirprint);

    }//method son


    //*****************************************************************************************************


    // Task-8 : List elemanlarinin son harfine gore ters sirali print yapiniz.
    public static void sonHarfeGoreTersSira(List<String> list) {

        System.out.print("TASK-8 =>  \n");
        list.stream().
                sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1)).reversed()).
                forEach(Methods::yazdirprint);

    }//method son


    //*****************************************************************************************************

    public static void karakterCiftKareBuyuktenKucuge(List<String> list) { // TODO

        // Task-9 : listin elemanlarinin cift sayili karakterlerinin karelerini hesaplayan ve karelerini tekrarsiz
        // buyukten kucuge dogru sirali print ediniz.


        System.out.print("TASK-9 =>  \n");
        list.stream().
                filter(t -> t.length() % 2 == 0).
                map(t -> t.length() * t.length()).
                distinct().
                sorted(Comparator.reverseOrder()).
                forEach(Methods::yazdirprint);


    }//method son


    //*****************************************************************************************************


    // Task-10 : list elemanlarinin karakter sayisini 7 ve 7 den buyuk olma durumunu kontrol ediniz.
    public static void karakterSayisi7denBuyuk(List<String> list) {

        System.out.print("TASK-10 =>  \n");
        // 1.yontem
        boolean kontrol = list.stream().allMatch(t -> t.length() < 8);
        if (kontrol) {

            System.out.println("list elemanlari 7 ve daha az harften olusmustur");

        } else System.out.println("listin bazi elemanlari 7 karakterden buyuk");

        // 2.yontem
        System.out.println(list.stream().allMatch(t -> t.length() < 8) ?
                "list elemanlari 7 ve daha az harften olusmustur"
                : "listin bazi elemanlari 7 karakterden buyuk");

    }//method son

    //*****************************************************************************************************

    // anyMatch() --> en az bir eleman sarti saglarsa true aksi durumda false return eder
    // allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    // noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    //*****************************************************************************************************

    // Task-11 : List elelmanlarinin "W" ile baslamas??n?? kontrol ediniz.
    public static void basHarfiWIleBaslayan(List<String> list) {

        System.out.print("TASK-11 =>  \n");
        System.out.println(list.stream().noneMatch(t -> t.toLowerCase().startsWith("w")) ?
                "w ile baslayan eleman yok" : "w ile baslayan eleman var");

    }//method son


    //*****************************************************************************************************


    // Task-12 : List elelmanlarinin "x" ile biten en az bir elemani kontrol ediniz.
    public static void xIleBitenEleman(List<String> list) {

        System.out.print("TASK-12 =>  \n");
        System.out.println(list.stream().anyMatch(t -> t.toLowerCase().endsWith("x")) ?
                "x ile biten eleman var" : "x ile biten eleman yok");

    }//method son


    //*****************************************************************************************************


    // Task-13 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void karakterSayisiEnFazlaEleman(List<String> list) {

        // limit(1) => S??n??rland??rma demek. Bu ak??????n elemanlar??ndan olu??an, uzunlu??u maxSize'dan uzun olmayacak
        // ??ekilde kesilmi?? bir ak???? return eder. Stream return eder.

        System.out.print("TASK-13 =>  \n");
        Stream<String> maxEleman =  // limit kullandigimiz icin maxEleman objesine atadik
                list.stream().
                        sorted(Comparator.comparing(t -> t.toString().length()).reversed()).//lenghte gore sartladi ve listi terse cevirdi
                        limit(1); //ilk elemani aldi
        //.forEach(Methods::yazdir);

        System.out.println(Arrays.toString(maxEleman.toArray()));//stream'i array'a cevirip yazdir

    }//method son

    //*****************************************************************************************************

     /*
    TR??CK : Stream'ler ekrana direk yazd??r??lamaz. Stream'i toArray() ile Array'e ??eviririz.
    Array'i de Arrays.toString() in i??ine al??p yazd??rabiliriz.
    ??r; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullan??labilir.
    */


    //*****************************************************************************************************

    // Task-14 : list elemanlarini son harfine gore siralayip ilk eleman haric print ediniz.
    public static void sonHarfeGoreSiralaIlkHaricElmanlariYaz(List<String> list) {

        System.out.print("TASK-14 =>  \n");
        list.stream().
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).forEach(Methods::yazdirprint);

        System.out.println("");

        list.stream().sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).
                skip(1).
                forEach(Methods::yazdirprint);

        // skip => n kadar atla sonrasini yazdir.

    }//method son

}
