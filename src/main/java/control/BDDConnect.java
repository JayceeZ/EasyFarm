package control;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * For all BDD connection purposes
 *
 * @author Jean-Christophe Isoard
 */
public class BDDConnect {
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
     * Use this method if you want to make a customized sql query
     * <br /> Please take care about closing the result after use
     *
     * @param sqlQuery The query to execute
     * @return The result of the query (null if nothing can be get)
     */
    public static List<Map<String, Object>> getResult(String sqlQuery) {
        if (connectionBDD == null) {
            if (!tryConnection()) {
                return null;
            }
        }
        Statement state;
        ResultSet queryOutput;

        List<Map<String, Object>> result = new LinkedList<>();

        try {
            state = connectionBDD.createStatement();
            queryOutput = state.executeQuery(sqlQuery);
            ResultSetMetaData resultMeta = queryOutput.getMetaData();

            while (queryOutput.next()) {
                Map<String, Object> hashMap = new HashMap<>();
                for (int i = 1; i <= resultMeta.getColumnCount(); i++) {
                    hashMap.put(resultMeta.getColumnName(i), queryOutput.getObject(i));
                }
                result.add(hashMap);
            }

            state.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
