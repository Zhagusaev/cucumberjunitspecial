package StepDefs;

import Utilities.DBType;
import Utilities.DBUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class testJDBC {

    public static void main(String[] args) throws SQLException {

        DBUtils.establishConnection(DBType.ORACLE);
        System.out.println(DBUtils.countRows("select salary from (select distinct(salary)\n" +
                "from employees\n" +
                "order by salary desc)\n" +
                "where rownum<=3"));

        System.out.println(DBUtils.runSQLquery("select salary from (select distinct(salary)\n" +
                "from employees\n" +
                "order by salary desc)\n" +
                "where rownum<=3"));

        System.out.println(DBUtils.runSQLquery("select first_name, salary from employees\n" +
                "where rownum<5"));

        List<Map<String, Object>> queryResult = DBUtils.runSQLquery("select first_name, salary from employees\n" +
                "where rownum<5");
        System.out.println("-------------------------");


        for(int i=0; i<queryResult.size();i++){
            for (String key: queryResult.get(i).keySet()) {
                System.out.println(queryResult.get(i).get(key));
            }
            System.out.println();
        }
    }



}
