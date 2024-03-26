package SolucioInformatica.Pantalles;

;
import SolucioInformatica.gui.*;
import SolucioInformatica.gui.PopUp.PopUp;
import SolucioInformatica.gui.mapa.Habitacio;
import SolucioInformatica.gui.mapa.Llum;
import SolucioInformatica.gui.mapa.Sensor;
import processing.core.PApplet;




import static SolucioInformatica.Pantalles.LayoutNMides.*;
import static SolucioInformatica.Pantalles.LayoutNMides.YMapaInteractivo;


public class GUI {

    // Enumerat de les Pantalles de l'App
    public enum PANTALLA {INICIO, MENÚ, SENSOR1, SENSOR2, SENSOR3, SENSOR4, SENSOR5, SENSOR6, SENSOR7, ACTUADOR1, ACTUADOR2, ACTUADOR3, ACTUADOR4,ACTUADOR5, ACTUADOR6, ACTUADOR7,GRÁFICA_SENSOR1, GRÁFICA_SENSOR2, GRÁFICA_SENSOR3, GRÁFICA_SENSOR4, GRÁFICA_SENSOR5, GRÁFICA_SENSOR6, GRÁFICA_SENSOR7,GRÁFICA_ACTUADOR1, GRÁFICA_ACTUADOR2,
        GRÁFICA_ACTUADOR3, GRÁFICA_ACTUADOR4, GRÁFICA_ACTUADOR5, GRÁFICA_ACTUADOR6, GRÁFICA_ACTUADOR7,INSTRUCCIONES};

    // Pantalla Actual
    public PANTALLA pantallaActual;

    //Colors i tipografia
    Fonts Fonts;
    Colors Colors;

    // PANTALLA INICIAL Y LOGIN
    Button BlogIn, Logo;
    TextField TUsuario;
    TextField TContraseña;
    PopUp Inicio;

    // MENÚ I PLÀNOL
    Button Sensor1, Sensor2, Sensor3, Sensor4, Sensor5, Sensor6, Sensor7;
    Button Actuador1, Actuador2, Actuador3, Actuador4, Actuador5, Actuador6, Actuador7;
    Button Instrucciones;

    //SensorX Afegir botó estadística
    Table ts1, ts2, ts3, ts4, ts5, ts6, ts7;
    Button InhabilitarSensor, GraficaSensor, MenuS;
    TextField TNameSensor;
    Select Tipos1, Ubicacions1, Arduino1, ActuadorS1;
    Select Tipos2, Ubicacions2, Arduino2, ActuadorS2;
    Select Tipos3, Ubicacions3, Arduino3, ActuadorS3;
    Select Tipos4, Ubicacions4, Arduino4, ActuadorS4;
    Select Tipos5, Ubicacions5, Arduino5, ActuadorS5;
    Select Tipos6, Ubicacions6, Arduino6, ActuadorS6;
    Select Tipos7, Ubicacions7, Arduino7, ActuadorS7;
    SwitchButton EncesS1, EncesS2, EncesS3, EncesS4, EncesS5, EncesS6, EncesS7;

    //ActuadorX Afegir botó estadística
    Table ta1, ta2, ta3, ta4, ta5, ta6, ta7;
    Button InhabilitarActuador, GraficaActuador, BloquearA;
    TextField TNameActuador, ValMax1, ValMin1, ValMax2, ValMin2, ValMax3, ValMin3, ValMax4, ValMin4, ValMax5, ValMin5, ValMax6, ValMin6, ValMax7, ValMin7;
    Select Tipoa1, Ubicaciona1, Arduinoa1, Sensora1;
    Select Tipoa2, Ubicaciona2, Arduinoa2, Sensora2;
    Select Tipoa3, Ubicaciona3, Arduinoa3, Sensora3;
    Select Tipoa4, Ubicaciona4, Arduinoa4, Sensora4;
    Select Tipoa5, Ubicaciona5, Arduinoa5, Sensora5;
    Select Tipoa6, Ubicaciona6, Arduinoa6, Sensora6;
    Select Tipoa7, Ubicaciona7, Arduinoa7, Sensora7;
    SwitchButton EncesA1, EncesA2,EncesA3,EncesA4,EncesA5,EncesA6,EncesA7;

    //Estadística SensorX
    LinesDiagram ssl17, ssl15, ssl13;
    LinesDiagram ssl27, ssl25, ssl23;
    LinesDiagram ssl37, ssl35, ssl33;
    LinesDiagram ssl47, ssl45, ssl43;
    LinesDiagram ssl57, ssl55, ssl53;
    LinesDiagram ssl67, ssl65, ssl63;
    LinesDiagram ssl77, ssl75, ssl73;

    Button UnidadesS, IntervaloS, MenuSns;

    //Estadística ActuadorX
    BarsDiagram sab17, sab15, sab13;
    BarsDiagram sab27, sab25, sab23;
    BarsDiagram sab37, sab35, sab33;
    BarsDiagram sab47, sab45, sab43;
    BarsDiagram sab57, sab55, sab53;
    BarsDiagram sab67, sab65, sab63;
    BarsDiagram sab77, sab75, sab73;

    Button MenuAct;
    Select Unidadest, Rangot;


    //INSTRUCCIONES
    Habitacio[] habitacions;
    Habitacio Dormitorio, Cocina, Salón ,Pasillo, Baño, hSelected, SensorSinHabitacion, ActuadorSinHabitacion;
    Sensor ActuadorMapa1, ActuadorMapa2, SensorMapa1, ActuadorMapa3, ActuadorMapa4, ActuadorMapa5, ActuadorMapa6, ActuadorMapa7, SensorMapa2, SensorMapa3, SensorMapa4, SensorMapa5, SensorMapa6, SensorMapa7;

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
        Logo.setEnabled(true);
        Inicio=new PopUp(p5, "ERROR", "Usuario o contraseña incorrectos", 330, 250, 600, 300);
        Inicio.setVisible(false);

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
        ts2=new Table(filesS,columnesS);
        ts3=new Table(filesS,columnesS);
        ts4=new Table(filesS,columnesS);
        ts5=new Table(filesS,columnesS);
        ts6=new Table(filesS,columnesS);
        ts7=new Table(filesS,columnesS);

