/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FromBasics;

/**
 *
 * @author Daniel
 */
public class Pesiak extends Schopnost implements TypFigurky {

    private int farba;
    private final char reprezentacia;
    private HraciePole hp;

    public Pesiak(int poziciaX, int poziciaY, char rep) {
        super(poziciaX, poziciaY);
        this.reprezentacia = rep;
        this.hp = new HraciePole();
        this.hp.zaplnPoleFigurkami();
        this.hp.rozlisFarby();
    }
    
    @Override
    public void farba(int farba) {
        this.farba = farba;
    }
    
    @Override
    public int getFarba() {
        return this.farba;
    }

    @Override
    public void pozicia(int x, int y) {
        super.setPoziciaX(x);
        super.setPoziciaY(y);
    }

    @Override
    public char reprezentacia() {
        return this.reprezentacia;
    }
    
    public void vytvorPole(HraciePole pHp) {
        this.hp = pHp;
    }

    @Override
    public boolean pohyb(int oKolko, Smer pSmer) {
        boolean p = false;
        if (this.hp.getFarba(getPoziciaX(), getPoziciaY()) == 2) {
            switch (pSmer) {
                case DOLE:
                    if (oKolko == 2 && hp.getFarba(getPoziciaX() + 2, getPoziciaY()) == 0 && hp.getFarba(getPoziciaX() + 1, getPoziciaY()) == 0) {
                        p = true;
                    } else {
                        if (oKolko == 1 && hp.getFarba(getPoziciaX() + 1, getPoziciaY()) == 0) {
                            p = true;
                        }
                    }
                    
                    break;
                
                case VPDOLE:
                    if (oKolko == 1 && hp.getFarba(getPoziciaX() + 1, getPoziciaY() + 1) == 1) {
                        p = true;
                    }
                    break;
                
                case VLDOLE:
                    if (oKolko == 1 && hp.getFarba(getPoziciaX() + 1, getPoziciaY() - 1) == 1) {
                        p = true;
                    }
                    break;
                
                default:
                    throw new AssertionError();
            }
        }
        
        if (this.hp.getFarba(getPoziciaX(), getPoziciaY()) == 1) {
            switch (pSmer) {
                case HORE:
                    if (oKolko == 2 && hp.getFarba(getPoziciaX() - 2, getPoziciaY()) == 0 && hp.getFarba(getPoziciaX() - 1, getPoziciaY()) == 0) {
                        p = true;
                    } else {
                        if (oKolko == 1 && hp.getFarba(getPoziciaX() - 1, getPoziciaY()) == 0) {
                            p = true;
                        }
                    }
                    break;
                
                case VLHORE:
                    if (oKolko == 1 && hp.getFarba(getPoziciaX() - 1, getPoziciaY() - 1) == 2) {
                        p = true;
                    }
                    break;
                
                case VPHORE:
                    if (oKolko == 1 && hp.getFarba(getPoziciaX() - 1, getPoziciaY() + 1) == 2) {
                        p = true;
                    }
                    break;
                
                default:
                    throw new AssertionError();
            }
        }
        return p;
    }
        
}
