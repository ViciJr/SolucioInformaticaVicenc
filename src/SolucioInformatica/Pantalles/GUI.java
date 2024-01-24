package SolucioInformatica.Pantalles;

;
import SolucioInformatica.gui.*;
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

    //SensorX Afegir botó estadística
    Table ts1;
    Button InhabilitarSensor;
    TextField TNameSensor;

    //ActuadorX Afegir botó estadística
    Table ts2;
    Button InhabilitarActuador;
    TextField TNameActuador;

    //Estadística SensorX
    LinesDiagram ssl;

    //Estadística ActuadorX
    BarsDiagram sab;

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
        Actuador2 = new Button (p5, "Actuador 2", XActuadors, YActuadors+heightActuadors, widthActuadors, heightActuadors);
       // Actuador2.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Actuador3 = new Button (p5, "Actuador 3", XActuadors, YActuadors+2*heightActuadors, widthActuadors, heightActuadors);
       // Actuador3.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Actuador4 = new Button (p5, "Actuador 4", XActuadors, YActuadors+3*heightActuadors, widthActuadors, heightActuadors);
       // Actuador4.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Actuador5 = new Button (p5, "Actuador 5", XActuadors, YActuadors+4*heightActuadors, widthActuadors, heightActuadors);
       // Actuador5.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Actuador6 = new Button (p5, "Actuador 6", XActuadors, YActuadors+5*heightActuadors, widthActuadors, heightActuadors);
       // Actuador6.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Actuador7 = new Button (p5, "Actuador 7", XActuadors, YActuadors+6*heightActuadors, widthActuadors, heightActuadors);
       // Actuador7.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));


        //Pantalla SensorX
        int filesS = 2, columnesS = 5;

        ts1=new Table(filesS,columnesS);

        // Número de files (capçalera inclosa) i columnes de la taula

        // Títols de les columnes
        String[] headersS = {"Tipo", "Ubicación", "Pto.Arduino", "Act.vinculados", "Valor actual"};

        // Amplades de les columnes
        //float[] colWidths = {widthTaules/columnes, widthTaules/columnes, widthTaules/columnes, widthTaules/columnes, widthTaules/columnes};
        float[] colWidthsS = {20, 20, 20, 20, 20};

        // Dades de la taula
        String[][] infoS = {
                {"x", "x", "x", "x", "x"},
        };

        ts1.setData(infoS);
        ts1.setHeaders(headersS);
        ts1.setColumnWidths(colWidthsS);

        InhabilitarSensor = new Button (p5, "Inhabilitar", XinhabilitarSensor, YinhabilitarSensor, WidthInhabilitarSensor, HeightInhabilitarSensor);
        TNameSensor = new TextField (p5, XNomSensor, YNomSensor, WidthNomSensor, HeightNomSensor);

      //  Pantalla actuador X
        int filesA = 2, columnesA = 6;

        ts2=new Table(filesA,columnesA);

        // Número de files (capçalera inclosa) i columnes de la taula

        // Títols de les columnes
        String[] headersA = {"Tipo", "Ubicación", "Pto.Arduino", "Sns.vinculados","Condición", "Estado actual"};

        // Amplades de les columnes
        //float[] colWidthsA = {widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA};
        float[] colWidthsA = {100/6f, 100/6f, 100/6f, 100/6f, 100/6f, 100/6f};

        // Dades de la taula
        String[][] infoA = {
                {"x", "x", "x", "x", "x", "x"}
        };

        ts2.setData(infoA);
        ts2.setHeaders(headersA);
        ts2.setColumnWidths(colWidthsA);

        InhabilitarActuador = new Button (p5, "Inhabilitar", XinhabilitarActuador, YinhabilitarActuador, WidthInhabilitarActuador, HeightInhabilitarActuador);
        TNameActuador = new TextField (p5, XNomActuador, YNomActuador, WidthNomActuador, HeightNomActuador);

        //Pantalla estadística Sensor x

        p5.textFont(Fonts.getFontAt(2));
        // Dades del Diagrama (etiquetes)
        String[] textosLS  = {"8am","9am", "10am", "11am", "12am", "1pm", "2pm",
                "3pm"};

        // Dades del Diagrama (valors)
        float[] valuesLS  = {6, 8, 11, 13, 18, 20, 22, 22};

        // Color de la línia
        int colorLineLS = p5.color(0);

        ssl = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        // Configuració de Dades (textosLS, valors, colors)
        ssl.setTexts(textosLS);
        ssl.setValues(valuesLS);
        ssl.setColors(colorLineLS);

        //Pantalla estadística Actuador x

        sab= new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        // Dades del Diagrama (textosLS, valors i colors)
        String[] textosBA = {"8am","9am", "10am", "11am", "12am", "1pm", "2pm",
                "3pm"};
        float[] valuesBA = {1, 2, 2, 2, 1, 1, 2, 1};
        int [] colorsBA = {Colors.getColorAt(2), Colors.getColorAt(4), Colors.getColorAt(4), Colors.getColorAt(4), Colors.getColorAt(2), Colors.getColorAt(2), Colors.getColorAt(4), Colors.getColorAt(2)};

// Configuració de Dades (textos, valors, colors)
        sab.setTexts(textosBA);
        sab.setValues(valuesBA);
        sab.setColors(colorsBA);


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
        p5.textFont(Fonts.getFontAt(2));
        p5.text("   Usuario:", XUsuari+2*marginH, YUsuari*9/7-5);

        TContraseña.display(p5);
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
        ts1.display(p5, XTaules, YTaules+(heightImatge/2)-heightTaules/2+8, widthTaules, heightTaules);
        InhabilitarSensor.display(p5);

        TNameSensor.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        p5.text("          Nombre sensor:", /*XNomSensor*/ 708, /*YNomSensor*/ 239);
    }

    public void dibuixaPantallaPlano(PApplet p5){
        p5.background(255);
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

        p5.textFont(Fonts.getFontAt(2));
        ts2.display(p5, XTaules, YTaules+(heightImatge/2)-heightTaules/2+8, widthTaules, heightTaules);
        InhabilitarActuador.display(p5);

        TNameActuador.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        p5.text("               Nombre actuador:", /*XNomSensor*/ 708, /*YNomSensor*/ 239);

    }

    public void dibuixaPantallaEstadisticaSensorX(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        dibuixaLogo(p5);
        p5.textFont(Fonts.getFontAt(2));
   //     dibuixaImatgeMapa(p5);
        ssl.display(p5);
      //  dibuixaColumnes123(p5);

    }

    public void dibuixaPantallaEstadisticaActuadorX(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        dibuixaLogo(p5);
        p5.textFont(Fonts.getFontAt(2));
        //dibuixaImatgeMapa(p5);
        sab.display(p5);
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