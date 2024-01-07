package SolucioInformatica.Pantalles;

;
import SolucioInformatica.gui.Button;
import SolucioInformatica.gui.Table;
import SolucioInformatica.gui.TextField;
import processing.core.PApplet;




import static SolucioInformatica.Pantalles.LayoutNMides.*;


public class GUI {

    // Enumerat de les Pantalles de l'App
    public enum PANTALLA {INICIO, PLANO, SENSORX, ACTUADORX, ESTADISTICASENSORX, ESTADÍSTICAACTUADORX};

    // Pantalla Actual
    public PANTALLA pantallaActual;

    //Colors i tipografia
    Fonts Fonts;
    Colors Colors;

    // PANTALLA INICIAL Y LOGIN
    Button BlogIn;
    TextField TUsuario;
    TextField TContraseña;

    // MENÚ I PLÀNOL
    Button Sensor1, Sensor2, Sensor3, Sensor4, Sensor5, Sensor6, Sensor7;
    Button Actuador1, Actuador2, Actuador3, Actuador4, Actuador5, Actuador6, Actuador7;

    //SensorX
    Table ts1, ts2;
    Button EditarSensor;



    // Constructor de la GUI
    public GUI(PApplet p5){

        pantallaActual = PANTALLA.INICIO;

        Colors = new Colors(p5);   // Constructor dels colors de l'App
        Fonts = new Fonts(p5);     // Constructor de les fonts de l'App

        //Pantalla inicial
        TUsuario = new TextField (p5, XUsuari+marginH, heightPrimeraPantalla+YUsuari, widthPrimeraPantalla, heightPrimeraPantalla); /*, "Usuario"*/
        TContraseña = new TextField (p5, XContra+marginH, YContra, widthPrimeraPantalla, heightPrimeraPantalla); /*, "Contraseña"*/
        p5.textFont(Fonts.getFontAt(2));
        BlogIn = new Button (p5, "HECHO", XHecho+marginH, YHecho, widthPrimeraPantalla, heightPrimeraPantalla);
       // BlogIn.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));

        //Pantalla Menú i Plànol
        p5.stroke(0, 2);
        p5.textFont(Fonts.getFontAt(2));
        Sensor1 = new Button (p5, "Sensor 1", XSensors, YSensors, widthSensors, heightSensors);
       // Sensor1.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Sensor2 = new Button (p5, "Sensor 2", XSensors, YSensors+heightSensors, widthSensors, heightSensors);
       // Sensor2.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Sensor3 = new Button (p5, "Sensor 3", XSensors, YSensors+2*heightSensors, widthSensors, heightSensors);
       // Sensor3.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Sensor4 = new Button (p5, "Sensor 4", XSensors, YSensors+3*heightSensors, widthSensors, heightSensors);
       // Sensor4.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Sensor5 = new Button (p5, "Sensor 5", XSensors, YSensors+4*heightSensors, widthSensors, heightSensors);
       // Sensor5.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Sensor6 = new Button (p5, "Sensor 6", XSensors, YSensors+5*heightSensors, widthSensors, heightSensors);
       // Sensor6.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Sensor7 = new Button (p5, "Sensor 7", XSensors, YSensors+6*heightSensors, widthSensors, heightSensors);
       // Sensor7.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));

        Actuador1 = new Button (p5, "Actuador 1", XActuadors, YActuadors, widthActuadors, heightActuadors);
       // Actuador1.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2),  Colors.getColorAt(3));
        Actuador2 = new Button (p5, "Actuador 1", XActuadors, YActuadors+heightActuadors, widthActuadors, heightActuadors);
       // Actuador2.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Actuador3 = new Button (p5, "Actuador 1", XActuadors, YActuadors+2*heightActuadors, widthActuadors, heightActuadors);
       // Actuador3.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Actuador4 = new Button (p5, "Actuador 1", XActuadors, YActuadors+3*heightActuadors, widthActuadors, heightActuadors);
       // Actuador4.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Actuador5 = new Button (p5, "Actuador 1", XActuadors, YActuadors+4*heightActuadors, widthActuadors, heightActuadors);
       // Actuador5.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Actuador6 = new Button (p5, "Actuador 1", XActuadors, YActuadors+5*heightActuadors, widthActuadors, heightActuadors);
       // Actuador6.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Actuador7 = new Button (p5, "Actuador 1", XActuadors, YActuadors+6*heightActuadors, widthActuadors, heightActuadors);
       // Actuador7.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));


        //Pantalla SensorX
        int files = 2, columnes = 5;

        ts1=new Table(files,columnes);

        // Número de files (capçalera inclosa) i columnes de la taula

        // Títols de les columnes
        String[] headers = {"Tipo", "Ubicación", "Puerto Arduino", "Actuador/es vinculado/s", "Estado actual"};

        // Amplades de les columnes
        //float[] colWidths = {widthTaules/columnes, widthTaules/columnes, widthTaules/columnes, widthTaules/columnes, widthTaules/columnes};
        float[] colWidths = {20, 20, 20, 20, 20};

        // Dades de la taula
        String[][] info = {
                {"x", "x", "x", "x", "x"},
        };

        ts1.setData(info);
        ts1.setHeaders(headers);
        ts1.setColumnWidths(colWidths);

        EditarSensor = new Button (p5, "Editar", XEditar, YEditar, WidthEditar, HeightEditar);

    }


