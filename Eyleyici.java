package Uygulama;

public class Eyleyici implements IEyleyici{
    private String sogutucuDurumu ;

    Eyleyici(){
        sogutucuDurumu = "Kapali";
    }

    public void islemYap(){
            SogutucuAc();
            SogutucuKapat();
    }

    public String SogutucuAc(){
        if (sogutucuDurumu == "Kapali"){
            durumuGuncelle("Acik");
            return "Sogutucu Aciliyor ...\n Sogutucu Acildi ... " ;
        }
        else {
            return "Isleminiz Gerceklesmedi \n Sogutucu Acik Zaten";
        }
    }

    public String SogutucuKapat(){
        if(sogutucuDurumu == "Acik"){
            durumuGuncelle("Kapali");
            return "Sogutucu Kapatiliyor ...\n Sogutucu Kapatildi ... " ;
        }
        else {
            return "Isleminiz Gerceklesmedi \n Sogutucu Kapali Zaten";
        }
    }

    private void durumuGuncelle(String durum){
        this.sogutucuDurumu = durum;
    }

}
