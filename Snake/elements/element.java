// Basic Element Parent Class
package Snake.elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Rectangle;

public class element
{
    // element data
    private double positionX, positionY;
    private double scale;
    private double sizeX, sizeY;

    // Color Propeprties
    private Color innerColor;
    private Color outerColor;
    private int borderSize;

    private boolean updateStat;         // Update Limiter (True = Update)
    private boolean drawStat;           // Draw Limiter (True = Draw)

    // Debug Code
    private boolean sceneDataOverlay;   // (True = On)
    private boolean debugPrint;         // (True = On)

    public element(double scale, int sizeX, int sizeY, int positionX, int positionY)
    {
        this.positionX = positionX;
        this.positionY = positionY;
        this.scale = scale;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    // Debug Functions
    public void debugMessage(String message)
    { 
        if (debugPrint)
        {
            System.out.println("Scene.java: " + message);
        }
    }
    
    public void sceneDateOverlay(Graphics2D win)
    {
        if (sceneDataOverlay)
        {
            int fontSize = 5;
            // Write Data on Top Left
            win.setColor(Color.white);
            win.setFont(new Font("Helvetica", Font.BOLD, fontSize));
            // win.drawString("sceneID: " + this.sceneID + "sceneVariation: " + this.sceneVariation, 0, sizeY);
            win.drawString("sizeX: " + this.sizeX + "sizeY: " + this.sizeY, 0, (int)sizeY+(fontSize*1));
            win.drawString("positionX: " + this.positionX + "positionY: " + this.positionY, 0, (int)sizeY+(fontSize*2));
            win.drawString("updateStat: " + this.updateStat + "drawStat: " + this.drawStat, 0, (int)sizeY+(fontSize*3));
        }
    }

    // Getters
    public double getPositionX() { return this.positionX; }
    public double getPositionY() { return this.positionY; }
    public double getScale() { return this.scale; }
    public double getSizeX() { return this.sizeX; }
    public double getSizeY() { return this.sizeY; }
    public boolean getUpdateSat() { return this.updateStat; }
    public boolean getDrawStat() { return this.drawStat; }
    public Rectangle getRectangle() {
        return new Rectangle((int)this.getPositionX(), (int)this.getPositionY(), (int)this.getSizeX(), (int)this.getSizeY()); }
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

