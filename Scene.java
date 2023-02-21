// Scene Object
// Holds Scene Data
// package scenes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Font;
import element;

public class Scene extends element
{
    // Scene Data
    private int sceneVariation;         // 0 Reserved for default

    public Scene(int sceneVariation, double scale, int sizeX, int sizeY, int positionX, int positionY)
    {
        super(scale, sizeX, sizeY, positionX, positionY);
        this.sceneVariation = sceneVariation;
    }
    // Default Overload - Full Size Scene
    public Scene()
    {
        super(1, getMaxWindowX(), getMaxWindowY(), 0, 0);
        this.sceneVariation = 0;
    }

    // Getters
    public int getSceneID() { return this.sceneID; }
    public int getSceneVariation() { return this.sceneVariation; }

    // Setters
    public void setSceneID(int num) { this.sceneID = num; }
    public void setSceneVariation(int num) { this.sceneVariation = num; }
}