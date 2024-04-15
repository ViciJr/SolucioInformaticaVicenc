package SolucioInformatica.gui.Pantalles;


import SolucioInformatica.Fonts.Mides;
import processing.core.PApplet;
import processing.core.PFont;

/**Con la clase Fonts se pueden obtener las diferentes tipografías seleccionadas y de diferentes tamaños*/
public class Fonts {



    PFont[] fonts;

/**Constructor de Fonts*/
    public Fonts(PApplet p5){
        this.setFonts(p5);
    }

/**Array de tipografías*/
    void setFonts(PApplet p5){
        this.fonts = new PFont[6];
        this.fonts[0] = p5.createFont("data/TTInterphasesProMonoTrialRegular.ttf", SolucioInformatica.Fonts.Mides.midaTitol);
        this.fonts[1] = p5.createFont("data/AltoneTrialRegular.ttf", SolucioInformatica.Fonts.Mides.midaSubtitol);
        this.fonts[2] = p5.createFont("data/LouisGeorgeCafeBold.ttf", Mides.midaParagraf);
        this.fonts[3] = p5.createFont("data/TTInterphasesProMonoTrialRegular.ttf", 12);
        this.fonts[4] = p5.createFont("data/AltoneTrialRegular.ttf",12);
        this.fonts[5] = p5.createFont("data/LouisGeorgeCafeBold.ttf", 12);
    }


    int getNumFonts(){
        return this.fonts.length;
    }


    PFont getFirstFont(){
        return  this.fonts[0];
    }


    PFont getSecondFont(){
        return  this.fonts[1];
    }


    PFont getThirdFont(){
        return  this.fonts[2];
    }


    PFont getFontAt(int i){
        return this.fonts[i];
    }



    void displayFonts(PApplet p5, float x, float y, float h){
        p5.pushStyle();
        for(int i=0; i<getNumFonts(); i++){
            p5.fill(0); p5.stroke(0); p5.strokeWeight(3);
            p5.textFont(getFontAt(i));
            p5.text("Tipografia "+i, x, y + i*h);
        }
        p5.popStyle();
    }
}
