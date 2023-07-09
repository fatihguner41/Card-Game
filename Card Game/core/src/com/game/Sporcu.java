
//Sporcu.java------------------------------------------------------------------------------------------------

package com.game;

import java.util.Random;

// Sporcu, futbolcu ve basketbolcu classlari tanimlanir.

public class Sporcu {
    
    Random random = new Random();
    String sporcuIsim;
    String sporcuTakim;
    String sporcuID;
    public Sporcu(String sporcuIsim, String sporcuTakim,String sporcuID) {
        this.sporcuIsim = sporcuIsim;
        this.sporcuTakim = sporcuTakim;
        this.sporcuID = sporcuID;
    }
    
}

class Futbolcu extends Sporcu{
    
    String futbolcuAdi;
    String futbolcuTakim;
    int penaltı;
    int serbestVurus;
    int karsiKarsiya;
    boolean kartKullanildiMi ;
    boolean kartAtildiMi;
    String futbolcuID;
    
    public Futbolcu(String futbolcuAdi, String futbolcuTakim, int serbestVurus, int penaltı, int karsiKarsiya,String futbolcuID) {
        super(futbolcuAdi,futbolcuTakim,futbolcuID);
        this.futbolcuAdi=this.sporcuIsim;
        this.futbolcuTakim = this.sporcuTakim;
        this.futbolcuID = this.sporcuID;
        this.penaltı = penaltı;
        this.serbestVurus = serbestVurus;
        this.karsiKarsiya = karsiKarsiya;
        this.kartKullanildiMi = false;
        this.kartAtildiMi = false;
    }

    
    
    
}

class Basketbolcu extends Sporcu{
    String basketbolcuAdi;
    String basketbolcuTakim;
    String basketbolcuID;
    int ikilik;
    int ucluk;
    int serbestAtis;
    boolean kartKullanildiMi = false;
    boolean kartAtildiMi;

    public Basketbolcu(String basketbolcuAdi, String basketbolcuTakim, int ikilik, int ucluk, int serbestAtis,String basketbolcuID) {
        super(basketbolcuAdi,basketbolcuTakim,basketbolcuID);
        this.basketbolcuAdi = this.sporcuIsim;
        this.basketbolcuTakim = this.sporcuTakim;
        this.basketbolcuID = this.sporcuID;
        this.ikilik = ikilik;
        this.ucluk = ucluk;
        this.serbestAtis = serbestAtis;
        this.kartAtildiMi = false;
    }
    
    


}

