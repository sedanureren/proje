package akilliCihaz;

import java.util.Random;

public class AgArayuzu implements IAgArayuzu {
    Random random=new Random();
    int sicaklik= random.nextInt(60);

    @Override
    public void sicaklikGonder(){
        System.out.println("Anlık Sıcaklık:"+sicaklik);
    }
}
