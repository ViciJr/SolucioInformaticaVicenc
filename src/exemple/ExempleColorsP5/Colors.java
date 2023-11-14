package exemple.ExempleColorsP5;

import processing.core.PApplet;

public class Colors{

    int[] colors;

    public Colors(PApplet p5){
        this.setColors(p5);
    }

    void setColors(PApplet p5){
        this.colors = new int[5];
        this.colors[0] = p5.color(0xFF272932);
        this.colors[1] = p5.color(0xFF335470);
        this.colors[2] = p5.color(0xFF4764A7);
        this.colors[3] = p5.color(0xFF4A7DD3);
        this.colors[4] = p5.color(0xFF23CCE7);
    }


    int getNumColors(){
        return this.colors.length;
    }


    int getFirstColor(){
        return  this.colors[0];
    }


    int getSecondColor(){
        return  this.colors[1];
    }


    int getThirdColor(){
        return  this.colors[2];
    }


    int getColorAt(int i){
        return this.colors[i];
    }



    void displayColors(PApplet p5, float x, float y, float w){
        p5.pushStyle();
        p5.fill(0); p5.textAlign(p5.LEFT); p5.textSize(36);
        p5.text("Colors:", x, y-10);

        float wc = w / getNumColors();
        for(int i=0; i<getNumColors(); i++){
            p5.fill(getColorAt(i)); p5.stroke(0); p5.strokeWeight(3);
            p5.rect(x + i*wc, y, wc, wc);
        }
        p5.popStyle();
    }
}
