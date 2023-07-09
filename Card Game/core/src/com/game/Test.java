
//Test.java------------------------------------------------------------------------------------------------

package com.game;


import java.util.Random;

public class Test {

    //futbolcu ve basketbolcular tanimlanir.
    Boolean kartSirasi=true;
    Random random = new Random();
    Futbolcu[] futbolcuArray = new Futbolcu[10];
    Basketbolcu[] basketbolcuArray = new Basketbolcu[10];
    Futbolcu[] futbolcuDeste = new Futbolcu[4];
    Futbolcu[] futbolcuDeste2 = new Futbolcu[4];
    Basketbolcu[] basketbolcuDeste = new Basketbolcu[4];
    Basketbolcu[] basketbolcuDeste2 = new Basketbolcu[4];
    Futbolcu messi = new Futbolcu("messi", "barcelona", 99, 95, 90, "Messi.png");
    Futbolcu ronaldo = new Futbolcu("ronaldo", "juventus", 75, 95, 95, "Ronaldo.png");
    Futbolcu alex = new Futbolcu("alex", "fenerbahce", 91, 89, 82, "Alex.png");
    Futbolcu bruyne = new Futbolcu("de bruyne", "city", 93, 88, 84, "Bruyne.png");
    Futbolcu guiza = new Futbolcu("guiza", "fenerbahce", 40, 60, 10, "Guiza.png");
    Futbolcu neymar = new Futbolcu("neymar", "PSG", 75, 85, 90, "Neymar.png");
    Futbolcu pirlo = new Futbolcu("pirlo", "juventus", 97, 96, 75, "Pirlo.png");
    Futbolcu ronaldinho = new Futbolcu("ronaldinho", "barcelona", 95, 95, 97, "Ronaldinho.png");
    Futbolcu tolga = new Futbolcu("tolga", "fenerbahce", 90, 90, 95, "Tolga.png");
    Futbolcu zlatan = new Futbolcu("zlatan", "AC Milan", 75, 85, 90, "Zlatan.png");
    Basketbolcu cedi = new Basketbolcu("cedi osman", "cleveland", 75, 77, 78, "Cedi.png");
    Basketbolcu curry = new Basketbolcu("stephen curry", "warriors", 90, 98, 85, "Curry.png");
    Basketbolcu doncic = new Basketbolcu("luka doncic", "mavericks", 90, 92, 86, "Doncic.png");
    Basketbolcu durant = new Basketbolcu("kevin durant", "nets", 93, 91, 92, "Durant.png");
    Basketbolcu harden = new Basketbolcu("james harden", "rockets", 91, 94, 84, "Harden.png");
    Basketbolcu jokic = new Basketbolcu("nikola jokic", "nuggets", 93, 84, 92, "Jokic.png");
    Basketbolcu jordan = new Basketbolcu("michael jordan", "bulls", 98, 90, 96, "Jordan.png");
    Basketbolcu klay = new Basketbolcu("klay thompson", "warriors", 75, 93, 85, "Klay.png");
    Basketbolcu kobe = new Basketbolcu("kobe bryant", "lakers", 96, 94, 94, "Kobe.png");
    Basketbolcu lebron = new Basketbolcu("lebron james", "lakers", 95, 85, 95, "Lebron.png");

    public Test() {
        futbolcuArray[0] = messi;
        futbolcuArray[1] = ronaldo;
        futbolcuArray[2] = alex;
        futbolcuArray[3] = bruyne;
        futbolcuArray[4] = guiza;
        futbolcuArray[5] = neymar;
        futbolcuArray[6] = pirlo;
        futbolcuArray[7] = ronaldinho;
        futbolcuArray[8] = tolga;
        futbolcuArray[9] = zlatan;
        basketbolcuArray[0] = cedi;
        basketbolcuArray[1] = curry;
        basketbolcuArray[2] = doncic;
        basketbolcuArray[3] = durant;
        basketbolcuArray[4] = harden;
        basketbolcuArray[5] = jokic;
        basketbolcuArray[6] = jordan;
        basketbolcuArray[7] = klay;
        basketbolcuArray[8] = kobe;
        basketbolcuArray[9] = lebron;

        //Her kart bir kez kullanilacak sekilde rasgele kart dagitimi yapilir.
        for (int i = 0; i < 4; i++) {
            int rand = ((int) (random.nextInt(10))) % 10;
            int rand2 = ((int) (random.nextInt(10))) % 10;
            if (false == futbolcuArray[rand].kartKullanildiMi && false == futbolcuArray[rand2].kartKullanildiMi && rand!=rand2) {
                futbolcuDeste[i] = futbolcuArray[rand];
                futbolcuDeste2[i] = futbolcuArray[rand2];
                futbolcuArray[rand].kartKullanildiMi = true;
                futbolcuArray[rand2].kartKullanildiMi = true;
            } else {
                i--;
            }
        }
        
        for (int j = 0; j < 4; j++) {
            int rand  = ((int) (random.nextInt(10))) % 10;
            int rand2 = ((int) (random.nextInt(10))) % 10;
            if (false == basketbolcuArray[rand].kartKullanildiMi && false == basketbolcuArray[rand2].kartKullanildiMi && rand!=rand2) {
                basketbolcuDeste[j] = basketbolcuArray[rand];
                basketbolcuDeste2[j] = basketbolcuArray[rand2];
                basketbolcuArray[rand].kartKullanildiMi = true;
                basketbolcuArray[rand2].kartKullanildiMi = true;
            } else {
                j--;
            }

        }

    }
    
    
    
    
    }

    


