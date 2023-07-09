
//Oyuncu.java------------------------------------------------------------------------------------------------

package com.game;

import java.util.Random;

//oyuncu classi tanimlanir.kullanici ve bilgisayar siniflari bu siniftan extend edilir.
public class Oyuncu {

    int n = 145;
    String oyuncuAdi;
    int skor;
    boolean oyunSirasi = true;
    Test test = new Test();
    Random random = new Random();

    Futbolcu[] futbolcuDeste = test.futbolcuDeste;
    Futbolcu[] futbolcuDeste2 = test.futbolcuDeste2;
    Basketbolcu[] basketbolcuDeste = test.basketbolcuDeste;
    Basketbolcu[] basketbolcuDeste2 = test.basketbolcuDeste2;

    public Oyuncu(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
        this.skor = 0;
    }

    public Oyuncu() {
        this.oyuncuAdi = "oyuncu";
        this.skor = 0;
    }

}

class Kullanici extends Oyuncu {

    String kullaniciAdi;
    int kullaniciSkor;

    public Kullanici() {
        kullaniciAdi = "kullanıcı";
        kullaniciSkor = this.skor = 0;
    }

    public Kullanici(String oyuncuAdi) {
        super(oyuncuAdi);
        kullaniciSkor = this.skor = 0;
        kullaniciAdi = oyuncuAdi;

    }

}

class Bilgisayar extends Oyuncu {

    String bilgisayarAdi;

    public Bilgisayar() {

        bilgisayarAdi = "Bilgisayar";

    }

}
