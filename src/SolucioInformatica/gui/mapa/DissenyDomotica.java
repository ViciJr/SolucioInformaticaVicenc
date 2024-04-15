package SolucioInformatica.gui.mapa;
import processing.core.PApplet;

/**Prueba del mapa*/
public class DissenyDomotica extends PApplet {

    // Variable de classe Habitació i Sensor
    Habitacio[] habitacions;
    Habitacio Habitación1, Habitación2, hSelected;
    Sensor Sensor1, Sensor2, Sensor4, Sensor3;

    public static void main(String[] args) {
        PApplet.main("SolucioInformatica.gui.mapa.DissenyDomotica", args);
    }

    public void settings(){
        size(1200, 800);
        smooth(10);
    }

    public void setup(){

        // Constructor de Sensors (Llums)
        Sensor1 = new Llum("Llum A", true);
        Sensor2 = new Llum("Llum B", true);
        Sensor4 = new Llum("Llum C");
        Sensor3 = new Sensor("Aire Condicionat");

        // Constructor d'Habitacions
        Habitación1 = new Habitacio("Habitación 1", 0, 0, 300, 300, color(200, 100, 100, 10));
        Habitación2 = new Habitacio("Habitación 2", 300, 0, 400, 600, color(100, 200, 100, 10));

        // Agregam Sensors a les Habitacions
        Habitación1.addSensor(Sensor1);
        Habitación1.addSensor(Sensor2);
        Habitación1.addSensor(Sensor3);
        Habitación2.addSensor(Sensor4);

        // Cream array d'habitacions
        habitacions = new Habitacio[2];
        habitacions[0] = Habitación1;
        habitacions[1] = Habitación2;

        // Habitació Seleccionada (cap)
        hSelected = null;
    }

    public void draw() {
        // Fons de la finestra
        background(255);

        // Dibuix de les Habitacions
        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(this);
        }

    }

    // ******************* KEYBOARD interaction ***************************** //

    public void keyPressed(){
        // Encen tots els llums
        if(key=='n' || key=='N'){
            if(hSelected != null) {
                hSelected.encenLlums();
            }
        }
        // Apaga tots els llums
        else if(key=='f' || key=='F'){
            if(hSelected != null) {
                hSelected.apagaLlums();
            }
        }
    }

    // ******************* MOUSE interaction ***************************** //

    // En cas de pitjar el ratolí
    public void mousePressed(){

        // Comprova si clicam sobre els sensors de les habitacions
        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].updateSensors(this);
        }

        // Comprova si clicam sobre una habitació.
        for(int i=0; i<habitacions.length; i++) {
            if(habitacions[i].mouseOnHabitacio(this)){
                hSelected = habitacions[i];
                habitacions[i].setSelected(true);
            }
            else {
                habitacions[i].setSelected(false);
            }
        }

    }

    public void mouseDragged(){

    }

    public void mouseReleased() {
        println("MOUSE RELEASED");
    }
}