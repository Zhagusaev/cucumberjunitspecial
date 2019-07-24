package Utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;
    private static ResultSetMetaData rsMetaData;

    public static void establishConnection(DBType dbType) throws SQLException {
        if (dbType.equals(DBType.ORACLE)){
            connection = DriverManager.getConnection(Configuration.getProperty("DBURL"), Configuration.getProperty("DBUsername"),
            Configuration.getProperty("DBPassword"));
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        }
    }

    public static int countRows(String query)throws SQLException{
        resultSet = statement.executeQuery(query);
        ResultSet resultSet2 = statement.executeQuery(query);
        resultSet2.last();
        return resultSet2.getRow();
    }

    public static List<Map<String,Object>> runSQLquery(String query)throws SQLException{

        resultSet= statement.executeQuery(query);
        rsMetaData= resultSet.getMetaData();

        int numberOfColumns = rsMetaData.getColumnCount();

        List<Map<String, Object>> listOfMaps = new ArrayList<Map<String, Object>>();

        while (resultSet.next()){
            Map<String, Object> map = new HashMap<String, Object>();
            for (int i=1;i<=numberOfColumns;i++){
                map.put(rsMetaData.getColumnName(i),resultSet.getObject(rsMetaData.getColumnName(i)));
            }
            listOfMaps.add(map);
        }

        return listOfMaps;
    }


    public static void closeConnection()throws SQLException{
        if(connection!=null){
            connection.close();
        }
        if (statement!=null){
            statement.close();
        }
        if (connection!= null){
            resultSet.close();
        }
    }

    public static List<String> getColumnNames() throws SQLException{
        List<String> columnNames = new ArrayList<String>();

        for (int i=0;i<rsMetaData.getColumnCount();i++){
            columnNames.add(rsMetaData.getColumnName(i));
        }
        return columnNames;
    }



}
