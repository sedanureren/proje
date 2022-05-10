package akilliCihaz;

public class Sql  implements Observer,IVeritabani{
    private String adi;
    public void setAdi(String adi) {
        this.adi = adi;
    }

    @Override
    public void update(Observable observable) {
        SicaklikAygilayici sicaklikAygilayici=(SicaklikAygilayici) observable;
        System.out.println(adi+" veritabanına veri gönderildi:"+sicaklikAygilayici.getAnlikSicaklik());
    }

    @Override
    public void veriGonder() {
        System.out.println("sql veritabanına veri gönderildi...");
    }
}
