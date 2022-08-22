package lambda_FunctionalPrograming;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp01_LambdaExpression {
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

          /*
        stream() => datalari yukaridan asagi akis sekline getirir.Stream interface'dir dogrudan obje almaz.

        distinct() => tekrarli elemanlari sadece bir defa akisa sokar.

        reduce() => azaltmak, bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.

        Bir stream icersindeki verilerin teker teker islenmesi,islenme surecinde bir onceki adimda elde edilen sonuc
        bir sonraki adima girdi olarak sunulur.

        Bu sayede yigimli bir hesaplama sureci elde edilmis olur,reduce() method'u ilk parametrede identity degeri,
        ikinci parametrede ise BinaryOperator turunden obje kullanilir.

        reduce()'da bir onceki islemde hesaplanmis deger siradaki deger ile isleme tabi tutulmaktadir.Isleme baslarken
        bir onceki deger olmadigi icin Identity parametresinde tanimlanmaktadir.
        */


        listElemanlariniYazdirStructured(liste);
        System.out.println("");
        listElemanlariniYazdirFunctional(liste);
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
        System.out.println();
        tekrarsizCiftElemanlarinKupununCarpimi(liste);
        getMaxEleman01(liste);
        System.out.println();
        getMaxEleman02(liste);
        System.out.println();
        getMinEleman01(liste);
        System.out.println();
        getMinEleman02(liste);
        System.out.println();
        getYedidenBuyukCiftMin01(liste);
        System.out.println();
        getYedidenBuyukCiftMin02(liste);
        System.out.println();
        getYedidenBuyukCiftMin03(liste);
        System.out.println();
        getTersSiralamaIleTekrarsizElemanlarinYarisi(liste);

    }


    public static void listElemanlariniYazdirStructured(List<Integer> list) {

        // 1 - list elemanlarini ayni satirda aralarinda bosluk birakarak yazdiran bir method olusturun(Structured).

        System.out.print("Structured, ile list elemanlari : ");
        for (Integer w : list) {

            System.out.print(w + " "); //  8 9 131 10 9 10 2 8
        }
    } // method son

    //--------------------------------------------------------------------------------------------------------

    public static void listElemanlariniYazdirFunctional(List<Integer> list) {

        // 2 - list elemanlarini ayni satirda aralarinda bosluk birakarak yazdiran bir method olusturun(Functional).

        System.out.print("Functional, ile list elemanlari : ");
        list.stream().forEach(t -> System.out.print(t + " ")); // 8 9 131 10 9 10 2 8
        //stream() method'u collection'dan elementleri akisa dahil etmek icin ve method'lara ulasmak icin kullanilir.

    }// method son

    //--------------------------------------------------------------------------------------------------------

    public static void ciftElemanlariYazdirStructured(List<Integer> list) {

        // 3 - Cift tamsayi olan list elemanlarini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun.(Structured)

        System.out.print("Structured, list cift sayilari : ");
        for (Integer w : list) {

            if (w % 2 == 0) {

                System.out.print(w + " "); // 8 10 10 2 8
            }
        }
    }// method son

    //-----------------------------------------------------------------------------------------------------------

    public static void ciftElemanlariYazdirFunctional(List<Integer> list) {

        // 4 - Cift tamsayi olan list elemanlarini aynı satırda aralarında boşluk bırakarak yazdıran bir method oluşturun(Functional).

        System.out.print("Functional, list cift sayilari : ");
        list.stream().filter(t -> t % 2 == 0).
                forEach(t -> System.out.print(t + " ")); // 8 10 10 2 8


    }//method son

    //------------------------------------------------------------------------------------------------------------

    public static void tekElemanlarinKaresiniYazdirFunctional(List<Integer> list) {

        // 5 - tek list elemanlarinin karelerini ayni satirda aralarında bosluk birakarak yazdiran bir method olusturan.(Functional)

        System.out.print("Functional, list tek sayilarin kareleri : ");
        list.stream().
                filter(t -> t % 2 != 0).
                map(t -> t * t).
                forEach(t -> System.out.print(t + " ")); // 81 17161 81

        // elemanlarin degeri degisecekse map() method'u kullanilir.

    }//method son

    //-----------------------------------------------------------------------------------------------------------

    public static void tekrarsizTekElemanlarinKupunuYazdir(List<Integer> list) {

        // 6 - tek list elemanlarinin kuplerini tekrarsiz olarak ayni satirda aralarinda bosluk birakarak yazdiran bir method olusturun.

        System.out.print("Functional, list tekrarsiz tek sayilarin kupleri : ");
        list.stream().distinct().
                filter(t -> t % 2 != 0).
                map(t -> t * t * t).
                forEach(t -> System.out.print(t + " ")); // 729 2248091

    }//method son

    //-----------------------------------------------------------------------------------------------------------

    public static void tekrarsizCiftElemanlarinKareToplami(List<Integer> list) {

        // 7 - Tekrarsiz cift elemanlarin karelerinin toplamini hesaplayan bir method olusturun.

        System.out.print("Functional, list tekrarsiz cift sayilarin kareleri toplami : ");
        Integer sum = list.stream().distinct().
                filter(t -> t % 2 == 0).
                map(t -> t * t).
                reduce(0, (t, u) -> t + u);

        System.out.println(sum);// 168

    }//method son

    //-----------------------------------------------------------------------------------------------------------

    public static void tekrarsizCiftElemanlarinKupununCarpimi(List<Integer> list) {

        // 8 - Tekrarsiz cift elemanlarin kupunun carpimini hesaplayan bir method olusturun

        System.out.print("Tekrarsiz cift elemanlarin kupunun carpimi : ");
        Integer carpim = list.stream().distinct().
                filter(t -> t % 2 == 0).
                map(t -> t * t * t).
                reduce(1, (t, u) -> t * u);

        System.out.println(carpim); // 4096000

    }//method son

    //-----------------------------------------------------------------------------------------------------------

    public static void getMaxEleman01(List<Integer> list) { // 1.YONTEM

        // 9 - list elemanlari arasindan en buyuk degeri bulan bir method olusturun.

        System.out.print("1.yontem listteki en buyuk eleman : ");
        Integer max = list.stream().distinct().reduce(Integer.MIN_VALUE, (t, u) -> t > u ? t : u);

        System.out.print(max); // 131

    }//method son

    public static void getMaxEleman02(List<Integer> list) { // 2.YONTEM

        System.out.print("2.yontem listteki en buyuk eleman : ");
        Integer max = list.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t, u) -> u);

        System.out.print(max); // 131

    }//method son

    //-----------------------------------------------------------------------------------------------------------

    public static void getMinEleman01(List<Integer> list) { // 1.YONTEM

        // Odev - list elemanlari arasindan en kucuk degeri bulan method olusturun

        System.out.print("1.yontem listteki en kucuk eleman : ");
        Integer min = list.stream().distinct().
                sorted(Comparator.reverseOrder()).
                reduce(Integer.MAX_VALUE, (t, u) -> u);

        System.out.print(min); // 2

    }//method son

    // sorted() => natural order'a gore siralanmis sekilde akis dondurur.Tekrarli kullanilirsa en son kullanilan aktif olur

    public static void getMinEleman02(List<Integer> list) { // 2.YONTEM

        System.out.print("2.yontem listteki en kucuk eleman : ");
        Integer min = list.stream().distinct().
                reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);

        System.out.print(min); // 2

    }//method son

    //-----------------------------------------------------------------------------------------------------------

    public static void getYedidenBuyukCiftMin01(List<Integer> list) { // 1.YONTEM

        // 10 - list elemanlari arasinda 7'den buyuk cift en kucuk degeri bulan method olusturun.

        System.out.print("1.yontem 7'den buyuk cift min sayi : ");
        Integer min = list.stream().distinct().
                filter(t -> t % 2 == 0).
                filter(t -> t > 7).
                reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);

        System.out.print(min); // 8

    }//method son
    public static void getYedidenBuyukCiftMin02(List<Integer> list) { // 2.YONTEM

        System.out.print("2.yontem 7'den buyuk cift min sayi : ");
        Integer min = list.stream().distinct().
                filter(t -> t % 2 == 0 && t > 7).
                sorted(Comparator.reverseOrder()).
                reduce(Integer.MAX_VALUE, (t, u) -> u); //ters cevirip sondakini aldik

        System.out.print(min); // 8

    }//method son
    public static void getYedidenBuyukCiftMin03(List<Integer> list) { // 3.YONTEM

        System.out.print("3.yontem 7'den buyuk cift min sayi : ");
        Integer min = list.stream().
                filter(t -> t % 2 == 0).
                filter(t -> t > 7).
                sorted().findFirst().get(); // natural order'den sonra ilk elemani aldi

        System.out.print(min); // 8

    }//method son

    //-----------------------------------------------------------------------------------------------------------

    public static void getTersSiralamaIleTekrarsizElemanlarinYarisi(List<Integer> list) {

        // 11 - Ters siralama ile tekrarsiz ve 5'ten buyuk elemanlarin yari degerlerini bulan method olusturun.

        System.out.print("tekrarsiz 5'ten buyuk elemanlarin yarisi degerleri list'i : ");
        List<Double> sonuc = list.stream().distinct().
                filter(t -> t > 5).
                map(t -> t / 2.0). // map(t -> (double)t / 2)
                        sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());

        System.out.println(sonuc); // [65.5, 5.0, 4.5, 4.0]

    }//method son

}
