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
public class Square extends Shape {

    private int length;

    public Square(int length, int centreX, int centreY, String shapeName) {
        super(centreX, centreY, shapeName);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public void draw(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(getCentreX(), getCentreY(), length, length);
    }
    
    public void fill(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.fillRect(getCentreX(), getCentreY(), length, length);
    }
    
    /*
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.getColor(wallColour));
        g2d.setColor(Color.getColor(borderColour));
        g2d.drawRect(getCentreX(), getCentreY(), length, length);
        g2d.setColor(Color.getColor(fillColour));
        g2d.fillRect(getCentreX(), getCentreY(), length, length);
    }
    */
}
