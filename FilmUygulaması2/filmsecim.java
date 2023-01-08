import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;

public class filmsecim {

    String secim,secim2;
    String[] filmTur = {"aksiyon","animasyon","bilim kurgu","dram","gerilim","komedi","korku","macera","romantik","tarih"};
    String[] gruplar = {"aksiyonfilmleri","animasyonfilmleri","bilimkurgufilmleri","dramfilmleri","gerilimfilmleri","komedifilmleri","korkufilmleri","macerafilmleri","romantikfilmler","tarihfilmleri"};
    abonelik nesAbonelik = new abonelik();
    Scanner scann = new Scanner(System.in);

    Connection conn;
    Statement st;

    public void  filmcsec()
    {
        int i=0;
        System.out.println("\n\t\tFilmler\n");
        for(i=0;i<10;i++)
        {
            System.out.println((i+1)+".Tür: "+filmTur[i]);
            nesAbonelik.sleep(300);
        }
        System.out.print("\nFilm türü seçin: ");
        secim=scann.nextLine();

        switch(secim)
        {
            case "aksiyon":
                System.out.println();
                sql(0);
                System.out.println();
                break;
            case "animasyon":
                System.out.println();
                sql(1);
                System.out.println();
                break;
            case "bilim kurgu":
                System.out.println();
                sql(2);
                System.out.println();
                break;
            case "dram":
                System.out.println();
                sql(3);
                System.out.println();
                break;
            case "gerilim":
                System.out.println();
                sql(4);
                System.out.println();
                break;
            case "komedi":
                System.out.println();
                sql(5);
                System.out.println();
                break;
            case "korku":
                System.out.println();
                sql(6);
                System.out.println();
                break;
            case "macera":
                System.out.println();
                sql(7);
                System.out.println();
                break;
            case "romantik":
                System.out.println();
                sql(8);
                System.out.println();
                break;
            case "tarih":
                System.out.println();
                sql(9);
                System.out.println();
                break;
        }

    }

    public void sql(int a)
    {
        int fiyat;
        try {
            
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmsitesi", "root", "Unutma23.");
            st=conn.createStatement();
            ResultSet rs = st.executeQuery("select *from "+gruplar[a]);
            while(rs.next())
            {
                System.out.println(rs.getString("id")+"-) "+rs.getString("film")+" "+rs.getString("fiyat")+"TL");
                nesAbonelik.sleep(500);
            }


            System.out.println("Hangi Filmi seçiyorsunuz ?");
            secim2=scann.next();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/filmsitesi", "root", "Unutma23.");
            st=conn.createStatement();
            rs = st.executeQuery("select *from "+gruplar[a]);
            while(rs.next())
            {
                if(secim2.equalsIgnoreCase(rs.getString("id")))
                {
                    fiyat=Integer.parseInt(rs.getString("fiyat"));
                    if(MAİN.kredi>=fiyat)
                    {
                        nesAbonelik.sleep(800);
                        System.out.println("Satın Alım Başarılı Kitap Kütüphanenize Eklendi!");
                        MAİN.kredi-=fiyat;
                        for(int i=0;i<10;i++)
                        {
                            if(MAİN.kutuphane[i].equals("*"))
                            {
                                MAİN.kutuphane[i]=rs.getString("film");
                                break;
                            }
                        }
                    }
                    else
                    {
                        System.out.println("Kredi Yetersiz Kredi Satın Alın");
                        kredi nesnKredi = new kredi();
                        nesnKredi.krediAl();
                        MAİN.kredi+=nesnKredi.krediTutar;
                    }
                }
            }

            conn.close();
            st.close();
            rs.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        
    }
}

