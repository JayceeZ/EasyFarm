package global;

import model.Map;
import model.location.Location;
import model.piece.Harvest;
import model.piece.Parcel;

import java.awt.*;
import java.sql.*;

/**
 * @author Jean-Christophe Isoard
 */
public class LoadMap {
    public static Connection connectionBDD;

    /**
     * Try connecting to the postgre sql bdd
     *
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
     * Load some parcels in the model Map given in parameter
     *
     * @param map
     * @param parcelId the parcel id from where the map start loading
     * @param distance the distance of loading (kind of deep)
     */
    public static boolean loadPieceOfMap(Map map, int parcelId, int distance) {
        //TODO EAS-4 load from database using the 2 parameters
        try {
            Statement state = connectionBDD.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM parcels");

            ResultSetMetaData resultMeta = result.getMetaData();
            // nombre de colonnes: resultMeta.getColumnCount()
            // nom de colonne i: resultMeta.getColumnName(i)

            while(result.next()) {
                int id = result.getInt("id");
                Harvest harvest = Harvest.valueOf(result.getString("harvest"));
                Location location = new Location(result.getInt("latitude"), result.getInt("longitude"));
                Polygon geometry = (Polygon) result.getObject("geometry");
                Parcel parcel = new Parcel(id, harvest, location, geometry);
                System.out.println(parcel+" has been loaded");
                map.addParcel(parcel);
            }
            result.close();
            state.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
