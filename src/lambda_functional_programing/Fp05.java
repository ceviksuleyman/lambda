package lambda_functional_programing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp05 {

    public static void main(String[] args) {

        Courses courseTurkishDay = new Courses("Summer", "Turkish Day", 97, 128);
        Courses courseTurkishNight = new Courses("Winter", "Turkish Night", 98, 154);
        Courses courseEnglishDay = new Courses("Spring", "English Day", 95, 132);
        Courses courseEnglishNight = new Courses("Winter", "English Night", 93, 144);
        List<Courses> coursesList = new ArrayList<>();
        coursesList.add(courseTurkishDay);
        coursesList.add(courseTurkishNight);
        coursesList.add(courseEnglishDay);
        coursesList.add(courseEnglishNight);
        System.out.println(coursesList);

        System.out.println("ortalamaPuanlarVerilenSayidanBuyukMu : " + ortalamaPuanlarVerilenSayidanBuyukMu(coursesList, 95));
        System.out.println("kelimeKursAdlariIcndeVarMi : " + kelimeKursAdlariIcndeVarMi(coursesList, "turkish"));
        ortalamasiEnYuksekKursAdi(coursesList);
        System.out.println();
        System.out.println(ortalamaPuanGoreSiralaVeIlkVerilenleriAtla(coursesList, 2));

    }


    // 1 - Tum ortalama puanlarin verilen sayidan buyuk olup olmadigi kontrol etmek icin bir method olusturun
    public static boolean ortalamaPuanlarVerilenSayidanBuyukMu(List<Courses> list, double x) {

        return list.stream().allMatch(t -> t.getAverageScore() > x);

    }//method son


    // 2 - Kurs adlarindan en az birinin verilen kelimeyi icerip icermedigini kontrol etmek icin method olusturun
    public static boolean kelimeKursAdlariIcndeVarMi(List<Courses> list, String str) {

        return list.stream().anyMatch(t -> t.getCourseName().toLowerCase().contains(str.toLowerCase()));

    }//method son


    // 3 - ortalama puani en yuksek olan kursu yazdirmak icin bir method olusturun
    public static void ortalamasiEnYuksekKursAdi(List<Courses> list) {

        int average = list.stream().
                max(Comparator.comparing(Courses::getAverageScore)).get().getAverageScore();

        String course = list.stream().
                sorted(Comparator.comparing(Courses::getAverageScore).reversed()).
                findFirst().get().getCourseName();

        System.out.println("ortalama puani en yuksek kurs : " + course + " => : " + average);

    }//method son


    // 4 - list elemanlarini artan duzende ortalama puana gore siralayin ve ilk verilenleri atlayin.
    public static List<Courses> ortalamaPuanGoreSiralaVeIlkVerilenleriAtla(List<Courses> list, int x) {

        return list.stream().
                sorted(Comparator.comparing(Courses::getAverageScore)).skip(x).collect(Collectors.toList());

        //skip => x kadar atla sonrasini ver

    }//method son
}
