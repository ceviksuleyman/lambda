package lambda_functional_programing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02_MethodReference {
    /*
    1) t-> "logic" , (t,u) -> "logic"  => Bu yapi "Lambda Expression"

    2) Functional programming kapsaminda "Lambda Expression" kullanilabilir ama onerilmez.
    "Lambda Expression" yerine "Method Reference" tercih edilir.

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
        System.out.println();
        tekrarsizCiftElemanlarinKareToplami01(liste);
        tekrarsizCiftElemanlarinKareToplami02(liste);
        tekrarsizCiftElemanlarinKareToplami03(liste);
        tekrarsizCiftElemanlarinKupleriCarpimi(liste);
        getMaxEleman(liste);
        getMinEleman(liste);
        yedidenBuyukCiftMinDeger(liste);
        tersSiraliTekrarsizElemanlarinYarisi(liste);
    }

    public static void listElemanlariniYazdirFunctional(List<Integer> list) {

        // 1 - list elemanlarini ayni satirda aralarinda bosluk birakarak yazdiran method olusturun.

        list.stream().forEach(Utils::ayniSatirdaBosluklaYazdir); // 8 9 131 10 9 10 2 8

    }//method son

    //---------------------------------------------------------------------------------------------------------

    public static void ciftElemanlariYazdirFunctional(List<Integer> list) {

        // 2 - list'in cift sayi olan elemanlarini aralarinda bosluk birakarak yazdiran method olusturun

        list.stream().
                filter(Utils::ciftElemanlariSec).
                forEach(Utils::ayniSatirdaBosluklaYazdir); // 8 10 10 2 8

    }//method son

    //----------------------------------------------------------------------------------------------------------

    public static void tekElemanlarinKareleriniYazdir(List<Integer> list) {

        // 3 - list'in tek sayi olan elemanlarinin karelerini ayni satirda aralarinda bosluk olarak yazdiran method olusturun

        list.stream().
                filter(Utils::tekElemanlariSec).
                map(Utils::karesiniAl).
                forEach(Utils::ayniSatirdaBosluklaYazdir); // 81 17161 81

    }//method son

    //-----------------------------------------------------------------------------------------------------------

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list) {

        // 4 - list'in tek sayi olan elemanlarinin kuplerini tekrarsiz olarak ayni satirda aralarda bosluk birakarak yazdiran method olusturun

        list.stream().distinct().
                filter(Utils::tekElemanlariSec).
                map(Utils::kupunuAl).
                forEach(Utils::ayniSatirdaBosluklaYazdir);// 729 2248091

    }//method son

    //---------------------------------------------------------------------------------------------------------

    public static void tekrarsizCiftElemanlarinKareToplami01(List<Integer> list) { // 1.YONTEM

        // 5 - Tekrarsiz cift elemanlarin kareleri toplamini yazdiran bir method olusturun.

        Integer sum = list.stream().distinct().
                filter(Utils::ciftElemanlariSec).
                map(Utils::karesiniAl).
                reduce(Math::addExact).get();

        System.out.println(sum); // 168

    }//method son

    public static void tekrarsizCiftElemanlarinKareToplami02(List<Integer> list) { // 2.YONTEM

        Integer sum = list.stream().distinct().
                filter(Utils::ciftElemanlariSec).
                map(Utils::karesiniAl).
                reduce(0,Math::addExact);

        System.out.println(sum); // 168

    }//method son

    public static void tekrarsizCiftElemanlarinKareToplami03(List<Integer> list) { // 3.YONTEM

        Integer sum = list.stream().distinct().
                filter(Utils::ciftElemanlariSec).
                map(Utils::karesiniAl).
                reduce(0, Integer::sum);

        System.out.println(sum); // 168

    }//method son

    //---------------------------------------------------------------------------------------------------------

    public static void tekrarsizCiftElemanlarinKupleriCarpimi(List<Integer> list) {

        // 6 - Tekrarsiz cift elemanlarin kupunun carpimini hesaplayan bir  method olusturun.

        Integer carpim = list.stream().distinct().
                filter(Utils::ciftElemanlariSec).
                map(Utils::kupunuAl).
                reduce(1, Math::multiplyExact);

        System.out.println(carpim);// 4096000 (10,8,2) elemanlar

    }//method son

    //--------------------------------------------------------------------------------------------------------

    public static void getMaxEleman(List<Integer> list) {

        // 7 - list elemanlari arasindan en buyuk degeri bulan method olusturun

        Integer max = list.stream().distinct().reduce(Math::max).get();

        System.out.println(max); // 131

    }//method son

    //--------------------------------------------------------------------------------------------------------

    public static void getMinEleman(List<Integer> list) {

        // 8 - list elemanlari arasindan en kucuk degeri bulan method olusturun

        Integer min = list.stream().distinct().reduce(Integer.MAX_VALUE, Math::min);

        System.out.println(min); // 2

    }//method son

    //---------------------------------------------------------------------------------------------------------

    public static void yedidenBuyukCiftMinDeger(List<Integer> list) {

        // 9 - list elemanlari arasindan 7'den buyuk, cift, en kucuk degeri bulan method olusturun

        Integer min = list.stream().distinct().
                filter(t -> t > 7).filter(Utils::ciftElemanlariSec).
                reduce(Math::min).get();

        System.out.println(min); // 8

    }//method son

    //---------------------------------------------------------------------------------------------------------

    public static void tersSiraliTekrarsizElemanlarinYarisi(List<Integer> list) {

        // 10 - Ters siralama ile tekrarsiz ve 5'ten buyuk elemanlarin yari(/2) degerlerini bulan method olusturun

        List<Double> methodList =
                list.stream(). // akisa alip gerekli methodlari kullanmamizi sagladi
                distinct(). // tekrarli olanlarin sadece ilkini aldi
                filter(t -> t > 5). // kosula gore filtreleme yapti
                map(Utils::yarisiniAl). // her elemanin degeri degisti
                sorted(Comparator.reverseOrder()). // natural order'a gore ters'ten siraladi
                collect(Collectors.toList()); // Collection'a cevirdi

        System.out.println(methodList); // [65.5, 5.0, 4.5, 4.0]

    }//method son
}
