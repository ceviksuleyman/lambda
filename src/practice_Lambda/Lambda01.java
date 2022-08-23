package practice_Lambda;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda01 {

    static ArrayList<String> names = new ArrayList<>(Arrays.asList("Tulay", "Zekeriya", "Hasan", "ismail", "osman", "Ersin", "Mevlut"));

    static List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 6, 3, 1, 4, 20, 12, 21, 2, 5, 11, 1, 10, 9));

    static List<String> menu = new ArrayList<>(Arrays.asList("kusleme", "kusleme", "adana", "trilice", "havucdilim", "buryan", "kokorec", "kuzutandir", "guvec"));

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

    }//method son

    public static void listCiftElemanlarinCarpimi(List<Integer> list) {

        // Task : List'teki cift elemanlarin carpimini  yazdiriniz.

        //1.yontem method reference
        Integer carpim = list.stream().filter(Methods::getCiftEleman).reduce(Math::multiplyExact).get();
        System.out.println(carpim);

        //2.yontem lambda expression
        System.out.println(list.stream().filter(t -> t % 2 == 0).reduce(1, (t, u) -> t * u));

    }//method son

    public static void teklerinKaresiBuyuktenKucuge(List<Integer> list) {

        // Task : tek sayilarin karesini buyukten kucuge yazdiran method.

        list.stream().
                filter(t -> t % 2 != 0). // tek olan sayilari al
                map(t -> t * t). // tek sayilarin karesini al
                sorted(Comparator.reverseOrder()). // buyukten kucuge yazdirmak icin naturel sirayi terse cevirdik
                forEach(Methods::yazdirprint);

    }//method son

    public static void alfabetikBuyukHarfTekrarsiz(List<String> list) {

        // Task : list elemanlarini buyuk harf ve tekrarsiz print ediniz.

        list.stream().distinct().map(String::toUpperCase).forEach(Methods::yazdirprint);

    }//method son

    public static void strKarakterSayisiYazdir(List<String> list) { // TODO

        // Task : list elemanlarinin character sayisini sirali olarak tekrarsiz yazdirin.





    }//method son

    public static void sonHarfeGoreTersSira(List<String> list) {

        // Task : List elemanlarinin son harfine gore ters sirali print yapiniz.

        list.stream().
                sorted(Comparator.comparing(t -> t.toString().charAt(t.toString().length() - 1)).reversed()).
                forEach(Methods::yazdirprint);

    }//method son

    public static void karakterCiftKareBuyuktenKucuge(List<String> list) { // TODO

        // Task: listin elemanlarinin cift sayili karakterlerinin karelerini hesaplayan ve karelerini tekrarsiz
        // buyukten kucuge dogru sirali print ediniz.




    }//method son

    public static void karakterSayisi7denBuyuk(List<String> list) {

        // Task : list elemanlarinin karakter sayisini 7 ve 7 den buyuk olma durumunu kontrol ediniz.

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

    // anyMatch() --> en az bir eleman sarti saglarsa true aksi durumda false return eder
    // allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    // noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.

    public static void basHarfiWIleBaslayan(List<String> list) {

        // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.

        System.out.println(list.stream().noneMatch(t -> t.toLowerCase().startsWith("w")) ?
                "w ile baslayan eleman yok" : "w ile baslayan eleman var");

    }//method son

    public static void xIleBitenEleman(List<String> list) {

        // Task : List elelmanlarinin "x" ile biten en az bir elemani kontrol ediniz.

        System.out.println(list.stream().anyMatch(t -> t.toLowerCase().endsWith("x")) ?
                "x ile biten eleman var" : "x ile biten eleman yok");

    }//method son

    public static void karakterSayisiEnFazlaEleman(List<String> list) {

        // limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
        // şekilde kesilmiş bir akış return eder. Stream return eder.

        // Task : Karakter sayisi en buyuk elemani yazdiriniz.

        Stream<String> maxEleman =  // limit kullandigimiz icin maxEleman objesine atadik
                list.stream().
                        sorted(Comparator.comparing(t -> t.toString().length()).reversed()).//lenghte gore sartladi ve listi terse cevirdi
                        limit(1); //ilk elemani aldi
                       //.forEach(Methods::yazdir);

        System.out.println(Arrays.toString(maxEleman.toArray()));//stream'a array'a cevirip yazdir

    }//method son

     /*
    TRİCK : Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz.
    Array'i de Arrays.toString() in içine alıp yazdırabiliriz.
    Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.
    */

    public static void sonHarfeGoreSiralaIlkHaricElmanlariYaz(List<String> list) {

        // Task : list elemanlarini son harfine gore siralayip ilk eleman haric print ediniz.

        list.stream().
                sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).forEach(Methods::yazdirprint);

        System.out.println("");

        list.stream().sorted(Comparator.comparing(t -> t.charAt(t.length() - 1))).
                skip(1).
                forEach(Methods::yazdirprint);

        // skip => n kadar atla sonrasini yazdir.

    }//method son


}
