package lambda_functional_programing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Fp02_LambdaExpression {

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

    public static void tekrarsizCiftElemanlarinKupununCarpimi(List<Integer> list) {

        // 8 - Tekrarsiz cift elemanlarin kupunun carpimini hesaplayan bir method olusturun

        System.out.print("Tekrarsiz cift elemanlarin kupunun carpimi : ");
        Integer carpim = list.stream().distinct().
                filter(t -> t % 2 == 0).
                map(t -> t * t * t).
                reduce(1, (t, u) -> t * u);

        System.out.println(carpim); // 4096000

    }//method son

    public static void getMaxEleman01(List<Integer> list) { // 1.yontem

        // 9 - list elemanlari arasindan en buyuk degeri bulan bir method olusturun.

        System.out.print("1.yontem listteki en buyuk eleman : ");
        Integer max = list.stream().distinct().reduce(Integer.MIN_VALUE, (t, u) -> t > u ? t : u);

        System.out.print(max); // 131

    }//method son

    public static void getMaxEleman02(List<Integer> list) { // 2.yontem

        System.out.print("2.yontem listteki en buyuk eleman : ");
        Integer max = list.stream().distinct().sorted().reduce(Integer.MIN_VALUE, (t, u) -> u);

        System.out.print(max); // 131

    }//method son

    public static void getMinEleman01(List<Integer> list) { // 1.yontem

        // Odev - list elemanlari arasindan en kucuk degeri bulan method olusturun

        System.out.print("1.yontem listteki en kucuk eleman : ");
        Integer min = list.stream().distinct().
                sorted(Comparator.reverseOrder()).
                reduce(Integer.MAX_VALUE, (t, u) -> u);

        System.out.print(min); // 2

    }//method son

    // sorted() => natural order'a gore siralanmis sekilde akis dondurur.Tekrarli kullanilirsa en son kullanilan aktif olur

    public static void getMinEleman02(List<Integer> list) { // 2.yontem

        System.out.print("2.yontem listteki en kucuk eleman : ");
        Integer min = list.stream().distinct().
                reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);

        System.out.print(min); // 2

    }//method son

    public static void getYedidenBuyukCiftMin01(List<Integer> list) { // 1.yontem

        // 10 - list elemanlari arasinda 7'den buyuk cift en kucuk degeri bulan method olusturun.

        System.out.print("1.yontem 7'den buyuk cift min sayi : ");
        Integer min = list.stream().distinct().
                filter(t -> t % 2 == 0).
                filter(t -> t > 7).
                reduce(Integer.MAX_VALUE, (t, u) -> t < u ? t : u);

        System.out.print(min); // 8

    }//method son

    public static void getYedidenBuyukCiftMin02(List<Integer> list) { // 2.yontem

        System.out.print("2.yontem 7'den buyuk cift min sayi : ");
        Integer min = list.stream().distinct().
                filter(t -> t % 2 == 0 && t > 7).
                sorted(Comparator.reverseOrder()).
                reduce(Integer.MAX_VALUE, (t, u) -> u); //ters cevirip sondakini aldik

        System.out.print(min); // 8

    }//method son

    public static void getYedidenBuyukCiftMin03(List<Integer> list) { // 3.yontem

        System.out.print("3.yontem 7'den buyuk cift min sayi : ");
        Integer min = list.stream().
                filter(t -> t % 2 == 0).
                filter(t -> t > 7).
                sorted().findFirst().get();

        System.out.print(min); // 8

    }//method son

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

