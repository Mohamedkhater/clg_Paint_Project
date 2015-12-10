/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author Heba
 */
public class Circle extends Ellipse {
    private int radius;

    public Circle(int radius, int diameter1, int diameter2, int centreX, int centreY, String shapeName) {
        super(diameter1, diameter2, centreX, centreY, shapeName);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //g2d.setBackground(Color.getColor(wallColour));
        //g2d.setColor(Color.getColor(borderColour));
        g2d.drawOval(getCentreX(), getCentreY(), 2*radius, 2*radius);
        //g2d.setColor(Color.getColor(fillColour));
        g2d.fillOval(getCentreX(), getCentreY(), 2*radius, 2*radius);
    }

}