        // Número de files (capçalera inclosa) i columnes de la taula

        // Títols de les columnes
        String[] headersS = {"Tipo", "Ubicación", "Pto.Arduino1", "Act.vinculado", "Valor actual"};

        // Amplades de les columnes
        //float[] colWidths = {widthTaules/columnes, widthTaules/columnes, widthTaules/columnes, widthTaules/columnes, widthTaules/columnes};
        float[] colWidthsS = {20, 20, 20, 20, 20};

        // Dades de la taula
        String[][] infoS1 = {
                {"x", "x", "x", "x", "x"},
        };
        String[][] infoS2 = {
                {"x", "x", "x", "x", "x"},
        };
        String[][] infoS3 = {
                {"x", "x", "x", "x", "x"},
        };
        String[][] infoS4 = {
                {"x", "x", "x", "x", "x"},
        };
        String[][] infoS5 = {
                {"x", "x", "x", "x", "x"},
        };
        String[][] infoS6 = {
                {"x", "x", "x", "x", "x"},
        };
        String[][] infoS7 = {
                {"x", "x", "x", "x", "x"},
        };

      // p5.textAlign(p5.CENTER);
        String[] selectValuesTs = {"Temperatura", "Proximidad", "Presión"};
        String[] selectValuesUs = {" ","        Cocina", "        Pasillo", "               Dormitorio", "     Baño", "     Salón"};
        String[] selectValuesAr = {"1", "2", "3", "4"};
        String[] selectValuesAct = {"               Actuador1", "               Actuador2", "               Actuador3", "               Actuador4"};

