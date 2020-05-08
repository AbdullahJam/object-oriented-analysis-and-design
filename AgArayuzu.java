package Uygulama;

import java.util.Scanner;


public class AgArayuzu implements IAgArayuzu{

    private IEyleyici eyletici ;
    private ISicaklikAlgilayici algilayici;

    public AgArayuzu(IEyleyici eyletici ,ISicaklikAlgilayici algilayici ){
        this.eyletici = eyletici;
        this.algilayici = algilayici;
    }

    public void mesajYazdir(String mesaj) {
        System.out.println(mesaj);
    }

    public void SicaklikGonder(int mesaj){
        System.out.println(mesaj);
    }

    public String veriAl() {
        Scanner input=new Scanner(System.in);
        return input.nextLine();
    }



}
