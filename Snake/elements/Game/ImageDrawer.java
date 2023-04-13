package Snake.elements.Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import Snake.elements.element;

public class ImageDrawer extends element
{
    private BufferedImage image;

    public ImageDrawer(String imagePath) // default
    {
        super(1,0,0,0,0);
        this.setDrawStat(false);
        this.setUpdateStat(false);
        try {
            this.image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setSizeX(this.image.getWidth());
        this.setSizeY(this.image.getHeight());
    }

    public ImageDrawer(String imagePath, int sizeX, int sizeY, int positionX, int positionY) 
    {
        super(1,sizeX,sizeY,positionX,positionY);
        this.setDrawStat(false);
        this.setUpdateStat(false);
        try {
            this.image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setSizeX(this.image.getWidth());
        this.setSizeY(this.image.getHeight());
    }

    public void draw(Graphics2D win) 
    {
        if (this.getDrawStat()) 
            win.drawImage(image, (int)this.getPositionX(), (int)this.getPositionY(), (int)this.getSizeX(), (int)this.getSizeY(), null);
    }
}