package akilliCihaz;

public class IstemciModul  {
    IVeritabaniFactory veritabaniFactory;
    public IstemciModul(IVeritabaniFactory veritabaniFactory){
        this.veritabaniFactory=veritabaniFactory;
    }
    public void basla(){
        IVeritabani veritabani=veritabaniFactory.factoryMethod();
    }

}
