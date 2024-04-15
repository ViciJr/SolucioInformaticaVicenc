package SolucioInformatica.ColorsFont;

import static SolucioInformatica.ColorsFont.Layout.*;
import static SolucioInformatica.ColorsFont.Mides.*;

import processing.core.PApplet;

/**Clase para probar colores, tipografías y maquetación*/
public class Main003 extends PApplet{
    Colors appColors;
    Fonts fontsApp;

    public static void main(String[] args) {
        PApplet.main("SolucioInformatica.ColorsFont.Main003", args);
    }

    public void settings(){

        size(1920, 1080);
        smooth(10);
    }

    public void setup(){
        noStroke();
        textAlign(CENTER); textSize(18);

        appColors = new Colors(this);
        fontsApp = new Fonts(this);
    }

    public void draw(){


        background(55);


        fill(appColors.getFirstColor());
        rect(marginH, marginV, width - marginH*2, height - marginV*2);


        fill(appColors.getSecondColor());
        rect(marginH, marginV, logoWidth, logoHeight);
        fill(0);textFont(fontsApp.getFirstFont()); textSize(midaTitol);
        text("LOGO", marginH + logoWidth/2, marginV + logoHeight/2);


        fill(appColors.getSecondColor());
        rect(marginH, 2*marginV + logoHeight, sidebarWidth, sidebarHeight);
        fill(0); textFont(fontsApp.getSecondFont()); textSize(midaSubtitol);
        text("SIDEBAR", marginH + sidebarWidth/2, marginV + logoHeight + sidebarHeight/2);


        fill(appColors.getColorAt(4));
        rect(2*marginH + logoWidth, marginV, bannerWidth, bannerHeight);
        fill(0); textFont(fontsApp.getSecondFont()); textSize(midaTitol);
        text("BANNER", marginH + logoWidth + bannerWidth/2, marginV + bannerHeight/2);



        fill(appColors.getThirdColor());
        rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        fill(0); textFont(fontsApp.getThirdFont()); textSize(midaParagraf);
        text("COLUMN 1", 2*marginH + sidebarWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        fill(appColors.getThirdColor());
        rect(3*marginH + sidebarWidth + columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        fill(0); textFont(fontsApp.getThirdFont()); textSize(midaParagraf);
        text("COLUMN 2", 3*marginH + sidebarWidth + columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        fill(appColors.getThirdColor());
        rect(4*marginH + sidebarWidth + 2*columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        fill(0); textFont(fontsApp.getThirdFont()); textSize(midaParagraf);
        text("COLUMN 3", 4*marginH + sidebarWidth + 2*columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

    }




    public void keyPressed(){
        println("KEY PRESSED");
    }


    public void mousePressed(){
        println("X: "+mouseX+", Y:"+mouseY);
    }

    public void mouseDragged(){
        println("MOUSE DRAGGED");
    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }

}