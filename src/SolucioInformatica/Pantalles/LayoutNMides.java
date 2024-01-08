package SolucioInformatica.Pantalles;

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
    public static int XSensors=668, XActuadors=1002;
    public static int YSensors=6*marginV + logoHeight, YActuadors=6*marginV + logoHeight;
    public static int widthSensors=309, widthActuadors=309;
    public static float heightSensors=heightImatge/7+1, heightActuadors=heightImatge/7+1;

    //Taules
    public static int widthTaules = 638, heightTaules=heightImatge/2-20, XTaules=668, YTaules=YSensors=6*marginV + logoHeight;

    //pantalla sensorX

    public static int XinhabilitarSensor =668, YinhabilitarSensor =574;
    public static int WidthInhabilitarSensor =638, HeightInhabilitarSensor =63;

    public static int XNomSensor=668, YNomSensor=241; //+16
    public static int WidthNomSensor =638, HeightNomSensor =63;

}
