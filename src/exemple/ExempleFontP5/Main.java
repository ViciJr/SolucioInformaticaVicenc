package exemple.ExempleFontP5;

import processing.core.PApplet;

public class Main extends PApplet {


    Fonts fontsApp;

    public static void main(String[] args) {
        PApplet.main("exemple.ExempleFontP5.Main", args);
    }

    public void settings() {
        size(800, 800, P2D);
        smooth(10);
    }

    public void setup() {


        fontsApp = new Fonts(this);
    }

    public void draw() {
        background(255);

        textFont(fontsApp.getFirstFont());
        text("Titol de l'App", 50, 200);

        fill(50);
        textFont(fontsApp.getSecondFont());
        text("Subtitol de l'App", 50, 250);

        fill(55, 0, 0);
        textFont(fontsApp.getThirdFont());
        text("Paràgraf de l'App", 50, 300);


        fontsApp.displayFonts(this, 100, 400, 50);

    }
    public void keyPressed(){
        println("KEY PRESSED");
    }

    public void mousePressed(){
        println("MOUSE PRESSED");
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}
