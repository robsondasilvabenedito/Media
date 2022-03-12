// Package
package code.view;

// Import
import code.base.TextField;
import code.base.Button;
import code.code.OpN;

import java.util.ArrayList;

import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

// Class
public class View implements ActionListener{

    private int i, w, add = 40, h_add = 70, h_text = 40;
    private String n;
    private Boolean press = false;
    
    JFrame __screen = new JFrame();
    Button __add, __peso, __rm, __calc;
    TextField __result, __newt, __newp, __1, __pesoTool;
    OpN number;
    ArrayList<TextField> __text = new ArrayList<TextField>();
    ArrayList<TextField> __pesos = new ArrayList<TextField>();

    Font font = new Font("Arial", Font.PLAIN, 12);

    public void draw(){
        // View
        __screen.setSize(800,400);
        __screen.setResizable(false);
        __screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        __screen.setLocationRelativeTo(null);
        __screen.setLayout(null);

        // JTextField
            // Result
        __result = new TextField(640, 270, 100, 20, false);
        __result.draw("", "Resultado");
        __result.setFont(font);
            // Nota 1
        __1 = new TextField(60, this.h_text, 70, 20, true);
        __1.draw(null, "Nota 1");
        __1.setFont(font);
            // Peso
        __pesoTool = new TextField(140+220, 10, 70, 20, false);
        __pesoTool.draw("PESO", null);
        __pesoTool.setHorizontalAlignment(TextField.CENTER);
        __pesoTool.setFont(font);

        // Button
            // Add
        __add = new Button(60, this.h_add, 70, 20, "+", this);
        __add.draw();
        __add.setFont(font);
            // Peso
        __peso = new Button(140, 10, 70, 20, "PESO", this);
        __peso.draw();
        __peso.setFont(font);
            // Calc
        __calc = new Button(640, 300, 100, 20, "Calcular", this);
        __calc.draw();
        __calc.setFont(font);

        // View Add
        __screen.add(__add);
        __screen.add(__result);
        __screen.add(__peso);
        __screen.add(__1);
        __screen.add(__calc);

        // Click
        __add.doClick();

        // View Visible
        __screen.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Add
        if (e.getSource() == __add){
            // ++
            i++;
            h_add+= 30;
            h_text+=30;
            n = ("Nota "+(i+1));

            if (i == 19) __screen.remove(__add);
            
            if (h_add == 370){
                w = 220;
                h_add = 70;
                h_text = 40;
                __screen.add(__pesoTool);
            }

            // Add
            __add.location(60+w, this.h_add);

            // Rm
            if (i == 2){
                __rm = new Button(10+w, this.h_add-30, 40, 19, "-", this);
                __rm.draw();
                __rm.setFont(font);
            }
            else if(i > 2){
                __rm.location(10+w, this.h_add-30);
            }
            
            // Text
            __newt = new TextField(60+w, this.h_text, 70, 20, true);
            __newt.draw(null, n);
            __newt.setFont(font);

            // Array & Screen
            if (i >= 2) __screen.add(__rm);
            __text.add(__newt);
            __screen.add(__text.get(i-1));

            // Peso
            if (press == true){
                if (i >= 10){
                    __newp = new TextField(140+w, (add + (30*(i-10))), 70, 20, true);
                    __newp.draw();
                    __newp.setFont(font);
    
                    __pesos.add(__newp);
                    __screen.add(__pesos.get(__pesos.size()-1));
                } 
                else{
                    __newp = new TextField(140, (add + (30*i)), 70, 20, true);
                    __newp.draw();
                    __newp.setFont(font);
    
                    __pesos.add(__newp);
                    __screen.add(__pesos.get(__pesos.size()-1));
                }
            }

            // Screen
            __screen.revalidate();
            __screen.repaint();
        }

        // Remove
        else if (e.getSource() == __rm){
            // --
            i--;
            h_add-= 30;
            h_text-=30;

            if (i == 18){
                __screen.add(__add);
            }

            if(h_add == 40){
                w = 0;
                h_add = 340;
                h_text = 310;
                __screen.remove(__pesoTool);
            }

            // Add
            __add.location(60+w, this.h_add);

            // Rm
            if (i == 1){
                __screen.remove(__rm);
            }
            else{
                __rm.location(10+w, this.h_add-30);
            }

            // Array
            __screen.remove(__text.get(i));
            __text.remove(i);

            // Peso
            if (press == true){
                __screen.remove(__pesos.get((i+1)));
                __pesos.remove((i+1));
            }

            // Screen
            __screen.revalidate();
            __screen.repaint();
        }

        // Peso
        else if(e.getSource() == __peso){
            // Press
            press = (press == false ? true : false);

            // Peso
            peso();
        }

        //Calc
        else if(e.getSource() == __calc){
            ArrayList<Float> numbers = new ArrayList<Float>();
            ArrayList<Float> ps = new ArrayList<Float>();

            // Peso
            if(press == true){
                String txt1 = (__1.getText().equals("") ? "0" : __1.getText());
                float num1 = Float.parseFloat(txt1);

                for (int k = 0; k < __text.size(); k++){
                    String txt = (__text.get(k).getText().equals("") ? "0" : __text.get(k).getText());
                    Float num = Float.parseFloat(txt);

                    numbers.add(num);
                }

                for (int k = 0; k <= __text.size(); k++){
                    String txtp = (__pesos.get(k).getText().equals("") ? "0" : __pesos.get(k).getText());
                    float num2 = Float.parseFloat(txtp);

                    ps.add(num2);
                }

                number = new OpN(num1, numbers);
                float q = number.calcP(ps);
                __result.draw(String.valueOf(q), "Resultado");
            }

            // 
            else{
                String txt1 = (__1.getText().equals("") ? "0" : __1.getText());
                Float num1 = Float.parseFloat(txt1);

                for (int k = 0; k < __text.size(); k++){
                    String txt = (__text.get(k).getText().equals("") ? "0" : __text.get(k).getText());
                    Float num = Float.parseFloat(txt);

                    numbers.add(num);
                }

                number = new OpN(num1, numbers);
                float q = number.calc();
                __result.draw(String.valueOf(q), "Resultado");
            }
        }
    }

    public void peso(){

        if(press == true){
            if (i >= 10) __screen.add(__pesoTool);

            // For
            for (int k = 0; k <= i; k++){

                if (k < 10){
                    __newp = new TextField(140, (add + (30*k)), 70, 20, true);
                    __newp.draw();
                    __newp.setFont(font);
    
                    __pesos.add(__newp);
                    __screen.add(__pesos.get(__pesos.size()-1));
    
                    // Screen
                    __screen.revalidate();
                    __screen.repaint();
                }
                else{
                    __newp = new TextField(140+w, (add + (30*(k-10))), 70, 20, true);
                    __newp.draw();
                    __newp.setFont(font);
    
                    __pesos.add(__newp);
                    __screen.add(__pesos.get(__pesos.size()-1));
    
                    // Screen
                    __screen.revalidate();
                    __screen.repaint();
                }
            }
            add=40;
        } else{
            __screen.remove(__pesoTool);

            // Int
            int p = __pesos.size();

            // For
            for(int k = 0; k < p; k++){
                __screen.remove(__pesos.get((k)));

                // Screen
                __screen.revalidate();
                __screen.repaint();
            }
            __pesos.clear();
        }
    }
}
