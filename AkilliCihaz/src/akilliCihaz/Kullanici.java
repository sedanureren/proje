package akilliCihaz;

public class Kullanici {
    private String kullaniciAdi;
    private String sifre;
    private boolean yetki;


    public Kullanici(boolean yetki,String sifre,String kullaniciAdi) {
        this.yetki = yetki;
        this.kullaniciAdi = kullaniciAdi;
        this.sifre = sifre;

    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }

    public boolean isYetki() {
        return yetki;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
    public Kullanici() {
        kullaniciAdi = ""; sifre = "";
    }

}
