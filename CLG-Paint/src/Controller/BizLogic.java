/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.awt.Dimension;
import java.util.LinkedList;

/**
 *
 * @author Ahmed, Business logic class
 */
public class BizLogic
{

    /**
     * List that contains all the object on the drawing canvas
     */
    public static LinkedList<Shape> canvasContents = new LinkedList<>();
    
    public void Move(Shape shape)
    {
        
    }

    public void Resize (Shape shape,Dimension newDimension)
    {
        // First show the little resize boxes ( anchors )
        ShowResizeAnchorPoints(shape);
        
        // Start resizing the shape
    }
    
    public void ShowResizeAnchorPoints(Shape shape)
    {
        
    }
    
    public void Draw(Shape shape)
    {
        
    }
    
    public void ChangeColor(Shape shape)
    {
        
    }
    
    public void Undo()
    {
        
    }
    
    public void Redo()
    {
        
    }
    
    public void UpdateCanvas()
    {
        // Redraws the canvas objects ? or something that's more efiicient
    }

    public static void MenuActions(String actionCommand)
    {
        
    }
}
