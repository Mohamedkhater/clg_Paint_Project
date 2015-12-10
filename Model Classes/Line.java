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
public class Line extends Shape {

    private int xStart;
    private int yStart;
    private int xEnd;
    private int yEnd;

    public Line(int xStart, int yStart, int xEnd, int yEnd, int centreX, int centreY, String shapeName) {
        super(centreX, centreY, shapeName);
        this.xStart = xStart;
        this.yStart = yStart;
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    public int[] getStart() {
        int[] z = null;
        z[0] = xStart;
        z[1] = yStart;
        return z;
    }

    public int[] getEnd() {
        int[] z = null;
        z[0] = xEnd;
        z[1] = yEnd;
        return z;
    }

    public void setStart(int xStart, int yStart) {
        this.xStart = xStart;
        this.yStart = yStart;
    }

    public void setyEnd(int xEnd, int yEnd) {
        this.xEnd = xEnd;
        this.yEnd = yEnd;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setBackground(Color.getColor(wallColour));
        //g2d.setColor(Color.getColor(borderColour));
        g2d.drawLine(xStart, yStart, xEnd, yEnd);
    }
    
}
