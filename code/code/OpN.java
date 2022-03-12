// Package
package code.code;

// Import
import java.util.ArrayList;

// Class
public class OpN {

    private float n, g;
    private ArrayList<Float> nA = new ArrayList<Float>();

    public OpN(float n, ArrayList<Float> na){
        this.nA = na;
        this.n = n;
    }

    public float calc(){
        for (int i = 0; i < nA.size(); i++){
            n += this.nA.get(i);
        }

        int b = this.nA.size()+1;
        float a = n/b;

        return a;
    }

    public float calcP(ArrayList<Float> p){
        for (int i = 0; i < p.size(); i++){
            g+=p.get(i);
        }

        n = n*p.get(0);

        // for
        for (int i = 0; i < nA.size(); i++){
            n += (this.nA.get(i)*p.get(i+1));
        }

        float a = n/g;

        return a;
    }

    public float getG(){
        return n;
    }
}
