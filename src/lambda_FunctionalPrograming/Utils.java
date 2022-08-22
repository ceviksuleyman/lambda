package lambda_FunctionalPrograming;

public class Utils {

    public static void ayniSatirdaBosluklaYazdir(Object obj) {

        System.out.print(obj + " ");
    } //method son

    public static boolean ciftElemanlariSec(int x) {

        return x % 2 == 0;
    }//method son

    public static boolean tekElemanlariSec(int x) {

        return x % 2 != 0;
    }//method son

    public static int karesiniAl(int x) {

        return x * x;
    }//method son

    public static int kupunuAl(int x) {

        return x * x * x;
    }//method son


    public static double yarisiniAl(double x) {

        return x /= 2;
    }//method son

    public static char sonKarakterAl(String str) {

        return str.charAt(str.length() - 1);
    }//method son

    public static char ilkKarakteriAl(String str) {

        return str.charAt(0);
    }//method son

    public static int rakamlarToplaminiAl(int x) {

        int sum = 0;
        while (x > 0) {

            sum += x % 10;
            x /= 10;
        }
        return sum;

    }//method son

}
