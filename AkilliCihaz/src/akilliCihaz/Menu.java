package akilliCihaz;

import java.util.Scanner;

public class Menu implements IMenu{
    Scanner input = new Scanner(System.in);

    @Override
    public boolean kullaniciGiris() {
        int hata = 0;

        do {
            System.out.println("Kullanıcı Arayüzüne Hoş Geldiniz");
            KullaniciDogrula kullanici = new KullaniciDogrula();
            System.out.println("Oturum açmak için lütfen Kullanıcı Adı ve Parola girin");
            System.out.print("Kullanıcı Adınız: ");
            kullanici.setKullaniciAdi(input.next());
            System.out.print("Parolanız: ");
            kullanici.setSifre(input.next());
            boolean sonuc = kullanici.kullaniciDogrula(kullanici.getKullaniciAdi(), kullanici.getSifre(),kullanici.isYetki());

            if (sonuc) {
                return true;
            }
            hata++;
        }while (hata != 3);
        return false;
    }

    @Override
    public int islemSecimi() {
        System.out.println("");
        System.out.println("İŞLEM MENÜSÜ");
        System.out.println("1.Sıcaklık Göster");
        System.out.println("2.Soğutucuyu Aç");
        System.out.println("3.Soğutucuyu Kapat");
        System.out.println("4.Çıkış");
        System.out.println("");
        int secim = input.nextInt();
        System.out.println("Seçtiğiniz İşlem Numarası: " + secim);
        return secim;
    }

    @Override
    public void Cikis() {
        System.out.println("Oturumunuz başarıyla sonlandırıldı.");
    }

    @Override
    public void islemYap() {

        AgArayuzu agArayuzu=new AgArayuzu();
        Eyleyici eyleyici=new Eyleyici();
        int sicaklik=0;
        if (arayuzGirisi()) {
            int islem = 0;
            do {
                islem = islemSecimi();
                switch (islem) {
                    case 1:
                        int minSicaklik=0;
                        int maxSicaklik=40;
                        SicaklikAygilayici sicaklikAygilayici=new SicaklikAygilayici(sicaklik,minSicaklik,maxSicaklik);
                        sicaklikAygilayici.sicaklikOku();
                        IVeritabaniFactory veritabaniFactory;
                        IstemciModul istemciModul=new IstemciModul(new SqlFactory());
                        istemciModul.basla();
                        VeriTabani sql=new VeriTabani("SQL");
                        sicaklikAygilayici.attach(sql);
                        sicaklikAygilayici.setAnlikSicaklik(sicaklikAygilayici.getAnlikSicaklik());

                        break;
                    case 2:
                        eyleyici.sogutucuAc();
                        break;
                    case 3:
                        eyleyici.sogutucuKapat();
                        break;
                    case 4:
                        Cikis();
                        break;
                    default:
                        System.out.println("Lütfen geçerli bir işlem seçiniz");
                        break;
                }
            }while (islem != 4);
        }else {
            System.out.println("Arayüze giriş yapılmadı");
        }
    }

    @Override
    public boolean arayuzGirisi() {
        return kullaniciGiris();
    }

}
