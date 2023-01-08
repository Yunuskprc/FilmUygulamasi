import java.util.Scanner;

public class abonelik {
    String kadiU,sifreU,sifreUT,kadiG,sifreG;
    Scanner scann = new Scanner(System.in);

    public void uyeOl()
    {
        System.out.println("Film Sitesine Hoşgeldiniz Lütfen üye olunuz\n");
        sleep(900);
        do
        {
            System.out.print("Kullanıcı Adı Giriniz: ");
            kadiU=scann.next();
            System.out.print("Şifrenizi Girin: ");
            sifreU=scann.next();
            System.out.print("Şifrenizi Tekrar Girin: ");
            sifreUT=scann.next();
            
            sleep(1500);
            if(sifreU.equals(sifreUT))
            {
                System.out.println("\nKayıt Başaralı Film Sitesine Hoşgeldiniz\n");
                break;
            }
            else
            {
                System.out.println("Şifreler Uyumlu Değil Tekrar Deneyin");
                sleep(1000);
            }
        }while(true);
    }

    public void uyeGirisi()
    {
        sleep(2000);
        System.out.println("\nFilm Sitesine Hoşgeldiniz Lütfen Giriş Yapın\n");
        do
        {
            System.out.print("Kullanıcı Adı Giriniz: ");
            kadiG=scann.next();
            System.out.print("Şifrenizi Girin: ");
            sifreG=scann.next();
            sleep(1000);
            if(kadiG.equals(kadiU))
            {
                if(sifreG.equals(sifreU))
                {
                    System.out.println("Giriş Başarlı Siteye Yönlendiriliyorsunuz...");
                    sleep(1000);
                    break;
                }
                else
                {
                    System.out.println("Sifre Hatalı Tekrar Deneyin");
                }
            }
            else
            {
                System.out.println("Kullanıcı adı bulunamadı Tekrar Deneyin");
            }
            sleep(1000);

        }while(true);
    }

    public void sleep(int duration)
    {
        try {Thread.sleep(duration);} catch (Exception e) {}
    }
}
