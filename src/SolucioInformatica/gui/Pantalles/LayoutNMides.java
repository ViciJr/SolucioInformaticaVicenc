package SolucioInformatica.gui.Pantalles;

/**Clase con las medidas usadas para la interfaz gráfica*/
public class LayoutNMides {
    // Marges Horitzontal i Vertical
    public static int marginH = 20, marginV = 20;

    // Dimensions Zona Lateral
    public static int sidebarWidth  = 400, sidebarHeight = 390;

    // Dimensions Logo
    public static int logoWidth  = 105, logoHeight = 105;

    // Dimensions Banner
    public static int bannerWidth  = 1121, bannerHeight = 155;

    // Dimensions Columnes
    public static int columnWidth  = 200, columnHeight = 370;

    //Dimensions Tipografia
    public static float midaTitol = 63;
    public static float midaSubtitol = 57;
    public static float midaParagraf = 19;

    // Dimensions Imatges
    public static int widthImatge = 628, heightImatge = 412;
    public static int midaLogo = 155;

    // Dimensions Botons i text fill Primera pantalla
    public static int heightPrimeraPantalla = 63, widthPrimeraPantalla = 628;
    public static int XUsuari=668, YUsuari=225;
    public static int XContra=668, YContra=438;
    public static int XHecho=668,  YHecho=574;

    //Botons Segona pantalla
    public static int XSensors=668+10, XActuadors=1002+5;
    public static int YSensors=6*marginV + logoHeight, YActuadors=6*marginV + logoHeight;
    public static int widthSensors=309, widthActuadors=309;
    public static float heightSensors=heightImatge/9+1, heightActuadors=heightImatge/9+1;
    public static int XMapaInteractivo =668+10, YMapaInteractivo =574;
    public static int WidthMapaInteractivo =638, HeightMapaInteractivo =63;
    //Taules
    public static int widthTaules = 638, heightTaules=heightImatge/4-20, XTaules=668+10, YTaules=YSensors=6*marginV + logoHeight;


    //pantalla sensorX
    public static int XinhabilitarSensor =668+10, YinhabilitarSensor =574;
    public static int WidthInhabilitarSensor =638, HeightInhabilitarSensor =63;

    public static int XGraficaSensor =668+10, YGraficaSensor=YTaules+heightTaules+60;
    public static int WidthGraficaSensor =638, HeightGraficaSensor =63;

    //pantalla actuadorX
    public static int XinhabilitarActuador =668+10, YinhabilitarActuador =574;
    public static int WidthInhabilitarActuador =638, HeightInhabilitarActuador =63;

    public static int XGraficaActuador =668+10, YGraficaActuador =YTaules+heightTaules+20;
    public static int WidthGraficaActuador =638, HeightGraficaActuador =63;

    //pantalla estadística sensorX
    public static int XDiagram = marginH, YDiagram = 6*marginV + logoHeight;
    public static int WidthDiagram = 628, HeightDiagram=412-60;

    //Mapa
    //Esquerra
    public static int XSalón = marginH, YSalón = 6*marginV + logoHeight;
    public static int WidthSalón = (628/9)*5, HeightSalón=300;

    public static int XDormitorio = marginH, YDormitorio = 6*marginV + logoHeight+HeightSalón;
    public static int WidthDormitorio = (628/9)*5, HeightDormitorio=112;
    //Passadís

    public static int XPasillo = marginH+WidthSalón, YPasillo = 6*marginV + logoHeight;
    public static int WidthPasillo = (628/9), HeightPasillo=412;

    //Dreata
    public static int XCocina = marginH+WidthSalón+WidthPasillo, YCocina = 6*marginV + logoHeight;
    public static int WidthCocina = (628/9)*3, HeightCocina=(412/5)*3;

    public static int XBaño = marginH+WidthSalón+WidthPasillo, YBaño = 6*marginV + logoHeight+HeightCocina;
    public static int WidthBaño = (628/9)*3, HeightBaño=(412/5)*2+2;


}
