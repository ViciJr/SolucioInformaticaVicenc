package SolucioInformatica.gui;

import processing.core.PApplet;
/**Los SwitchButton son botones que simulan interruptores y que en la app se usan para controlar los sensores y actuadores*/
public class SwitchButton {

    // Propietats d'un botó:
    float x, y, w, h;  // Posició i dimensions
    // Colors de contorn, farciment, actiu i desactiu
    int fillColor, strokeColor, fillColorOver, fillColorDisabled, i;
    boolean enabled;  // Abilitat / desabilitat

    String l, f;
    char encesOrApagat;


    // Mètode Constructor
    public SwitchButton(PApplet p5, String f, String l, float x, float y, float w, float h){
        this.f=f;
        this.l=l;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.enabled = false;
        fillColor = p5.color(70);
        fillColorOver = p5.color(100);
        fillColorDisabled = p5.color(150);
        strokeColor = p5.color(0);
        i=1;
    }

    // Setters

    public void setEnabled(boolean b){
        this.enabled = b;
    }

    public void toggle(){
        this.enabled = !this.enabled;
    }

    // Getters
    public boolean isEnabled(){
        return  this.enabled;
    }

    public char getEncesOrApagat(){
        if (this.enabled==false){
            return this.encesOrApagat='S';
        }
        else {
            return this.encesOrApagat='N';
        }
    }

    public boolean setMouseOverButtonFalse(PApplet p5){
        return mouseOverButton(p5)==false;
    }

    // Dibuixa el botó
    public void display(PApplet p5){

        p5.pushStyle();

        if(!enabled){
            p5.fill(fillColorDisabled);  // Color desabilitat
        }
        else if(mouseOverButton(p5)){
            p5.fill(fillColorOver);      // Color quan ratolí a sobre
        }
        else{
            p5.fill(fillColor);          // Color actiu però ratolí fora
        }
        p5.stroke(strokeColor); p5.strokeWeight(2);        //Color i gruixa del contorn
        p5.rect(this.x, this.y, this.w, this.h, 10);    // Rectangle del botó

        p5.rectMode(p5.CENTER); p5.textAlign(p5.CENTER); p5.textSize(24);
        if(this.enabled){
            p5.rect(this.x + this.h/2, this.y + this.h/2, this.h-10, this.h-10, 5);
            p5.fill(0);
            p5.text(f, this.x + this.h/2, this.y + this.h/2 + 10);
        }
        else {
            p5.rect(this.x + this.w - this.h/2, this.y + this.h/2, this.h-10, this.h-10, 5);
            p5.fill(0);
            p5.text(l, this.x + this.w - this.h/2, this.y + this.h/2 + 10);
        }

        p5.popStyle();

    }


    // Indica si el cursor està sobre el botó
    public boolean mouseOverButton(PApplet p5){
        return (p5.mouseX >= this.x) &&
                (p5.mouseX<=this.x + this.w) &&
                (p5.mouseY>= this.y) &&
                (p5.mouseY<= this.y + this.h);
    }


}
