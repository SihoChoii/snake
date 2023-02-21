// Grid Block Object

// package elemtns;

import java.awt.Rectangle;
import element;

public class gridBlock extends element
{

    public void divide(int division, int divX, int divY)
    {
        // naive test
        this.setScale(this.getScale()/division);
        this.setPosition(this.getPositionX(), this.getPositionY() + this.getSizeY());
        
    }
}