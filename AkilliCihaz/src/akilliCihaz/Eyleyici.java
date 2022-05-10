package akilliCihaz;

public class Eyleyici implements IEyleyici{
    @Override
    public void sogutucuAc() {
        System.out.println("Soğutucu Açıldı.");
    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Soğutucu Kapatıldı.");

    }
}
