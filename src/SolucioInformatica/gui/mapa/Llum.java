package SolucioInformatica.gui.mapa;

import processing.core.PApplet;
/**La clase Llum hereda de Sensor y es la que se usa para crear los actuadores.*/
public class Llum extends Sensor{
/**Constructores de Llum*/
    public Llum (String n){
        super(n);
    }

    public Llum(String n, boolean ences){
        super(n, ences);
    }

    public Llum (String n, boolean ences, Sensor sv, Habitacio h, String ta, String pa, float valMax, float valMin) {
        super(n, ences, sv, h, ta, pa, valMax, valMin);
    }

    public void dibuixa(PApplet p5){

        p5.pushStyle();
        p5.fill(0);
        p5.circle(x, y+10, radi);
        p5.fill(this.ences? p5.color(255, 255, 0) : p5.color(0));
        p5.circle(x, y+10, 25);
        p5.fill(0); p5.textAlign(p5.CENTER);
        p5.text(this.nom, x, y +  35);
        p5.popStyle();
    }

    public String getNom() {
        return nom;
    }

}