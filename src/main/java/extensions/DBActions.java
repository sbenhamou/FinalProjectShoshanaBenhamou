package extensions;

import io.qameta.allure.Step;
import utilities.CommonOps;
import java.util.ArrayList;
import java.util.List;

public class DBActions extends CommonOps {

    @Step("Get credentials from Database")
    public static List<String> getCredentials(String query) {
        List<String> credentials = new ArrayList<String>();
        try {
            rs = stmt.executeQuery(query);
            rs.next();
            credentials.add(rs.getString(1));
            credentials.add(rs.getString(2));
            credentials.add(rs.getString(3));
        } catch (Exception e) {
            System.out.println("Error Occured while printing Table Data, See Details: " + e);
        }
        return credentials;
    }
}
