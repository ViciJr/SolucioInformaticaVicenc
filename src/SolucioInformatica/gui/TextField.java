package SolucioInformatica.gui;

import processing.core.PApplet;

import static processing.core.PConstants.BACKSPACE;
/**Clase con la que se crean los campos de texto usados en la pantalla de inicio, de los sensores y de los actuadores*/
public class TextField {

    // Propietats del camp de text
    int x, y, h, w;

    // Colors
    int bgColor, fgColor, selectedColor, borderColor;
    int borderWeight = 1;

    // Text del camp
    String text = "";
    int textSize = 24;

    boolean selected = false;

    // Constructor
    public TextField(PApplet p5, int x, int y, int w, int h) {
        this.x = x; this.y = y; this.w = w; this.h = h;
        this.bgColor = p5.color(140, 140, 140);
        this.fgColor = p5.color(0, 0, 0);
        this.selectedColor = p5.color(200);
        this.borderColor = p5.color(0);
        this.borderWeight = 1;
    }

    public String getText(){
       return this.text;
    }

    public void setText(String s){
        this.text=s;
    }

    // Dibuixa el Camp de Text
    public void display(PApplet p5) {
        p5.pushStyle();
        if (selected) {
            p5.fill(selectedColor);
        } else {
            p5.fill(bgColor);
        }

        p5.strokeWeight(borderWeight);
        p5.stroke(borderColor);
        p5.rect(x, y, w, h, 5);

        p5.fill(fgColor);
        p5.textSize(textSize); p5.textAlign(p5.LEFT, p5.CENTER);
        p5.text(text, x + 5, y + h - textSize);
        p5.popStyle();
    }

    // Afegeix, lleva el text que es tecleja
    public void keyPressed(char key, int keyCode) {
        if (selected) {
            if (keyCode == (int)BACKSPACE) {
                borrarTexto();
            } else if (keyCode == 32) {
                añadeTexto(' '); // SPACE
            } else {

                boolean isKeyCapitalLetter = (key >= 'A' && key <= 'Z');
                boolean isKeySmallLetter = (key >= 'a' && key <= 'z');
                boolean isKeyNumber = (key >= '0' && key <= '9');

                if (isKeyCapitalLetter || isKeySmallLetter || isKeyNumber) {
                    añadeTexto(key);
                }
            }
        }
    }

    // Afegeix la lletra c al final del text
    public void añadeTexto(char c) {
        if (this.text.length() + 1 < w) {
            this.text += c;
        }
    }

    // Lleva la darrera lletra del text
    public void borrarTexto() {
        if (text.length() > 0) {
            text = text.substring(0, text.length() - 1);
        }
    }

    // Indica si el ratolí està sobre el camp de text
    public boolean mouseOverTextField(PApplet p5) {
        return (p5.mouseX >= this.x && p5.mouseX <= this.x + this.w && p5.mouseY >= this.y && p5.mouseY <= this.y + this.h);
    }
    // Selecciona el camp de text si pitjam a sobre
    // Deselecciona el camp de text si pitjam a fora
    public void isPressed(PApplet p5) {
        if (mouseOverTextField(p5)) {
            selected = true;
        } else {
            selected = false;
        }
    }
}