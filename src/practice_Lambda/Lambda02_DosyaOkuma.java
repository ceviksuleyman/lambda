package practice_Lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

        System.out.println("TASK 01 --> siirler.txt dosyasini konsolda yazdirin -->  ");

        // 1.yontem
        Path siir = Path.of("src/practice_Lambda/siirler.txt");
        Stream<String> akis = Files.lines(siir);
        //akis.forEach(System.out::println);

        //buyuk harfe cevir
        akis.map(String::toString).map(String::toUpperCase).forEach(Methods::yazdirprintln);

        // 2.yontem
        Files.lines(Path.of("src/practice_Lambda/siirler.txt")).forEach(Methods::yazdirprintln);


        //System.out.println("\nTASK 1 --> siirler.txt dosyasindaki ilk satiri kucuk harflerle yazdirin  -->  ");
        //System.out.println("\nTASK 2 --> siirler.txt dosyasinda basari kelimesinin kac satirda gectiginiz yazdiriniz -->  ");
        //System.out.println("\nTASK 3 --> siirler.txt dosyasindaki ayni kelimeleri cikartarak y yazdiriniz. -->  ");
        //System.out.println("\nTASK 4 --> siirler.txt dosyasindaki tum kelimeleri natural order  yazdiriniz. -->  ");
        //System.out.println("\nTASK 5 --> siirler.txt dosyasinda basari kelimesinin kac kere gectigini  yazdiriniz. -->  ");
        //System.out.println("\nTASK 6 --> siirler.txt dosyasinda a harfi gecen kelimelerin sayisini ekrana yazdiran programi yazdiriniz. -->  ");
        //System.out.println("\nTASK 7 --> siirler.txt dosyasinda a harfi gecen kelimeler yazdiriniz. -->  ");
        //System.out.println("\nTASK 8 --> siirler.txt dosyasinda kac /farklı harf kullanildigini  yazdiriniz. -->  ");
        //System.out.println("\nTASK 9 --> siirler.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");
        //System.out.println("\nTASK 10 --> siirler.txt dosyasinda kac farkli kelime kullanildigini  yazdiriniz. -->  ");

    }
}
