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
public class Ellipse extends Shape{
    private int diameter1;
    private int diameter2;

    public Ellipse(int diameter1, int diameter2, int centreX, int centreY, String shapeName) {
        super(centreX, centreY, shapeName);
        this.diameter1 = diameter1;
        this.diameter2 = diameter2;
    }

    public int getDiameter1() {
        return diameter1;
    }

    public void setDiameter1(int diameter1) {
        this.diameter1 = diameter1;
    }

    public int getDiameter2() {
        return diameter2;
    }

    public void setDiameter2(int diameter2) {
        this.diameter2 = diameter2;
    }
    
    public void draw(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(getCentreX(), getCentreY(), diameter1, diameter2);
    }
    
    public void fill(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillOval(getCentreX(), getCentreY(), diameter1, diameter2);
    }
    
    /*
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.getColor(wallColour));
        g2d.setColor(Color.getColor(borderColour));
        g2d.drawOval(getCentreX(), getCentreY(), diameter1, diameter2);
        g2d.setColor(Color.getColor(fillColour));
        g2d.fillOval(getCentreX(), getCentreY(), diameter1, diameter2);
    }
    */
    
}
