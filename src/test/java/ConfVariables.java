import org.apache.commons.configuration2.ex.ConfigurationException;

public class ConfVariables {

    private static LoadProperties loadProperties;

    public static String getHost() throws ConfigurationException {
        return LoadProperties.load().getString("host");
    }

    public static String getPath() throws ConfigurationException {
        return LoadProperties.load().getString("path");
    }

}
