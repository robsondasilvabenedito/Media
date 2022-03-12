// Package
package code.base;

// Import
import javax.swing.JButton;

import java.awt.event.ActionListener;

// Class
public class Button extends JButton{
    
    private int x, y, w, h;
    private String name;
    ActionListener e;

    public Button(int x, int y, int w, int h, String name, ActionListener e){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.name = name;
        this.e = e;
    }

    public void draw(){
        // Bounds
        setBounds(this.x, this.y, this.w, this.h);

        // Text
        setText(this.name);

        // ActionListener
        addActionListener(this.e);
    }

    public void location(int x, int y){
        this.x = x;
        this.y = y;

        // Location
        setLocation(this.x, this.y);
    }
}
