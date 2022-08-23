package practice_Lambda;

public class Methods {

    public static boolean getCiftEleman(int x) {

        return x % 2 == 0;

    }//method son

    public static void yazdirprint(Object obj) {

        System.out.print(obj + " ");

    }//method son

    public static void yazdirprintln(Object obj) {

        System.out.println(obj + " ");
    }

    public static int karaktersayisi(String str) {

        int count = 0;
        for (int i = 0; i < str.length(); i++) {

            count++;

        }
        return count;
    }
}
