// Package
package code.base;

// Import
import javax.swing.JTextField;

// Class
public class TextField extends JTextField{

    private int x, y, w, h;
    private Boolean edit;

    public TextField(int x, int y, int w, int h, Boolean edit){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.edit = edit;
    }

    public void draw(){
        // Bounds
        setBounds(this.x, this.y, this.w, this.h);

        // Edit
        setEditable(this.edit);
    }

    public void draw(String text){
        // Bounds
        setBounds(this.x, this.y, this.w, this.h);

        // Edit
        setEditable(this.edit);

        // Text
        setText(text);
    }

    public void draw(String text, String tool){
        // Bounds
        setBounds(this.x, this.y, this.w, this.h);

        // Edit
        setEditable(this.edit);

        // Text
        setText(text);

        // ToolTipText
        setToolTipText(tool);
    }
}
