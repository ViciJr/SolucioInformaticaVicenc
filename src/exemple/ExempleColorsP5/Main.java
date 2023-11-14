package exemple.ExempleColorsP5;

import processing.core.PApplet;

import static exemple.ExempleColorsP5.Mides.midaCercle;

public class Main extends PApplet {


        Colors appColors;


        Cercle c1, c2, c3;

        public static void main(String[] args) {
            PApplet.main("exemple.ExempleColorsP5.Main", args);
        }

        public void settings(){
            size(800, 800, P2D);
            smooth(10);
        }

        public void setup(){


            appColors = new Colors(this);


            c1 = new Cercle(width/4, height/2, midaCercle);
            c1.setColor(appColors.getFirstColor());

            c2 = new Cercle(width/2, height/2, midaCercle);
            c2.setColor(appColors.getSecondColor());

            c3 = new Cercle(3*width/4, height/2, midaCercle);
            c3.setColor(appColors.getThirdColor());
        }

        public void draw(){
            // Dibuixa el fons (blanc)
            background(255);

            // Dibuixa els cercles (exemple de classes emprant colors).
            c1.display(this);
            c2.display(this);
            c3.display(this);

            // Dibuixa rectangle amb 5è color (exemple d'emprar els colors directament).
            fill(appColors.getColorAt(4)); noStroke();
            rect(0, 3*height/4, width, height/4);

            // Mostra la paleta de colors
            appColors.displayColors(this, 100,100,width-200);
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
