package Uygulama;

public class AkilliCihaz  {

    private IEyleyici eyleyici;
    private ISicaklikAlgilayici sicaklikAlgilayici;
    private IAgArayuzu agArayuzu;
    private Veritabani veritaban;
    private Publisher p;

    private static final String SOGUTUCU_AC = "1";
    private static final String SOGUTUCU_KAPAT = "2";
    private static final String SICAKLIK_GOTUNTULE = "3";
    private static final String CIKIS = "4";

    private static AkilliCihaz instance;

    public static synchronized AkilliCihaz getInstance(){
        if(instance==null)
            instance = new AkilliCihaz();
        return instance;
    }

    private AkilliCihaz(){
        veritaban = new Veritabani();
        eyleyici =new Eyleyici();
        sicaklikAlgilayici =new SicaklikAlgilayici();
        agArayuzu= new AgArayuzu(eyleyici , sicaklikAlgilayici);
        p = new Publisher();
    }

    public void basla(){
        agArayuzu.mesajYazdir("<<< HOS GELDINIZ >>>");
        User kullanici ;
        do {
            agArayuzu.mesajYazdir("Kullanici Adiniz Giriniz : ");
            String userName = agArayuzu.veriAl();
            agArayuzu.mesajYazdir("Sifreniz Giriniz         : ");
            String password = agArayuzu.veriAl();
            kullanici = new User(userName, password);


            if (kullanici.isKontrol()) {
                agArayuzu.mesajYazdir("GIRISINIZ BASARIYLA GERCEKLESTI ... ");
            }
            else {
                agArayuzu.mesajYazdir("Kullanici Adiniz yada Sifreniz Yanlistir ... Luftan Bir Daha Deneyin");
            }
        }while (!kullanici.isKontrol());

        p.attach(kullanici);

        islemSec();

    }

    private void islemSec(){
        String secim;
        do {
            secim = anaMenuGoster();

            switch (secim){
                case SOGUTUCU_AC :
                    agArayuzu.mesajYazdir(eyleyici.SogutucuAc());
                    break;
                case SOGUTUCU_KAPAT:
                    agArayuzu.mesajYazdir(eyleyici.SogutucuKapat());
                    break;
                case SICAKLIK_GOTUNTULE:
                    agArayuzu.SicaklikGonder(sicaklikAlgilayici.sicaklikGonder());
                    break;
                case CIKIS:
                    agArayuzu.mesajYazdir("Cikis Yapiliyor ....");
                    agArayuzu.mesajYazdir(">>> HOSCAKALIN <<<");
                    break;
                default:
                    agArayuzu.mesajYazdir("Yanlis Bir Secenek Sectiniz , Lutfan Bir Daha Seciniz ...");
                    break;
            }
        }while(!secim.equals(CIKIS));
    }

    private String anaMenuGoster(){
        agArayuzu.mesajYazdir("************************************");
        agArayuzu.mesajYazdir(" <<< Ana Menu >>> ");
        agArayuzu.mesajYazdir("1. Sogutucu Ac ");
        agArayuzu.mesajYazdir("2. Sogutucu Kapat");
        agArayuzu.mesajYazdir("3. Sicaklik goster");
        agArayuzu.mesajYazdir("4. Cikis ");
        agArayuzu.mesajYazdir("Lutfan Bir Islem sec : ");
        return agArayuzu.veriAl();
    }

}
