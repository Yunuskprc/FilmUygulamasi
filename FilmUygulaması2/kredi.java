import java.util.Scanner;

public class kredi {
    Scanner scann = new Scanner(System.in);
    String kartNO;
    String sonKT,cvv;
    int krediTutar;

    abonelik  nesAbonelik = new abonelik();

    public void krediAl()
    {
        System.out.print("Almak istediğiniz kredi miktarını girin: ");
        krediTutar=scann.nextInt();
        System.out.println("\nÖdeme Aşamasına Yönlendiriliyorsunuz\n");
        nesAbonelik.sleep(1000);

        System.out.println("\t Kart Bilgilerinizi Girin\n");

        do
        {
            System.out.print("Kart Numarası: ");
            kartNO=scann.nextLine();
            System.out.print("Son Kullanım Tarihi: ");
            sonKT=scann.nextLine();
            System.out.print("CVV : ");
            cvv=scann.nextLine();

            if(kartNO.length()==12)
            {
                if(sonKT.length()==4)
                {
                    if(cvv.length()==3)
                    {
                        System.out.println("Kart Bulundu Ödeme Tamamlanıyor");
                        nesAbonelik.sleep(1000);
                        System.out.println("Ödeme Tamamlandı");
                        break;
                    }
                    else
                    {
                        System.out.println("CVV eksik değer girildi");
                    }
                }
                else
                {
                    System.out.println("Son Kullanma Tarihi eksik değer girildi");
                }
            }
            else
            {
                System.out.println("Kart no eksik değer girildi");
            }
        }while(true);
        
    }

}