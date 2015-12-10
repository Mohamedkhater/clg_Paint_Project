/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author Heba
 */
public class Shape extends JPanel {

    protected int centreX;
    protected int centreY;
    protected String shapeName;
    protected String borderColour;
    protected String fillColour;
    protected String wallColour;

    public Shape(int centreX, int centreY, String shapeName) {
        this.centreX = centreX;
        this.centreY = centreY;
        this.shapeName = shapeName;
    }

    public int getCentreX() {
        return centreX;
    }

    public void setCentreX(int centreX) {
        this.centreX = centreX;
    }

    public int getCentreY() {
        return centreY;
    }

    public void setCentreY(int centreY) {
        this.centreY = centreY;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public String getColour() {
        return borderColour;
    }

    public void setColour(String borderColour) {
        this.borderColour = borderColour;
    }

    public String getFillColour() {
        return fillColour;
    }

    public void setFillColour(String fillColour) {
        this.fillColour = fillColour;
    }

    public String getWallColour() {
        return wallColour;
    }

    public void setWallColour(String wallColour) {
        this.wallColour = wallColour;
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setBackground(Color.getColor(wallColour));
        g2d.setColor(Color.getColor(borderColour));
        g2d.setColor(Color.getColor(fillColour));
    }
}
