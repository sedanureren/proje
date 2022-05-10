package akilliCihaz;

public class VeriTabani implements Observer {
    private String adi;
    public VeriTabani(String adi){
        this.adi=adi;
    }


    @Override
    public void update(Observable observable) {
        SicaklikAygilayici sicaklikAygilayici=(SicaklikAygilayici) observable;
        AgArayuzu agArayuzu=new AgArayuzu();
        System.out.println(adi+" veritabanına gönderilen veri:"+sicaklikAygilayici.getAnlikSicaklik());

    }
}
