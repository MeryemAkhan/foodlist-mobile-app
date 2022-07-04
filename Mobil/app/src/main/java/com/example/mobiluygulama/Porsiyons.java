package com.example.mobiluygulama;

public class Porsiyons {


    //DEGİSKENLERİ TANIMLADIM..
    private String codename, porsiyon,kalori, aciklama;
    private boolean expandable;


    public Porsiyons(String codename, String porsiyon,String kalori,String aciklama) {
        this.aciklama = aciklama;
        this.kalori = kalori;
        this.porsiyon = porsiyon;
        this.codename = codename;
        this.expandable = false; //expandable degiskenini false yaptım..ilk basta bir sey olmadıgı icin
    }

    //constructer ..
    public boolean isExpandable()
    {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }

    public String getAciklama() {
        return aciklama;
    }

    //Olusturdugum nesnelerin üye değişkenlerine değer atama ve içerisindeki değeri kullanırken belirli kontroller..
    //get ve set metodları ..

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public String getKalori() {
        return kalori;
    }

    public void setKalori(String kalori) {
        this.kalori = kalori;
    }

    public String getPorsiyon() {
        return porsiyon;
    }

    public void setPorsiyon(String porsiyon) {
        this.porsiyon = porsiyon;
    }

    //nesnelerin metin karşılıklarını ekrana yazmak için..
    //tostring metodunu override ettim..
    @Override
    public String toString() {
        return "Porsiyons{" +
                "codename='" + codename + '\'' +
                ", porsiyon='" + porsiyon + '\'' +
                ", kalori='" + kalori + '\'' +
                ", aciklama='" + aciklama + '\'' +
                '}';
    }
}
