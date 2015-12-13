/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Heba
 */
public class Triangle extends Shape {

    private int xpt1;
    private int ypt1;
    private int xpt2;
    private int ypt2;
    private int xpt3;
    private int ypt3;

    public Triangle(int xpt1, int ypt1, int xpt2, int ypt2, int xpt3, int ypt3, int centreX, int centreY, String shapeName) {
        super(centreX, centreY, shapeName);
        this.xpt1 = xpt1;
        this.ypt1 = ypt1;
        this.xpt2 = xpt2;
        this.ypt2 = ypt2;
        this.xpt3 = xpt3;
        this.ypt3 = ypt3;
    }

    public int[] getPt1() {
        int[] z = null;
        z[0] = xpt1;
        z[1] = ypt1;
        return z;
    }

    public int[] getPt2() {
        int[] z = null;
        z[0] = xpt2;
        z[1] = ypt2;
        return z;
    }

    public int[] getPt3() {
        int[] z = null;
        z[0] = xpt3;
        z[1] = ypt3;
        return z;
    }
    
    public void draw(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int[] x = {xpt1, xpt2, xpt3};
        int[] y = {ypt1, ypt2, ypt3};
        g2d.drawPolyline(x, y, 3);
    }
    
    public void fill(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int[] x = {xpt1, xpt2, xpt3};
        int[] y = {ypt1, ypt2, ypt3};
        g2d.fillPolygon(x, y, 3);
    }
    
    /*
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.getColor(wallColour));
        g2d.setColor(Color.getColor(borderColour));
        g2d.drawLine(xpt1, ypt1, xpt2, ypt2);
        g2d.drawLine(xpt2, ypt2, xpt3, ypt3);
        g2d.drawLine(xpt3, ypt3, xpt1, ypt1);
        int[] x = {xpt1, xpt2, xpt3};
        int[] y = {ypt1, ypt2, ypt3};
        g2d.drawPolyline(x, y, 3);
        g2d.fillPolygon(x, y, 3);
    }*/

}
