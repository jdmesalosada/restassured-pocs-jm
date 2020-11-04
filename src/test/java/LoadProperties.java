import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;
import java.util.Optional;

public class LoadProperties {

    private static final String APPLICATION_PREFIX = "application";
    private static final String APPLICATION_SUFFIX = "properties";

    public static Configuration load() throws ConfigurationException {

        String environment = Optional.of(System.getenv("env")).orElse("dev");

        Configurations configs = new Configurations();

        return configs
                .properties(new File(String.format("%s-%s.%s", APPLICATION_PREFIX, environment, APPLICATION_SUFFIX)));
    }

}
