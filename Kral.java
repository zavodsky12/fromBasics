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
public class Kral extends Schopnost implements TypFigurky {
    
    private final char reprezentacia;
    private int farba;
    private HraciePole hp;

    public Kral(int poziciaX, int poziciaY, char rep) {
        super(poziciaX, poziciaY);
        this.reprezentacia = rep;
        this.hp = new HraciePole();
        this.hp.zaplnPoleFigurkami();
        this.hp.rozlisFarby();
        
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
        if (oKolko < 2) {
            switch (pSmer) {
            
            case DOLE:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() + 1, getPoziciaY()) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                
                    
            case HORE:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() - 1, getPoziciaY()) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                    
            case VLAVO:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX(), getPoziciaY() - 1) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                    
            case VPRAVO:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX(), getPoziciaY() + 1) != this.getFarba()) {
                    p = true;
                    break;
                }
                break;
            
            case VLHORE:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() - 1, getPoziciaY() - 1) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                
                    
            case VPHORE:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() - 1, getPoziciaY() + 1) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                    
            case VLDOLE:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() + 1, getPoziciaY() - 1) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                    
            case VPDOLE:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() + 1, getPoziciaY() + 1) != this.getFarba()) {
                    p = true;
                    break;
                }
                break;
                
            default:
                    throw new AssertionError();
        }
    }
        return p;
    }

    @Override
    public void farba(int farba) {
        this.farba = farba;
    }

    @Override
    public void pozicia(int x, int y) {
        super.setPoziciaX(x);
        super.setPoziciaY(y);
    }

    @Override
    public int getFarba() {
        return this.farba;
    }
    
}
