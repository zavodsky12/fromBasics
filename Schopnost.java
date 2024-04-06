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
public abstract class Schopnost {
    
    private int poziciaX;
    private int poziciaY;

    public Schopnost(int poziciaX, int poziciaY) {
        this.poziciaX = poziciaX;
        this.poziciaY = poziciaY;
    }
    
    public int getPoziciaX() {
        return this.poziciaX;
    }
    
    public int getPoziciaY() {
        return this.poziciaY;
    }

    public void setPoziciaX(int poziciaX) {
        this.poziciaX = poziciaX;
    }

    public void setPoziciaY(int poziciaY) {
        this.poziciaY = poziciaY;
    }
    
    public abstract char reprezentacia();
    
    public abstract boolean pohyb(int oKolko, Smer pSmer);
}