    // PANTALLES DE LA GUI

    public void dibuixaPantallaInicio(PApplet p5){

        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        dibuixaLogo(p5);
        p5.textFont(Fonts.getFontAt(2));


        BlogIn.display(p5);
        TUsuario.display(p5);
        TContraseña.display(p5);

        p5.textFont(Fonts.getFontAt(2));
        p5.text("   Usuario:", XUsuari+2*marginH, YUsuari*9/7-5);
        p5.textFont(Fonts.getFontAt(2));
        p5.text("           Contraseña:", XContra+2*marginH, YContra*8/7-heightPrimeraPantalla-2);
        p5.textFont(Fonts.getFontAt(1));
        dibuixaImatgeMapa(p5);
    }

    public void dibuixaPantallaSensorX(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        dibuixaLogo(p5);
        p5.textFont(Fonts.getFontAt(1));
        dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ts1.display(p5, XTaules, YTaules+(heightImatge/2)-heightTaules/2, widthTaules, heightTaules);
        EditarSensor.display(p5);

    }

    public void dibuixaPantallaPlano(PApplet p5){
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        dibuixaLogo(p5);
        p5.textFont(Fonts.getFontAt(1));
        dibuixaImatgeMapa(p5);
        p5.textFont(Fonts.getFontAt(2));


        Sensor1.display(p5);
        Sensor2.display(p5);
        Sensor3.display(p5);
        Sensor4.display(p5);
        Sensor5.display(p5);
        Sensor6.display(p5);
        Sensor7.display(p5);

        Actuador1.display(p5);
        Actuador2.display(p5);
        Actuador3.display(p5);
        Actuador4.display(p5);
        Actuador5.display(p5);
        Actuador6.display(p5);
        Actuador7.display(p5);
    }

    public void dibuixaPantallaActuadorX(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        dibuixaLogo(p5);
        p5.textFont(Fonts.getFontAt(1));
        dibuixaImatgeMapa(p5);

    }

    public void dibuixaPantallaEstadisticaSensorX(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        dibuixaLogo(p5);
        p5.textFont(Fonts.getFontAt(1));
        dibuixaImatgeMapa(p5);
      //  dibuixaColumnes123(p5);
    }

    public void dibuixaPantallaEstadisticaActuadorX(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        dibuixaLogo(p5);
        p5.textFont(Fonts.getFontAt(1));
        dibuixaImatgeMapa(p5);
      //  dibuixaColumnes123(p5);
    }

    public void dibuixaPantallaNuevoActuador(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        dibuixaLogo(p5);
        p5.textFont(Fonts.getFontAt(1));
        dibuixaImatgeMapa(p5);
       // dibuixaColumnes123(p5);
    }
    // ZONES DE LA GUI

    public void dibuixaLogo(PApplet p5){
        p5.fill(Colors.getColorAt(0));
        p5.rect(marginH, marginV, midaLogo, midaLogo);
        p5.fill(0);
        p5.text("LOGO", marginH + midaLogo/2, marginV + midaLogo/2);
    }

    public void dibuixaImatgeMapa(PApplet p5){
        // Zona Sidebar ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(Colors.getColorAt(2));
        p5.rect(marginH, 6*marginV + logoHeight, widthImatge, heightImatge);
        p5.fill(0);
        p5.text("IMATGE/MAPA", marginH + widthImatge/2, 3*marginV + logoHeight + heightImatge/2);
    }

    public void dibuixaBanner(PApplet p5){
        p5.fill(Colors.getColorAt(1));
        p5.rect(2*marginH + midaLogo, marginV, bannerWidth, bannerHeight);
        p5.fill(0);
        p5.text(pantallaActual.name(), marginH + logoWidth + bannerWidth/2, marginV + bannerHeight*2/3);
    }

    public void dibuixaColumna1(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(200, 200, 50);
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, 3*columnWidth + 2*marginH, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth + 3*columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);
    }

    public void dibuixaColumnes12(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(200, 200, 50);
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(200, 200, 50);
        p5.rect(3*marginH + sidebarWidth + columnWidth, 2*marginV + bannerHeight, 2*columnWidth + marginH, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 2", 3*marginH + sidebarWidth + 2*columnWidth, 2*marginV + bannerHeight + columnHeight/2);
    }

    public void dibuixaColumnes123(PApplet p5){
        // Zona Columnes 1, 2 i 3 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        p5.fill(200, 200, 50);
        p5.rect(2*marginH + sidebarWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 1", 2*marginH + sidebarWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(200, 200, 50);
        p5.rect(3*marginH + sidebarWidth + columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 2", 3*marginH + sidebarWidth + columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);

        p5.fill(200, 200, 50);
        p5.rect(4*marginH + sidebarWidth + 2*columnWidth, 2*marginV + bannerHeight, columnWidth, columnHeight);
        p5.fill(0);
        p5.text("COLUMN 3", 4*marginH + sidebarWidth + 2*columnWidth +columnWidth/2, 2*marginV + bannerHeight + columnHeight/2);
    }
}