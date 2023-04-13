package Snake.elements.Game;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MousePositionTracker implements MouseListener, MouseMotionListener {
    private JFrame frame;
    private JLabel mousePositionLabel;

    public MousePositionTracker(JFrame frame) {
        this.frame = frame;

        // Create a label to display the mouse position
        mousePositionLabel = new JLabel();
        mousePositionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(mousePositionLabel, BorderLayout.SOUTH);

        // Add mouse listener and mouse motion listener to the frame
        frame.addMouseListener(this);
        frame.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        // Update the mouse position label with the current mouse position
        Point mousePos = e.getPoint();
        SwingUtilities.convertPointToScreen(mousePos, frame);
        SwingUtilities.convertPointFromScreen(mousePos, mousePositionLabel);
        mousePositionLabel.setText("Mouse Position: (" + mousePos.x + ", " + mousePos.y + ")");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Update the mouse position label with the current mouse position
        Point mousePos = e.getPoint();
        SwingUtilities.convertPointToScreen(mousePos, frame);
        SwingUtilities.convertPointFromScreen(mousePos, mousePositionLabel);
        mousePositionLabel.setText("Mouse Position: (" + mousePos.x + ", " + mousePos.y + ")");
    }
}