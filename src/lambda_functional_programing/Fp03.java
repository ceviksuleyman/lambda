package lambda_functional_programing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fp03 {

    public static void main(String[] args) {

        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Amanda");
        liste.add("Christopher");
        liste.add("Jackson");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("Benjamin");
        System.out.println(liste);

        elemanlariBuyukHarfIleYazdir01(liste);
        System.out.println();
        //elemanlariBuyukHarfIleYazdir02(liste);
        uzunlugaGoreYazdir(liste);
        System.out.println();
        uzunlugaGoreTerstenYazdir(liste);
        System.out.println();
        sonKaraktereGoreTekrarsizYazdir(liste);
        System.out.println();
        uzunlukVeIlkHarfeGoreSiralaYazdir(liste);
        System.out.println();
        //uzunlukBestenBuyukleriSil(liste);
        //ilkVeSonKaraktereGoreSil01(liste);
        //ilkVeSonKaraktereGoreSil02(liste);
        //uzunlukVeVerilenKaraktereGoreSil(liste);
        System.out.println(uzunlugu12denAzMi(liste));
        System.out.println(xIleBaslayanYokMu(liste));
        System.out.println(rIleBitenVarMi(liste));

    }

    public static void elemanlariBuyukHarfIleYazdir01(List<String> list) { // 1.YONTEM

        // 1 - list'in tum elemanlarini buyuk harf ile yazdiran bir method olusturun

        System.out.println(list.toString().toUpperCase());//[ALİ, ALİ, MARK, AMANDA, CHRİSTOPHER, JACKSON, MARİANO, ALBERTO, TUCKER, BENJAMİN]

        list.stream().map((String::toUpperCase)).forEach(Utils::ayniSatirdaBosluklaYazdir);

        // output : ALİ ALİ MARK AMANDA CHRİSTOPHER JACKSON MARİANO ALBERTO TUCKER BENJAMİN

    }//method son

    /*
    public static void elemanlariBuyukHarfIleYazdir02(List<String> list){ // 2.YONTEM

        list.replaceAll(String::toUpperCase); // list mutable oldugu icin kalici degisiklik olur

        System.out.println(list); // output : [ALİ, ALİ, MARK, AMANDA, CHRİSTOPHER, JACKSON, MARİANO, ALBERTO, TUCKER, BENJAMİN]

    }//method son
    */

    public static void uzunlugaGoreYazdir(List<String> list) {

        // 2 - Elemanlari uzunluklarina gore siralayip yazdiran bir method olusturun

        list.stream().
                sorted(Comparator.comparing(String::length)). //Comparator.comparing() => siralama kosulunu belirtmek icin kullanilir
                forEach(Utils::ayniSatirdaBosluklaYazdir);

        //output : Ali Ali Mark Amanda Tucker Jackson Mariano Alberto Benjamin Christopher

    }//method son

    public static void uzunlugaGoreTerstenYazdir(List<String> list) {

        // 3 - Elemanlari uzunluklarina gore ters siralayip yazdiran bir method olusturun

        list.stream().
                sorted(Comparator.comparing(String::length).
                        reversed()).
                forEach(Utils::ayniSatirdaBosluklaYazdir);

        //output : Christopher Benjamin Jackson Mariano Alberto Amanda Tucker Mark Ali Ali

    }//method son

    public static void sonKaraktereGoreTekrarsizYazdir(List<String> list) {

        // 4 - Elemanlari son karakterlerine gore siralayip tekrarsiz yazdiran bir method olusturun

        //sorted(Comparator.comparing(t -> t.charAt(t.length()-1)))
        list.stream().distinct().
                sorted(Comparator.comparing(Utils::sonKarakterAl)).
                forEach(Utils::ayniSatirdaBosluklaYazdir);

        //output : Amanda Ali Mark Jackson Benjamin Mariano Alberto Christopher Tucker

    }//method son

    public static void uzunlukVeIlkHarfeGoreSiralaYazdir(List<String> list) {

        // 5 - Elemanlari once uzunluk ve sonra ilk karakterine gore siralayip yazdiran method olusturun

        list.stream().sorted(Comparator.comparing(String::length).// uzunluk kontrol'den
                thenComparing(Utils::ilkKarakteriAl)). // sonra ilk harf kontrol
                forEach(Utils::ayniSatirdaBosluklaYazdir);

        //output : Ali Ali Mark Amanda Tucker Alberto Jackson Mariano Benjamin Christopher

    }//method son


    /*
   public static void uzunlukBestenBuyukleriSil(List<String> list){

       // 6 - Uzunlugu 5'ten buyuk olan elemanlari silen bir method olusturun

       list.removeIf(t-> t.length() > 5); // uzunluk 5'ten buyuk ise sil

       System.out.println(list); // [Ali, Ali, Mark]


   }//method son
   */


     /*
    public static void ilkVeSonKaraktereGoreSil01(List<String> list) { // 1.YONTEM

        // 7 - ‘A’, ‘a’ ile baslayan ya da ‘N’, ‘n’ ile biten elemanlari silen bir method olusturun.

        list.removeIf(t -> t.charAt(0) == 'a'
                || t.charAt(0) == 'A'
                || t.charAt(t.length() - 1) == 'n'
                || t.charAt(t.length() - 1) == 'N');

        System.out.println(list);// [Mark, Christopher, Mariano, Tucker]

    }//method son
     */


    /*
    public static void ilkVeSonKaraktereGoreSil02(List<String> list) { // 2.YONTEM

        list.removeIf(t -> t.startsWith("A") || t.startsWith("a")
                || t.endsWith("n") || t.endsWith("N"));

        System.out.println(list);// [Mark, Christopher, Mariano, Tucker]

    }//method son
     */


    /*
    public static void uzunlukVeVerilenKaraktereGoreSil(List<String> list) {

        // 8 - uzunlugu 8 ile 10 arasinda olan ya da "o" ile biten elemanlari silen bir method olusturun

        list.removeIf(t -> t.length() > 7 && t.length() < 11 || t.endsWith("o"));
        // remove : Benjamin,Alberto,Mariano

        System.out.println(list);// [Ali, Ali, Mark, Amanda, Christopher, Jackson, Tucker]

    }// method son
    */

    public static boolean uzunlugu12denAzMi(List<String> list) {

        //9 - Tum elemanlarin uzunluklarinin 12'den az olup olmadigini kontrol eden method

        System.out.print("elemanlarin Uzunluklari 12 den az mi : ");

        return list.stream().allMatch(t -> t.length() < 12); // true

        // allMatch() => hepsini kontrol ediyor,elemanlarin tumunun uzunlugu 12 den kucukse true

    }//method son

    public static boolean xIleBaslayanYokMu(List<String> list) {

        //10 - Hicbir elemanin "X" ile baslamadigini kontrol eden method olusturun

        System.out.print("x ile baslayan eleman yok mu : ");

        return list.stream().noneMatch(t -> t.startsWith("x") || t.startsWith("X")); // true

        // noneMatch => hicbirisi sarti saglamiyorsa true x ile baslayan yok mu diye kontrol eder

    }//method son

    public static boolean rIleBitenVarMi(List<String> list){

        //11 - Herhangi bir elemanin "r" ile bitip bitmedigini kontrol eden method olusturun

        System.out.print("r ile biten eleman varmi : ");

        return list.stream().anyMatch(t -> t.endsWith("r") || t.endsWith("R")); // true

        // anyMatch => herhangi bir eleman sarti sagliyorsa true

    }//method son


}
