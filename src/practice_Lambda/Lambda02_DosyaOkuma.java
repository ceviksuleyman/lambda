package practice_Lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lambda02_DosyaOkuma {

       /*
       dosya eklemek icin 2 yol var
       1) Files.lines(Path.of("path") buradan stream e eklemek icin Stream <String> satir=Files.lines(Path.of(".........."));
       bu bize tekrardan stream tanimlamadan kullanmayi saglar

       2) //Files.lines(Paths.get("..........")).  kullanilir


         intellj dosya eklemek icin src => new=>file=>text diyoruz ve istedigimiz metni buraya kopyaliyoruz
         bu dosyanin path almak icin dosyanin uzerine gelip sag tikliyoruz(burada dosya C7_TextFile)
         sonrasinda copy path seciyoruz bundan sonra iki secenek var
         1) absolute path seciyoruz yada
         2) path from content root seciyoruz
         her ikisinde de path kopyalamis oluyoruz cevirirken EXCEPTION OLUSMASIN DIYE => throws IOException <= EKLEMELIYIZ
         buda lines altinda kirmizi uyari veriyor uzerine tiklayinca kendiliginden oluyor
         */


    // src/practice_Lambda/siirler.txt

    public static void main(String[] args) throws IOException {

        System.out.println("TASK 1 --> siirler.txt dosyasini konsolda yazdirin -->  ");

        // 1.yontem
        Path siir = Path.of("src/practice_Lambda/siirler.txt"); // siirler dosyasi siir objesine atandi

        Stream<String> akis = Files.lines(siir); // siir objesi akis objesine atanarak Stream class'inda akisa eklendi.

        //akis.forEach(System.out::println);

        //buyuk harfe cevir
        akis.map(String::toString).map(String::toUpperCase).forEach(Methods::yazdirprintln);

        // 2.yontem
        Files.lines(Path.of("src/practice_Lambda/siirler.txt")).forEach(Methods::yazdirprintln);

        // ******************************************************************************************************

        System.out.println("\nTASK 2  -> siirler.txt dosyasindaki ilk satiri buyuk harflerle yazdirin  ->");
        // 1. Yontem
        Files.lines(siir).map(String::toUpperCase).limit(1).forEach(System.out::println);
        // 2. Yontem
        System.out.println(Files.lines(siir).map(String::toUpperCase).findFirst().get());

        // ******************************************************************************************************

        System.out.println("\nTASK 3 -> siirler.txt dosyasinda 'hatir' kelimesinin kac satirda gectiginiz yazdiriniz ->");

        // Kac tane degil kac satirda oldugunu verir.
        System.out.println(Files.lines(siir).map(String::toLowerCase).filter(t -> t.contains("hatir")).count());

        // ******************************************************************************************************

        System.out.println("\nTASK 4 -> siirler.txt dosyasindaki ayni kelimeleri cikartarak (Unique)yazdiriniz. ->");
        //1.yontem
        System.out.println(Files.lines(siir).map(t -> t.split(" ")).
                flatMap(Arrays::stream).map(String::toLowerCase).
                distinct().collect(Collectors.toList()));

        //2.yontem
        System.out.println(Files.lines(siir).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                collect(Collectors.toSet())); // setler unique

        // ******************************************************************************************************

        System.out.println("\nTASK 5 -> siirler.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. ->");

        Files.lines(siir).map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                sorted().  // natural order'a gore siralar
                forEach(Methods::yazdirprint);

        // ******************************************************************************************************

        System.out.println("\n\nTASK 6 -> siirler.txt dosyasinda 'gonlum' kelimesinin kac kere gectigini  yazdiriniz. ->");

        System.out.println(Files.lines(siir).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("gonlum")).count());

        // ******************************************************************************************************

        System.out.println("\nTASK 7 -> siirler.txt dosyasinda 'a' harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. ->");

        System.out.println(Files.lines(siir).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).count());

        // ******************************************************************************************************

        System.out.println("\nTASK 8 -> siirler.txt dosyasinda 'a' harfi gecen kelimeleri  yazdiriniz. ->");

        Files.lines(siir).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t -> t.contains("a")).collect(Collectors.toList()).
                forEach(Methods::yazdirprint);

        // ******************************************************************************************************

        System.out.println("\n\nTASK 9 -> siirler.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. ->");

        System.out.println(Files.lines(siir).
                map(t -> t.replaceAll("\\W", "").replaceAll("\\d", "").split("")).
                flatMap(Arrays::stream).distinct().count());

        // ******************************************************************************************************

        System.out.println("\nTASK 10 -> siirler.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. ->");

        System.out.println(Files.lines(siir).
                map(t -> t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                distinct().
                count());

    }
}
