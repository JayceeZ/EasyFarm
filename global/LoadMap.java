package global;

import model.Map;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Jean-Christophe Isoard
 */
public class LoadMap {
    public static Connection connectionBDD;

    /**
     * Try connecting to the postgre sql bdd
     * @return True on success, false on fail
     */
    public static boolean tryConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver O.K.");

            String url = "jdbc:postgresql://localhost:5432/EasyFarm";
            String user = "postgres";
            String passwd = "wsxd5cfvg";

            connectionBDD = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion effective !");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Load a piece of the map in the model map given in parameter
     * @param map
     * @param parcelId the parcel id from where the map start loading
     * @param distance the distance of loading (kind of deep)
     */
    public static void LoadPieceOfMap(Map map, int parcelId, int distance) {
        //TODO EAS-4 load from database using the 2 parameters

    }
}