        Tipos1 = new Select(selectValuesTs, XGraficaSensor, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Ubicacions1 = new Select(selectValuesUs, XGraficaSensor+widthTaules/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Arduino1 = new Select(selectValuesAr, XGraficaSensor+widthTaules*2/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        ActuadorS1 = new Select( selectValuesAct, XGraficaSensor+widthTaules*3/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);

        Tipos2 = new Select(selectValuesTs, XGraficaSensor, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Ubicacions2 = new Select(selectValuesUs, XGraficaSensor+widthTaules/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Arduino2 = new Select(selectValuesAr, XGraficaSensor+widthTaules*2/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        ActuadorS2 = new Select( selectValuesAct, XGraficaSensor+widthTaules*3/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);

        Tipos3 = new Select(selectValuesTs, XGraficaSensor, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Ubicacions3 = new Select(selectValuesUs, XGraficaSensor+widthTaules/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Arduino3 = new Select(selectValuesAr, XGraficaSensor+widthTaules*2/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        ActuadorS3 = new Select( selectValuesAct, XGraficaSensor+widthTaules*3/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);

        Tipos4 = new Select(selectValuesTs, XGraficaSensor, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Ubicacions4 = new Select(selectValuesUs, XGraficaSensor+widthTaules/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Arduino4 = new Select(selectValuesAr, XGraficaSensor+widthTaules*2/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        ActuadorS4 = new Select( selectValuesAct, XGraficaSensor+widthTaules*3/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);

        Tipos5 = new Select(selectValuesTs, XGraficaSensor, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Ubicacions5 = new Select(selectValuesUs, XGraficaSensor+widthTaules/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Arduino5 = new Select(selectValuesAr, XGraficaSensor+widthTaules*2/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        ActuadorS5 = new Select( selectValuesAct, XGraficaSensor+widthTaules*3/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);

        Tipos6 = new Select(selectValuesTs, XGraficaSensor, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Ubicacions6 = new Select(selectValuesUs, XGraficaSensor+widthTaules/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Arduino6 = new Select(selectValuesAr, XGraficaSensor+widthTaules*2/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        ActuadorS6 = new Select( selectValuesAct, XGraficaSensor+widthTaules*3/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);

        Tipos7 = new Select(selectValuesTs, XGraficaSensor, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Ubicacions7 = new Select(selectValuesUs, XGraficaSensor+widthTaules/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        Arduino7 = new Select(selectValuesAr, XGraficaSensor+widthTaules*2/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);
        ActuadorS7 = new Select( selectValuesAct, XGraficaSensor+widthTaules*3/5, YTaules+heightTaules/2, widthTaules/5, heightTaules/2);


        ts1.setData(infoS1);
        ts1.setHeaders(headersS);
        ts1.setColumnWidths(colWidthsS);

        ts2.setData(infoS2);
        ts2.setHeaders(headersS);
        ts2.setColumnWidths(colWidthsS);

        ts3.setData(infoS3);
        ts3.setHeaders(headersS);
        ts3.setColumnWidths(colWidthsS);

        ts4.setData(infoS4);
        ts4.setHeaders(headersS);
        ts4.setColumnWidths(colWidthsS);

        ts5.setData(infoS5);
        ts5.setHeaders(headersS);
        ts5.setColumnWidths(colWidthsS);

        ts6.setData(infoS6);
        ts6.setHeaders(headersS);
        ts6.setColumnWidths(colWidthsS);

        ts7.setData(infoS7);
        ts7.setHeaders(headersS);
        ts7.setColumnWidths(colWidthsS);

        GraficaSensor = new Button (p5, "Gráfica del sensor", XGraficaSensor, YGraficaSensor, WidthGraficaSensor, HeightGraficaSensor);
        MenuS = new Button (p5, "Volver al menú", XinhabilitarSensor, YinhabilitarSensor, WidthInhabilitarSensor, HeightInhabilitarSensor);
      //  InhabilitarSensor = new Button (p5, "Inhabilitar", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        TNameSensor = new TextField (p5, XGraficaSensor, YGraficaSensor, WidthGraficaSensor, HeightGraficaSensor);
        EncesS1 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesS2 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesS3 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesS4 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesS5 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesS6 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesS7 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);

        //  Pantalla actuador X
        int filesA = 2, columnesA = 6;

        ta1 =new Table(filesA,columnesA);
        ta2 =new Table(filesA,columnesA);
        ta3 =new Table(filesA,columnesA);
        ta4 =new Table(filesA,columnesA);
        ta5 =new Table(filesA,columnesA);
        ta6 =new Table(filesA,columnesA);
        ta7 =new Table(filesA,columnesA);

        // Número de files (capçalera inclosa) i columnes de la taula

        // Títols de les columnes
        String[] headersA = {"Tipo", "Ubicación", "Pto.Arduino1", "Sns.vinculado","Valor min.rgo.", "Valor max.rgo."};

        // Amplades de les columnes
        //float[] colWidthsA = {widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA, widthTaules/columnesA};
        float[] colWidthsA = {100/6f, 100/6f, 100/6f, 100/6f, 100/6f, 100/6f, 100/6f};

        // Dades de la taula
        String[][] infoA1 = {
                {"x", "x", "x", "x", "x", "x"}
        };
        String[][] infoA2 = {
                {"x", "x", "x", "x", "x", "x"}
        };
        String[][] infoA3 = {
                {"x", "x", "x", "x", "x", "x"}
        };
        String[][] infoA4 = {
                {"x", "x", "x", "x", "x", "x"}
        };
        String[][] infoA5 = {
                {"x", "x", "x", "x", "x", "x"}
        };
        String[][] infoA6 = {
                {"x", "x", "x", "x", "x", "x"}
        };
        String[][] infoA7 = {
                {"x", "x", "x", "x", "x", "x"}
        };

        String[] selectValuesTa = {"          LED", "                 Servomotor", "               Zumbador"};
        String[] selectValuesSns = {"               Sensor1", "               Sensor2", "               Sensor3", "               Sensor4"};

        Tipoa1 =new Select(selectValuesTa, XGraficaSensor, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Ubicaciona1 = new Select(selectValuesUs, XGraficaSensor+widthTaules/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Arduinoa1 =new Select(selectValuesAr, XGraficaSensor+widthTaules*2/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Sensora1 =new Select(selectValuesSns, XGraficaSensor+widthTaules*3/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);

        Tipoa2 =new Select(selectValuesTa, XGraficaSensor, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Ubicaciona2 = new Select(selectValuesUs, XGraficaSensor+widthTaules/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Arduinoa2 =new Select(selectValuesAr, XGraficaSensor+widthTaules*2/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Sensora2 =new Select(selectValuesSns, XGraficaSensor+widthTaules*3/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);

        Tipoa3 =new Select(selectValuesTa, XGraficaSensor, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Ubicaciona3 = new Select(selectValuesUs, XGraficaSensor+widthTaules/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Arduinoa3 =new Select(selectValuesAr, XGraficaSensor+widthTaules*2/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Sensora3 =new Select(selectValuesSns, XGraficaSensor+widthTaules*3/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);

        Tipoa4 =new Select(selectValuesTa, XGraficaSensor, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Ubicaciona4 = new Select(selectValuesUs, XGraficaSensor+widthTaules/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Arduinoa4 =new Select(selectValuesAr, XGraficaSensor+widthTaules*2/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Sensora4 =new Select(selectValuesSns, XGraficaSensor+widthTaules*3/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);

        Tipoa5 =new Select(selectValuesTa, XGraficaSensor, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Ubicaciona5 = new Select(selectValuesUs, XGraficaSensor+widthTaules/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Arduinoa5 =new Select(selectValuesAr, XGraficaSensor+widthTaules*2/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Sensora5 =new Select(selectValuesSns, XGraficaSensor+widthTaules*3/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);

        Tipoa6 =new Select(selectValuesTa, XGraficaSensor, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Ubicaciona6 = new Select(selectValuesUs, XGraficaSensor+widthTaules/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Arduinoa6 =new Select(selectValuesAr, XGraficaSensor+widthTaules*2/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Sensora6 =new Select(selectValuesSns, XGraficaSensor+widthTaules*3/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);

        Tipoa7 =new Select(selectValuesTa, XGraficaSensor, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Ubicaciona7 = new Select(selectValuesUs, XGraficaSensor+widthTaules/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Arduinoa7 =new Select(selectValuesAr, XGraficaSensor+widthTaules*2/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);
        Sensora7 =new Select(selectValuesSns, XGraficaSensor+widthTaules*3/6, YTaules+heightTaules/2, widthTaules/6, heightTaules/2);


        ValMin1 = new TextField(p5, XGraficaSensor+widthTaules*4/6+1,YTaules+heightTaules/2, widthTaules/6-2, heightTaules/2);
        ValMax1 = new TextField(p5, XGraficaSensor+widthTaules*5/6+1,YTaules+heightTaules/2, widthTaules/6-1, heightTaules/2);
        ValMin2 = new TextField(p5, XGraficaSensor+widthTaules*4/6+1,YTaules+heightTaules/2, widthTaules/6-2, heightTaules/2);
        ValMax2 = new TextField(p5, XGraficaSensor+widthTaules*5/6+1,YTaules+heightTaules/2, widthTaules/6-1, heightTaules/2);
        ValMin3 = new TextField(p5, XGraficaSensor+widthTaules*4/6+1,YTaules+heightTaules/2, widthTaules/6-2, heightTaules/2);
        ValMax3 = new TextField(p5, XGraficaSensor+widthTaules*5/6+1,YTaules+heightTaules/2, widthTaules/6-1, heightTaules/2);
        ValMin4 = new TextField(p5, XGraficaSensor+widthTaules*4/6+1,YTaules+heightTaules/2, widthTaules/6-2, heightTaules/2);
        ValMax4 = new TextField(p5, XGraficaSensor+widthTaules*5/6+1,YTaules+heightTaules/2, widthTaules/6-1, heightTaules/2);
        ValMin5 = new TextField(p5, XGraficaSensor+widthTaules*4/6+1,YTaules+heightTaules/2, widthTaules/6-2, heightTaules/2);
        ValMax5 = new TextField(p5, XGraficaSensor+widthTaules*5/6+1,YTaules+heightTaules/2, widthTaules/6-1, heightTaules/2);
        ValMin6 = new TextField(p5, XGraficaSensor+widthTaules*4/6+1,YTaules+heightTaules/2, widthTaules/6-2, heightTaules/2);
        ValMax6 = new TextField(p5, XGraficaSensor+widthTaules*5/6+1,YTaules+heightTaules/2, widthTaules/6-1, heightTaules/2);
        ValMin7 = new TextField(p5, XGraficaSensor+widthTaules*4/6+1,YTaules+heightTaules/2, widthTaules/6-2, heightTaules/2);
        ValMax7 = new TextField(p5, XGraficaSensor+widthTaules*5/6+1,YTaules+heightTaules/2, widthTaules/6-1, heightTaules/2);


        ta1.setData(infoA1);
        ta1.setHeaders(headersA);
        ta1.setColumnWidths(colWidthsA);

        ta2.setData(infoA2);
        ta2.setHeaders(headersA);
        ta2.setColumnWidths(colWidthsA);

        ta3.setData(infoA3);
        ta3.setHeaders(headersA);
        ta3.setColumnWidths(colWidthsA);

        ta4.setData(infoA4);
        ta4.setHeaders(headersA);
        ta4.setColumnWidths(colWidthsA);

        ta5.setData(infoA5);
        ta5.setHeaders(headersA);
        ta5.setColumnWidths(colWidthsA);

        ta6.setData(infoA6);
        ta6.setHeaders(headersA);
        ta6.setColumnWidths(colWidthsA);

        ta7.setData(infoA7);
        ta7.setHeaders(headersA);
        ta7.setColumnWidths(colWidthsA);

        GraficaActuador = new Button (p5, "Gráfica del actuador", XGraficaSensor, YGraficaSensor, WidthGraficaSensor, HeightGraficaSensor);
        MenuAct =new Button (p5, "Volver al menú del actuador", XinhabilitarActuador, YinhabilitarActuador, WidthInhabilitarActuador, HeightInhabilitarActuador);
       // BloquearA = new Button (p5, "Bloquear ActuadorS1", XinhabilitarActuador, (YinhabilitarActuador+YinhabilitarActuador)/2-40-2*HeightGraficaActuador, WidthInhabilitarActuador, HeightInhabilitarActuador);
       // InhabilitarActuador = new Button (p5, "Inhabilitar", XinhabilitarActuador, (YinhabilitarActuador+YinhabilitarActuador)/2-20-HeightGraficaActuador, WidthInhabilitarActuador, HeightInhabilitarActuador);
        TNameActuador = new TextField (p5, XGraficaActuador, YGraficaActuador, WidthGraficaActuador, HeightGraficaActuador);

        EncesA1 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesA2 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesA3 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesA4 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesA5 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesA6 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);
        EncesA7 =new SwitchButton(p5, "Off", "On", XGraficaSensor, (YGraficaSensor+YinhabilitarSensor)/2, WidthGraficaSensor, HeightGraficaSensor);

        //Pantalla estadística Sensor x

        p5.textFont(Fonts.getFontAt(2));
        // Dades del Diagrama (etiquetes)
        String[] textosLS7  = {"7","6", "5", "4", "3", "2", "1"};
        String[] textosLS5  = {"5", "4", "3", "2", "1"};
        String[] textosLS3  = {"3", "2", "1"};

        // Dades del Diagrama (valors)
        float[] values1LS7  = {6, 8, 11, 13, 18, 20, 22};
        float[] values1LS5  = {11, 13, 18, 20, 22};
        float[] values1LS3  = {18, 20, 22};

        float[] values2LS7  = {6, 8, 11, 13, 18, 20, 22};
        float[] values2LS5  = {11, 13, 18, 20, 22};
        float[] values2LS3  = {18, 20, 22};

        float[] values3LS7  = {6, 8, 11, 13, 18, 20, 22};
        float[] values3S5  = {11, 13, 18, 20, 22};
        float[] values3LS3  = {18, 20, 22};

        float[] values4LS7  = {6, 8, 11, 13, 18, 20, 22};
        float[] values4LS5  = {11, 13, 18, 20, 22};
        float[] values4LS3  = {18, 20, 22};

        float[] values5LS7  = {6, 8, 11, 13, 18, 20, 22};
        float[] values5LS5  = {11, 13, 18, 20, 22};
        float[] values5LS3  = {18, 20, 22};

        float[] values6LS7  = {6, 8, 11, 13, 18, 20, 22};
        float[] values6LS5  = {11, 13, 18, 20, 22};
        float[] values6LS3  = {18, 20, 22};

        float[] values7LS7  = {6, 8, 11, 13, 18, 20, 22};
        float[] values7LS5  = {11, 13, 18, 20, 22};
        float[] values7LS3  = {18, 20, 22};

        // Color de la línia
        int colorLineLS = p5.color(0);

        ssl17 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl15 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl13 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        ssl27 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl25 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl23 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        ssl37 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl35 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl33 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        ssl47 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl45 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl43 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        ssl57 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl55 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl53 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        ssl67 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl65 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl63 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        ssl77 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl75 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        ssl73 = new LinesDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        // Configuració de Dades (textosLS, valors, colors)
        ssl17.setTexts(textosLS7);
        ssl15.setTexts(textosLS5);
        ssl13.setTexts(textosLS3);
        ssl17.setValues(values1LS7);
        ssl15.setValues(values1LS5);
        ssl13.setValues(values1LS3);
        ssl17.setColors(colorLineLS);
        ssl15.setColors(colorLineLS);
        ssl13.setColors(colorLineLS);

        ssl27.setTexts(textosLS7);
        ssl25.setTexts(textosLS5);
        ssl23.setTexts(textosLS3);
        ssl27.setValues(values1LS7);
        ssl25.setValues(values1LS5);
        ssl23.setValues(values1LS3);
        ssl27.setColors(colorLineLS);
        ssl25.setColors(colorLineLS);
        ssl23.setColors(colorLineLS);

        ssl37.setTexts(textosLS7);
        ssl35.setTexts(textosLS5);
        ssl33.setTexts(textosLS3);
        ssl37.setValues(values1LS7);
        ssl35.setValues(values1LS5);
        ssl33.setValues(values1LS3);
        ssl37.setColors(colorLineLS);
        ssl35.setColors(colorLineLS);
        ssl33.setColors(colorLineLS);

        ssl47.setTexts(textosLS7);
        ssl45.setTexts(textosLS5);
        ssl43.setTexts(textosLS3);
        ssl47.setValues(values1LS7);
        ssl45.setValues(values1LS5);
        ssl43.setValues(values1LS3);
        ssl47.setColors(colorLineLS);
        ssl45.setColors(colorLineLS);
        ssl43.setColors(colorLineLS);

        ssl57.setTexts(textosLS7);
        ssl55.setTexts(textosLS5);
        ssl53.setTexts(textosLS3);
        ssl57.setValues(values1LS7);
        ssl55.setValues(values1LS5);
        ssl53.setValues(values1LS3);
        ssl57.setColors(colorLineLS);
        ssl55.setColors(colorLineLS);
        ssl53.setColors(colorLineLS);

        ssl67.setTexts(textosLS7);
        ssl65.setTexts(textosLS5);
        ssl63.setTexts(textosLS3);
        ssl67.setValues(values1LS7);
        ssl65.setValues(values1LS5);
        ssl63.setValues(values1LS3);
        ssl67.setColors(colorLineLS);
        ssl65.setColors(colorLineLS);
        ssl63.setColors(colorLineLS);

        ssl77.setTexts(textosLS7);
        ssl75.setTexts(textosLS5);
        ssl73.setTexts(textosLS3);
        ssl77.setValues(values1LS7);
        ssl75.setValues(values1LS5);
        ssl73.setValues(values1LS3);
        ssl77.setColors(colorLineLS);
        ssl75.setColors(colorLineLS);
        ssl73.setColors(colorLineLS);

        //Pantalla estadística ActuadorS1 x

        sab17 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab15 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab13 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        sab27 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab25 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab23 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        sab37 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab35 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab33 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        sab47 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab45 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab43 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        sab57 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab55 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab53 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        sab67 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab65 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab63 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        sab77 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab75 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);
        sab73 = new BarsDiagram(XDiagram, YDiagram, WidthDiagram, HeightDiagram);

        // Dades del Diagrama (textosLS, valors i colors)
        String[] textosBA7 = {"7","6", "5", "4", "3", "2", "1"};
        String[] textosBA5 = {"5", "4", "3", "2", "1"};
        String[] textosBA3 = {"3", "2", "1"};

        float[] values1BA7 = {1, 2, 2, 2, 1, 1, 2};
        float[] values1BA5 = {2, 2, 1, 1, 2};
        float[] values1BA3 = {1, 1, 2};

        float[] values2BA7 = {1, 2, 2, 2, 1, 1, 2};
        float[] values2BA5 = {2, 2, 1, 1, 2};
        float[] values2BA3 = {1, 1, 2};

        float[] values3BA7 = {1, 2, 2, 2, 1, 1, 2};
        float[] values3BA5 = {2, 2, 1, 1, 2};
        float[] values3BA3 = {1, 1, 2};

        float[] values4BA7 = {1, 2, 2, 2, 1, 1, 2};
        float[] values4BA5 = {2, 2, 1, 1, 2};
        float[] values4BA3 = {1, 1, 2};

        float[] values5BA7 = {1, 2, 2, 2, 1, 1, 2};
        float[] values5BA5 = {2, 2, 1, 1, 2};
        float[] values5BA3 = {1, 1, 2};

        float[] values6BA7 = {1, 2, 2, 2, 1, 1, 2};
        float[] values6BA5 = {2, 2, 1, 1, 2};
        float[] values6BA3 = {1, 1, 2};

        float[] values7BA7 = {1, 2, 2, 2, 1, 1, 2};
        float[] values7BA5 = {2, 2, 1, 1, 2};
        float[] values7BA3 = {1, 1, 2};

        int [] colorsBA = {Colors.getColorAt(2), Colors.getColorAt(4), Colors.getColorAt(4), Colors.getColorAt(4), Colors.getColorAt(2), Colors.getColorAt(2), Colors.getColorAt(4), Colors.getColorAt(2)};

        String[] selectValuesUni = {"     Días", "        Horas", "          Minutos"};
        String[] selectValuesRangt = {String.valueOf(3), String.valueOf(5), String.valueOf(7)};

        Unidadest=new Select(selectValuesUni, XSensors, YActuadors+HeightInhabilitarSensor/2, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        Rangot=new Select(selectValuesRangt, XSensors, (YActuadors+YinhabilitarActuador)/2+HeightInhabilitarSensor/2, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        MenuSns =new Button (p5, "Volver al menú del sensor", XinhabilitarActuador, YinhabilitarActuador, WidthInhabilitarActuador, HeightInhabilitarActuador);

// Configuració de Dades (textos, valors, colors)
        sab17.setTexts(textosBA7);
        sab17.setValues(values1BA7);
        sab17.setColors(colorsBA);
        sab15.setTexts(textosBA5);
        sab15.setValues(values1BA5);
        sab15.setColors(colorsBA);
        sab13.setTexts(textosBA3);
        sab13.setValues(values1BA3);
        sab13.setColors(colorsBA);

        sab27.setTexts(textosBA7);
        sab27.setValues(values2BA7);
        sab27.setColors(colorsBA);
        sab25.setTexts(textosBA5);
        sab25.setValues(values2BA5);
        sab25.setColors(colorsBA);
        sab23.setTexts(textosBA3);
        sab23.setValues(values2BA3);
        sab23.setColors(colorsBA);

        sab37.setTexts(textosBA7);
        sab37.setValues(values3BA7);
        sab37.setColors(colorsBA);
        sab35.setTexts(textosBA5);
        sab35.setValues(values3BA5);
        sab35.setColors(colorsBA);
        sab33.setTexts(textosBA3);
        sab33.setValues(values3BA3);
        sab33.setColors(colorsBA);

        sab47.setTexts(textosBA7);
        sab47.setValues(values4BA7);
        sab47.setColors(colorsBA);
        sab45.setTexts(textosBA5);
        sab45.setValues(values4BA5);
        sab45.setColors(colorsBA);
        sab43.setTexts(textosBA3);
        sab43.setValues(values4BA3);
        sab43.setColors(colorsBA);

        sab57.setTexts(textosBA7);
        sab57.setValues(values5BA7);
        sab57.setColors(colorsBA);
        sab55.setTexts(textosBA5);
        sab55.setValues(values5BA5);
        sab55.setColors(colorsBA);
        sab53.setTexts(textosBA3);
        sab53.setValues(values5BA3);
        sab53.setColors(colorsBA);

        sab67.setTexts(textosBA7);
        sab67.setValues(values6BA7);
        sab67.setColors(colorsBA);
        sab65.setTexts(textosBA5);
        sab65.setValues(values6BA5);
        sab65.setColors(colorsBA);
        sab63.setTexts(textosBA3);
        sab63.setValues(values6BA3);
        sab63.setColors(colorsBA);

        sab77.setTexts(textosBA7);
        sab77.setValues(values7BA7);
        sab77.setColors(colorsBA);
        sab75.setTexts(textosBA5);
        sab75.setValues(values7BA5);
        sab75.setColors(colorsBA);
        sab73.setTexts(textosBA3);
        sab73.setValues(values7BA3);
        sab73.setColors(colorsBA);
/*
        UnidadesA = new Button(p5, "Unidades(t)", XSensors, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor);
        UnidadesA.setColors(Colors.getColorAt(4), Colors.getColorAt(1), Colors.getColorAt(3),  Colors.getColorAt(3));
        IntervaloA = new Button(p5, "Intervalo", XSensors, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarSensor, HeightInhabilitarSensor);
        IntervaloA.setColors(Colors.getColorAt(4), Colors.getColorAt(1), Colors.getColorAt(3),  Colors.getColorAt(3)); */

        //Mapa




        SensorMapa1 = new Sensor("Sensor 1", false, (Llum) ActuadorMapa1, SensorSinHabitacion, "Térmico", "1", 26f);
        SensorMapa2 = new Sensor("Sensor 2", false, (Llum) ActuadorMapa2, SensorSinHabitacion, "Térmico", "1", 26f);
        SensorMapa3 = new Sensor("Sensor 3", false, (Llum) ActuadorMapa3, SensorSinHabitacion, "Térmico", "1", 26f);
        SensorMapa4 = new Sensor("Sensor 4",false, (Llum) ActuadorMapa4, SensorSinHabitacion, "Térmico", "1", 26f);
        SensorMapa5 = new Sensor("Sensor 5",false, (Llum) ActuadorMapa5, SensorSinHabitacion, "Térmico", "1", 26f);
        SensorMapa6 = new Sensor("Sensor 6",false, (Llum) ActuadorMapa6, SensorSinHabitacion, "Térmico", "1", 26f);
        SensorMapa7 = new Sensor("Sensor 7", false, (Llum) ActuadorMapa7, SensorSinHabitacion, "Térmico", "1", 26f);

        ActuadorMapa1 = new Llum("Actuador 1", false , SensorMapa1, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa2 = new Llum("Actuador 2", false , SensorMapa2, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa3 = new Llum("Actuador 3", false , SensorMapa3, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa4 = new Llum("Actuador 4", false , SensorMapa4, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa5 = new Llum("Actuador 5",  false , SensorMapa5, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa6 = new Llum("Actuador 6", false , SensorMapa6, ActuadorSinHabitacion, "LED", "1", 15f, 0f);
        ActuadorMapa7 = new Llum("Actuador 7", false , SensorMapa7, ActuadorSinHabitacion, "LED", "1", 15f, 0f);




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


        SensorSinHabitacion.addSensor(SensorMapa1);
        SensorSinHabitacion.addSensor(SensorMapa2);
        SensorSinHabitacion.addSensor(SensorMapa3);
        SensorSinHabitacion.addSensor(SensorMapa4);
        SensorSinHabitacion.addSensor(SensorMapa5);
        SensorSinHabitacion.addSensor(SensorMapa6);
        SensorSinHabitacion.addSensor(SensorMapa7);



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
        Inicio.display(p5);
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
        //p5.textAlign(p5.LEFT);
        GraficaSensor.display(p5);
        EncesS1.display(p5);
        MenuS.display(p5);
        Tipos1.display(p5);
        Ubicacions1.display(p5);
        Arduino1.display(p5);
        ActuadorS1.display(p5);

       // TNameSensor.display(p5);
        p5.textFont(Fonts.getFontAt(2));
       // p5.text("          Nombre sensor:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }

    public void dibuixaPantallaSensor2(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        // dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ts2.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaSensor.display(p5);
        EncesS2.display(p5);
        MenuS.display(p5);
        Tipos2.display(p5);
        Ubicacions2.display(p5);
        Arduino2.display(p5);
        ActuadorS2.display(p5);

        // TNameSensor.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        // p5.text("          Nombre sensor:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }

    public void dibuixaPantallaSensor3(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        // dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ts3.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaSensor.display(p5);
        EncesS3.display(p5);
        MenuS.display(p5);
        Tipos3.display(p5);
        Ubicacions3.display(p5);
        Arduino3.display(p5);
        ActuadorS3.display(p5);

        // TNameSensor.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        // p5.text("          Nombre sensor:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }

    public void dibuixaPantallaSensor4(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        // dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ts4.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaSensor.display(p5);
        EncesS4.display(p5);
        MenuS.display(p5);
        Tipos4.display(p5);
        Ubicacions4.display(p5);
        Arduino4.display(p5);
        ActuadorS4.display(p5);

        // TNameSensor.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        // p5.text("          Nombre sensor:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }

    public void dibuixaPantallaSensor5(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        // dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ts5.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaSensor.display(p5);
        EncesS5.display(p5);
        MenuS.display(p5);
        Tipos5.display(p5);
        Ubicacions5.display(p5);
        Arduino5.display(p5);
        ActuadorS5.display(p5);

        // TNameSensor.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        // p5.text("          Nombre sensor:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }

    public void dibuixaPantallaSensor6(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        // dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ts6.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaSensor.display(p5);
        EncesS6.display(p5);
        MenuS.display(p5);
        Tipos6.display(p5);
        Ubicacions6.display(p5);
        Arduino6.display(p5);
        ActuadorS6.display(p5);

        // TNameSensor.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        // p5.text("          Nombre sensor:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }

    public void dibuixaPantallaSensor7(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        // dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ts7.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaSensor.display(p5);
        EncesS7.display(p5);
        MenuS.display(p5);
        Tipos7.display(p5);
        Ubicacions7.display(p5);
        Arduino7.display(p5);
        ActuadorS7.display(p5);

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
        ta1.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaActuador.display(p5);
        EncesA1.display(p5);
        MenuS.display(p5);
        Tipoa1.display(p5);
        Ubicaciona1.display(p5);
        Arduinoa1.display(p5);
        Sensora1.display(p5);

        ValMin1.display(p5);
        ValMax1.display(p5);

        //  TNameActuador.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        // p5.text("               Nombre actuador:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }
    public void dibuixaPantallaActuador2(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        //  dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ta2.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaActuador.display(p5);
        EncesA2.display(p5);
        MenuS.display(p5);
        Tipoa2.display(p5);
        Ubicaciona2.display(p5);
        Arduinoa2.display(p5);
        Sensora2.display(p5);

        ValMin2.display(p5);
        ValMax2.display(p5);

        //  TNameActuador.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        // p5.text("               Nombre actuador:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }
    public void dibuixaPantallaActuador3(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        //  dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ta3.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaActuador.display(p5);
        EncesA3.display(p5);
        MenuS.display(p5);
        Tipoa3.display(p5);
        Ubicaciona3.display(p5);
        Arduinoa3.display(p5);
        Sensora3.display(p5);

        ValMin3.display(p5);
        ValMax3.display(p5);

        //  TNameActuador.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        // p5.text("               Nombre actuador:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }
    public void dibuixaPantallaActuador4(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        //  dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ta4.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaActuador.display(p5);
        EncesA4.display(p5);
        MenuS.display(p5);
        Tipoa4.display(p5);
        Ubicaciona4.display(p5);
        Arduinoa4.display(p5);
        Sensora4.display(p5);

        ValMin4.display(p5);
        ValMax4.display(p5);

        //  TNameActuador.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        // p5.text("               Nombre actuador:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }
    public void dibuixaPantallaActuador5(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        //  dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ta5.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaActuador.display(p5);
        EncesA5.display(p5);
        MenuS.display(p5);
        Tipoa5.display(p5);
        Ubicaciona5.display(p5);
        Arduinoa5.display(p5);
        Sensora5.display(p5);

        ValMin5.display(p5);
        ValMax5.display(p5);

        //  TNameActuador.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        // p5.text("               Nombre actuador:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }
    public void dibuixaPantallaActuador6(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        //  dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ta6.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaActuador.display(p5);
        EncesA6.display(p5);
        MenuS.display(p5);
        Tipoa6.display(p5);
        Ubicaciona6.display(p5);
        Arduinoa6.display(p5);
        Sensora6.display(p5);

        ValMin6.display(p5);
        ValMax6.display(p5);

        //  TNameActuador.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        // p5.text("               Nombre actuador:", /*XGraficaSensor*/ 708, /*YGraficaSensor*/ 239);

        for(int i=0; i<habitacions.length; i++) {
            habitacions[i].dibuixa(p5);
        }
    }
    public void dibuixaPantallaActuador7(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(1));
        //  dibuixaImatgeMapa(p5);

        p5.textFont(Fonts.getFontAt(2));
        ta7.display(p5, XTaules, YTaules/*+(heightImatge/2)-heightTaules/2+8*/, widthTaules, heightTaules);
        GraficaActuador.display(p5);
        EncesA7.display(p5);
        MenuS.display(p5);
        Tipoa7.display(p5);
        Ubicaciona7.display(p5);
        Arduinoa7.display(p5);
        Sensora7.display(p5);

        ValMin7.display(p5);
        ValMax7.display(p5);

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

        System.out.println("RANGOT: "+Rangot.getSelectedValue());

        if (Rangot.getSelectedValue().equals("7") ||Rangot.getSelectedValue()==""){
            ssl17.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("5")){
            ssl15.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("3")){
            ssl13.display(p5);
        }

      //  dibuixaColumnes123(p5);
        MenuSns.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaSensor2(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        //     dibuixaImatgeMapa(p5);

        System.out.println("RANGOT: "+Rangot.getSelectedValue());

        if (Rangot.getSelectedValue().equals("7") ||Rangot.getSelectedValue()==""){
            ssl27.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("5")){
            ssl25.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("3")){
            ssl23.display(p5);
        }

        //  dibuixaColumnes123(p5);
        MenuSns.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaSensor3(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        //     dibuixaImatgeMapa(p5);

        System.out.println("RANGOT: "+Rangot.getSelectedValue());

        if (Rangot.getSelectedValue().equals("7") ||Rangot.getSelectedValue()==""){
            ssl37.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("5")){
            ssl35.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("3")){
            ssl33.display(p5);
        }

        //  dibuixaColumnes123(p5);
        MenuSns.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaSensor4(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        //     dibuixaImatgeMapa(p5);

        System.out.println("RANGOT: "+Rangot.getSelectedValue());

        if (Rangot.getSelectedValue().equals("7") ||Rangot.getSelectedValue()==""){
            ssl47.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("5")){
            ssl45.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("3")){
            ssl43.display(p5);
        }

        //  dibuixaColumnes123(p5);
        MenuSns.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaSensor5(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        //     dibuixaImatgeMapa(p5);

        System.out.println("RANGOT: "+Rangot.getSelectedValue());

        if (Rangot.getSelectedValue().equals("7") ||Rangot.getSelectedValue()==""){
            ssl57.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("5")){
            ssl55.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("3")){
            ssl53.display(p5);
        }

        //  dibuixaColumnes123(p5);
        MenuSns.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaSensor6(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        //     dibuixaImatgeMapa(p5);

        System.out.println("RANGOT: "+Rangot.getSelectedValue());

        if (Rangot.getSelectedValue().equals("7") ||Rangot.getSelectedValue()==""){
            ssl67.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("5")){
            ssl65.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("3")){
            ssl63.display(p5);
        }

        //  dibuixaColumnes123(p5);
        MenuSns.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaSensor7(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));
        //     dibuixaImatgeMapa(p5);

        System.out.println("RANGOT: "+Rangot.getSelectedValue());

        if (Rangot.getSelectedValue().equals("7") ||Rangot.getSelectedValue()==""){
            ssl77.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("5")){
            ssl75.display(p5);
        }
        else if (Rangot.getSelectedValue().equals("3")){
            ssl73.display(p5);
        }

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

        System.out.println("RANGOT:"+Rangot.getSelectedValue());
        //dibuixaImatgeMapa(p5);
        if(Rangot.getSelectedValue().equals("7")||Rangot.getSelectedValue().equals("")){
            sab17.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("5")){
            sab15.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("3")){
            sab13.display(p5);
        }
      //  dibuixaColumnes123(p5);
        MenuAct.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaActuador2(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));

        System.out.println("RANGOT:"+Rangot.getSelectedValue());
        //dibuixaImatgeMapa(p5);
        if(Rangot.getSelectedValue().equals("7")||Rangot.getSelectedValue().equals("")){
            sab27.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("5")){
            sab25.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("3")){
            sab23.display(p5);
        }
        //  dibuixaColumnes123(p5);
        MenuAct.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaActuador3(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));

        System.out.println("RANGOT:"+Rangot.getSelectedValue());
        //dibuixaImatgeMapa(p5);
        if(Rangot.getSelectedValue().equals("7")||Rangot.getSelectedValue().equals("")){
            sab37.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("5")){
            sab35.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("3")){
            sab33.display(p5);
        }
        //  dibuixaColumnes123(p5);
        MenuAct.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaActuador4(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));

        System.out.println("RANGOT:"+Rangot.getSelectedValue());
        //dibuixaImatgeMapa(p5);
        if(Rangot.getSelectedValue().equals("7")||Rangot.getSelectedValue().equals("")){
            sab47.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("5")){
            sab45.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("3")){
            sab43.display(p5);
        }
        //  dibuixaColumnes123(p5);
        MenuAct.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaActuador5(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));

        System.out.println("RANGOT:"+Rangot.getSelectedValue());
        //dibuixaImatgeMapa(p5);
        if(Rangot.getSelectedValue().equals("7")||Rangot.getSelectedValue().equals("")){
            sab57.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("5")){
            sab55.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("3")){
            sab53.display(p5);
        }
        //  dibuixaColumnes123(p5);
        MenuAct.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaActuador6(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));

        System.out.println("RANGOT:"+Rangot.getSelectedValue());
        //dibuixaImatgeMapa(p5);
        if(Rangot.getSelectedValue().equals("7")||Rangot.getSelectedValue().equals("")){
            sab67.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("5")){
            sab65.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("3")){
            sab63.display(p5);
        }
        //  dibuixaColumnes123(p5);
        MenuAct.display(p5);
        p5.text("Unidades:", XUsuari+2*marginH, YActuadors, WidthInhabilitarSensor, HeightInhabilitarSensor/2);
        p5.text("Rango(t):", XUsuari+2*marginH, (YActuadors+YinhabilitarActuador)/2, WidthInhabilitarActuador, HeightInhabilitarSensor/2);
        Rangot.display(p5);
        Unidadest.display(p5);
    }

    public void dibuixaPantallaEstadisticaActuador7(PApplet p5){
        p5.background(255);
        p5.textFont(Fonts.getFontAt(0));
        dibuixaBanner(p5);
        Logo.display(p5);
        p5.textFont(Fonts.getFontAt(2));

        System.out.println("RANGOT:"+Rangot.getSelectedValue());
        //dibuixaImatgeMapa(p5);
        if(Rangot.getSelectedValue().equals("7")||Rangot.getSelectedValue().equals("")){
            sab77.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("5")){
            sab75.display(p5);
        }
        else if(Rangot.getSelectedValue().equals("3")){
            sab73.display(p5);
        }
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