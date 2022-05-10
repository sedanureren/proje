package akilliCihaz;

public class SicaklikAygilayici extends Observable implements ISicaklikAygilayici{
    AgArayuzu agArayuzu=new AgArayuzu();
    private int minSicaklik;
    private int maxSicaklik;

    private int anlikSicaklik;

    public SicaklikAygilayici(int anlikSicaklik,int minSicaklik,int maxSicaklik) {
        this.anlikSicaklik=agArayuzu.sicaklik;
        this.maxSicaklik=maxSicaklik;
        this.minSicaklik=minSicaklik;
    }

    @Override
    public void sicaklikOku() {
        agArayuzu.sicaklikGonder();
    }

    public void setAnlikSicaklik(int anlikSicaklik) {
        this.anlikSicaklik = anlikSicaklik;
        sicakligiKontrolEt();
    }

    private void sicakligiKontrolEt() {
        boolean isCokSicak=anlikSicaklik>maxSicaklik;
        boolean isCokSoguk=anlikSicaklik<minSicaklik;
        if (isCokSicak||isCokSoguk){
            haberVer();
        }
    }


    public int getAnlikSicaklik() {
        return anlikSicaklik;
    }
}
