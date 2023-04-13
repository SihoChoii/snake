package Snake;
// CSA Snake Game Project
// Made by  : Siho Choi
// Version  : v1.1
// Date     : 3/1/2023

import java.awt.Graphics2D;
import Snake.elements.Game.snakeHead;
import Snake.utilities.GDV5;
import Snake.elements.Game.apple;
import Snake.elements.Game.MouseListener;

public class GameRunner extends GDV5
{
    // Variables
    private snakeHead snake1;
    private String appleString = "C:\\Users\\sihoc\\Documents\\GitHub\\snake\\Snake\\elements\\Game\\Sprites\\RimuruSlime.png";

    public GameRunner()
    {
        snake1 = new snakeHead();
        apple.apples.add(new apple(appleString));
        apple.apples.add(new apple(appleString));
        apple.apples.add(new apple(appleString));
        apple.apples.add(new apple(appleString));
        apple.apples.get(0).setDrawStat(true);
        apple.apples.get(1).setDrawStat(true);
        apple.apples.get(2).setDrawStat(true);
        apple.apples.get(3).setDrawStat(true);
    }
    
    public static void main(String[] args)
    {
        GameRunner mainInstance = new GameRunner();
        mainInstance.start();
    }

    @Override
    public void update()
    {
        snake1.update();
        for (int i = 0; i < apple.apples.size(); i++) apple.apples.get(i).update();
    }

    @Override
    public void draw(Graphics2D win)
    {
        snake1.draw(win);
       for (int i = 0; i < apple.apples.size(); i++) apple.apples.get(i).draw(win);
    }
}