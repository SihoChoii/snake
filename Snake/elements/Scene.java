// Scene Object
// Holds Scene Data
package Snake.elements;

import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import Snake.GameRunner;

public class Scene extends element
{
    // Scene Data
    private int sceneVariation;         // 0 Reserved for default
    private boolean sceneDataOverlay;   // (True = On)

    public Scene(int sceneVariation, double scale, int sizeX, int sizeY, int positionX, int positionY)
    {
        super(scale, sizeX, sizeY, positionX, positionY);
        this.sceneVariation = sceneVariation;
    }
    // Default Overload - Full Size Scene
    public Scene()
    {
        super(1, GameRunner.getMaxWindowX(), GameRunner.getMaxWindowY(), 0, 0);
        this.sceneVariation = 0;
    }

    public void sceneDataOverlay(Graphics2D win)
    {
        if (sceneDataOverlay)
        {
            int fontSize = 5;
            // Write Data on Top Left
            win.setColor(Color.white);
            win.setFont(new Font("Helvetica", Font.BOLD, fontSize));
            //win.drawString("sceneID: " + this.sceneID + "sceneVariation: " + this.sceneVariation, 0, sizeY);
            win.drawString("sizeX: " + this.getSizeX() + "sizeY: " + this.getSizeY(), 0, (int)getSizeY()+(fontSize*1));
            win.drawString("positionX: " + this.getPositionX() + "positionY: " + this.getPositionY(), 0, (int)getSizeY()+(fontSize*2));
            win.drawString("updateStat: " + this.getUpdateStat() + "drawStat: " + this.getDrawStat(), 0, (int)getSizeY()+(fontSize*3));
        }
    }

    // Getters
    public int getSceneVariation() { return this.sceneVariation; }

    // Setters
    public void setSceneVariation(int num) { this.sceneVariation = num; }
}