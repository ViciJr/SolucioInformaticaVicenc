package SolucioInformatica.Pantalles;

;
import SolucioInformatica.gui.*;
import SolucioInformatica.gui.mapa.Actuador;
import SolucioInformatica.gui.mapa.Habitacio;
import SolucioInformatica.gui.mapa.Llum;
import SolucioInformatica.gui.mapa.Sensor;
import processing.core.PApplet;




import static SolucioInformatica.Pantalles.LayoutNMides.*;
import static SolucioInformatica.Pantalles.LayoutNMides.YMapaInteractivo;


public class GUI {

    // Enumerat de les Pantalles de l'App
    public enum PANTALLA {INICIO, MENÚ, SENSOR1, ACTUADOR1, GRÁFICA_SENSOR1, GRÁFICA_ACTUADOR1, INSTRUCCIONES};

    // Pantalla Actual
    public PANTALLA pantallaActual;

    //Colors i tipografia
    Fonts Fonts;
    Colors Colors;

    // PANTALLA INICIAL Y LOGIN
    Button BlogIn, Logo;
    TextField TUsuario;
    TextField TContraseña;

    // MENÚ I PLÀNOL
    Button Sensor1, Sensor2, Sensor3, Sensor4, Sensor5, Sensor6, Sensor7;
    Button Actuador1, Actuador2, Actuador3, Actuador4, Actuador5, Actuador6, Actuador7;
    Button Instrucciones;

    //SensorX Afegir botó estadística
    Table ts1;
    Button InhabilitarSensor, GraficaSensor, MenuS;
    TextField TNameSensor;
    Select Tipos, Ubicacions, Arduino, Actuador;
    SwitchButton EncesS;

    //ActuadorX Afegir botó estadística
    Table ts2;
    Button InhabilitarActuador, GraficaActuador, BloquearA;
    TextField TNameActuador, ValMax, ValMin;
    Select Tipoa, Ubicaciona, Arduinoa, Sensora;
    SwitchButton EncesA, BloquejatA;

    //Estadística SensorX
    LinesDiagram ssl;
    Button UnidadesS, IntervaloS, MenuSns;

    //Estadística ActuadorX
    BarsDiagram sab;
    Button UnidadesA, IntervaloA, MenuAct;
    Select Unidadest, Rangot;


    //INSTRUCCIONES
    Habitacio[] habitacions;
    Habitacio Dormitorio, Cocina, Salón ,Pasillo, Baño, hSelected, SensorSinHabitacion, ActuadorSinHabitacion;
    Sensor ActuadorMapa1, ActuadorMapa2, SensorMapa4, ActuadorMapa3, ActuadorMapa4, ActuadorMapa5, ActuadorMapa6, ActuadorMapa7, SensorMapa5, SensorMapa6, SensorMapa7, SensorMapa8, SensorMapa9, SensorMapa10;

