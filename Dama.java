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
public class Dama extends Schopnost implements TypFigurky {
    
    private final char reprezentacia;
    private int farba;
    private HraciePole hp;

    public Dama(int poziciaX, int poziciaY, char rep) {
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
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() + 1, getPoziciaY()) != this.getFarba()) {
                    p = true;
                    break;
                }
                
                for (int i = 1; i <= oKolko; i++) {
                    if (i != oKolko) {
                        if (this.hp.getFarba(getPoziciaX() + i, getPoziciaY()) == 0) {
                            p = true;
                        } else {
                            p = false;
                            break;
                        }
                    } else {
                        if (this.hp.getFarba(getPoziciaX() + i, getPoziciaY()) == this.farba) {
                            p = false;
                            break;
                        } else {
                            p = true;
                        }
                    }
                }
            break;
                
                    
            case HORE:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() - 1, getPoziciaY()) != this.getFarba()) {
                    p = true;
                    break;
                }
                
                for (int i = 1; i <= oKolko; i++) {
                    if (i != oKolko) {
                        if (this.hp.getFarba(getPoziciaX() - i, getPoziciaY()) == 0) {
                            p = true;
                        } else {
                            p = false;
                            break;
                        }
                    } else {
                        if (this.hp.getFarba(getPoziciaX() - i, getPoziciaY()) == this.farba) {
                            p = false;
                            break;
                        } else {
                            p = true;
                        }
                    }
                }
            break;
                    
            case VLAVO:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX(), getPoziciaY() - 1) != this.getFarba()) {
                    p = true;
                    break;
                }
                
                for (int i = 1; i <= oKolko; i++) {
                    if (i != oKolko) {
                        if (this.hp.getFarba(getPoziciaX(), getPoziciaY() - i) == 0) {
                            p = true;
                        } else {
                            p = false;
                            break;
                        }
                    } else {
                        if (this.hp.getFarba(getPoziciaX(), getPoziciaY() - i) == this.farba) {
                            p = false;
                            break;
                        } else {
                            p = true;
                        }
                    }
                }
            break;
                    
            case VPRAVO:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX(), getPoziciaY() + 1) != this.getFarba()) {
                    p = true;
                    break;
                }
                
                for (int i = 1; i <= oKolko; i++) {
                    if (i != oKolko) {
                        if (this.hp.getFarba(getPoziciaX(), getPoziciaY() + i) == 0) {
                            p = true;
                        } else {
                            p = false;
                            break;
                        }
                    } else {
                        if (this.hp.getFarba(getPoziciaX(), getPoziciaY() + i) == this.farba) {
                            p = false;
                            break;
                        } else {
                            p = true;
                        }
                    }
                }
                break;
            
            case VLHORE:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() - 1, getPoziciaY() - 1) != this.getFarba()) {
                    p = true;
                    break;
                }
                
                for (int i = 1; i <= oKolko; i++) {
                    if (i != oKolko) {
                        if (this.hp.getFarba(getPoziciaX() - i, getPoziciaY() - i) == 0) {
                            p = true;
                        } else {
                            p = false;
                            break;
                        }
                    } else {
                        if (this.hp.getFarba(getPoziciaX() - i, getPoziciaY() - i) == this.farba) {
                            p = false;
                            break;
                        } else {
                            p = true;
                        }
                    }
                }
            break;
                
                    
            case VPHORE:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() - 1, getPoziciaY() + 1) != this.getFarba()) {
                    p = true;
                    break;
                }
                
                for (int i = 1; i <= oKolko; i++) {
                    if (i != oKolko) {
                        if (this.hp.getFarba(getPoziciaX() - i, getPoziciaY() + i) == 0) {
                            p = true;
                        } else {
                            p = false;
                            break;
                        }
                    } else {
                        if (this.hp.getFarba(getPoziciaX() - i, getPoziciaY() + i) == this.farba) {
                            p = false;
                            break;
                        } else {
                            p = true;
                        }
                    }
                }
            break;
                    
            case VLDOLE:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() + 1, getPoziciaY() - 1) != this.getFarba()) {
                    p = true;
                    break;
                }
                
                for (int i = 1; i <= oKolko; i++) {
                    if (i != oKolko) {
                        if (this.hp.getFarba(getPoziciaX() + i, getPoziciaY() - i) == 0) {
                            p = true;
                        } else {
                            p = false;
                            break;
                        }
                    } else {
                        if (this.hp.getFarba(getPoziciaX() + i, getPoziciaY() - i) == this.farba) {
                            p = false;
                            break;
                        } else {
                            p = true;
                        }
                    }
                }
            break;
                    
            case VPDOLE:
                
                if (oKolko == 1 && this.hp.getFarba(getPoziciaX() + 1, getPoziciaY() + 1) != this.getFarba()) {
                    p = true;
                    break;
                }
                
                for (int i = 1; i <= oKolko; i++) {
                    if (i != oKolko) {
                        if (this.hp.getFarba(getPoziciaX() + i, getPoziciaY() + i) == 0) {
                            p = true;
                        } else {
                            p = false;
                            break;
                        }
                    } else {
                        if (this.hp.getFarba(getPoziciaX() + i, getPoziciaY() + i) == this.farba) {
                            p = false;
                            break;
                        } else {
                            p = true;
                        }
                    }
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
