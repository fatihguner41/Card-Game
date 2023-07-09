
//TestScreen.java------------------------------------------------------------------------------------------------

package com.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import java.util.Random;

//oyunun oynanma sürecini kapsayan oyunu görsel olarak takip etmemizi saglayan class.

public class TestScreen implements Screen {

    public MyGdxGame game;
    int t;

    public TestScreen(MyGdxGame game) {
        this.game = game;
    }

    public TestScreen() {
    }

    Test test = new Test();
    SpriteBatch batch;
    BitmapFont font = new BitmapFont();
    Random random = new Random();
    Oyuncu oyuncu = new Oyuncu();
    Kullanici kullanici = new Kullanici();
    Bilgisayar bilgisayar = new Bilgisayar();
    Boolean[] kartsec = {false, false, false, false};
    boolean birkez = true;
    Futbolcu seciliFutbolcu;
    Basketbolcu seciliBasketbolcu;
    Futbolcu pcseciliFutbolcu;
    Basketbolcu pcseciliBasketbolcu;  
    Sporcu kazananSporcu;
    int rand = random.nextInt(4);
    int randOzellik;
    int x = -72;
    public ShapeRenderer sr;
    public Viewport viewport;

    Texture curry;
    Texture table;
    Texture youlost;
    Texture youwin;
    Texture tie;
    Texture berabere;
    Texture baslat;
    Texture kapalikart;
    Texture[] futbolcuTexture = new Texture[4];
    Texture[] basketbolcuTexture = new Texture[4];
    Texture[] pcfutbolcuTexture = new Texture[4];
    Texture[] pcbasketbolcuTexture = new Texture[4];
    Texture seciliFutbolcuTexture;
    Texture pcseciliFutbolcuTexture;
    Texture seciliBasketbolcuTexture;
    Texture pcseciliBasketbolcuTexture;

    @Override
    public void show() {

        font.getData().setScale(0.5f, 0.5f);
        font.getRegion().getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        font.setColor(Color.GOLD);
        viewport = new FitViewport(150, 100);
        viewport.apply();
        batch = new SpriteBatch();

        sr = new ShapeRenderer();
        sr.setProjectionMatrix(viewport.getCamera().combined);
        batch.setProjectionMatrix(viewport.getCamera().combined);

        table = new Texture("table.png");
        youlost = new Texture("youlost.png");
        youwin = new Texture("youwin.png");
        tie = new Texture("tie.png");
        berabere = new Texture("berabere.png");
        baslat = new Texture("baslat.png");
        kapalikart = new Texture("kapalikart.png");

        for (t = 0; t < 4; t++) {
            futbolcuTexture[t] = new Texture(oyuncu.futbolcuDeste[t].futbolcuID);
            basketbolcuTexture[t] = new Texture(oyuncu.basketbolcuDeste[t].basketbolcuID);
            pcfutbolcuTexture[t] = new Texture(oyuncu.futbolcuDeste2[t].futbolcuID);
            pcbasketbolcuTexture[t] = new Texture(oyuncu.basketbolcuDeste2[t].basketbolcuID);

        }
        seciliFutbolcu = test.messi;
        pcseciliFutbolcu = test.messi;
        seciliBasketbolcu = test.curry;
        pcseciliBasketbolcu = test.curry;
        seciliFutbolcuTexture = new Texture(test.messi.futbolcuID);
        pcseciliFutbolcuTexture = new Texture(test.messi.futbolcuID);
        seciliBasketbolcuTexture = new Texture(test.curry.basketbolcuID);
        pcseciliBasketbolcuTexture = new Texture(test.curry.basketbolcuID);

    }

