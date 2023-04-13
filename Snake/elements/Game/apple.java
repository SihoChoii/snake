package Snake.elements.Game;

import Snake.elements.Game.ImageDrawer;
import Snake.utilities.GDV5;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class apple extends ImageDrawer
{
    // TODO public static apple list implementation. Not safe but works for now.
    public static ArrayList<apple> apples = new ArrayList<apple>();

    public apple(String path)
    {
        super(path);
        this.setScale(0.5);
        randomizeLocation();
    }

    public void randomizeLocation()
    {
        int x = (int)(Math.random() * GDV5.getMaxWindowX()+1);
        int y = (int)(Math.random() * GDV5.getMaxWindowY()+1);
        this.setPositionX(Math.max(0, Math.min(x, (int)(GDV5.getMaxWindowX()-this.getSizeX()))));
        this.setPositionY(Math.max(0, Math.min(y, (int)(GDV5.getMaxWindowY()-this.getSizeY()))));
    }

    public void update()
    {
        if (GDV5.KeysPressed[KeyEvent.VK_P]) this.randomizeLocation();
    }
}
