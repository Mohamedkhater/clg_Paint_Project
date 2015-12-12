/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author Ahmed
 */
public abstract class Shape
{

    private Point location;
    private Dimension dimension;
    private Color fillColor;
    private Color strokeColor;

    /**
     * @return the location of the target shape
     */
    public Point getLocation()
    {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(Point location)
    {
        if (location.x < 0 || location.y < 0)
        {
            System.out.println("Location can't contain a negative number");
        }
        else
        {
            this.location = location;
        }
    }

    /**
     * @return the dimension of the target shape
     */
    public Dimension getDimension()
    {
        return dimension;
    }

    /**
     * @param dimension the dimension to set
     */
    public void setDimension(Dimension dimension)
    {
        if (dimension.width < 0 || dimension.height < 0)
        {
            System.out.println("Dimension can't contain a negative number");
        }
        else
        {
            this.dimension = dimension;
        }
    }

    /**
     * @return the fillColor
     */
    public Color getFillColor()
    {
        return fillColor;
    }

    /**
     * @param fillColor the fillColor to set
     */
    public void setFillColor(Color fillColor)
    {
        this.fillColor = fillColor;
    }

    /**
     * @return the strokeColor
     */
    public Color getStrokeColor()
    {
        return strokeColor;
    }

    /**
     * @param strokeColor the strokeColor to set
     */
    public void setStrokeColor(Color strokeColor)
    {
        this.strokeColor = strokeColor;
    }
}
