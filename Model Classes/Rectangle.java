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
public class Rectangle extends Shape {

    private int width;
    private int height;

    public Rectangle(int width, int height, int centreX, int centreY, String shapeName) {
        super(centreX, centreY, shapeName);
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setBackground(Color.getColor(wallColour));
        //g2d.setColor(Color.getColor(borderColour));
        g2d.drawRect(getCentreX(), getCentreY(), width, height);
        //g2d.setColor(Color.getColor(fillColour));
        g2d.fillRect(getCentreX(), getCentreY(), width, height);
    }
    
}

