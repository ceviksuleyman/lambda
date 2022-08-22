package lambda_Functional_Programing;

import java.util.stream.IntStream;

public class Fp04 {

    public static void main(String[] args) {

        System.out.println("1.yontem 7'den 100'e kadar sayilar toplam : " + get7den100eToplam01());
        System.out.println("2.yontem 7'den 100'e kadar sayilar toplam : " + get7den100eToplam02());
        System.out.println("2'den 11'e kadar sayilar carpim : " + get2den11eCarpim());
        System.out.println("faktoryel : " + faktoryelHesapla(5));
        System.out.println("xyArasindakiCiftSayiTopla(x, y) = " + xyArasindakiCiftSayiTopla(11, 9));
        System.out.println("ikiSayiArasindakiSayilarinRakamlarininToplami(x,y) = " + ikiSayiArasindakiSayilarinRakamlarininToplami(32, 23));

    }

    public static int get7den100eToplam01() { // 1.YONTEM

        // 1 - 7'den 100'e kadar integer degerlerinin toplamini bulan method olusturun

        return IntStream.range(7, 101).reduce(Math::addExact).getAsInt(); // 5029

        //range() => sondakini dahil etmedigi icin 101 de bitirdik

    }// method son

    public static int get7den100eToplam02() { // 2.YONTEM

        return IntStream.rangeClosed(7, 100).reduce(Math::addExact).getAsInt(); // 5029

        //rangeClosed() => sondaki 100 de dahil ediyor

    }//method son

    //-----------------------------------------------------------------------------------------------------------

    public static int get2den11eCarpim() {

        // 2- 2'den 11'e kadar integer degerlerinin carpimini bulan method olusturun

        return IntStream.rangeClosed(2, 11).reduce(Math::multiplyExact).getAsInt();// 39916800

    }//method son

    //-----------------------------------------------------------------------------------------------------------

    public static int faktoryelHesapla(int x) {

        // 3 - Faktoryel hesaplayan bir method olusturun (5 factorial = 1*2*3*4*5  ==> 5! = 1*2*3*4*5)

        if (x > 0 && x < 13) { // 12'den sonra int kapsami disinda

            return IntStream.rangeClosed(1, x).reduce(Math::multiplyExact).getAsInt();

        } else if (x == 0) return 1;

        else return 0;

    }// method son

    //-----------------------------------------------------------------------------------------------------------

    public static int xyArasindakiCiftSayiTopla(int x, int y) {

        // 4 - Verilen iki sayi arasindaki cift sayilarin toplamini bulan method olusturun

        if (x < y) {

            return IntStream.rangeClosed(x, y).filter(Utils::ciftElemanlariSec).reduce(Integer::sum).stream().sum();

        } else return IntStream.rangeClosed(y, x).filter(Utils::ciftElemanlariSec).reduce(Math::addExact).getAsInt();

    }//method son

    //-----------------------------------------------------------------------------------------------------------

    public static int ikiSayiArasindakiSayilarinRakamlarininToplami(int x, int y) {

        // 5 - iki sayi arasindaki tum sayilarin rakamlarinin toplamini hesaplayan bir method olusturun
        // 23 and 32 ==> 2+3 + 2+4 + 2+5 + 2+6 + 2+7 + 2+8 + 2+9 + 3+0 + 3+1 + 3+2 ==> 68

        int z = 0;
        if (x > y) {
            z = x;
            x = y;
            y = z;
        }

        return IntStream.rangeClosed(x, y).map(Utils::rakamlarToplaminiAl).sum();

    }// method son

}
