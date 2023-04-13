// Basic Element Parent Class
package Snake.elements;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.BasicStroke;

public class element
{
    // element data
    private double positionX, positionY;
    private double scale; // 0-1
    private double sizeX, sizeY;
    
    // Color Propeprties
    private Color innerColor;
    private Color outerColor;
    private int borderSize;

    private boolean updateStat = false;         // Update Limiter (True = Update)
    private boolean drawStat = false;           // Draw Limiter (True = Draw)

    // Debug Code
    private boolean debugPrint;         // (True = On)

    public element(double scale, double sizeX, double sizeY, double positionX, double positionY)
    {
        this.positionX = positionX;
        this.positionY = positionY;
        this.scale = scale;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public boolean intersects(element object) // intersection from the center of the object
    {
        double x = this.getPositionX() + this.getSizeX()/2;
        double y = this.getPositionY() + this.getSizeY()/2;

        if (x > object.getPositionX() && x < object.getPositionX() + object.getSizeX())
            if (y > object.getPositionY() && y < object.getPositionY() + object.getSizeY()) return true;
        return false;
    }

    // Debug Functions
    public void debugMessage(String message)
    { 
        if (debugPrint)
        {
            System.out.println("Scene.java: " + message);
        }
    }

    // Getters
    public double getPositionX() { return this.positionX; }
    public double getPositionY() { return this.positionY; }
    public double getScale() { return this.scale; }
    public double getSizeX() { return this.sizeX; }
    public double getSizeY() { return this.sizeY; }
    public boolean getUpdateStat() { return this.updateStat; }
    public boolean getDrawStat() { return this.drawStat; }
    public Rectangle getRectangle() {
        return new Rectangle((int)this.getPositionX(), (int)this.getPositionY(), (int)this.getSizeX(), (int)this.getSizeY()); }
    public BasicStroke getStroke() { return new BasicStroke(this.borderSize); }
    public boolean getDebugPrint() { return this.debugPrint; }
    // Color Getters
    public Color getOuterColor() { return this.outerColor; }
    public Color getInnerColor() { return this.innerColor; }
    public int getBorderSize() { return this.borderSize; }

    // Setters
    public void setPositionX(double num) { this.positionX = num; }
    public void setPositionY(double num) { this.positionY = num; }
    public void setSizeX(double num) { this.sizeX = num; }
    public void setSizeY(double num) { this.sizeY = num; }
    public void setUpdateStat(boolean stat) { this.updateStat = stat; }
    public void setDrawStat(boolean stat) { this.drawStat = stat; }
    public void setDebugPrint(boolean stat) { this.debugPrint = stat; }
    public void setPosition(double x, double y)
    {
        this.positionX = x;
        this.positionY = y;
    }
    public void setScale(double num) 
    { 
        this.scale = num;
        this.sizeX *= this.scale;
        this.sizeY *= this.scale;
    }
    // Color Setters
    public void setOuterColor(Color color) { this.outerColor = color; }
    public void setInnerColor(Color color) { this.innerColor = color; }
    public void setBorderSize(int num) { this.borderSize = num; }
}

