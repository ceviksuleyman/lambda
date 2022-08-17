package lambda_functional_programing;

import java.util.ArrayList;
import java.util.List;

public class Fp01 {
    /*
    1 - Lambda(Functional Programing), Java 8 ile kullanilmaya baslamistir

    2 - Functional Programing'de "ne yapilacak" (what to do) uzerine yogunlasilir.
    Structured Programming "Nasil yapilacak"(How to do) uzerine yogunlasilir.

    3 - Functional Programing Arrays ve Collections ile kullanilir.

    4 - entrySet() method'u ile Map, Set'e donusturulerek FP'de kullanilabilir.
  */
    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(8);
        System.out.println(liste);


        listElementleriniYazdirStructured(liste);
        System.out.println("");
        listElementleriniYazdirFunctional(liste);
        System.out.println();
        ciftElemanlariYazdirStructured(liste);
        System.out.println();
        ciftElemanlariYazdirFunctional(liste);
        System.out.println();
        tekElemanlarinKaresiniYazdirFunctional(liste);
        System.out.println();
        tekrarsizTekElemanlarinKupunuYazdir(liste);
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami(liste);

    }

    public static void listElementleriniYazdirStructured(List<Integer> list) {

        // Ardisik list elemanlarini ayni satirda aralarinda bosluk birakarak
        // yazdiran bir method olusturun(Structured).

        for (Integer w : list) {

            System.out.print(w + " ");
        }
    } // method sonu


    public static void listElementleriniYazdirFunctional(List<Integer> list) {

        // Ardisik list elemanlarini ayni satirda aralarinda bosluk birakarak
        // yazdiran bir method olusturun(Functional).

        list.stream().forEach(t -> System.out.print(t + " "));
        //stream() method'u collection'dan elementleri akisa dahil etmek icin ve method'lara ulasmak icin kullanilir.

    }// method sonu


    public static void ciftElemanlariYazdirStructured(List<Integer> list) {

        // Cift tamsayi olan list elemanlarini aynı satırda aralarında boşluk bırakarak
        // yazdıran bir method oluşturun.(Structured)

        for (Integer w : list) {

            if (w % 2 == 0) {

                System.out.print(w + " ");
            }
        }
    }// method sonu


    public static void ciftElemanlariYazdirFunctional(List<Integer> list) {

        // Cift tamsayi olan list elemanlarini aynı satırda aralarında boşluk bırakarak
        // yazdıran bir method oluşturun(Functional).

        list.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " "));


    }//method sonu

    public static void tekElemanlarinKaresiniYazdirFunctional(List<Integer> list) {

        // Ardisik tek list elementlerinin karelerini aynı satirda aralarında bosluk birakarak
        // yazdiran bir method olusturan.(Functional)

        list.stream().filter(t -> t % 2 != 0).map(t -> t * t).forEach(t -> System.out.print(t + " "));
        // elemanlarin degeri degisecekse map() method'u kullanilir.

    }//method sonu

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list) {

        // Ardisik tek list elementlerinin kuplerini tekrarsiz olarak ayni satirda aralarinda
        // bosluk birakarak yazdiran bir method olusturun.

        list.stream().distinct().filter(t -> t % 2 != 0).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));

    }//method sonu

    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer> list) {

        // Tekrarsiz cift elemanlarin karelerinin toplamini hesaplayan bir method olusturun.

        Integer sum = list.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (t, u) -> t + u);
        System.out.println(sum);

    }//method sonu

}
