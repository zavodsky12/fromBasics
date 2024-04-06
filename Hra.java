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
public class Hra {
    private Pesiak pesiak;
    private Veza veza;
    private Strelec strelec;
    private Dama dama;
    private Kral kral;
    private Kon kon;
    private HraciePole hp;

    public Hra() {
        this.pesiak = new Pesiak(4, 4, 'i');
        this.veza = new Veza(4, 4, '#');
        this.strelec = new Strelec(4, 4, '$');
        this.dama = new Dama(4, 4, '*');
        this.kral = new Kral(4, 4, '@');
        this.kon = new Kon(4, 4, 'L');
        this.hp = new HraciePole();
        this.hp.zaplnPoleFigurkami();
        this.hp.rozlisFarby();
    }
    
    public void pohyb(int x, int y, int oKolko, Smer pSmer) {
        int farba = this.hp.getFarba(x, y);
        char figurka = this.hp.getFigurka(x, y);
        this.pesiak.vytvorPole(hp);
        this.veza.vytvorPole(hp);
        this.strelec.vytvorPole(hp);
        this.dama.vytvorPole(hp);
        this.kral.vytvorPole(hp);
        this.kon.vytvorPole(hp);
        switch (figurka) {
            case 'i':
                this.pesiak.pozicia(x, y);
                this.pesiak.farba(farba);
                if (this.pesiak.pohyb(oKolko, pSmer) == true) {
                    this.hp.setFarba(x, y, 0);
                    this.hp.setFifurka(x, y, '.');
                    this.pesiak.pohyb(oKolko, pSmer);
                    switch (pSmer) {
                        case HORE:
                            if (oKolko == 1) {
                                this.hp.setFarba(x - 1, y, 1);
                                this.hp.setFifurka(x - 1, y, 'i');
                            } else {
                                if (oKolko == 2) {
                                    this.hp.setFarba(x - 2, y, 1);
                                    this.hp.setFifurka(x - 2, y, 'i');
                                }
                            }
                            break;
    
                        case VLHORE:
                            if (oKolko == 1) {
                                this.hp.setFarba(x - 1, y - 1, 1);
                                this.hp.setFifurka(x - 1, y - 1, 'i');
                            }
                            break;
                            
                        case VPHORE:
                            if (oKolko == 1) {
                                this.hp.setFarba(x - 1, y + 1, 1);
                                this.hp.setFifurka(x - 1, y + 1, 'i');
                            }
                            break;
                            
                        case DOLE:
                            if (oKolko == 1) {
                                this.hp.setFarba(x + 1, y, 2);
                                this.hp.setFifurka(x + 1, y, 'i');
                            } else {
                                if (oKolko == 2) {
                                    this.hp.setFarba(x + 2, y, 2);
                                    this.hp.setFifurka(x + 2, y, 'i');
                                }
                            }
                            break;
                            
                        case VLDOLE:
                            if (oKolko == 1) {
                                this.hp.setFarba(x + 1, y - 1, 2);
                                this.hp.setFifurka(x + 1, y - 1, 'i');
                            }
                            break;
                            
                        case VPDOLE:
                            if (oKolko == 1) {
                                this.hp.setFarba(x + 1, y + 1, 2);
                                this.hp.setFifurka(x + 1, y + 1, 'i');
                            }
                            break;
                            
                        default:
                            throw new AssertionError();
                    }
                }
                break;
                
            case '#':
                this.veza.pozicia(x, y);
                this.veza.farba(farba);
                if (this.veza.pohyb(oKolko, pSmer) == true) {
                    this.hp.setFarba(x, y, 0);
                    this.hp.setFifurka(x, y, '.');
                    this.veza.pohyb(oKolko, pSmer);
                    System.out.println(pSmer);
                    switch (pSmer) {
                        case HORE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.veza.getFarba() == 2) {
                                        this.hp.setFarba(x - i, y, 2);
                                        this.hp.setFifurka(x - i, y, '#');
                                        break;
                                    } else {
                                        this.hp.setFarba(x - i, y, 1);
                                        this.hp.setFifurka(x - i, y, '#');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case DOLE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.veza.getFarba() == 2) {
                                        this.hp.setFarba(x + i, y, 2);
                                        this.hp.setFifurka(x + i, y, '#');
                                        break;
                                    } else {
                                        this.hp.setFarba(x + i, y, 1);
                                        this.hp.setFifurka(x + i, y, '#');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VLAVO:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.veza.getFarba() == 2) {
                                        this.hp.setFarba(x, y - i, 2);
                                        this.hp.setFifurka(x, y - i, '#');
                                        break;
                                    } else {
                                        this.hp.setFarba(x, y - i, 1);
                                        this.hp.setFifurka(x, y - i, '#');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VPRAVO:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.veza.getFarba() == 2) {
                                        this.hp.setFarba(x, y + i, 2);
                                        this.hp.setFifurka(x, y + i, '#');
                                        break;
                                    } else {
                                        this.hp.setFarba(x, y + i, 1);
                                        this.hp.setFifurka(x, y + i, '#');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        default:
                            throw new AssertionError();
                    }
                    break;
                }
                break;
                
                case '$':
                this.strelec.pozicia(x, y);
                this.strelec.farba(farba);
                if (this.strelec.pohyb(oKolko, pSmer) == true) {
                    this.hp.setFarba(x, y, 0);
                    this.hp.setFifurka(x, y, '.');
                    this.strelec.pohyb(oKolko, pSmer);
                    System.out.println(pSmer);
                    switch (pSmer) {
                        case VLHORE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.strelec.getFarba() == 2) {
                                        this.hp.setFarba(x - i, y - i, 2);
                                        this.hp.setFifurka(x - i, y - i, '$');
                                        break;
                                    } else {
                                        this.hp.setFarba(x - i, y - i, 1);
                                        this.hp.setFifurka(x - i, y - i, '$');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VPHORE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.strelec.getFarba() == 2) {
                                        this.hp.setFarba(x - i, y + i, 2);
                                        this.hp.setFifurka(x - i, y + i, '$');
                                        break;
                                    } else {
                                        this.hp.setFarba(x - i, y + i, 1);
                                        this.hp.setFifurka(x - i, y + i, '$');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VLDOLE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.strelec.getFarba() == 2) {
                                        this.hp.setFarba(x + i, y - i, 2);
                                        this.hp.setFifurka(x + i, y - i, '$');
                                        break;
                                    } else {
                                        this.hp.setFarba(x + i, y - i, 1);
                                        this.hp.setFifurka(x + i, y - i, '$');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VPDOLE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.strelec.getFarba() == 2) {
                                        this.hp.setFarba(x + i, y + i, 2);
                                        this.hp.setFifurka(x + i, y + i, '$');
                                        break;
                                    } else {
                                        this.hp.setFarba(x + i, y + i, 1);
                                        this.hp.setFifurka(x + i, y + i, '$');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        default:
                            throw new AssertionError();
                    }
                    break;
                }
                break;
             
                case '*':
                this.dama.pozicia(x, y);
                this.dama.farba(farba);
                if (this.dama.pohyb(oKolko, pSmer) == true) {
                    this.hp.setFarba(x, y, 0);
                    this.hp.setFifurka(x, y, '.');
                    this.dama.pohyb(oKolko, pSmer);
                    System.out.println(pSmer);
                    switch (pSmer) {
                        case HORE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.dama.getFarba() == 2) {
                                        this.hp.setFarba(x - i, y, 2);
                                        this.hp.setFifurka(x - i, y, '*');
                                        break;
                                    } else {
                                        this.hp.setFarba(x - i, y, 1);
                                        this.hp.setFifurka(x - i, y, '*');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case DOLE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.dama.getFarba() == 2) {
                                        this.hp.setFarba(x + i, y, 2);
                                        this.hp.setFifurka(x + i, y, '*');
                                        break;
                                    } else {
                                        this.hp.setFarba(x + i, y, 1);
                                        this.hp.setFifurka(x + i, y, '*');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VLAVO:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.dama.getFarba() == 2) {
                                        this.hp.setFarba(x, y - i, 2);
                                        this.hp.setFifurka(x, y - i, '*');
                                        break;
                                    } else {
                                        this.hp.setFarba(x, y - i, 1);
                                        this.hp.setFifurka(x, y - i, '*');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VPRAVO:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.dama.getFarba() == 2) {
                                        this.hp.setFarba(x, y + i, 2);
                                        this.hp.setFifurka(x, y + i, '*');
                                        break;
                                    } else {
                                        this.hp.setFarba(x, y + i, 1);
                                        this.hp.setFifurka(x, y + i, '*');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VLHORE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.dama.getFarba() == 2) {
                                        this.hp.setFarba(x - i, y - i, 2);
                                        this.hp.setFifurka(x - i, y - i, '*');
                                        break;
                                    } else {
                                        this.hp.setFarba(x - i, y - i, 1);
                                        this.hp.setFifurka(x - i, y - i, '*');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VPHORE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.dama.getFarba() == 2) {
                                        this.hp.setFarba(x - i, y + i, 2);
                                        this.hp.setFifurka(x - i, y + i, '*');
                                        break;
                                    } else {
                                        this.hp.setFarba(x - i, y + i, 1);
                                        this.hp.setFifurka(x - i, y + i, '*');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VLDOLE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.dama.getFarba() == 2) {
                                        this.hp.setFarba(x + i, y - i, 2);
                                        this.hp.setFifurka(x + i, y - i, '*');
                                        break;
                                    } else {
                                        this.hp.setFarba(x + i, y - i, 1);
                                        this.hp.setFifurka(x + i, y - i, '*');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VPDOLE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.dama.getFarba() == 2) {
                                        this.hp.setFarba(x + i, y + i, 2);
                                        this.hp.setFifurka(x + i, y + i, '*');
                                        break;
                                    } else {
                                        this.hp.setFarba(x + i, y + i, 1);
                                        this.hp.setFifurka(x + i, y + i, '*');
                                        break;
                                    }
                                }
                            }
                        break;
                    }
                }
                break;
                    
                case '@':
                this.kral.pozicia(x, y);
                this.kral.farba(farba);
                if (this.kral.pohyb(oKolko, pSmer) == true) {
                    this.hp.setFarba(x, y, 0);
                    this.hp.setFifurka(x, y, '.');
                    this.kral.pohyb(oKolko, pSmer);
                    System.out.println(pSmer);
                    switch (pSmer) {
                        case HORE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.kral.getFarba() == 2) {
                                        this.hp.setFarba(x - i, y, 2);
                                        this.hp.setFifurka(x - i, y, '@');
                                        break;
                                    } else {
                                        this.hp.setFarba(x - i, y, 1);
                                        this.hp.setFifurka(x - i, y, '@');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case DOLE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.kral.getFarba() == 2) {
                                        this.hp.setFarba(x + i, y, 2);
                                        this.hp.setFifurka(x + i, y, '@');
                                        break;
                                    } else {
                                        this.hp.setFarba(x + i, y, 1);
                                        this.hp.setFifurka(x + i, y, '@');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VLAVO:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.kral.getFarba() == 2) {
                                        this.hp.setFarba(x, y - i, 2);
                                        this.hp.setFifurka(x, y - i, '@');
                                        break;
                                    } else {
                                        this.hp.setFarba(x, y - i, 1);
                                        this.hp.setFifurka(x, y - i, '@');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VPRAVO:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.kral.getFarba() == 2) {
                                        this.hp.setFarba(x, y + i, 2);
                                        this.hp.setFifurka(x, y + i, '@');
                                        break;
                                    } else {
                                        this.hp.setFarba(x, y + i, 1);
                                        this.hp.setFifurka(x, y + i, '@');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VLHORE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.kral.getFarba() == 2) {
                                        this.hp.setFarba(x - i, y - i, 2);
                                        this.hp.setFifurka(x - i, y - i, '@');
                                        break;
                                    } else {
                                        this.hp.setFarba(x - i, y - i, 1);
                                        this.hp.setFifurka(x - i, y - i, '@');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VPHORE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.kral.getFarba() == 2) {
                                        this.hp.setFarba(x - i, y + i, 2);
                                        this.hp.setFifurka(x - i, y + i, '@');
                                        break;
                                    } else {
                                        this.hp.setFarba(x - i, y + i, 1);
                                        this.hp.setFifurka(x - i, y + i, '@');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VLDOLE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.kral.getFarba() == 2) {
                                        this.hp.setFarba(x + i, y - i, 2);
                                        this.hp.setFifurka(x + i, y - i, '@');
                                        break;
                                    } else {
                                        this.hp.setFarba(x + i, y - i, 1);
                                        this.hp.setFifurka(x + i, y - i, '@');
                                        break;
                                    }
                                }
                            }
                        break;
                            
                        case VPDOLE:
                            for (int i = 1; i < 8; i++) {
                                if (i == oKolko) {
                                    if (this.kral.getFarba() == 2) {
                                        this.hp.setFarba(x + i, y + i, 2);
                                        this.hp.setFifurka(x + i, y + i, '@');
                                        break;
                                    } else {
                                        this.hp.setFarba(x + i, y + i, 1);
                                        this.hp.setFifurka(x + i, y + i, '@');
                                        break;
                                    }
                                }
                            }
                        break;
                    }
                }
                break;
                    
                case 'L':
                this.kon.pozicia(x, y);
                this.kon.farba(farba);
                if (this.kon.pohyb(oKolko, pSmer) == true) {
                    this.hp.setFarba(x, y, 0);
                    this.hp.setFifurka(x, y, '.');
                    this.kon.pohyb(oKolko, pSmer);
                    System.out.println(pSmer);
                    switch (pSmer) {
                        case HORE:
                            if (this.kon.getFarba() == 2) {
                                this.hp.setFarba(x - 2, y + 1, 2);
                                this.hp.setFifurka(x - 2, y + 1, 'L');
                                break;
                            } else {
                                this.hp.setFarba(x - 2, y + 1, 1);
                                this.hp.setFifurka(x - 2, y + 1, 'L');
                                break;
                            }
                            
                        case DOLE:
                            if (this.kon.getFarba() == 2) {
                                this.hp.setFarba(x + 2, y - 1, 2);
                                this.hp.setFifurka(x + 2, y - 1, 'L');
                                break;
                            } else {
                                this.hp.setFarba(x + 2, y - 1, 1);
                                this.hp.setFifurka(x + 2, y - 1, 'L');
                                break;
                            }
                            
                        case VLAVO:
                            if (this.kon.getFarba() == 2) {
                                this.hp.setFarba(x - 1, y - 2, 2);
                                this.hp.setFifurka(x - 1, y - 2, 'L');
                                break;
                            } else {
                                this.hp.setFarba(x - 1, y - 2, 1);
                                this.hp.setFifurka(x - 1, y - 2, 'L');
                                break;
                            }
                            
                        case VPRAVO:
                            if (this.kon.getFarba() == 2) {
                                this.hp.setFarba(x + 1, y + 2, 2);
                                this.hp.setFifurka(x + 1, y + 2, 'L');
                                break;
                            } else {
                                this.hp.setFarba(x + 1, y + 2, 1);
                                this.hp.setFifurka(x + 1, y + 2, 'L');
                                break;
                            }
                            
                        case VLHORE:
                            if (this.kon.getFarba() == 2) {
                                this.hp.setFarba(x - 2, y - 1, 2);
                                this.hp.setFifurka(x - 2, y - 1, 'L');
                                break;
                            } else {
                                this.hp.setFarba(x - 2, y - 1, 1);
                                this.hp.setFifurka(x - 2, y - 1, 'L');
                                break;
                            }
                            
                        case VPHORE:
                            if (this.kon.getFarba() == 2) {
                                this.hp.setFarba(x - 1, y + 2, 2);
                                this.hp.setFifurka(x - 1, y + 2, 'L');
                                break;
                            } else {
                                this.hp.setFarba(x - 1, y + 2, 1);
                                this.hp.setFifurka(x - 1, y + 2, 'L');
                                break;
                            }
                            
                        case VLDOLE:
                            if (this.kon.getFarba() == 2) {
                                this.hp.setFarba(x + 1, y - 2, 2);
                                this.hp.setFifurka(x + 1, y - 2, 'L');
                                break;
                            } else {
                                this.hp.setFarba(x + 1, y - 2, 1);
                                this.hp.setFifurka(x + 1, y - 2, 'L');
                                break;
                            }
                            
                        case VPDOLE:
                            if (this.kon.getFarba() == 2) {
                                this.hp.setFarba(x + 2, y + 1, 2);
                                this.hp.setFifurka(x + 2, y + 1, 'L');
                                break;
                            } else {
                                this.hp.setFarba(x + 2, y + 1, 1);
                                this.hp.setFifurka(x + 2, y + 1, 'L');
                                break;
                            }
                    }
                }
                break;
                    
            default:
                throw new AssertionError();
        }
        hp.vypis();
        hp.vypis2();
        
    }
    
    public Smer urciSmer(int pX, int pY, int x, int y) {
        Smer smer = null;
        if (this.getFigurka(pX, pY) != 'L') {
        if (pX == x) {
            if (y < pY) {
                smer = Smer.VLAVO;
            } else {
                smer = smer.VPRAVO;
            }
        } else {
            if (pY == y) {
                if (x < pX) {
                    smer = Smer.HORE;
                } else {
                    smer = Smer.DOLE;
                }
            } else {
                if (x < pX) {
                    if (y < pY) {
                        smer = smer.VLHORE;
                    } else {
                        smer = Smer.VPHORE;
                    }
                } else {
                    if (y < pY) {
                        smer = Smer.VLDOLE;
                    } else {
                        smer = Smer.VPDOLE;
                    }
                }
            }
        }
        
        } else {
            if (pY == y - 1) {
                if (pX == x - 2) {
                    smer = smer.VPDOLE;
                } else{
                    if (pX == x + 2) {
                        smer = smer.HORE;
                    } else {
                        smer = null;
                    }
                }
            } else {
                if (pY == y + 1) {
                    if (pX == x - 2) {
                        smer = smer.DOLE;
                    } else{
                        if (pX == x + 2) {
                            smer = smer.VLHORE;
                        } else {
                            smer = null;
                        }
                    }
                } else {
                    if (pY == y - 2) {
                        if (pX == x - 1) {
                            smer = smer.VPRAVO;
                        } else {
                            if (pX == x + 1) {
                                smer = smer.VPHORE;
                            } else {
                                smer = null;
                            }
                        }
                    } else {
                        if (pY == y + 2) {
                            if (pX == x - 1) {
                                smer = smer.VLDOLE;
                            } else {
                                if (pX == x + 1) {
                                    smer = smer.VLAVO;
                                } else {
                                    smer = null;
                                }
                            }
                        }
                    }
                }
            }
        }
        return smer;
    }
    
    public char getFigurka(int x, int y) {
        return this.hp.getFigurka(x, y);
    }
    
    public int getFarba(int x, int y) {
        return this.hp.getFarba(x, y);
    }
    
    public void vypis() {
        this.hp.vypis();
        this.hp.vypis2();
    }
    
    public boolean zisti(int oKolko, Smer smer) {
        if (this.pesiak.pohyb(oKolko, Smer.HORE) == true) {
            return true;
        } else {
            return false;
        }
    }
    public boolean vyhral() {
        int sucet = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.hp.getFigurka(i, j) == '@') {
                    sucet ++;
                }
            }
        }
        if (sucet == 2) {
            return false;
        } else {
            return true;
        }
    }
}
