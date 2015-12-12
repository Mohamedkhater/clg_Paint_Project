/*Required updates:
 * 1. fix the clear operation(clicking on the new menu)
 * 2.save the   workout in panel as image.
 * 3.change the look of mouse pointer after clicking brash button to brash and so on.
 * 4. Use defaultToolkit
 * 5. Fix unnecessary complexities
 */
package Referrence;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public final class PaintBrushApp extends JFrame
{

    // Control buttons
    JButton brushButton, ellipseButton, rectangleButton, lineButton, fillButton, strokeButton, clearButton;

    // Last performed action ( default set to freehand brush )
    int recentActionValue = 1;

    // Default shape properties
    Color fillColor = Color.BLACK;
    Color strokeColor;

    // Transperancy settings
    JLabel transperancyLabel;
    JSlider transparencySlider;

    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    Graphics2D graphicalDrawing;

    float transparencyValue = 1.0f;

    PaintBrushApp()
    {

        JFrame mainFrame = new JFrame();

        // Get a handle to the contents of the frame
        final Container mainFrameContents = mainFrame.getContentPane();

        // Properties of the main window
        this.setIconImage(new ImageIcon("./src/images/defaultIcon.png").getImage());
        this.setTitle("PaintBrush");
        this.setSize(1200, 550);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel contained in the JFrame
        JPanel controlButtonsPanel = new JPanel();

        // Menu bar for file / help menues
        JMenuBar menuBar = new JMenuBar();

        JMenu graphicsMenu = new JMenu("File");
        JMenuItem newMenuButton = new JMenuItem("New");
        graphicsMenu.add(newMenuButton);
        newMenuButton.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                // Action that happens when the "New" menu is pressed
            }
        });

        JMenu helpMenu = new JMenu("Help");
        JMenuItem howToDrawMenuButton = new JMenuItem("How To Draw");
        helpMenu.add(howToDrawMenuButton);

        // Add the sub-menus items to the menubar
        menuBar.add(graphicsMenu);
        menuBar.add(helpMenu);

        // Set the menu bar for this JFrame
        this.setJMenuBar(menuBar);

        final Canvas drawPad = new Canvas();

        Box buttonBox = Box.createVerticalBox();

        // Create the shape button objects
        brushButton = addImageToButtons("./src/images/brushIcon.png", 1, "Brush");
        ellipseButton = addImageToButtons("./src/images/Ellipse.png", 3, "Ellipse");
        rectangleButton = addImageToButtons("./src/images/Rectangle.png", 4, "Rectangle");
        lineButton = addImageToButtons("./src/images/Line.png", 2, "Line");

        // Create the control button objects
        strokeButton = addImageToColorButtons("./src/images/Fill.png", 5, true, "Stroke");
        fillButton = addImageToColorButtons("./src/images/Stroke.png", 7, false, "Fill");

        clearButton = new JButton("CLEAR");

        rectangleButton.setPreferredSize(new Dimension(100, 100));

        // Add items to the vertical box ( stack panel )
        buttonBox.add(brushButton);
        buttonBox.add(lineButton);
        buttonBox.add(ellipseButton);
        buttonBox.add(rectangleButton);

        buttonBox.add(fillButton);
        buttonBox.add(strokeButton);
        buttonBox.add(clearButton);

        transperancyLabel = new JLabel("Transparency: 1 ");
        transparencySlider = new JSlider(1, 99, 99);

        ListenForSlider lSlider = new ListenForSlider();
        transparencySlider.addChangeListener(lSlider);

        buttonBox.add(transperancyLabel);
        buttonBox.add(transparencySlider);

        controlButtonsPanel.add(buttonBox);
        controlButtonsPanel.setBackground(Color.CYAN);
        mainFrameContents.add(drawPad, BorderLayout.CENTER);
        mainFrameContents.setBackground(Color.WHITE);

        mainFrameContents.add(controlButtonsPanel, BorderLayout.WEST);
        this.add(mainFrameContents);

        //content.add(panel, BorderLayout.CENTER);
        clearButton.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                if (e.getSource() == clearButton)
                {
                    drawPad.clear();
                }
            }
        });

    }

    public JButton addImageToButtons(String iconFile, final int actionCommandNumber, String tooltipText)
    {
        // This method creates the shape button object and sets the action number for it
        // Controller

        JButton button = new JButton();
        button.setText(tooltipText);
        button.setToolTipText(tooltipText);

        //Icon buttonIcon = new ImageIcon(iconFile);
        //button.setIcon(buttonIcon);
        //button.setSize(100, 200);
        button.addActionListener(new ActionListener()
        {

            // Add the action listner to this button            
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Set the number of the active shape to know the last pressed button
                recentActionValue = actionCommandNumber;

            }
        });
        return button;
    }

    public JButton addImageToColorButtons(String iconfile, final int activeNumber,
            final boolean stroke, String text)
    {

        // This method creates the control button object and sets the action number for it
        // Controller
        JButton button = new JButton();
        button.setText(text);

        //Icon buttonicon = new ImageIcon(iconfile);
        //button.setIcon(buttonicon);
        button.addActionListener((ActionEvent e) ->
        {
            if (stroke)
            {
                // Create the 
                strokeColor = JColorChooser.showDialog(null, "Choose stroke color", Color.BLACK);
            }
            else
            {
                fillColor = JColorChooser.showDialog(null, "Choose fill color", Color.BLACK);
            }
        });
        return button;

    }

    /**
     *
     */
    public class Canvas extends JComponent
    {

        // Drawing area - controller package
        // Shape is an interface, make an abstract class and inherit from this interface
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        ArrayList<Color> shapeFill = new ArrayList<Color>();
        ArrayList<Color> shapeStroke = new ArrayList<Color>();
        ArrayList<Float> transPersent = new ArrayList<Float>();
        Point drawingStartingPoint, drawingEndingPoint;

        public Canvas()
        {

            // Those methods shall be in the view package
            this.addMouseListener(new MouseAdapter()
            {

                @Override
                public void mousePressed(MouseEvent e)
                {

                    if (recentActionValue != 1)
                    {

                        drawingStartingPoint = new Point(e.getX(), e.getY());
                        drawingEndingPoint = drawingStartingPoint;
                        repaint();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e)
                {

                    if (recentActionValue != 1)
                    {

                        Shape aShape = null;
                        switch (recentActionValue)
                        {
                            case 2:
                                aShape = drawLine(drawingStartingPoint.x,
                                        drawingStartingPoint.y,
                                        e.getX(),
                                        e.getY());
                                break;
                            case 3:
                                aShape = drawEllipse(drawingStartingPoint.x,
                                        drawingStartingPoint.y,
                                        e.getX(),
                                        e.getY());
                                break;
                            case 4:
                                aShape = drawRectangle(drawingStartingPoint.x,
                                        drawingStartingPoint.y,
                                        e.getX(),
                                        e.getY());
                                break;
                            default:
                        }

                        shapes.add(aShape);
                        shapeFill.add(fillColor);
                        shapeStroke.add(strokeColor);
                        transPersent.add(transparencyValue);

                        drawingStartingPoint = null;
                        drawingEndingPoint = null;
                        repaint();
                    }

                }
            });

            this.addMouseMotionListener(new MouseMotionAdapter()
            {

                // This method shall be in the view package
                @Override
                public void mouseDragged(MouseEvent e)
                {

                    if (recentActionValue == 1)
                    {

                        int x = e.getX();
                        int y = e.getY();

                        Shape aShape = null;
                        strokeColor = fillColor;
                        aShape = drawBrush(x, y, 5, 5);

                        shapes.add(aShape);
                        shapeFill.add(fillColor);
                        shapeStroke.add(strokeColor);
                        transPersent.add(transparencyValue);
                    }

                    drawingEndingPoint = new Point(e.getX(), e.getY());
                    repaint();
                }

            });
        }

        public void paint(Graphics g)
        {
            // This method shall be in the controller
            graphicalDrawing = (Graphics2D) g;
            graphicalDrawing.setStroke(new BasicStroke(0));

            graphicalDrawing.setPaint(Color.WHITE);
            Iterator<Color> strokeCounter = shapeStroke.iterator();
            Iterator<Color> fillCounter = shapeFill.iterator();
            Iterator<Float> transCounter = transPersent.iterator();

            for (Shape s : shapes)
            {
                graphicalDrawing.setComposite(
                        AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                                transCounter.next()));

                graphicalDrawing.setPaint(strokeCounter.next());
                graphicalDrawing.draw(s);
                graphicalDrawing.setPaint(fillCounter.next());
                graphicalDrawing.fill(s);

            }
            if (drawingStartingPoint != null && drawingEndingPoint != null)
            {

                graphicalDrawing.setComposite(
                        AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                                0.40f));

                graphicalDrawing.setPaint(Color.BLACK);

                Shape aShape = null;

                switch (recentActionValue)
                {
                    case 2:
                        aShape = drawLine(drawingStartingPoint.x,
                                drawingStartingPoint.y,
                                drawingEndingPoint.x,
                                drawingEndingPoint.y);
                        break;
                    case 3:
                        aShape = drawEllipse(drawingStartingPoint.x,
                                drawingStartingPoint.y,
                                drawingEndingPoint.x,
                                drawingEndingPoint.y);
                        break;
                    case 4:
                        aShape = drawRectangle(drawingStartingPoint.x,
                                drawingStartingPoint.y,
                                drawingEndingPoint.x,
                                drawingEndingPoint.y);
                        break;
                    default:
                }

                graphicalDrawing.draw(aShape);

            }

        }

        public void clear()
        {
            // This method shall be in the controller
            graphicalDrawing.setPaint(Color.white);
            graphicalDrawing.fillRect(0, 0, getSize().width, getSize().height);
            graphicalDrawing.setPaint(Color.black);
            repaint();
        }

        private Rectangle2D.Float drawRectangle(int x1, int y1, int x2, int y2)
        {
            // This method shall be in the controller
            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);

            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);

            return new Rectangle2D.Float(x, y, width, height);

        }

        private Ellipse2D.Float drawEllipse(int x1, int y1, int x2, int y2)
        {
            // This method shall be in the controller
            int x = Math.min(x1, x2);
            int y = Math.min(y1, y2);

            int width = Math.abs(x1 - x2);
            int height = Math.abs(y1 - y2);

            return new Ellipse2D.Float(x, y, width, height);

        }

        private Line2D.Float drawLine(int x1, int y1, int x2, int y2)
        {
            // This method shall be in the controller
            return new Line2D.Float(x1, y1, x2, y2);
        }

        private Ellipse2D.Float drawBrush(int x1, int y1, int brashStrokeWeidth, int brushStrokeHeight)
        {
            // This method shall be in the controller
            return new Ellipse2D.Float(x1, y1, brashStrokeWeidth, brushStrokeHeight);

        }

    }

    public class ListenForSlider implements ChangeListener
    {

        // This method shall be in the view
        @Override
        public void stateChanged(ChangeEvent e)
        {

            if (e.getSource() == transparencySlider)
            {
                transperancyLabel.setText("Transparency :"
                        + decimalFormat.format(transparencySlider.getValue() * .01));

                transparencyValue = (float) (transparencySlider.getValue() * .01);

            }

        }

    }

    public static void main(String[] args)
    {

        new PaintBrushApp().setVisible(true);
    }
}