    @Override
    public void render(float f) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyJustPressed(Keys.R)) {
            game.create();
        }

        batch.begin();

        batch.draw(table, -75, -50, 150, 100);
        

        for (int i = 0; i < 4; i++) {
            if (oyuncu.futbolcuDeste[i].kartAtildiMi == false) {
                batch.draw(futbolcuTexture[i], x + (i + 1) * 15, -30, 12, 17);
            }
            if (oyuncu.basketbolcuDeste[i].kartAtildiMi == false) {
                batch.draw(basketbolcuTexture[i], x + 60 + (i + 1) * 15, -30, 12, 17);
            }
            if (oyuncu.futbolcuDeste2[i].kartAtildiMi == false) {
                batch.draw(kapalikart, x + (i + 1) * 15, 20, 12, 17);
            }
            if (oyuncu.basketbolcuDeste2[i].kartAtildiMi == false) {
                batch.draw(kapalikart, x + 60 + (i + 1) * 15, 20, 12, 17);
            }
        }

        // for (int i = 0; i < 4; i++) {
        boolean b1 = Gdx.input.isKeyJustPressed(145), b2 = Gdx.input.isKeyJustPressed(146), b3 = Gdx.input.isKeyJustPressed(147), b4 = Gdx.input.isKeyJustPressed(148);
        if (b1 || b2 || b3 || b4) {
            if (b1) {
                oyuncu.n = 145;
            }
            if (b2) {
                oyuncu.n = 146;
            }
            if (b3) {
                oyuncu.n = 147;
            }
            if (b4) {
                oyuncu.n = 148;
            }
            if (oyuncu.oyunSirasi == true) {

                if (oyuncu.futbolcuDeste[oyuncu.n - 145].kartAtildiMi == false) {

                    while (oyuncu.futbolcuDeste2[rand].kartAtildiMi == true) {
                        rand = random.nextInt(4);
                    }
                    kartsec[oyuncu.n - 145] = true;

                    if (kartsec[oyuncu.n - 145]) {
                        kartsec[0] = false;
                        kartsec[1] = false;
                        kartsec[2] = false;
                        kartsec[3] = false;
                        kartsec[oyuncu.n - 145] = true;
                    }

                    if (kartsec[oyuncu.n - 145]) {

                        if (seciliFutbolcu != oyuncu.futbolcuDeste[oyuncu.n - 145]) {
                            oyuncu.futbolcuDeste[oyuncu.n - 145].kartAtildiMi = true;
                        }
                        if (pcseciliFutbolcu != oyuncu.futbolcuDeste2[rand]) {
                            oyuncu.futbolcuDeste2[rand].kartAtildiMi = true;
                        }

                        seciliFutbolcu = oyuncu.futbolcuDeste[oyuncu.n - 145];
                        seciliFutbolcuTexture = new Texture(seciliFutbolcu.futbolcuID);
                        batch.draw(futbolcuTexture[oyuncu.n - 145], -13, -5, 12, 17);

                        pcseciliFutbolcu = oyuncu.futbolcuDeste2[rand];
                        pcseciliFutbolcuTexture = new Texture(pcseciliFutbolcu.futbolcuID);
                        batch.draw(pcfutbolcuTexture[rand], 10, -5, 12, 17);
                        oyuncu.oyunSirasi = oyuncu.oyunSirasi ? false : true;
                        randOzellik = random.nextInt(3) % 3;

                        if (kazananSporcu == seciliFutbolcu || kazananSporcu == seciliBasketbolcu) {
                            kullanici.skor += 10;
                        } else if (kazananSporcu == pcseciliFutbolcu || kazananSporcu == pcseciliBasketbolcu) {
                            bilgisayar.skor += 10;
                        }

                    }
                }
            } else if (oyuncu.oyunSirasi == false) {
                if (oyuncu.basketbolcuDeste[oyuncu.n - 145].kartAtildiMi == false) {

                    while (oyuncu.basketbolcuDeste2[rand].kartAtildiMi == true) {
                        rand = random.nextInt(4);
                    }

                    kartsec[oyuncu.n - 145] = true;

                    if (kartsec[oyuncu.n - 145]) {
                        kartsec[0] = false;
                        kartsec[1] = false;
                        kartsec[2] = false;
                        kartsec[3] = false;
                        kartsec[oyuncu.n - 145] = true;
                    }

                    if (kartsec[oyuncu.n - 145]) {

                        oyuncu.basketbolcuDeste[oyuncu.n - 145].kartAtildiMi = true;

                        oyuncu.basketbolcuDeste2[rand].kartAtildiMi = true;

                        seciliBasketbolcu = oyuncu.basketbolcuDeste[oyuncu.n - 145];
                        seciliBasketbolcuTexture = new Texture(seciliBasketbolcu.basketbolcuID);
                        batch.draw(basketbolcuTexture[oyuncu.n - 145], -13, -5, 12, 17);

                        pcseciliBasketbolcu = oyuncu.basketbolcuDeste2[rand];
                        pcseciliBasketbolcuTexture = new Texture(pcseciliBasketbolcu.basketbolcuID);
                        batch.draw(pcbasketbolcuTexture[rand], 10, -5, 12, 17);

                        oyuncu.oyunSirasi = oyuncu.oyunSirasi ? false : true;
                        randOzellik = random.nextInt(3);
                        if (kazananSporcu == seciliFutbolcu || kazananSporcu == seciliBasketbolcu) {
                            kullanici.skor += 10;
                        } else if (kazananSporcu == pcseciliFutbolcu || kazananSporcu == pcseciliBasketbolcu) {
                            bilgisayar.skor += 10;
                        }

                    }

                }
            }

        } else {

            font.draw(batch, "kullanici=" + kullanici.skor, -57f, -35f);
            font.draw(batch, "bilgisayar=" + bilgisayar.skor, -57f, 10f);
            if (oyuncu.oyunSirasi == false && oyunBasladiMi()) {

                batch.draw(seciliFutbolcuTexture, -13, -5, 12, 17);
                batch.draw(pcseciliFutbolcuTexture, 10, -5, 12, 17);
                if (randOzellik == 0 && seciliFutbolcu.karsiKarsiya > pcseciliFutbolcu.karsiKarsiya) {

                    kazananSporcu = seciliFutbolcu;
                    font.draw(batch, "birebir", 30, 12);
                    font.draw(batch, kazananSporcu.sporcuIsim, 30, 5);
                } else if (randOzellik == 0 && seciliFutbolcu.karsiKarsiya < pcseciliFutbolcu.karsiKarsiya) {

                    kazananSporcu = pcseciliFutbolcu;
                    font.draw(batch, "birebir", 30, 12);
                    font.draw(batch, kazananSporcu.sporcuIsim, 30, 5);
                } else if (randOzellik == 0 && seciliFutbolcu.karsiKarsiya == pcseciliFutbolcu.karsiKarsiya) {

                    kazananSporcu = test.guiza;
                    font.draw(batch, "birebir", 30, 12);
                    font.draw(batch, "berabere", 30, 7);
                }

                if (randOzellik == 1 && seciliFutbolcu.penaltı > pcseciliFutbolcu.penaltı) {

                    kazananSporcu = seciliFutbolcu;
                    font.draw(batch, "penalti", 30, 12);
                    font.draw(batch, kazananSporcu.sporcuIsim, 30, 5);
                } else if (randOzellik == 1 && seciliFutbolcu.penaltı < pcseciliFutbolcu.penaltı) {

                    kazananSporcu = pcseciliFutbolcu;
                    font.draw(batch, "penalti", 30, 12);
                    font.draw(batch, kazananSporcu.sporcuIsim, 30, 5);
                } else if (randOzellik == 1 && seciliFutbolcu.penaltı == pcseciliFutbolcu.penaltı) {

                    kazananSporcu = test.guiza;
                    font.draw(batch, "penalti", 30, 12);
                    font.draw(batch, "berabere", 30, 7);
                }
                if (randOzellik == 2 && seciliFutbolcu.serbestVurus > pcseciliFutbolcu.serbestVurus) {

                    kazananSporcu = seciliFutbolcu;
                    font.draw(batch, "frikik", 30, 12);
                    font.draw(batch, kazananSporcu.sporcuIsim, 30, 5);
                } else if (randOzellik == 2 && seciliFutbolcu.serbestVurus < pcseciliFutbolcu.serbestVurus) {

                    kazananSporcu = pcseciliFutbolcu;
                    font.draw(batch, "frikik", 30, 12);
                    font.draw(batch, kazananSporcu.sporcuIsim, 30, 5);
                } else if (randOzellik == 2 && seciliFutbolcu.serbestVurus == pcseciliFutbolcu.serbestVurus) {

                    kazananSporcu = test.guiza;
                    font.draw(batch, "frikik", 30, 12);
                    font.draw(batch, "berabere", 30, 5);
                }

            } else if (oyuncu.oyunSirasi == true && oyunBasladiMi()) {

                batch.draw(seciliBasketbolcuTexture, -13, -5, 12, 17);
                batch.draw(pcseciliBasketbolcuTexture, 10, -5, 12, 17);
                if (randOzellik == 0 && seciliBasketbolcu.ikilik > pcseciliBasketbolcu.ikilik) {

                    kazananSporcu = seciliBasketbolcu;
                    font.draw(batch, "ikilik", 30, 12);
                    font.draw(batch, seciliBasketbolcu.basketbolcuAdi, 30, 7);
                } else if (randOzellik == 0 && seciliBasketbolcu.ikilik < pcseciliBasketbolcu.ikilik) {

                    kazananSporcu = pcseciliBasketbolcu;
                    font.draw(batch, "ikilik", 30, 12);
                    font.draw(batch, pcseciliBasketbolcu.basketbolcuAdi, 30, 7);
                } else if (randOzellik == 0 && seciliBasketbolcu.ikilik == pcseciliBasketbolcu.ikilik) {

                    kazananSporcu = test.guiza;
                    font.draw(batch, "ikilik", 30, 12);
                    font.draw(batch, "berabere", 30, 7);
                }

                if (randOzellik == 1 && seciliBasketbolcu.ucluk > pcseciliBasketbolcu.ucluk) {

                    kazananSporcu = seciliBasketbolcu;
                    font.draw(batch, "ucluk", 30, 12);
                    font.draw(batch, seciliBasketbolcu.basketbolcuAdi, 30, 7);
                } else if (randOzellik == 1 && seciliBasketbolcu.ucluk < pcseciliBasketbolcu.ucluk) {

                    kazananSporcu = pcseciliBasketbolcu;
                    font.draw(batch, "ucluk", 30, 12);
                    font.draw(batch, pcseciliBasketbolcu.basketbolcuAdi, 30, 7);
                } else if (randOzellik == 1 && seciliBasketbolcu.ucluk == pcseciliBasketbolcu.ucluk) {

                    kazananSporcu = test.guiza;
                    font.draw(batch, "ucluk", 30, 12);
                    font.draw(batch, "berabere", 30, 7);
                }
                if (randOzellik == 2 && seciliBasketbolcu.serbestAtis > pcseciliBasketbolcu.serbestAtis) {

                    kazananSporcu = seciliBasketbolcu;
                    font.draw(batch, "serbest atis", 30, 12);
                    font.draw(batch, seciliBasketbolcu.basketbolcuAdi, 30, 7);
                } else if (randOzellik == 2 && seciliBasketbolcu.serbestAtis < pcseciliBasketbolcu.serbestAtis) {

                    kazananSporcu = pcseciliBasketbolcu;
                    font.draw(batch, "serbest atis", 30, 12);
                    font.draw(batch, pcseciliBasketbolcu.basketbolcuAdi, 30, 7);
                } else if (randOzellik == 2 && seciliBasketbolcu.serbestAtis == pcseciliBasketbolcu.serbestAtis) {

                    kazananSporcu = test.guiza;
                    font.draw(batch, "serbest atis", 30, 12);
                    font.draw(batch, "berabere", 30, 7);
                }
            }

        }

        if (oyunBasladiMi() == false) {
            batch.draw(baslat, -13, -5, 12, 17);
            batch.draw(baslat, 10, -5, 12, 17);
        }

        if (kartlarBittiMi()) {

            if ((kazananSporcu == seciliFutbolcu || kazananSporcu == seciliBasketbolcu) && birkez) {
                kullanici.skor += 10;
                birkez = false;
            } else if ((kazananSporcu == pcseciliFutbolcu || kazananSporcu == pcseciliBasketbolcu) && birkez) {
                bilgisayar.skor += 10;
                birkez = false;
            }
            if (kullanici.skor > bilgisayar.skor) {
                batch.draw(youwin, -25, -20, 50, 40);
                font.draw(batch,"r->Restart", -70, 49);
            } else if (kullanici.skor < bilgisayar.skor) {
                batch.draw(youlost, -25, -20, 50, 40);
                font.draw(batch,"r->Restart", -70, 49);
            } else {
                randOzellik = random.nextInt(3);
                birkez=true;
                batch.draw(tie, -25, -20, 50, 40);
                font.draw(batch,"r->Restart", -70, 49);
            }

        }

        rand = random.nextInt(4);

        batch.end();

    }

    @Override
    public void resize(int i, int i1
    ) {
        viewport.update(i, i1);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        sr.dispose();
        table.dispose();
        pcfutbolcuTexture[rand].dispose();
        futbolcuTexture[oyuncu.n - 145].dispose();
        basketbolcuTexture[oyuncu.n - 145].dispose();
        pcbasketbolcuTexture[rand].dispose();
        seciliFutbolcuTexture.dispose();
        pcseciliFutbolcuTexture.dispose();
        seciliBasketbolcuTexture.dispose();
        pcseciliBasketbolcuTexture.dispose();

    }

    boolean kartlarBittiMi() {
        for (int i = 0; i < 4; i++) {
            if (oyuncu.basketbolcuDeste[i].kartAtildiMi == false || oyuncu.futbolcuDeste[i].kartAtildiMi == false) {
                return false;
            }
        }
        return true;
    }

    boolean oyunBasladiMi() {
        for (int i = 0; i < 4; i++) {
            if (oyuncu.basketbolcuDeste[i].kartAtildiMi == true || oyuncu.futbolcuDeste[i].kartAtildiMi == true) {
                return true;
            }
        }
        return false;
    }

}
