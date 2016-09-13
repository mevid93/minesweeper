
package miinaharava.miinaharava;

import java.awt.Dimension;
import javax.swing.JButton;

/**
 *
 * @author Martin Vidjeskog
 */
public class Ruutu extends JButton{
    
    private int x;
    private int y;
    
    
    /**
     * 
     * @param x : Ruudun x-koordinaatti pelikentässä. 
     * @param y : Ruudun y-koordinaatti pelikentässä.
     */
    public Ruutu(int x, int y){
        this.x = x;
        if(x < 0){
            x = 0;
        }
        this.y = y;
        if(y < 0){
            y = 0;
        }
        this.setPreferredSize(new Dimension(40, 40));
        this.addMouseListener(new NappienKuuntelija());
    }
    
}
