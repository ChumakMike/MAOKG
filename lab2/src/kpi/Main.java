package kpi;


import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JPanel implements ActionListener {

    private static int maxWidth;
    private static int maxHeight;

    Timer timer;

    private double angle = 0;
    private double scale = 1;
    private double delta = 0.01;

    public Main() {
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D graphics2D = (Graphics2D)g;

        //Set render settings
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHints(rh);

        //Set background color
        graphics2D.setBackground(Color.BLUE);
        graphics2D.clearRect(0,0, maxWidth, maxHeight);

        //Draw border
        drawBorder(graphics2D);

        // Set (0;0) to the center to draw main Frame.
        graphics2D.translate(maxWidth/2, 600);

        //Animation of turn
        graphics2D.rotate(-angle, 110,-140);

        //Set Transparency
        graphics2D.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, (float)scale));

        //Draw rect
        GradientPaint gp = new GradientPaint(10, 100,
                Color.BLACK, 20, 2, Color.YELLOW, true);
        graphics2D.setPaint(gp);
        int[] xRect = new int[] {-100, 100, 100, -100};
        int[] yRect = new int[] {120, 120, -120, -120};
        Polygon rect = new Polygon(xRect, yRect,4);
        graphics2D.drawPolygon(rect);
        graphics2D.fillPolygon(rect);

        //Draw triangle
        graphics2D.setColor(Color.LIGHT_GRAY);
        Polygon triangle = new Polygon();
            triangle.addPoint( 55, -75);
            triangle.addPoint( 20, 180);
            triangle.addPoint( 300, 160);
        graphics2D.drawPolygon(triangle);
        graphics2D.fillPolygon(triangle);

        //Draw quadra
        GradientPaint gp2 = new GradientPaint(10, 200,
                Color.BLACK, 10, 2, Color.GREEN, true);
        graphics2D.setPaint(gp2);
        Polygon quadra = new Polygon();
            quadra.addPoint(5,0);
            quadra.addPoint(-180,-25);
            quadra.addPoint(-210,140);
            quadra.addPoint(-100, 200);
        graphics2D.drawPolygon(quadra);
        graphics2D.fillPolygon(quadra);

        //Draw upper lines
        graphics2D.setColor(Color.YELLOW);
        graphics2D.drawLine(-125, -140, 110,-140);
        graphics2D.drawLine(-125, -140, -125, -100);
        graphics2D.drawLine(110, -140, 110, -100);
    }

    private GeneralPath makeLine(double[][] points) {
        GeneralPath line = new GeneralPath();
        line.moveTo(points[0][0],points[0][1]);
        for (int k = 1; k < points.length; k++)
            line.lineTo(points[k][0], points[k][1]);
        line.closePath();

        return line;
    }

    private void drawBorder(Graphics2D graphics2D) {
        BasicStroke basicStroke = new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        graphics2D.setStroke(basicStroke);
        GradientPaint gp = new GradientPaint(5, 20,
                Color.RED, 20, 2, Color.WHITE, true);
        graphics2D.setPaint(gp);
        graphics2D.drawRect(10, 10, maxWidth - 20, maxHeight - 20);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("lab2");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(1300, 1000);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.add(new Main());
        jFrame.setVisible(true);
        Dimension size = jFrame.getSize();
        Insets insets = jFrame.getInsets();
        maxWidth = size.width - insets.left - insets.right - 1;
        maxHeight = size.height - insets.top - insets.bottom - 1;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if ( scale < 0.35 ) {
            delta = -delta;
        } else if (scale > 0.99) {
            delta = -delta;
        }

        scale += delta;
        angle += 0.007;
        repaint();
    }

}
