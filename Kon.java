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
public class Kon extends Schopnost implements TypFigurky {
    
    private final char reprezentacia;
    private int farba;
    private HraciePole hp;

    public Kon(int poziciaX, int poziciaY, char rep) {
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
            switch (pSmer) {
            
            case DOLE:
                
                if (this.hp.getFarba(getPoziciaX() + 2, getPoziciaY() - 1) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                
                    
            case HORE:
                
                if (this.hp.getFarba(getPoziciaX() - 2, getPoziciaY() + 1) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                    
            case VLAVO:
                
                if (this.hp.getFarba(getPoziciaX() - 1, getPoziciaY() - 2) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                    
            case VPRAVO:
                
                if (this.hp.getFarba(getPoziciaX() + 1, getPoziciaY() + 2) != this.getFarba()) {
                    p = true;
                    break;
                }
                break;
            
            case VLHORE:
                
                if (this.hp.getFarba(getPoziciaX() - 2, getPoziciaY() - 1) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                
                    
            case VPHORE:
                
                if (this.hp.getFarba(getPoziciaX() - 1, getPoziciaY() + 2) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                    
            case VLDOLE:
                
                if (this.hp.getFarba(getPoziciaX() + 1, getPoziciaY() - 2) != this.getFarba()) {
                    p = true;
                    break;
                }
            break;
                    
            case VPDOLE:
                
                if (this.hp.getFarba(getPoziciaX() + 2, getPoziciaY() + 1) != this.getFarba()) {
                    p = true;
                    break;
                }
                break;
                
            default:
                    throw new AssertionError();
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
