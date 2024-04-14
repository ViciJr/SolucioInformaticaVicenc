package SolucioInformatica.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DataBase {

    // Variable de connexió a la BBDD
    // Variable de connexió a la BBDD
    Connection c;

    // Variable de consulta
    Statement query;

    // Dades de connexió (user, password, nom de la base de dades)
    String user, password, databaseName;

    // Estat de la connexió
    boolean connectat = false;


    public DataBase(String user, String password, String databaseName){
        this.user = user;
        this.password = password;
        this.databaseName = databaseName;
    }

    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databaseName, user, password);
            query = c.createStatement();
            System.out.println("Connectat a la BBDD! :) ");
            connectat = true;
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    // Retorna el número de files d'una taula
    public int getNumRowsTaula(String nomTaula){
        try {
            ResultSet rs = query.executeQuery( "SELECT COUNT(*) AS n FROM "+ nomTaula );
            rs.next();
            int numRows = rs.getInt("n");
            return numRows;
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    // Retorna el número de files que retornaria una query SELECT qualsevol amb valor "n"
    // Per exemple: SELECT COUNT(*) AS n FROM ...
    public int getNumRowsQuery(String q){
        try {
            ResultSet rs = query.executeQuery( q);
            rs.next();
            return rs.getInt("n");
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    // Retorna el número de columnes d'una taula de la base de dades
    public int getNumColsTaula(String nomTaula){
        try {
            String q = "SELECT count(*) as n FROM information_schema.columns WHERE table_name ='"+ nomTaula +"' AND table_schema='"+databaseName+"'";
            System.out.println(q);
            ResultSet rs = query.executeQuery( q);
            rs.next();
            int numCols = rs.getInt("n");
            return numCols;
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }



    // Retorna totes les dades d'una taula en concret
    public String[][] getInfoTaulaUnitat(){
        int numFiles = getNumRowsTaula("unitat");
        int numCols  = 2;
        String[][] info = new String[numFiles][numCols];
        try {
            ResultSet rs = query.executeQuery( "SELECT * FROM unitat");
            int nr = 0;
            while (rs.next()) {
                info[nr][0] = String.valueOf(rs.getInt("numero"));
                info[nr][1] = rs.getString("nom");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Retorna les dades bidimensionals d'una query en concret (Dades de les unitats d'un curs en concret).
    public String[][] getInfoTaulaUnitatCurs(int curs){
        int numFiles = getNumRowsQuery("SELECT COUNT(*) AS n FROM unitat WHERE curs = '"+curs+"'");
        int numCols  = 3;
        String[][] info = new String[numFiles][numCols];
        try {
            ResultSet rs = query.executeQuery( "SELECT numero, nom, curs FROM unitat WHERE curs= '"+curs+"'");
            int nr = 0;
            while (rs.next()) {
                info[nr][0] = String.valueOf(rs.getInt("numero"));
                info[nr][1] = rs.getString("nom");
                info[nr][2] = String.valueOf(rs.getInt("curs"));
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Retorna les dades unidimensionals d'una query en concret (Cursos diferents)
    public String[] getInfoColumnaCursTaulaUnitat(){
        int numFiles = getNumRowsQuery("SELECT COUNT(DISTINCT curs) AS n FROM unitat");
        String[] info = new String[numFiles];
        try {
            ResultSet rs = query.executeQuery( "SELECT DISTINCT(curs) AS curs FROM unitat");
            int nr = 0;
            while (rs.next()) {
                info[nr] = rs.getString("curs");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    // Retorna les dades de la columna NOM de la taula UNITAT
    public String[] getColumnaNomTaulaUnitat(){
        int numFiles = getNumRowsTaula("unitat");
        String[] info = new String[numFiles];
        try {
            ResultSet rs = query.executeQuery( "SELECT nom FROM unitat ORDER BY nom ASC");
            int nr = 0;
            while (rs.next()) {
                info[nr] = rs.getString("nom");
                nr++;
            }
            return info;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }




    // Retorna el valor de la Columna NUMERO de la taula UNITAT per aquella fila amb NOM
    public String getNumeroFromTaulaUnitat(String nom)  {
        try {
            ResultSet rs = query.executeQuery( "SELECT numero FROM unitat WHERE nom = '"+nom+"'");
            rs.next();
            return String.valueOf(rs.getInt("numero"));
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String[] getHabitacions(/*String userName*/)  {
        int numFiles = getNumRowsTaula("ubicacion");
        String[] habitaciones = new String[numFiles];
        try {
            ResultSet rs = query.executeQuery( "SELECT nombre FROM ubicacion" /*WHERE idUsuario = '"+userName+"'"*/);
            int nr = 0;
            while (rs.next()) {

                habitaciones[nr] = rs.getString("nombre");
                nr++;
            }
            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return habitaciones;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String[] getTipoSensor(/*String userName*/)  {
        int numFiles = getNumRowsTaula("tipos");
        String[] tiposSensor = new String[numFiles];
        try {
            ResultSet rs = query.executeQuery( "SELECT tipoSensor FROM tipos" /*WHERE idUsuario = '"+userName+"'"*/);
            int nr = 0;
            while (rs.next()) {

                tiposSensor[nr] = rs.getString("tipoSensor");
                nr++;
            }
            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return tiposSensor;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String[] getTipoActuador(/*String userName*/)  {
        int numFiles = getNumRowsTaula("tipoa");
        String[] tiposActuador = new String[numFiles];
        try {
            ResultSet rs = query.executeQuery( "SELECT tipoActuador FROM tipoa" /*WHERE idUsuario = '"+userName+"'"*/);
            int nr = 0;
            while (rs.next()) {

                tiposActuador[nr] = rs.getString("tipoActuador");
                nr++;
            }
            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return tiposActuador;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String[] getActuadores(/*String userName*/)  {
        int numFiles = getNumRowsTaula("actuador");
        String[] Actuadores = new String[numFiles];
        try {
            ResultSet rs = query.executeQuery( "SELECT idActuador FROM actuador" /*WHERE idUsuario = '"+userName+"'"*/);
            int nr = 0;
            while (rs.next()) {

                Actuadores[nr] = rs.getString("idActuador");
                nr++;
            }
            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return Actuadores;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String[] getSensores(/*String userName*/)  {
        int numFiles = getNumRowsTaula("sensor");
        String[] Sensores = new String[numFiles];
        try {
            ResultSet rs = query.executeQuery( "SELECT idSensor FROM sensor" /*WHERE idUsuario = '"+userName+"'"*/);
            int nr = 0;
            while (rs.next()) {

                Sensores[nr] = rs.getString("idSensor");
                nr++;
            }
            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return Sensores;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getSensorOnOf(String idSensor)  {
        String SensorOnOf = new String();

        try {
            ResultSet rs = query.executeQuery( "SELECT encendido FROM sensor WHERE idSensor = '"+idSensor+"'");
            rs.next();
            SensorOnOf = rs.getString("encendido");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return SensorOnOf;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

   /* public boolean getSensorOnOf(String idSensor)  {
        String SensorOnOf = new String();

        try {
            String q = "SELECT encendido FROM sensor WHERE actuador = '"+idSensor+"'";
            System.out.println(q);
            ResultSet rs = query.executeQuery( q);
            if(rs.next()) {
                SensorOnOf = rs.getString("encendido");

                //return new String[]{String.valueOf(rs.getInt("nombre"))};
                if (SensorOnOf.equals("N")) {
                    return false;
                } else {
                    return true;
                }
            }
            return false;
        }
        catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }*/

   public float getStatSensor(LocalDateTime Fecha1, LocalDateTime Fecha2, String idSensor)  {
       String StatSensor = new String();
       try {
           ResultSet rs = query.executeQuery( "SELECT valor FROM registros WHERE idSensor = '"+idSensor+"' AND instante BETWEEN '"+Fecha1+"'AND'"+Fecha2+"' ");
           rs.next();
        StatSensor = rs.getString(String.valueOf("valor"));

           //return new String[]{String.valueOf(rs.getInt("nombre"))};
           return Float.valueOf(StatSensor);
       }
       catch(Exception e) {
           System.out.println(e);
           return 0;
       }
   }

    public float getStatActuador(LocalDateTime Fecha1, LocalDateTime Fecha2, String idActuador)  {
        String StatActuador = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT valor FROM registroa WHERE idActuador = '"+idActuador+"' AND instante BETWEEN '"+Fecha1+"'AND'"+Fecha2+"' ");
            rs.next();
            StatActuador = rs.getString(String.valueOf("valor"));

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return Float.valueOf(StatActuador);
        }
        catch(Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public String getTiposActuador(String idActuador)  {
        String Actuador = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT tipoActuador FROM actuador WHERE idActuador = '"+idActuador+"'");
            rs.next();
                Actuador = rs.getString("tipoActuador");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return Actuador;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

  /*  public String getActuadorOnOf(String idActuador)  {
        String ActuadorOnOf = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT encendido FROM actuador WHERE idActuador = '"+idActuador+"'");
            rs.next();
            ActuadorOnOf = rs.getString("encendido");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return ActuadorOnOf;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }*/
    public int getActuadorOnOf(String idActuador)  {
        String ActuadorOnOf = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT encendido FROM actuador WHERE idActuador = '"+idActuador+"'");
            rs.next();
            ActuadorOnOf = rs.getString("encendido");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            if (ActuadorOnOf.equals("S")) {
                return 2;
            }
            else{return 1;}
        }
        catch(Exception e) {
            System.out.println(e);
            return 1;
        }
    }

    public String getPuertoArduinoActuador(String idActuador)  {
        String Arduino = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT puertoArduino FROM actuador WHERE idActuador = '"+idActuador+"'");
            rs.next();
            Arduino = rs.getString("puertoArduino");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return Arduino;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getUbicacionActuador(String idActuador)  {
        String UbicacionA = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT ubicacion FROM actuador WHERE idActuador = '"+idActuador+"'");
            rs.next();
            UbicacionA = rs.getString("ubicacion");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return UbicacionA;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getSensorActuador(String idActuador)  {
        String SensorA = new String();
        try {
            String q = "SELECT idSensor FROM sensor WHERE actuador = '"+idActuador+"'";
            System.out.println(q);
            ResultSet rs = query.executeQuery(q);
            rs.next();
            SensorA = rs.getString("idSensor");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return SensorA;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }
   /* public String getSensorActuador(String idActuador)  {
        String SensorA = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT sensor FROM actuador WHERE idActuador = '"+idActuador+"'");
            rs.next();
            SensorA = rs.getString("actuador");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return SensorA;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }*/

    public String getValMinActuador(String idActuador)  {
        String valMin = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT valorMinParaActuar FROM actuador WHERE idActuador = '"+idActuador+"'");
            rs.next();
            valMin = rs.getString("valorMinParaActuar");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return valMin;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getValMaxActuador(String idActuador)  {
        String valMax = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT valorMaxParaActuar FROM actuador WHERE idActuador = '"+idActuador+"'");
            rs.next();
            valMax = rs.getString("valorMaxParaActuar");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return valMax;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }




    public String getTiposSensor(String idSensor)  {
        String SensorT = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT tipoSensor FROM sensor WHERE idSensor = '"+idSensor+"'");
            rs.next();
            SensorT = rs.getString("tipoSensor");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return SensorT;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getPuertoArduinoSensor(String idSensor)  {
        String Arduino = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT puertoArduino FROM sensor WHERE idSensor = '"+idSensor+"'");
            rs.next();
            Arduino = rs.getString("puertoArduino");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return Arduino;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getUbicacionSensor(String idSensor)  {
        String Ubicacion = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT ubicacion FROM sensor WHERE idSensor = '"+idSensor+"'");
            rs.next();
            Ubicacion = rs.getString("ubicacion");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return Ubicacion;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public String getActuadorSensor(String idSensor)  {
        String ASensor = new String();
        try {
            ResultSet rs = query.executeQuery( "SELECT actuador FROM sensor WHERE idSensor = '"+idSensor+"'");
            rs.next();
            ASensor = rs.getString("actuador");

            //return new String[]{String.valueOf(rs.getInt("nombre"))};
            return ASensor;
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }


    public boolean isValidUser(String userName, String password){
        String q = "SELECT COUNT(*) AS n FROM usuario WHERE idUsuario = '"+userName+"' AND password='"+password+"'";
        try {
            ResultSet rs = query.executeQuery( q);
            rs.next();
            return rs.getInt("n")==1;
        }
        catch(Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public String getClaveFromTabla(String nombreTable, String nombreClave, String nombreColumna, String valorColumna){
        try {
            String q = "SELECT "+nombreClave+" AS clave FROM "+nombreTable+" WHERE "+nombreColumna+"='"+valorColumna+"'";
            ResultSet rs = query.executeQuery( q);
            rs.next();
            return rs.getString("clave");
        }
        catch(Exception e) {
            System.out.println(e);
            return null;
        }
    }


    // INSERTS

    // Inserta les dades a la taula Unitat

    void insertInfoTaulaUnitat(String num, String nom){
        try {
            String sNom = nom.replace("\'", "\\'");
            String q = "INSERT INTO unitat (numero, nom) VALUES ('" + num + "','" + sNom + "')";
            System.out.println(q);
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

   public void insertInfoRegistroSensor(String idRegistroSensorS, LocalDateTime instanteS, float valorS, String sensor){
       String nomSensor = sensor.replace("\'", "\\'");
        try {
            String q = "INSERT INTO registrosensor (idRegistroSensor, instante, valor, sensor) VALUES ('"+idRegistroSensorS+"', '"+instanteS+"', '"+valorS+"', '"+nomSensor+"')";

            System.out.println(q);
            query.execute(q);

        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void insertInfoRegistroActuador(String idRegistroActuadorA, LocalDateTime instanteA, int valorA, String nomActuador){
        try {
            // String sNom = nom.replace("\'", "\\'");
            String q = "INSERT INTO registroactuador (idRegistroActuador, instante, valor, actuador) VALUES ('"+idRegistroActuadorA+"', '"+instanteA+"', '"+valorA+"', '"+nomActuador+"')";

            System.out.println(q);
            query.execute(q);
           }
        catch(Exception e) {
            System.out.println(e);
        }
    }


    // UPDATES

    // Actualitza les dades a la taula Unitat

    void updateInfoTaulaUnitat(String id, String num, String nom){
        try {
            String q = "UPDATE unitat SET numero='"+num+"', nom='"+nom+"' WHERE numero='"+id+"'";
            System.out.println(q);
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

   public void updateCosesSensor(/*String tipoSensorAntic,*/ String tipoSensorNou, String puertoArduino, char encendido, String ubicacion, String actuador,  String identificadorSensor){
        try {
            String q = "UPDATE `sensor` SET `puertoArduino` = '"+puertoArduino+"', `encendido` = '"+encendido+"', `ubicacion` = '"+ubicacion+"', `actuador` = '"+actuador+"', `tipoSensor` = '"+tipoSensorNou+"' WHERE `sensor`.`idSensor` = '"+identificadorSensor+"'";
            System.out.println(q);
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void updateCosesActuador(String puertoArduino, String valorMinParaActuar, String valorMaxParaActuar, char encendido, String ubicacion, String tipoActuador,  String identificadorActuador){
        try {
            String q = "UPDATE `actuador` SET `puertoArduino` = '"+puertoArduino+"', `valorMinParaActuar` = '"+valorMinParaActuar+"', `valorMaxParaActuar` = '"+valorMaxParaActuar+"', `encendido` = '"+encendido+"', `ubicacion` = '"+ubicacion+"', `tipoActuador` = '"+tipoActuador+"' WHERE `actuador`.`idActuador` = '"+identificadorActuador+"'";
            System.out.println(q);
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }

    public void updateSensorOnOf(String b, String nomDSensor) {
        try{
            String q = "UPDATE `sensor` SET  `encendido` = '"+b+"' WHERE `sensor`.`idSensor` = '"+nomDSensor+"'";
        System.out.println(q);
        query.execute(q);
    }
        catch(Exception e) {
        System.out.println(e);
    }
    }


    // DELETES

    // Esborra la fila de la taula Unitat amb el número concret
    void deleteInfoTaulaUnitat(String id){
        try {
            String q = "DELETE FROM unitat WHERE numero='"+id+"'";
            System.out.println(q);
            query.execute(q);
        }
        catch(Exception e) {
            System.out.println(e);
        }
    }
}
