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
public class HraciePole {
    private char[][] pole;
    private int[][] pole2;

    public HraciePole() {
        this.pole = new char[8][8];
        this.pole2 = new int[8][8];
    }
    
    public void zaplnPoleFigurkami() {
        for (int i = 0; i < 8; i++) {
            this.pole[1][i] = 'i';
            this.pole[6][i] = 'i';
        }
        
        for (int i = 0; i < 8; i += 7) {
            this.pole[i][0] = '#';
            this.pole[i][7] = '#';
        }
        
        for (int i = 0; i < 8; i += 7) {
            this.pole[i][1] = 'L';
            this.pole[i][6] = 'L';
        }
        
        for (int i = 0; i < 8; i += 7) {
            this.pole[i][2] = '$';
            this.pole[i][5] = '$';
        }
        
        this.pole[0][3] = '*';
        this.pole[7][3] = '*';
        this.pole[0][4] = '@';
        this.pole[7][4] = '@';
        
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                this.pole[i][j] = '.';
            }
        }
    }
    
    public void rozlisFarby() {
        for (int i = 0; i < 8; i++) {
            this.pole2[0][i] = 2;
            this.pole2[1][i] = 2;
            this.pole2[6][i] = 1;
            this.pole2[7][i] = 1;
        }
    }
    
    public void vypis() {
        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(this.pole[i][j]);
            }
        }
        System.out.println();
    }
    
    public void vypis2() {
        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(this.pole2[i][j]);
            }
        }
    }
    
    public int getFarba(int x, int y) {
        return this.pole2[x][y];
    }
    
    public char getFigurka(int x, int y) {
        return this.pole[x][y];
    }
    
    public void setFarba(int x, int y, int farba) {
        this.pole2[x][y] = farba;
    }
    
    public void setFifurka(int x, int y, char figurka) {
        this.pole[x][y] = figurka;
    }
}
