package Snake.elements.Game;

import Snake.elements.element;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import Snake.elements.Game.snakeBody;
import Snake.utilities.GDV5;

import java.util.ArrayList;
import Snake.elements.Game.MouseListener;

public class snakeHead extends element
{
    private ArrayList<snakeBody> body;
    private double direction;
    private double speed;
    private double prevPosX, prevPosY;
    private int prevCount;
    private int length;
    private int updateFreq = 2;

    public snakeHead()
    {
        super(1,50,50,100,100);
        this.setOuterColor(Color.white);
        this.setInnerColor(Color.orange);
        this.setBorderSize(7);
        this.body = new ArrayList<snakeBody>();
        this.populateBody();
        // TODO temp code
        this.setUpdateStat(true);
        this.setDrawStat(true);
    }

    public void populateBody()
    {
        this.body.clear();
        for (int i = 0; i < this.length; i++)
        {
            this.body.add(new snakeBody(this, i));
            this.body.get(i).setDrawStat(true);
        }
    }

    public void growBody(int increment)
    {
        for (int i = 0; i < increment; i++)
        {
            this.body.add(new snakeBody(this, this.length));
            this.body.get(this.length).setDrawStat(true);
            this.length++;
        }
    }

    public void shrinkBody(int increment)
    {
        if (this.length >= increment)
        {
            for (int i = 0; i < increment; i++)
            {
                this.body.remove(this.length-1);
            }
            this.length -= increment;
        }  
    }

    public void drawHead(Graphics2D win)
    {
        win.setColor(this.getInnerColor());
        win.fillOval((int)this.getPositionX(), (int)this.getPositionY(), (int)this.getSizeX(), (int)this.getSizeY());
        
        win.setStroke(this.getStroke());
        win.setColor(this.getOuterColor());
        win.drawOval((int)this.getPositionX(), (int)this.getPositionY(), (int)this.getSizeX(), (int)this.getSizeY());
    }

    public void drawBodies(Graphics2D win)
    {
        for (int i = this.body.size()-1; i > 0; i--)
        {
            this.body.get(i).draw(win);
        }
    }

    public void draw(Graphics2D win)
    {
        if (this.getDrawStat())
        {
            this.drawHead(win);
            this.drawBodies(win);
        }
    }

    public void bodyCheck()
    {
        for (int i = 0; i < this.body.size(); i++)
        {
            this.body.get(i).update();
            if (this.body.get(i).intersects())
            {
                break;
            }
        }
    }

    public void prevPosUpdate()
    {
        if (this.prevCount % this.updateFreq == 0)
        {
            this.prevCount = 0;
            this.prevPosX = this.getPositionX();
            this.prevPosY = this.getPositionY();
        }
    }

    public void bodyLength(int increment)
    {
        if (GDV5.KeysPressed[KeyEvent.VK_UP]) this.growBody(increment);
        if (GDV5.KeysPressed[KeyEvent.VK_DOWN]) this.shrinkBody(increment);
    }

    public void appleCheck()
    {
        for (int i = 0; i < apple.apples.size(); i++)
        {
            if (this.intersects(apple.apples.get(i)))
            {
                apple.apples.get(i).setDrawStat(false);
                apple.apples.remove(i);
                this.growBody(10);
            }
        }
    }

    public void update()
    {
        if (this.getUpdateStat())
        {
            prevPosUpdate();
            move(5);
            bodyCheck();
            appleCheck();
            // TODO Snake Length Test Code
            bodyLength(1);

            this.prevCount++;
        }
    }

    // public void turn(double increment)
    // {
    //     if (GDV5.KeysPressed[KeyEvent.VK_RIGHT]) this.direction += increment;
    //     if (GDV5.KeysPressed[KeyEvent.VK_LEFT]) this.direction -= increment;
    // }

    // public void move(int increment)
    // {
    //     this.setPositionX(this.getPositionX() + Math.cos(this.direction) * increment);
    //     this.setPositionY(this.getPositionY() + Math.sin(this.direction) * increment);
    // }

    public void move(int increment)
    {
        this.setPositionX(this.getPositionX() + Math.cos(this.direction) * increment);
        this.setPositionY(this.getPositionY() + Math.sin(this.direction) * increment);
    }

    // Getters
    public int getLength() { return this.length; }
    public double getDirection() { return this.direction; }
    public double getSpeed() { return this.speed; }
    public double getPrevPosX() { return this.prevPosX; }
    public double getPrevPosY() { return this.prevPosY; }
    public ArrayList<snakeBody> getSnakeBody() { return this.body; }
    public int getUpdateFreq() { return this.updateFreq; }

    // Setters
    public void setDirection(double direction) { this.direction = direction; }
    public void setSpeed(double speed) { this.speed = speed; }
    public void setPrevPosX(double prevPosX) { this.prevPosX = prevPosX; }
    public void setPrevPosY(double prevPosY) { this.prevPosY = prevPosY; }
    public void setUpdateFreq(int updateFreq) { this.updateFreq = updateFreq; }
    public void setLength(int length) { this.length = length; }
}
