package practice_Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lambda03 {

    public static void main(String[] args) {

        System.out.println(mdArrayNaturalSirala(arr));
        listtekSayilarinKaresiToplami(numbers);
        System.out.println(toplaAmele(5));
        System.out.println(toplaCincix(5));
        System.out.println(toplaCift(10));
        System.out.println(ilkXCiftSayiyiTopla(3));
        System.out.println(ilkXTekSayiyiTopla(3));
        ikininIlkXKuvvetPrint(3);
        System.out.println();
        isteneSayiIlkXKuvvetPrint(3, 3);

        System.out.println();
        System.out.println(istenenSayiFactorial(5));
        System.out.println(xKuvveti(2, 3));

    }

    static String[][] arr = {{"Ali", "Veli", "Ayse"}, {"Hasan", "Can"}, {"Suzan"}};
    static List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 3, 4));


    public static List<String> mdArrayNaturalSirala(String[][] arr) {
         /*
         TASK advanced 01 : 2 Boyutlu bir Multidimensional array i input kabul edip, arraydeki tüm elemanları bir listeye
         kopyalayan ve harf sırasına göre yazdıran bir METHOD yazınız.
         Eg : Input : {{Ali,Veli,Ayse},{Hasan,Can},{Suzan}}
         Output:[Ali, Ayse, Can, Hasan, Suzan, Veli]
         */

        System.out.print("TASK advanced 01 => ");
        List<String> list = Arrays.stream(arr).flatMap(Arrays::stream).sorted().collect(Collectors.toList());

        return list;

    }// method son


    //***************************************************************************************************

    public static void listtekSayilarinKaresiToplami(List<Integer> list) {

      /*
      TASK advanced 02 : Bir Integer lis olusturun ve bu list'teki yum sayilarin karesinin toplamini bulan
      method create edin.
     */
        System.out.print("TASK advanced 02 => 1.yontem listteki sayilarin kareleri toplami : ");
        System.out.println(list.stream().map(t -> t * t).reduce(0, (t, u) -> t + u));

        System.out.print("TASK advanced 02 => 2.yontem listteki sayilarin kareleri toplami : ");
        System.out.println(list.stream().mapToInt(t -> t * t).sum());

    }// method son


    //***************************************************************************************************

    //TASK 01: Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir program create ediniz.
    public static int toplaAmele(int i) { // Structured programming


        System.out.print("TASK 01 => Structured Toplama : ");
        int sum = 0;
        for (int j = 1; j <= i; j++) {
            sum += j;
        }
        return sum;

    }//method son

    public static int toplaCincix(int x) { // Functional Programming

        System.out.print("TASK 01 => Functional Toplama : ");
        return IntStream.rangeClosed(1, x).sum();

    }//method son


    //***************************************************************************************************
    public static int toplaCift(int x) {

        //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.

        System.out.print("TASK 02 => 1 den " + x + " 'e kadar cift sayilarin toplami : ");
        return IntStream.rangeClosed(1, x).filter(t -> t % 2 == 0).sum();

    }//method son


    //***************************************************************************************************

    public static int ilkXCiftSayiyiTopla(int x) {

        //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.

        System.out.print("TASK 03 => ilk " + x + " CiftSayiyiTopla : ");
        return IntStream.
                iterate(2, t -> t + 2).  // 2 den sonsuza kadar elemanlari 2 artirarak akisa alir.
                        limit(x). // akisdaki ilk x degeri alir.
                        sum(); // topla

    }//method son


    //***************************************************************************************************

    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkXTekSayiyiTopla(int x) {

        System.out.print("TASK 04 => ilk " + x + " TekSayiyiTopla : ");
        return IntStream.
                iterate(1, t -> t + 2). // 1 den sonsuza kadar elemanlari 2 artirarak akisa alir.
                        limit(x).
                sum();

    }//method son


    //***************************************************************************************************

    //TASK 05 --> 2'nin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x) {

        System.out.print("TASK 05 => ikininIlk " + x + " KuvvetPrint : ");
        IntStream.iterate(2, t -> t * 2).limit(x).forEach(Methods::yazdirprint);

    }


    //***************************************************************************************************

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void isteneSayiIlkXKuvvetPrint(int istenenSayi, int x) {

        System.out.print("TASK 06 => " + istenenSayi + " in " + x + ". kuvveti : ");
        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).
                limit(x).
                forEach(Methods::yazdirprint);

    }// method son


    //***************************************************************************************************

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    public static int istenenSayiFactorial(int x) {

        System.out.print("TASK 07 => " + x + " Faktoryel : ");
        //1.yontem
        return IntStream.rangeClosed(1, x).reduce(Math::multiplyExact).stream().sum();

        //2.yontem
        //return IntStream.rangeClosed(1, x).reduce(1, (t, u) -> t * u);

    }//method son


    //***************************************************************************************************

    //TASK 08 --> Istenilen bir sayinin  x. kuvvetini ekrana yazdiran programi  create ediniz.
    public static double xKuvveti(int sayi, int x) {

        System.out.print("TASK 08 => " + sayi + " in " + x + " kuvveti : ");
        double sonuc = Math.pow(sayi, x);

        return sonuc;
    }// method son

}
