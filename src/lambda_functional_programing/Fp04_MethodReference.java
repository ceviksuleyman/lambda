package lambda_functional_programing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Fp04_MethodReference {

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
                sorted(Comparator.comparing(String::length)). //Comparator.comparing => siralama kosulunu belirtmek icin kullanilir
                forEach(Utils::ayniSatirdaBosluklaYazdir);
        //output : Ali Ali Mark Amanda Tucker Jackson Mariano Alberto Benjamin Christopher

    }//method son


}
