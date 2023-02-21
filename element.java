// Basic Element Parent Class

// package elements;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;

public class element extends Snake
{
    // element data
    private int positionX, positionY;
    private double scale;
    private int sizeX, sizeY;

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
        this.sizeX = sizeX * scale;
        this.sizeY = sizeY * scale;
    }

    // Debug Functions
    public void debugMessage(String message)
    { 
        if (debugPrint)
        {
            System.out.println("sceneID: " + sceneID + "sceneVariation: " + sceneVariation); 
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
            win.drawString("sizeX: " + this.sizeX + "sizeY: " + this.sizeY, 0, sizeY+(fontSize*1));
            win.drawString("positionX: " + this.positionX + "positionY: " + this.positionY, 0, sizeY+(fontSize*2));
            win.drawString("updateStat: " + this.updateStat + "drawStat: " + this.drawStat, 0, sizeY+(fontSize*3));
        }
    }

    // Getters
    public int getPositionX() { return this.positionX(); }
    public int getPositionY() { return this.positionY(); }
    public int getScale() { return this.scale; }
    public int getSizeX() { return this.sizeX; }
    public int getSizeY() { return this.sizeY; }
    public int getUpdateSat() { return this.updateStat; }
    public int getDrawStat() { return this.drawStat; }

    // Setters
    public void setPositionX(int num) { this.positionX = num; }
    public void setPositionY(int num) { this.positionY = num; }
    public void setSizeX(int num) { this.sizeX = num; }
    public void setSizeY(int num) { this.sizeY = num; }
    public void setUpdateStat(boolean stat) { this.updateStat = stat; }
    public void setDrawStat(boolean stat) { this.drawStat = stat; }

    public void setPosition(int x, int y)
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
}