    // Constructor de la GUI
    public GUI(PApplet p5){

        pantallaActual = PANTALLA.INICIO;

        Colors = new Colors(p5);   // Constructor dels colors de l'App
        Fonts = new Fonts(p5);     // Constructor de les fonts de l'App

        //Pantalla inicial
        TUsuario = new TextField (p5, XUsuari+marginH, heightPrimeraPantalla+YUsuari, widthPrimeraPantalla, heightPrimeraPantalla); /*, "Usuario"*/
        TContraseña = new TextField (p5, XContra+marginH, YContra, widthPrimeraPantalla, heightPrimeraPantalla); /*, "Contraseña"*/
        p5.textFont(Fonts.getFontAt(2));
        BlogIn = new Button (p5, "Hecho", XHecho+marginH, YHecho, widthPrimeraPantalla, heightPrimeraPantalla);
       // BlogIn.setColors(Colors.getColorAt(0), Colors.getColorAt(1), Colors.getColorAt(2), Colors.getColorAt(3));
        Logo = new Button(p5, "LOGO", marginH, marginV, midaLogo, midaLogo);


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

        Instrucciones = new Button (p5, "Instrucciones", XMapaInteractivo, YMapaInteractivo, WidthMapaInteractivo, HeightMapaInteractivo);


        //Pantalla SensorX
        int filesS = 2, columnesS = 5;

        ts1=new Table(filesS,columnesS);

        // Número de files (capçalera inclosa) i columnes de la taula

        // Títols de les columnes
        String[] headersS = {"Tipo", "Ubicación", "Pto.Arduino", "Act.vinculado", "Valor actual"};

        // Amplades de les columnes
        //float[] colWidths = {widthTaules/columnes, widthTaules/columnes, widthTaules/columnes, widthTaules/columnes, widthTaules/columnes};
        float[] colWidthsS = {20, 20, 20, 20, 20};

        // Dades de la taula
        String[][] infoS = {
                {"x", "x", "x", "x", "x"},
        };

        
        String[] selectValuesTs = {"                   Temperatura", "                 Proximidad", "          Presión"};
        String[] selectValuesUs = {"        Cocina", "        Pasillo", "               Dormitorio", "     Baño", "     Salón"};
        String[] selectValuesAr = {"1", "2", "3", "4"};
        String[] selectValuesAct = {"               Actuador1", "               Actuador2", "               Actuador3", "               Actuador4"};

        Tipos = new Select(selectValuesTs, XGraficaSensor, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Ubicacions = new Select(selectValuesUs, XGraficaSensor+widthTaules/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Arduino = new Select(selectValuesAr, XGraficaSensor+widthTaules*2/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Actuador = new Select( selectValuesAct, XGraficaSensor+widthTaules*3/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);

        ts1.setData(infoS);
        ts1.setHeaders(headersS);
        ts1.setColumnWidths(colWidthsS);

        GraficaSensor = new Button (p5, "Gráfica del sensor", XGraficaSensor, YGraficaSensor, WidthGraficaSensor, HeightGraficaSensor);
        MenuS = new Button (p5, "Volver al menú", XinhabilitarSensor, YinhabilitarSensor, WidthInhabilitarSensor, HeightInhabilitarSensor);
      //  InhabilitarSensor = new Button (p5, "Inhabilitar", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        TNameSensor = new TextField (p5, XGraficaSensor, YGraficaSensor, WidthGraficaSensor, HeightGraficaSensor);
        EncesS=new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);

      //  Pantalla actuador X
        int filesA = 2, columnesA = 6;

        ts2=new Table(filesA,columnesA);

        // Número de files (capçalera inclosa) i columnes de la taula

        // Títols de les columnes
        String[] headersA = {"Tipo", "Ubicación", "Pto.Arduino", "Sns.vinculado","Valor min.rgo.", "Valor max.rgo."};

        // Amplades de les columnes
        //float[] colWidthsA = {widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA};
        float[] colWidthsA = {100/6f, 100/6f, 100/6f, 100/6f, 100/6f, 100/6f, 100/6f};

        // Dades de la taula
        String[][] infoA = {
                {"x", "x", "x", "x", "x", "x"}
        };

        String[] selectValuesTa = {"          LED", "                 Servomotor", "               Zumbador"};
        String[] selectValuesSns = {"               Sensor1", "               Sensor2", "               Sensor3", "               Sensor4"};

        Tipoa=new Select(selectValuesTa, XGraficaSensor, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Ubicaciona= new Select(selectValuesUs, XGraficaSensor+widthTaules/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Arduinoa=new Select(selectValuesAr, XGraficaSensor+widthTaules*2/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Sensora=new Select(selectValuesSns, XGraficaSensor+widthTaules*3/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);

        ValMin = new TextField(p5, XGraficaSensor+widthTaules*4/6+1,YTaules+heightTaules/2, widthTaules/6-2, heightTaules/2);
        ValMax = new TextField(p5, XGraficaSensor+widthTaules*5/6+1,YTaules+heightTaules/2, widthTaules/6-1, heightTaules/2);


        ts2.setData(infoA);
        ts2.setHeaders(headersA);
        ts2.setColumnWidths(colWidthsA);

        GraficaActuador = new Button (p5, "Gráfica del actuador", XGraficaActuador, YGraficaActuador, WidthGraficaActuador, HeightGraficaActuador);
        MenuAct =new Button (p5, "Volver al menú del actuador", XinhabilitarActuador, YinhabilitarActuador, WidthInhabilitarActuador, HeightInhabilitarActuador);
       // BloquearA = new Button (p5, "Bloquear Actuador", XinhabilitarActuador, (YinhabilitarActuador+YinhabilitarActuador)/2-40-2*HeightGraficaActuador, WidthInhabilitarActuador, HeightInhabilitarActuador);
       // InhabilitarActuador = new Button (p5, "Inhabilitar", XinhabilitarActuador, (YinhabilitarActuador+YinhabilitarActuador)/2-20-HeightGraficaActuador, WidthInhabilitarActuador, HeightInhabilitarActuador);
        TNameActuador = new TextField (p5, XGraficaActuador, YGraficaActuador, WidthGraficaActuador, HeightGraficaActuador);

        EncesA=new SwitchButton(p5, "Off", "On", XinhabilitarActuador, (YinhabilitarActuador+YinhabilitarActuador)/2-20-HeightGraficaActuador, WidthInhabilitarActuador, HeightInhabilitarActuador);
        BloquejatA=new SwitchButton(p5, "NB","B", XinhabilitarActuador, (YinhabilitarActuador+YinhabilitarActuador)/2-40-2*HeightGraficaActuador, WidthInhabilitarActuador, HeightInhabilitarActuador);

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

        String[] selectValuesUni = {"     Días", "        Horas", "          Minutos"};
        String[] selectValuesRangt = {String.valueOf(3), String.valueOf(5), String.valueOf(7)};

        Unidadest=new Select(selectValuesUni, XSensors, YActuadors+HeightInhabilitarSensor/2, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        Rangot=new Select(selectValuesRangt, XSensors, (YActuadors+YinhabilitarActuador)/2+HeightInhabilitarSensor/2, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        MenuSns =new Button (p5, "Volver al menú del sensor", XinhabilitarActuador, YinhabilitarActuador, WidthInhabilitarActuador, HeightInhabilitarActuador);

// Configuració de Dades (textos, valors, colors)
        sab.setTexts(textosBA);
        sab.setValues(valuesBA);
        sab.setColors(colorsBA);
/*
        UnidadesA = new Button(p5, "Unidades(t)", XSensors, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor);
        UnidadesA.setColors(Colors.getColorAt(4), Colors.getColorAt(1), Colors.getColorAt(3),  Colors.getColorAt(3));
        IntervaloA = new Button(p5, "Intervalo", XSensors, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarSensor, HeightInhabilitarSensor);
        IntervaloA.setColors(Colors.getColorAt(4), Colors.getColorAt(1), Colors.getColorAt(3),  Colors.getColorAt(3)); */

        //Mapa




        SensorMapa4 = new Sensor("Sensor 1");
        SensorMapa5 = new Sensor("Sensor 2");
        SensorMapa6 = new Sensor("Sensor 3");
        SensorMapa7 = new Sensor("Sensor 4");
        SensorMapa8 = new Sensor("Sensor 5");
        SensorMapa9 = new Sensor("Sensor 6");
        SensorMapa10 = new Sensor("Sensor 7");

        ActuadorMapa1 = new Llum("Actuador 1", false ,SensorMapa4, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa2 = new Llum("Actuador 2", false ,SensorMapa5, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa3 = new Llum("Actuador 3", false ,SensorMapa6, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa4 = new Llum("Actuador 4", false ,SensorMapa7, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa5 = new Llum("Actuador 5",  false ,SensorMapa8, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa6 = new Llum("Actuador 6", false ,SensorMapa9, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa7 = new Llum("Actuador 7", false ,SensorMapa10, ActuadorSinHabitacion, "LED", "1", 15f, 0f);




        // Constructor d'Habitacions
        p5.strokeWeight(1);
        Dormitorio = new Habitacio(" Dormitorio", XDormitorio, YDormitorio, WidthDormitorio, HeightDormitorio, Colors.getColorAt(7));
        Cocina = new Habitacio("Cocina", XCocina, YCocina, WidthCocina, HeightCocina, Colors.getColorAt(8));
        Baño = new Habitacio(" Baño", XBaño, YBaño, WidthBaño, HeightBaño, Colors.getColorAt(7));
        Pasillo = new Habitacio(" Pasillo", XPasillo, YPasillo, WidthPasillo, HeightPasillo, Colors.getColorAt(6));
        Salón = new Habitacio("Salón", XSalón, YSalón, WidthSalón, HeightSalón, Colors.getColorAt(8));
        SensorSinHabitacion = new Habitacio(" ", XSalón-60, YPasillo+HeightPasillo+2, WidthBaño+WidthPasillo+WidthSalón+140, WidthPasillo/2+13, Colors.getColorAt(10));
        ActuadorSinHabitacion = new Habitacio(" ", XSalón-60, YPasillo-(WidthPasillo/2+15), WidthBaño+WidthPasillo+WidthSalón+140, WidthPasillo/2+13, Colors.getColorAt(10));

        // Agregam Sensors a les Habitacions
        ActuadorSinHabitacion.addSensor(ActuadorMapa1);
        ActuadorSinHabitacion.addSensor(ActuadorMapa2);
        ActuadorSinHabitacion.addSensor(ActuadorMapa3);
        ActuadorSinHabitacion.addSensor(ActuadorMapa4);
        ActuadorSinHabitacion.addSensor(ActuadorMapa5);
        ActuadorSinHabitacion.addSensor(ActuadorMapa6);
        ActuadorSinHabitacion.addSensor(ActuadorMapa7);


        SensorSinHabitacion.addSensor(SensorMapa4);
        SensorSinHabitacion.addSensor(SensorMapa5);
        SensorSinHabitacion.addSensor(SensorMapa6);
        SensorSinHabitacion.addSensor(SensorMapa7);
        SensorSinHabitacion.addSensor(SensorMapa8);
        SensorSinHabitacion.addSensor(SensorMapa9);
        SensorSinHabitacion.addSensor(SensorMapa10);



        // Cream array d'habitacions
        habitacions = new Habitacio[7];
        habitacions[0] = Dormitorio;
        habitacions[1] = Cocina;
        habitacions[2] = Pasillo;
        habitacions[3]= Salón;
        habitacions[4]= Baño;
        habitacions[5]= SensorSinHabitacion;
        habitacions[6]= ActuadorSinHabitacion;

        // Habitació Seleccionada (cap)
        hSelected = null;
        }


    // PANTALLES DE LA GUI

    public void dibuixaPantallaInicio(PApplet p5){

        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
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

    public void dibuixaPantallaSensor1(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
       // dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ts1.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaSensor.display(p5);
        EncesS.display(p5);
        MenuS.display(p5);
        Tipos.display(p5);
        Ubicacions.display(p5);
        Arduino.display(p5);
        Actuador.display(p5);

       // TNameSensor.display(p5);
        p5.textFont(Fonts.getFontAt(2));
       // p5.text("          Nombre sensor:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }

    public void dibuixaPantallaPlano(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        //dibuixaImatgeMapa(p5);
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

        Instrucciones.display(p5);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }

    public void dibuixaPantallaActuador1(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
      //  dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ts2.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaActuador.display(p5);
        EncesA.display(p5);
        BloquejatA.display(p5);
        MenuS.display(p5);
        Tipoa.display(p5);
        Ubicaciona.display(p5);
        Arduinoa.display(p5);
        Sensora.display(p5);

        ValMin.display(p5);
        ValMax.display(p5);

     //  TNameActuador.display(p5);
       p5.textFont(Fonts.getFontAt(2));
      // p5.text("               Nombre actuador:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }

    public void dibuixaPantallaEstadisticaSensor1(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));
   //     dibuixaImatgeMapa(p5);
        ssl.display(p5);
      //  dibuixaColumnes123(p5);
        MenuSns.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaActuador1(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        //dibuixaImatgeMapa(p5);
        sab.display(p5);
      //  dibuixaColumnes123(p5);
        MenuAct.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaInstrucciones(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        MenuS.display(p5);
     p5.stroke(0); p5.strokeWeight(1);
      /*  for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
*/

    }
    // ZONES DE LA GUI

    public void dibuixaLogo(PApplet p5){
        p5.fill(Colors.getColorAt(0));
        p5.rect(marginH, marginV, midaLogo, midaLogo);
        p5.fill(0);
        p5.text("LOGO", marginH + midaLogo/2, marginV + midaLogo/2);
    }

    public void dibuixaImatgeMapa(PApplet p5){
        // Dibuix de les Habitacions
        p5.fill(Colors.getColorAt(2));
        p5.rect(marginH, 6*marginV + logoHeight, widthImatge, heightImatge);
        p5.fill(0);
        p5.text("IMATGE", marginH + widthImatge/2, 3*marginV + logoHeight + heightImatge/2);
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