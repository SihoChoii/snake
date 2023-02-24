// Grid Block Object
package Snake.elements.Game;

import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.Stroke;

import Snake.elements.element;

import java.awt.BasicStroke;

public class gridBlock extends element
{
    public gridBlock()
    {
        super(0,0,0,0,0);
    }

    public void draw(Graphics2D win)
    {
        win.setColor(this.getInnerColor());
        win.fill(this.getRectangle());

        // Stroke prevStroke = win.getStroke();  TODO This shouldnt't be needed if every object sets its own stroke
        win.setStroke(new BasicStroke(this.getBorderSize()));

        win.setColor(this.getOuterColor());
        win.draw(this.getRectangle());
        // win.setStroke(prevStroke);
    }
}