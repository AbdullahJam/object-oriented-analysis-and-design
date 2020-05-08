package Uygulama;

import java.util.Random;

public class SicaklikAlgilayici implements ISicaklikAlgilayici {

    private int sicaklik;
    private Random rand;

    public SicaklikAlgilayici(){
        rand = new Random();
        sicaklikAlgila();
    }

    public void islemYap(){
            sicaklikDegistir();
    }

    private void sicaklikAlgila(){
        sicaklik = rand.nextInt(50); // sicaklik 0-50 arasi rastgele uretme
    }

    private void sicaklikDegistir(){
        sicaklik += rand.nextInt(5) -2 ;
    }

    public int sicaklikGonder(){
        sicaklikDegistir();
        return sicaklik;
    }

}
