package Snake.elements.Game;

import Snake.elements.element;
import java.awt.Graphics2D;

import java.awt.Color;
import Snake.elements.Game.snakeHead;

// Should not be used out of snakeHead

public class snakeBody extends element
{
    private int position;
    private snakeHead head;
    private double prevPosX, prevPosY;
    private int prevCount = 0;

    public snakeBody(snakeHead head, int position)
    {
        super(head.getScale(),head.getSizeX(),head.getSizeY(),head.getPrevPosX(),head.getPrevPosY());
        this.head = head;
        this.setOuterColor(Color.white);
        this.setInnerColor(Color.orange);
        this.setBorderSize(1);
        this.position = position;
        this.setDrawStat(false);
    }

    public void draw(Graphics2D win)
    {
        if (this.getDrawStat())
        {
            win.setColor(this.getInnerColor());
            win.fillOval((int)this.getPositionX(), (int)this.getPositionY(), (int)this.getSizeX(), (int)this.getSizeY());
            
            win.setStroke(this.getStroke());
            win.setColor(this.getOuterColor());
            win.drawOval((int)this.getPositionX(), (int)this.getPositionY(), (int)this.getSizeX(), (int)this.getSizeY());
        }
    }

    public void update()
    {
        if (prevCount % head.getUpdateFreq() == 0) // Delayed Update Method
        {
            this.prevPosX = this.getPositionX();
            this.prevPosY = this.getPositionY();
        }

        if (position > 0) // First Body of Snake Head Condition
        {
            this.setPositionX(this.head.getSnakeBody().get(position-1).getPrevPosX());
            this.setPositionY(this.head.getSnakeBody().get(position-1).getPrevPosY());
            this.prevCount++;
        }
        else // All other Snake Bodies
        {
            this.setPositionX(this.head.getPrevPosX());
            this.setPositionY(this.head.getPrevPosY());
            this.prevCount++;
        }

        if (prevCount > 1000) // Reset Counter
        {
            prevCount = 0;
        }
    }

    // Body Head Intersect Check
    public boolean intersects()
    {
        if (position > 15 && prevCount >= 40)
        {
            // Check if position is within the head
            if (this.getPositionX() >= this.head.getPositionX() && this.getPositionX() <= this.head.getPositionX() + this.head.getSizeX())
            {
                if (this.getPositionY() >= this.head.getPositionY() && this.getPositionY() <= this.head.getPositionY() + this.head.getSizeY())
                {
                    this.setOuterColor(Color.yellow);
                    this.setInnerColor(Color.blue);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    // Getters
    public double getPrevPosX() { return this.prevPosX; }
    public double getPrevPosY() { return this.prevPosY; }
}
