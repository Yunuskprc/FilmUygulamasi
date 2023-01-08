import java.util.Scanner;

public class MAİN {
    static int kredi = 0;

    static String[] kutuphane = { "*", "*", "*", "*", "*", "*", "*", "*", "*", "*" };

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        String cevap;
        abonelik nesneA = new abonelik();
        nesneA.uyeOl();
        nesneA.uyeGirisi();

        kredi nesnKredi = new kredi();
        nesnKredi.krediAl();
        kredi += nesnKredi.krediTutar;

        do {
            filmsecim nesfilmSecim = new filmsecim();
            nesfilmSecim.filmcsec();

            System.out.println("Başka bir film almak istiyor musunuz ?");
            cevap = scann.next();
            if (cevap.equals("evet")) {
                System.out.println("\nGüncel Bakiye: " + kredi + "\n");
            } else {
                System.out.println("Kütüphaneyi Görmek istiyor musunuz?");
                cevap = scann.next();
                if (cevap.equals("evet")) {
                    System.out.println();
                    for (int i = 0; i < 10; i++) {
                        if (kutuphane[i].equals("*")) {
                            continue;
                        } else {
                            System.out.println(kutuphane[i]);
                        }
                    }
                }
                break;
            }

        } while (true);

    }

}
