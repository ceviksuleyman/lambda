package lambda_functional_programing;

import java.util.ArrayList;
import java.util.List;

public class Fp03_MethodReference {
    /*
    1) t-> "logic" , (t,u) -> "logic"  => Bu yapiya "Lambda Expression"

    2) Functional programming kapsaminda "Lambda Expession" kullanilabilir ama onerilmez.
    "Lambda Expession" yerine "Method Reference" tercih edilir.

    3) Method Reference kullanimi "Class Name :: Method Name"

    Ayni zamanda kendi class'larinizi da kullanabilirsiniz.
    Ornegin bir Animal class'iniz var ve bu class "eat()" methoduna sahip ==> "Animal :: eat"
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

        listElemanlariniYazdirFunctional(liste);
        System.out.println();
        ciftElemanlariYazdirFunctional(liste);
        System.out.println();
        tekElemanlarinKareleriniYazdir(liste);
        System.out.println();
        tekrarsizTekElemanlarinKupunuYazdir(liste);
    }

    public static void listElemanlariniYazdirFunctional(List<Integer> list) {

        // 1 - list elemanlarini ayni satirda aralarinda bosluk birakarak yazdiran method olusturun.

        list.stream().forEach(Utils::ayniSatirdaBosluklaYazdir); // 8 9 131 10 9 10 2 8

    }//method son

    public static void ciftElemanlariYazdirFunctional(List<Integer> list) {

        // 2 - list'in cift sayi olan elemanlarini aralarinda bosluk birakarak yazdiran method olusturun

        list.stream().
                filter(Utils::ciftElemanlariSec).
                forEach(Utils::ayniSatirdaBosluklaYazdir);

    }//method son

    public static void tekElemanlarinKareleriniYazdir(List<Integer> list) {

        // 3 - list'in tek sayi olan elemanlarinin karelerini ayni satirda aralarinda bosluk olarak yazdiran method olusturun

        list.stream().
                filter(Utils::tekElemanlariSec).
                map(Utils::karesiniAl).
                forEach(Utils::ayniSatirdaBosluklaYazdir);

    }//method son

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list) {

        // 4 - list'in tek sayi olan elemanlarinin kuplerini tekrarsiz olarak ayni satirda aralarda bosluk birakarak yazdiran method olusturun

        list.stream().distinct().
                filter(Utils::tekElemanlariSec).
                map(Utils::kupunuAl).
                forEach(Utils::ayniSatirdaBosluklaYazdir);

    }//method son
}
