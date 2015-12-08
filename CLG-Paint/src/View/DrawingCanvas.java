/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author Ahmed
 */
public class DrawingCanvas extends JComponent
{

    int x1, y1;
    Graphics2D g;

    public DrawingCanvas()
    {
        // Set the size of the drawing canvas
        this.setSize(850, 648);
        this.setLocation(135, 12);

        // Test Button
        JButton dd = new JButton();
        dd.setSize(70, 80);
        dd.setLocation(200, 200);
        dd.setText("Test");
        dd.addActionListener((ActionEvent e) ->
        {
            JOptionPane.showMessageDialog(Paint0.FrameHandle, e.getActionCommand());
            // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        });

        this.add(dd);
        this.setBorder(BorderFactory.createBevelBorder(10, Color.lightGray, Color.yellow));
        // Add listners for click and relase
        this.addMouseListener(new MouseAdapter()
        {
            // Stores the click place 
            @Override
            public void mousePressed(MouseEvent e)
            {
                // Save the origin point of the new shape
                x1 = e.getX();
                y1 = e.getY();

                // Mouse click on drawing canvas ( add a shape )
                //JOptionPane.showMessageDialog(Paint0.FrameHandle,
                System.out.println("Coordinates:X:" + e.getX() + ",Y:" + e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                // Call the method to draw the shape here
            }
        });

        this.addMouseMotionListener(new MouseMotionAdapter()
        {
            @Override
            public void mouseDragged(MouseEvent e)
            {
                int x = e.getX();
                int y = e.getY();
                //JOptionPane.showMessageDialog(Paint0.FrameHandle,
                int distance = (int) Math.sqrt(
                        (Math.pow((x1 - x), 2)
                        + Math.pow((y1 - y), 2)));
                System.out.println(("Drag Coordinates:X:" + (x1 - x) + ",Y:" + (y1 - y) + " Distance:" + distance));

                //Line2D d = new Line2D.Float(x1, y1, x, y);
                repaint();
            }
        });

        this.setBorder(BorderFactory.createLineBorder(Color.black));

    }
}
