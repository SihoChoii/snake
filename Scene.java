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
    private int sceneID;                // 0 Reserved for default
    private int sceneVariation;         // 0 Reserved for default

    public Scene(int sceneID, int sceneVariation)
    {
        this.sceneID = sceneID;
        this.sceneVariation = sceneVariation;

        currentScene = new SceneList(sceneID, sceneVariation);
    }

    // Getters
    public int getSceneID() { return this.sceneID; }
    public int getSceneVariation() { return this.sceneVariation; }

    // Setters
    public void setSceneID(int num) { this.sceneID = num; }
    public void setSceneVariation(int num) { this.sceneVariation = num; }
}