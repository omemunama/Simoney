package nursulaeman.simoney.data;

import com.j256.ormlite.android.apptools.OrmLiteConfigUtil;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by nur on 13/10/16.
 */
public class DatabaseConfigUtil extends OrmLiteConfigUtil {

    public static void main (String[] args) throws SQLException, IOException {
        writeConfigFile("ormlite_comfig.txt");
    }

}
