package SolucioInformatica.gui.mapa;

import processing.core.PApplet;

public class Sensor {

    String nom;
    boolean ences;

    Llum actuadorVinculado;

    Sensor sensorVinculado;

    Habitacio habitacion;

    String puertoArduino;

    String tipoSensor;

    String tipoActuador;

    float valMax, valMin;

    float valorActual;

    float x, y;
    float radi = 25;

    public Sensor(String n){
        this.nom = n;
        this.ences = false;
    }

    public Sensor(String n, boolean ences){
        this.nom = n;
        this.ences = ences;
    }

    public Sensor (String n, boolean ences, Sensor sv, Habitacio h, String ta, String pa, float valMax, float valMin){
        this.nom = n;
        this.ences = ences;
        this.sensorVinculado=sv;
        this.habitacion=h;
        this.tipoActuador=ta;
        this.puertoArduino=pa;
        this.valMax=valMax;
        this.valMin=valMin;
    }

    public Sensor (String n, boolean ences, Llum a, Habitacio h, String ts, String pa, float valorActual){
        this.actuadorVinculado=a;
        this.habitacion=h;
        this.tipoSensor=ts;
        this.puertoArduino=pa;
    }

    public void setPosicio(float x, float y){
        this.x = x;
        this.y = y;
    }

    public void setEnces(boolean b){
        this.ences = b;
    }

    public void dibuixa(PApplet p5){

        p5.pushStyle();
        p5.stroke(0);
        p5.fill(this.ences? p5.color(255, 255, 0) : p5.color(0));
        p5.rectMode(p5.CENTER);
        p5.rect(x, y+10, 25, 25);
        p5.fill(0); p5.textAlign(p5.CENTER);
        p5.text(this.nom, x, y +  35);
        p5.popStyle();
    }

    public boolean mouseOnSensor(PApplet p5){
        return p5.dist(p5.mouseX, p5.mouseY, x, y)<=radi;
    }

    public void toggleEnces(){
        ences = !ences;
    }

    public void updateSensor(PApplet p5){
        if(mouseOnSensor(p5)){
            toggleEnces();
        }
    }

}