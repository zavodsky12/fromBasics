/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FromBasics;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.System.exit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Daniel
 */
public class SpustuHru extends Applet implements KeyListener {
    
    private HraciePole hp;
    private HraciePole pHp;
    private int pomX;
    private int pomY;
    private Hra hra;
    private boolean prvyKrat;
    private int prvyX;
    private int prvyY;
    private boolean hrac1;
    
    public static void main(String[] args) {
        JFrame wind = new JFrame("Šachy");
        SpustuHru p =new SpustuHru();
        wind.add(p);
        wind.pack();
        wind.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        wind.setLocationRelativeTo(null);
        wind.setResizable(false);
        wind.setVisible(true);
        wind.addKeyListener(p);
    }
    
    public SpustuHru() {
        this.hp = new HraciePole();
        this.pHp = new HraciePole();
        hp.rozlisFarby();
        hp.zaplnPoleFigurkami();
        pHp.rozlisFarby();
        pHp.zaplnPoleFigurkami();
        this.pomX = 0;
        this.pomY = 0;
        this.hra = new Hra();
        this.prvyKrat = false;
        this.prvyX = 0;
        this.prvyY = 0;
        this.hrac1 = true;
        
    }
    
    
    //public void init() {
        //this.addKeyListener(this);
        
        //this.rect = new Rectangle(50, 50, 40, 40);
    //}
    
    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, 400, 400);
        for (int i = 0; i < 400; i += 100) {
            for (int j = 0; j < 400; j += 100) {
                g.setColor(Color.white);
                g.fillRect(i, j, 50, 50);
            }
        }
        
        for (int i = 50; i < 400; i += 100) {
            for (int j = 50; j < 400; j += 100) {
                g.setColor(Color.white);
                g.fillRect(i, j, 50, 50);
            }
        }
        
        g.setColor(new Color(0, 255, 255));
        g.drawRect(pomY, pomX, 50, 50);
        
        if (this.prvyKrat == true) {
            g.setColor(new Color(255, 0, 0));
            g.drawRect(prvyY, prvyX, 50, 50);
        }
        
        if (hrac1 == true) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.setColor(Color.lightGray);
            g.drawString(String.valueOf(" Player 1"), 10, 425);
        } else {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.setColor(Color.darkGray);
            g.drawString(String.valueOf(" Player 2"), 10, 425);
        }
        
        /*for (int i = 15; i < 400; i += 50) {
            g.setColor(Color.darkGray);
            g.fillRect(i, 65, 20, 20);
        }*/
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                try {
                    switch (this.hra.getFigurka(j, i)) {
                        case 'i':
                            if (this.hra.getFarba(j, i) == 1) {
                                g.setColor(Color.lightGray);
                                g.fillOval(i * 50 + 15, j * 50 + 15, 20, 20);
                            } else {
                                g.setColor(Color.darkGray);
                                g.fillOval(i * 50 + 15, j * 50 + 15, 20, 20);
                            }
                            break;
                        
                        case '#':
                            if (this.hra.getFarba(j, i) == 1) {
                                g.setColor(Color.lightGray);
                                g.fillRect(i * 50 + 10, j * 50 + 10, 30, 30);
                            } else {
                                g.setColor(Color.darkGray);
                                g.fillRect(i * 50 + 10, j * 50 + 10, 30, 30);
                            }
                            break;
                            
                        case '$':
                            if (this.hra.getFarba(j, i) == 1) {
                                g.setColor(Color.lightGray);
                                g.fillOval(i * 50 + 10, j * 50 + 10, 30, 30);
                            } else {
                                g.setColor(Color.darkGray);
                                g.fillOval(i * 50 + 10, j * 50 + 10, 30, 30);
                            }
                            break;
                            
                        case '*':
                            if (this.hra.getFarba(j, i) == 1) {
                                g.setColor(Color.lightGray);
                                g.fillRect(i * 50 + 20, j * 50 + 10, 10, 30);
                                g.fillRect(i * 50 + 10, j * 50 + 20, 30, 10);
                                g.fillOval(i * 50 + 10, j * 50 + 10, 10, 10);
                                g.fillOval(i * 50 + 30, j * 50 + 10, 10, 10);
                                g.fillOval(i * 50 + 10, j * 50 + 30, 10, 10);
                                g.fillOval(i * 50 + 30, j * 50 + 30, 10, 10);
                            } else {
                                g.setColor(Color.darkGray);
                                g.fillRect(i * 50 + 20, j * 50 + 10, 10, 30);
                                g.fillRect(i * 50 + 10, j * 50 + 20, 30, 10);
                                g.fillOval(i * 50 + 10, j * 50 + 10, 10, 10);
                                g.fillOval(i * 50 + 30, j * 50 + 10, 10, 10);
                                g.fillOval(i * 50 + 10, j * 50 + 30, 10, 10);
                                g.fillOval(i * 50 + 30, j * 50 + 30, 10, 10);
                            }
                            break;
                            
                        case '@':
                            if (this.hra.getFarba(j, i) == 1) {
                                g.setColor(Color.lightGray);
                                g.fillOval(i * 50 + 15, j * 50 + 15, 20, 20);
                                g.fillRect(i * 50 + 20, j * 50 + 10, 10, 30);
                                g.fillRect(i * 50 + 10, j * 50 + 20, 30, 10);
                            } else {
                                g.setColor(Color.darkGray);
                                g.fillOval(i * 50 + 15, j * 50 + 15, 20, 20);
                                g.fillRect(i * 50 + 20, j * 50 + 10, 10, 30);
                                g.fillRect(i * 50 + 10, j * 50 + 20, 30, 10);
                            }
                            break;
                            
                        case 'L':
                            if (this.hra.getFarba(j, i) == 1) {
                                g.setColor(Color.lightGray);
                                //g.fillOval(i * 50 + 15, j * 50 + 15, 20, 20);
                                g.fillRect(i * 50 + 25, j * 50 + 10, 12, 30);
                                g.fillRect(i * 50 + 10, j * 50 + 10, 25, 10);
                            } else {
                                g.setColor(Color.darkGray);
                                //g.fillOval(i * 50 + 15, j * 50 + 15, 20, 20);
                                g.fillRect(i * 50 + 25, j * 50 + 10, 12, 30);
                                g.fillRect(i * 50 + 10, j * 50 + 10, 25, 10);
                            }
                            break;
                    }
                } catch (Exception ex) {
                    System.out.println("zle");
                }
            }
        }
        
        /*for (int i = 15; i < 400; i += 50) {
            g.setColor(Color.lightGray);
            g.fillRect(i, 315, 20, 20);
        }*/
        
        /*setSize(500, 500);
        Graphics2D g2 = (Graphics2D)g;
        g2.fill(rect);*/
    }
    
    public Dimension getPreferredSize() {

        return new Dimension(430, 430);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Hra hra = new Hra();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W :
                System.out.println("e");
                if (pomX != 0) {
                    this.pomX -= 50;
                }
                break;
                
            case KeyEvent.VK_A :
                System.out.println("o");
                if (pomY != 0) {
                    this.pomY -= 50;
                }
                break;
                    
                    
            case KeyEvent.VK_S :
                System.out.println("s");
                if (pomX != 350) {
                    this.pomX += 50;
                }
                break;
                    
            case KeyEvent.VK_D :
                System.out.println("u");
                if (pomY != 350) {
                    this.pomY += 50;
                }
                break;
                
            case KeyEvent.VK_ENTER :
                if (this.prvyKrat == false) {
                    this.prvyKrat = true;
                    prvyX = pomX;
                    prvyY = pomY;
                    
                } else {
                    this.prvyKrat = false;
                    
                    
                    int oKolko = 0;
                    
                    if (Math.abs(pomX / 50 - prvyX / 50) > Math.abs(pomY / 50 - prvyY / 50)) {
                        oKolko = Math.abs(pomX / 50 - prvyX / 50);
                    } else {
                        oKolko = Math.abs(pomY / 50 - prvyY / 50);
                    }
                    
                    if ((this.hrac1 == true) && (this.hra.getFarba(prvyX / 50, prvyY / 50)) == 1 || (this.hrac1 == false) && (this.hra.getFarba(prvyX / 50, prvyY / 50)) == 2) {
                        this.hra.pohyb(prvyX / 50, prvyY / 50, oKolko, this.hra.urciSmer(prvyX / 50, prvyY / 50, pomX / 50, pomY / 50));
                        if (this.hrac1 == true) {
                            this.hrac1 = false;
                        } else {
                            this.hrac1 = true;
                        }
                    }
                }
                break;
                
            case KeyEvent.VK_ESCAPE :
                exit(0);
                    
            default:
                break;
            }
        if (this.hra.vyhral()) {
            if (this.hp.getFarba(pomX / 50, pomY / 50) == 1) {
                JOptionPane.showMessageDialog(this, "Vyhrali cierni");
                exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "Vyhrali bieli");
                exit(0);
            }
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
    
}
